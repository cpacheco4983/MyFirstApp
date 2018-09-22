package com.example.cpacheco4983.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.cpacehco4983.myfirstapp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view) {
        // onClick create an intent. Pass context and class the intent is going to.
        // this works as a Context because Activity is a subclass of it
        Intent intent = new Intent(this, DisplayMessageActivity.class);

        // pass text input and start DisplayMessageActivity
        EditText editText = findViewById(R.id.sendMessageInput);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void goToPalindromeTester(View view) {
        Intent intent = new Intent(this, PalindromeTesterActivity.class);
        startActivity(intent);
    }
}
