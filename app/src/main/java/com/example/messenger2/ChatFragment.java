package com.example.messenger2;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.messenger2.UserChat.User;
import com.example.messenger2.UserChat.UserAdapter;
import com.example.messenger2.my_interface.MyClick;

import java.util.ArrayList;
import java.util.List;

public class ChatFragment extends Fragment implements MyClick {
    private RecyclerView mRecycler;
    private UserAdapter userAdapter;
    private List<User> mUser;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chat, container, false);
        mRecycler = view.findViewById(R.id.recycler_chat);
        mRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        mUser = new ArrayList<>();
        userAdapter = new UserAdapter(mUser, this);
        mRecycler.setAdapter(userAdapter);

        loadChatItems();
        return view;
    }

    private void loadChatItems() {
        mUser.add(new User(R.drawable.user, "Khanh 1"));
        mUser.add(new User(R.drawable.user, "Khanh 2"));
        mUser.add(new User(R.drawable.user, "Khanh 3"));
        mUser.add(new User(R.drawable.user, "Khanh 1"));
        mUser.add(new User(R.drawable.user, "Khanh 2"));
        mUser.add(new User(R.drawable.user, "Khanh 3"));
        mUser.add(new User(R.drawable.user, "Khanh 1"));
        mUser.add(new User(R.drawable.user, "Khanh 2"));
        mUser.add(new User(R.drawable.user, "Khanh 3"));
        mUser.add(new User(R.drawable.user, "Khanh 1"));
        mUser.add(new User(R.drawable.user, "Khanh 2"));
        mUser.add(new User(R.drawable.user, "Khanh 3"));
        mUser.add(new User(R.drawable.user, "Khanh 1"));
        mUser.add(new User(R.drawable.user, "Khanh 2"));
        mUser.add(new User(R.drawable.user, "Khanh 3"));
        userAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClickUser(User user) {
        int position = mUser.indexOf(user);
        Intent myIntent = new Intent(getActivity(), ChatActivity.class);
        myIntent.putExtra("userName", user.getUserName());
        myIntent.putExtra("userImage", user.getRecourceId());
        myIntent.putExtra("user_position", position);
        startActivityForResult(myIntent, 99);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 99 && resultCode == ChatActivity.RESULT_OK) {
            String newName = data.getStringExtra("newName");
            int position = data.getIntExtra("user_position", -1);
            if (position != -1 && newName != null) {
                mUser.get(position).setUserName(newName);
                userAdapter.notifyItemChanged(position);
            }
        }
    }
}