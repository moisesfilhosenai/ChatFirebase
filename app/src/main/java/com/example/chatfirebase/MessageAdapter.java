package com.example.chatfirebase;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder>{
    private List<Message> messages;
    private Context context;
    private User user;
    private User me;
    private boolean minhaMensagem;

    public MessageAdapter(List<Message> messages, Context context, User user, User me) {
        this.messages = messages;
        this.context = context;
        this.user = user;
        this.me = me;
    }

    @NonNull
    @Override
    public MessageAdapter.MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_message, parent, false);
        return new MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageAdapter.MessageViewHolder holder, int position) {
        Message message = messages.get(position);
        holder.messageUser.setText(message.getText());

        minhaMensagem = message.getFromId().equals(FirebaseAuth.getInstance().getUid());

        if (minhaMensagem) {
            Picasso.get().load(me.getProfileUrl()).into(holder.imgPhotoUser);
        } else {
            Picasso.get().load(user.getProfileUrl()).into(holder.imgPhotoUser);
        }
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public class MessageViewHolder extends RecyclerView.ViewHolder {

        private final TextView messageUser;
        private final ImageView imgPhotoUser;

        MessageViewHolder(@NonNull View itemView) {
            super(itemView);
            if (minhaMensagem) {
                itemView.findViewById(R.id.tvMessageFrom).setVisibility(View.VISIBLE);
                itemView.findViewById(R.id.ivChatUserFrom).setVisibility(View.VISIBLE);

                itemView.findViewById(R.id.tvMessageTo).setVisibility(View.GONE);
                itemView.findViewById(R.id.ivChatUserTo).setVisibility(View.GONE);

                messageUser = itemView.findViewById(R.id.tvMessageFrom);
                imgPhotoUser = itemView.findViewById(R.id.ivChatUserFrom);

            } else {
                itemView.findViewById(R.id.tvMessageFrom).setVisibility(View.GONE);
                itemView.findViewById(R.id.ivChatUserFrom).setVisibility(View.GONE);

                itemView.findViewById(R.id.tvMessageTo).setVisibility(View.VISIBLE);
                itemView.findViewById(R.id.ivChatUserTo).setVisibility(View.VISIBLE);

                messageUser = itemView.findViewById(R.id.tvMessageTo);
                imgPhotoUser = itemView.findViewById(R.id.ivChatUserTo);
            }
        }
    }
}


