package com.example.hp.busproject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by HP on 14-Feb-17.
 */

public class AdminLogin extends Activity {

    private EditText Username;
    private EditText Password;
    private Button   LoginButton;
    private FirebaseAuth mAuth;

    private FirebaseAuth.AuthStateListener mAuthListener;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_login);
        Username=(EditText)findViewById(R.id.Username);
        Password=(EditText)findViewById(R.id.Password);
        LoginButton=(Button)findViewById(R.id.LoginButton);
        mAuth=FirebaseAuth.getInstance();
        mAuthListener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() != null) {
                    Toast.makeText(AdminLogin.this, "login", Toast.LENGTH_SHORT).show();
                    //Intent intent=new Intent(AdminLogin.this, AdminRights.class);
                    // startActivity(intent);
                }
            }

        };


        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ProgressDialog pd = new ProgressDialog(AdminLogin.this);
                pd.setMessage("login");
                pd.show();

                startLogin();

            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    private void startLogin() {
        String email = Username.getText().toString();
        String password = Password.getText().toString();
        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password))
        {
            Toast.makeText(AdminLogin.this, "Fields cannt be left blank", Toast.LENGTH_LONG).show();
        }
        else {
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if(!task.isSuccessful())
                    {
                        Toast.makeText(AdminLogin.this, "Login problem ", Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Intent intent=new Intent(AdminLogin.this, AdminRights.class);
                        startActivity(intent);

                    }
                }
            });
        }


    }
}

