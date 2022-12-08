package com.hfad.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private ImageView imvSend;
    private EditText newMessage;
    Date currentTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imvSend = findViewById(R.id.imvSend);
        newMessage = (EditText)findViewById(R.id.etMessage);
        imvSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Message> messages;
                messages = DataBase.getMessages();
                Calendar c = Calendar.getInstance();
                String timeComp = c.get(Calendar.HOUR)+":"+c.get(Calendar.MINUTE);
                messages.add(new Message(newMessage.getText().toString(), timeComp, Message.TYPE_SENT));
                hideKeyboard(view);
            }
            private void hideKeyboard(View view) {
                InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(view.getApplicationWindowToken(),0);
            }
        });

        setUpRecyclerView();
    }
    private void setUpRecyclerView(){

        RecyclerView rv = findViewById(R.id.recyclerView);

        //adapter
        MessageAdapter adapter = new MessageAdapter(getSupportFragmentManager());
        rv.setAdapter(adapter);

        //manager connects the above 2
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        rv.setLayoutManager(layoutManager);

    }
}