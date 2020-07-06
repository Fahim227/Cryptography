package com.example.hashing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class First extends AppCompatActivity implements View.OnClickListener {
    private Button button,button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.encrypt);
        button1 =  (Button) findViewById(R.id.decrypt);

        button.setOnClickListener(this);
        button1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.encrypt){
            Intent intent = new Intent(First.this,Encrypt.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.decrypt){
            Intent intent = new Intent(First.this,Decrypt.class);
            startActivity(intent);

        }
    }
}
