package com.app.chatbot;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.app.chatbot.Model.Arbol;
import com.app.chatbot.Model.Message;
import com.app.chatbot.Model.Nodo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ChatActivity extends AppCompatActivity {

    private static final String TAG = ChatActivity.class.getName();
    private Message_Adapter adapter;
    private Arbol arbol = SingleArbol.getInstance();
    private SharedPreferences prefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        final List<Message> messageList = new ArrayList<>();
        final RecyclerView recyclerView = findViewById(R.id.recyclerView);
        adapter = new Message_Adapter(this, messageList);
        ImageView ivSend = findViewById(R.id.fab_img);
        final EditText etMessage = findViewById(R.id.editText);
        recyclerView.setHasFixedSize(true);
        prefs = getSharedPreferences("Preference", Context.MODE_PRIVATE);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        ivSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt = etMessage.getText().toString().toLowerCase().trim();
                if (!txt.isEmpty()) {
                    Message message = new Message();
                    message.setMessage(txt);
                    message.setUser("user");
                    //messageList.add(message);
                    etMessage.setText("");
                    adapter.addItem(message,adapter.getItemCount());
                    recyclerView.scrollToPosition(messageList.size());
                    //Todo: typing animation
                    Nodo nodo = arbol.buscar(formatText(message.getMessage()));
                    boolean compra = false;
                    if (nodo != null) {

                        message = new Message();
                        StringBuilder builder = new StringBuilder();
                        for (Nodo n : nodo.getHijos()) {
                            if(n.getValor().contains("Con gusto, el total seria de")) {
                                compra = true;
                                if(formatText(txt).replace(" ","").toLowerCase().contains("menu1")){
                                    n.setValor("Con gusto, el total seria de: Q25.00");
                                }else if(formatText(txt).replace(" ","").toLowerCase().contains("menu2")) {
                                    n.setValor("Con gusto, el total seria de: Q35.00");
                                }else if(formatText(txt).replace(" ","").toLowerCase().contains("postre")||
                                        formatText(txt).replace(" ","").toLowerCase().contains("helado")||
                                        formatText(txt).replace(" ","").toLowerCase().contains("pastel")){
                                    n.setValor("Con gusto, el total seria de: Q10.00");
                                }
                            }
                            builder.append(n.getValor()).append("\n");
                        }
                        message.setMessage(builder.toString());
                        message.setUser("bot");


                    } else {
                        txt += "\n";
                        txt += prefs.getString("Pregunta", "");
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putString("Pregunta", txt);
                        editor.apply();
                        message = new Message();
                        message.setUser("bot");
                        message.setMessage("Respuesta no disponible");
                    }
                    hideKeyboard();
                    //messageList.add(message);
                    etMessage.setText("");
                    adapter.addItem(message,adapter.getItemCount());
                    recyclerView.scrollToPosition(messageList.size());
                    if(compra){
                        message = new Message();
                        message.setMessage("A que direccion le enviamos su orden?");
                        message.setUser("bot");
                        //messageList.add(message);
                        adapter.addItem(message,adapter.getItemCount());

                    }
                    Log.e(TAG,"Size msg: "+messageList.size());
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        obtenerPreguntas();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    private void hideKeyboard(){
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.send:
                sendEmail();
                break;
        }
        return true;
    }

    protected void sendEmail() {
        String[] TO = {"mrvargas16@gmail.com"};
        String message = prefs.getString("Pregunta","");
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("Pregunta","");
        editor.apply();
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");


        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Preguntas");
        emailIntent.putExtra(Intent.EXTRA_TEXT, message);

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i(TAG, "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this,
                    "No hay un cliente de correo electrónico instalado.", Toast.LENGTH_SHORT).show();
        }
    }

    private void obtenerPreguntas(){
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://loveguateapp.atwebpages.com/wsPregunta.php?function=obtenerPregunta";
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET,url,null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.e(TAG, "response " + response.toString());
                if(response.length()>0){
                    if(arbol.getRaiz() != null && arbol.getRaiz().getHijos() != null)
                        arbol.getRaiz().getHijos().clear();
                }
                for(int i = 0; i<response.length();i++){
                    try {
                        JSONObject object = response.getJSONObject(i);
                        JSONArray respuesta = object.getJSONArray("respuesta");
                        arbol.insertarHijo(object.getInt("id"), object.getString("valor"));
                        for(int j=0; j< respuesta.length(); j++){
                            JSONObject objectRespuesta = respuesta.getJSONObject(j);
                            arbol.insertarHijo(-1, objectRespuesta.getString("valor"),object.getInt("id"));
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Error volley " + error.getLocalizedMessage());
            }
        });
        queue.add(request);

    }

    public String formatText(String text){
        String original = "áàäéèëíìïóòöúùuñÁÀÄÉÈËÍÌÏÓÒÖÚÙÜÑçÇ";
        // Cadena de caracteres ASCII que reemplazarán los originales.
        String ascii = "aaaeeeiiiooouuunAAAEEEIIIOOOUUUNcC";
        String output = text;
        for (int i=0; i<original.length(); i++) {
            // Reemplazamos los caracteres especiales.
            output = output.replace(original.charAt(i), ascii.charAt(i));
        }//for i
        return output;
    }

}
