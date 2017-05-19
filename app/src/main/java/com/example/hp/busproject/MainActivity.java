package com.example.hp.busproject;

    import android.content.Intent;
    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.Button;

    public class MainActivity extends AppCompatActivity {
    private Button BusDriver;
    private Button AdminLogin;
    private Button ParentLogin;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BusDriver=(Button)findViewById(R.id.BusDriver);
        AdminLogin=(Button)findViewById(R.id.AdminLogin);
        ParentLogin=(Button)findViewById(R.id.ParentLogin);
    }
    public void clicknavkar(View view)
    {
        String button_text;
        button_text=((Button)view).getText().toString();
        if(button_text.equals("BusDriver"))
        {
          // bus driver(later)
        }
             else if(button_text.equals("ADMIN"))
        {
            finish();
            Intent intent=new Intent(this,AdminLogin.class);
            startActivity(intent);
        }
        else
        {
            //Parent login (later)
        }
    }

}
