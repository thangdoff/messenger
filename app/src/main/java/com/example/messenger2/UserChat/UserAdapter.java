package com.example.messenger2.UserChat;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.messenger2.ChatActivity;
import com.example.messenger2.ChatFragment;
import com.example.messenger2.MainActivity;
import com.example.messenger2.R;
import com.example.messenger2.my_interface.MyClick;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private List<User> mListchat;
    private MyClick myClick;
    private Context mContext;

    public UserAdapter(List<User> mListchat, MyClick click) {
        this.mListchat = mListchat;
        this.myClick = click;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_user,parent,false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User mUser = mListchat.get(position);
        if(mUser == null){
            return;
        }
        holder.textViewName.setText(mUser.getUserName());
        holder.imageView.setImageResource(mUser.getRecourceId());

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myClick.onClickUser(mUser);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(mListchat != null){
            return mListchat.size();
        }
        return 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView textViewName;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textViewName = itemView.findViewById(R.id.textViewName);
        }
    }
}
