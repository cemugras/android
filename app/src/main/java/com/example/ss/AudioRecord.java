package com.example.ss;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
//import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
//import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class AudioRecord extends AppCompatActivity {
    private String permGiven = "Audio record permission is given.";

    private static final String TAG = "AudioRecord";
    private static final String[] AUDIO_PERMISSION = {
            Manifest.permission.RECORD_AUDIO
    };

    TextView textone, texttwo, textperm;
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.audio_record);

        //TextView Definitions
        textone = (TextView) findViewById(R.id.text1);
        texttwo = (TextView) findViewById(R.id.text2);

        //Button Definitions
        Button buttonCheckPerm = findViewById(R.id.buttonCheckPerm);
        Button buttonMenu = findViewById(R.id.buttonMenu);

        if(checkPermissionAudio()==1){
            buttonCheckPerm.setClickable(false);
            buttonCheckPerm.setText(permGiven);
            buttonCheckPerm.setBackgroundColor(android.R.color.white);
        }

        //Get Frequency Button Actions
        buttonCheckPerm.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            public void onClick(View v) {
                Button buttonCheckPerm = findViewById(R.id.buttonCheckPerm);
                verifyPermissions();
                if(checkPermissionAudio()==1){
                    buttonCheckPerm.setClickable(false);
                    buttonCheckPerm.setText(permGiven);
                    buttonCheckPerm.setBackgroundColor(android.R.color.white);
                }
            }
        });

        //Main Menu Button Actions
        buttonMenu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
    }

    private void verifyPermissions(){
        Log.d(TAG, "verifyPermissions: Checking Permissions.");

        if (checkPermissionAudio()==0) {
            ActivityCompat.requestPermissions(
                    AudioRecord.this,
                    AUDIO_PERMISSION,
                    1
            );
            return;
        }else
            return;

    }
    private int checkPermissionAudio(){
        int permissionAudioRecord = ActivityCompat.checkSelfPermission(AudioRecord.this, Manifest.permission.RECORD_AUDIO);
        if (permissionAudioRecord != PackageManager.PERMISSION_GRANTED){
            return 0;
        }else{
            return 1;
        }
    }
}

