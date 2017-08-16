package com.example.apple.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edname,edlname,edmail,edpass,edcompass;
    Button b1;
    CheckBox c1;

    public static final String MyPREFERENCES = "MyPreFs";
    public static final String Name = "nameKey";
    public static final String lasname = "LastnKey";
    public static final String Email = "emailKey";
    public static final String pass = "passKey";
    public static final String conpass = "conlKey";
    public static final String check = "checkKey";


    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edname = (EditText) findViewById(R.id.edname);
        edlname = (EditText) findViewById(R.id.edlname);
        edmail = (EditText) findViewById(R.id.edmail);
        edpass = (EditText) findViewById(R.id.edpass);
        edcompass = (EditText) findViewById(R.id.edcompass);
        c1 = (CheckBox) findViewById(R.id.checkBox);

        b1 = (Button) findViewById(R.id.btn1);
        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);


        edname.setText(sharedPreferences.getString(Name,null));
        edlname.setText(sharedPreferences.getString(lasname,null));
        edmail.setText(sharedPreferences.getString(Email,null));
        edpass.setText(sharedPreferences.getString(pass,null));
        edcompass.setText(sharedPreferences.getString(conpass,null));
        c1.setChecked(sharedPreferences.getBoolean(check,false));






        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = edname.getText().toString();
                String ph = edlname.getText().toString();
                String e = edmail.getText().toString();
                String p = edpass.getText().toString();
                String cp = edcompass.getText().toString();
                boolean ck = c1.isChecked();



                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString(Name,n);
                editor.putString(lasname,ph);
                editor.putString(Email,e);
                editor.putString(pass,p);
                editor.putString(conpass,cp);
                editor.putBoolean(check,ck);
                editor.commit();
                Toast.makeText(MainActivity.this,"Thanks",Toast.LENGTH_LONG).show();


            }
        });
    }
}
