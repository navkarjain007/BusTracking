package com.example.hp.busproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by HP on 14-Feb-17.
 */

public class AdminRights extends Activity {
    private Button AddDriver;
    private Button AddParent;
    private Button ViewBus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_rights);
        AddDriver=(Button)findViewById(R.id.AddDriver);
        AddParent=(Button)findViewById(R.id.AddParent);
        ViewBus=(Button)findViewById(R.id.ViewBus);
    }
    public void click(View view)
    {
      String button_txt;
        button_txt=((Button)view).getText().toString();
        if(button_txt.equals("Add Driver"))
        {
            Intent intent=new Intent(this,AddDriver.class);
            startActivity(intent);
        }
        else if(button_txt.equals("Add Parent"))
        {
            Intent intent=new Intent(this,AddParent.class);
            startActivity(intent);
        }
        else
        {
            // view bus details
        }
    }

}
