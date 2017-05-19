package com.example.hp.busproject;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;

import org.w3c.dom.Text;

/**
 * Created by HP on 15-Feb-17.
 */

public class AddParent extends Activity {
    private EditText StudentName;
    private EditText StudentClass;
    private EditText FatherName;
    private EditText PhoneNo;
    private EditText BusNo;
    private Button AddParent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_parent);
        StudentName=(EditText)findViewById(R.id.StudentName);
        StudentClass=(EditText)findViewById(R.id.StudentClass);
        FatherName=(EditText)findViewById(R.id.FatherName);
        PhoneNo=(EditText)findViewById(R.id.PhoneNo);
        BusNo=(EditText)findViewById(R.id.BusNo);
        AddParent=(Button)findViewById(R.id.AddParent);
        Firebase.setAndroidContext(this);
        AddParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Firebase ref = new Firebase(Config.FIREBASE_URL);
                String name=StudentName.getText().toString();
                String studentclass=StudentClass.getText().toString();
                String fathername=FatherName.getText().toString();
                String phoneno=PhoneNo.getText().toString();
                String busno=BusNo.getText().toString();
                if(TextUtils.isEmpty(name)||TextUtils.isEmpty(studentclass)||TextUtils.isEmpty(fathername)||TextUtils.isEmpty(phoneno)|| TextUtils.isEmpty(busno))
                {
                   Toast.makeText(AddParent.this,"Fields Can't be left blank",Toast.LENGTH_SHORT).show();
                }
                DatabaseParent object=new DatabaseParent();
                object.setStudentName(name);
                object.setStudentclass(studentclass);
                object.setFatherName(fathername);
                object.setPhoneNo(phoneno);
                object.setBusNo(busno);

                Firebase newRef = ref.child("Parent Details").push();
                newRef.setValue(object);
                Toast.makeText(AddParent.this,"data Added",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
