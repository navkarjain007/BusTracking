package com.example.hp.busproject;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInstaller;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View.OnClickListener;
import com.firebase.client.Firebase;

import java.util.Properties;

/**
 * Created by HP on 15-Feb-17.
*/

public class AddDriver extends Activity implements OnClickListener {
    private EditText BusRouteNo;
    private EditText DriverName;
    private EditText PhoneNo;
    private EditText DriverEmail;
    private EditText DriverPassword;
    private Button AddDriver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_driver);
        DriverEmail = (EditText) findViewById(R.id.DriverEmail);
        DriverPassword = (EditText) findViewById(R.id.DriverPassword);
        BusRouteNo = (EditText) findViewById(R.id.BusRouteNo);
        DriverName = (EditText) findViewById(R.id.DriverName);
        PhoneNo = (EditText) findViewById(R.id.PhoneNo);
        AddDriver = (Button) findViewById(R.id.AddDriver);

        Firebase.setAndroidContext(this);
    }

    public void onClick(View v) {

                Firebase ref = new Firebase(Config.FIREBASE_URL);



                String RouteNo = BusRouteNo.getText().toString();
                String Phone = PhoneNo.getText().toString();
                String name = DriverName.getText().toString();
                String email = DriverEmail.getText().toString();
                String password = DriverPassword.getText().toString();

                if (TextUtils.isEmpty(RouteNo) || TextUtils.isEmpty(Phone) || TextUtils.isEmpty(name) || TextUtils.isEmpty(email) || TextUtils.isEmpty(password))
                {
                    Toast.makeText(AddDriver.this, "Field Can't be left blank", Toast.LENGTH_SHORT).show();
                }



                DatabaseGetterSetter object = new DatabaseGetterSetter();
                object.setBusRouteNo(RouteNo);
                object.setDriverName(name);
                object.setPhoneNo(Phone);
                object.setDriverEmail(email);
                object.setDriverPassword(password);
                Firebase newRef = ref.child("Driver Details").push();
                newRef.setValue(object);
                Toast.makeText(AddDriver.this, "data Added", Toast.LENGTH_SHORT).show();

            }
        }


