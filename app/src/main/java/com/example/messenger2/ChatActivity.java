package com.example.messenger2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ChatActivity extends AppCompatActivity {
    private TextView textViewNameChat;
    private ImageView imageViewChat;
    private EditText inputChat;
    private Button btnSend;
    private int userposition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chat);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textViewNameChat = findViewById(R.id.textViewNameChat);
        imageViewChat = findViewById(R.id.imageViewChat);
        inputChat = findViewById(R.id.input_chat);
        btnSend = findViewById(R.id.btn_Send);

        Intent intent = getIntent();
        if(intent != null){
            String namechat = intent.getStringExtra("userName");
            int imagechat = intent.getIntExtra("userImage", -1);
            userposition = intent.getIntExtra("user_position", -1);
            textViewNameChat.setText(namechat);
            imageViewChat.setImageResource(imagechat);
            inputChat.setText(namechat);

        }

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ChatActivity.this, "update", Toast.LENGTH_SHORT).show();
                String newUserName = inputChat.getText().toString();
                Intent resultIntent = new Intent();
                resultIntent.putExtra("newName", newUserName);
                resultIntent.putExtra("user_position", userposition);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }

}