package com.example.hashing;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;

public class Encrypt extends AppCompatActivity implements View.OnClickListener {
    private char[] capital;
    private char[] latin;
    private EditText editText;
    private Button button;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encrypt);
        //adding backbutton
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        capital = new char[26];
        latin = new char[26];

        for(int i=0,c=65,l=97;i<26;i++,c++,l++){
            capital[i]=(char)c;
            latin[i]=(char)l;
        }

        editText = (EditText) findViewById(R.id.encryptedittext);
        button = (Button) findViewById(R.id.encryptbutton);
        textView = (TextView) findViewById(R.id.encrypttextview);

        button.setOnClickListener(this);





    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.encryptbutton){

            String str=editText.getText().toString();
            String s="";
            for(int i=0;i<str.length();i++){

                int idx;
                int temp = (int)str.charAt(i);
                if(temp<=122 && temp>=97){
                    idx = Arrays.binarySearch(latin,str.charAt(i));
                    idx=(idx+7)%26;
                    s+=latin[idx];
                }
                else if(temp<=90 && temp>=65){
                    idx = Arrays.binarySearch(capital,str.charAt(i));
                    idx=(idx+7)%26;
                    s+=capital[idx];
                }
                else{
                    s+=str.charAt(i);
                }

            }
            textView.setText(s);
            textView.setTextIsSelectable(true);




        }
    }
}
