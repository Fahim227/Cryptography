package com.example.hashing;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;

public class Decrypt extends AppCompatActivity implements View.OnClickListener {
    private char[] capital;
    private char[] latin;
    private EditText editText;
    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decrypt);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        capital = new char[26];
        latin = new char[26];

        for(int i=0,c=65,l=97;i<26;i++,c++,l++){
            capital[i]=(char)c;
            latin[i]=(char)l;
        }

        editText = (EditText) findViewById(R.id.decryptedittext);
        button = (Button) findViewById(R.id.decryptbutton);
        textView = (TextView) findViewById(R.id.decrypttextview);

        button.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.decryptbutton){

            String str=editText.getText().toString();
            String s="";
            for(int i=0;i<str.length();i++){

                int idx;
                int temp = (int)str.charAt(i);
                if(temp<=122 && temp>=97){
                    idx = Arrays.binarySearch(latin,str.charAt(i));
                    idx=((26+idx)-7)%26;
                    s+=latin[idx];
                }
                else if(temp<=90 && temp>=65){
                    idx = Arrays.binarySearch(capital,str.charAt(i));
                    idx=((26+idx)-7)%26;
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
