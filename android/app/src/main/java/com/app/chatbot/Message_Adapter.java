package com.app.chatbot;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.chatbot.Model.Message;

import java.util.List;

/**
 * Created by Mario on 24/05/2018.
 *
 */

public class Message_Adapter extends RecyclerView.Adapter<Message_Adapter.MessageViewHolder>{

    private List<Message> message;
    private Context mContext;
    public Message_Adapter(Context context,List<Message> message) {
        this.message = message;
        this.mContext = context;
    }

    @Override
    public MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.message_adapter, parent, false);
        return new MessageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MessageViewHolder holder, int position) {
        //position = holder.getAdapterPosition();
        if(message.get(position).getUser().equalsIgnoreCase("user")) {
            holder.rightText.setVisibility(View.VISIBLE);
            holder.rightText.setText(message.get(position).getMessage());
            holder.leftText.setVisibility(View.GONE);
        }
        else {
            holder.leftText.setVisibility(View.VISIBLE);
            holder.leftText.setText(message.get(position).getMessage());
            holder.rightText.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return message.size();
    }

    void addItem(Message dataObj, int index) {
        message.add(dataObj);
        notifyItemInserted(index);
    }

    public class MessageViewHolder extends RecyclerView.ViewHolder  {
        TextView leftText,rightText;

        public MessageViewHolder(View itemView){
            super(itemView);
            leftText = itemView.findViewById(R.id.leftText);
            rightText = itemView.findViewById(R.id.rightText);
        }
    }
}
