package com.example.ss;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.app.Activity;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListenerOnButton();
     }

     public void addListenerOnButton(){
         //Button Definitions
         Button audioButton = findViewById(R.id.audioRecords);
         Button quitButton = findViewById(R.id.quitButton);

         audioButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 startActivity(new Intent(MainActivity.this,AudioRecord.class));
             }
         });

         quitButton.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 finish();
                 //System.exit(0);
             }
         });
     }
}
