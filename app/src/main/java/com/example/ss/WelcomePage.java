package com.example.ss;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;
import android.app.Activity;

public class WelcomePage extends Activity{

    Button btnSignIn, btnSignUp, btnConfirm, btnCancel;
    EditText gsmNumber, otpPassword;
    String cemGsm="5423874199", cemPass="3579";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_page);

        btnSignIn = findViewById(R.id.signin);
        btnSignUp = findViewById(R.id.signUp);
        btnConfirm = findViewById(R.id.confirmButton);
        btnCancel = findViewById(R.id.cancelButton);

        //TextView Definitions
        gsmNumber = (EditText) findViewById(R.id.gsmNumber);
        otpPassword = (EditText) findViewById(R.id.otpPassword);


    }

    //Oturum aç
    public void singIn(View view){
        /*//Button Definitions
        btnSignIn = findViewById(R.id.signin);
        btnSignUp = findViewById(R.id.signUp);
        btnConfirm = findViewById(R.id.confirmButton);
        btnCancel = findViewById(R.id.cancelButton);

        //TextView Definitions
        gsmNumber = (EditText) findViewById(R.id.gsmNumber);
        otpPassword = (EditText) findViewById(R.id.otpPassword);*/

        //Button visibility executions
        btnSignIn.setVisibility(View.INVISIBLE);
        btnSignUp.setVisibility(View.INVISIBLE);
        btnConfirm.setVisibility(View.VISIBLE);
        btnCancel.setVisibility(View.VISIBLE);

        //EditText visibility executions
        gsmNumber.setVisibility(View.VISIBLE);
        otpPassword.setVisibility(View.VISIBLE);

    }

    //Kayıt ol
    public void signUp(View view){
        Toast.makeText(WelcomePage.this, "This feature is not useable right now.", Toast.LENGTH_LONG).show();
        showSoftKeyboard(findViewById(R.id.cancelButton));
    }

    public void cancelOtp(View view){
        /*//Button Definitions
        btnSignIn = findViewById(R.id.signin);
        btnSignUp = findViewById(R.id.signUp);
        btnConfirm = findViewById(R.id.confirmButton);
        btnCancel = findViewById(R.id.cancelButton);

        //TextView Definitions
        gsmNumber = (EditText) findViewById(R.id.gsmNumber);
        otpPassword = (EditText) findViewById(R.id.otpPassword);*/

        //Button visibility executions
        btnSignIn.setVisibility(View.VISIBLE);
        btnSignUp.setVisibility(View.VISIBLE);
        btnConfirm.setVisibility(View.INVISIBLE);
        btnCancel.setVisibility(View.INVISIBLE);

        //EditText visibility executions
        gsmNumber.setVisibility(View.INVISIBLE);
        otpPassword.setVisibility(View.INVISIBLE);

        gsmNumber.setText(null);
        otpPassword.setText(null);

        showSoftKeyboard(findViewById(R.id.cancelButton));

        //Closing soft keyboard
        //hideSoftKeyboard(this);
    }

    public void confirmSignIn(View view){
        if(gsmNumber.getText().toString().equals(cemGsm) && otpPassword.getText().toString().equals(cemPass)){
            startActivity(new Intent(WelcomePage.this,MainActivity.class));
            //Button visibility executions
            btnSignIn.setVisibility(View.VISIBLE);
            btnSignUp.setVisibility(View.VISIBLE);
            btnConfirm.setVisibility(View.INVISIBLE);
            btnCancel.setVisibility(View.INVISIBLE);

            //EditText visibility executions
            gsmNumber.setVisibility(View.INVISIBLE);
            otpPassword.setVisibility(View.INVISIBLE);
        }else{
            Toast.makeText(WelcomePage.this, "Wrong GSM or Password!", Toast.LENGTH_LONG).show();
            gsmNumber.setText(null);
            otpPassword.setText(null);
        }
    }

    public void hideSoftKeyboard(Activity activity) {
        /*InputMethodManager imm = (InputMethodManager) getSystemService(
                Activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);*/
    }

    public void showSoftKeyboard(View view) {
        if (view.requestFocus()) {
            InputMethodManager imm = (InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
        }
    }
    }
