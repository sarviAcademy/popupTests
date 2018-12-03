package com.example.amir.popuptests;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText userName;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LayoutInflater inflater=getLayoutInflater();
        final View v=inflater.inflate(R.layout.dialoglayout,null);




        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Simple Dialog");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //Toast.makeText(getApplicationContext(),"positive buttom is clicked!!!",Toast.LENGTH_SHORT).show();
                        userName=v.findViewById(R.id.username);
                        password=v.findViewById(R.id.pass);
                        String strUserName=userName.getText().toString();
                        String strPass=password.getText().toString();
                        Toast.makeText(getBaseContext(),strUserName+"  "+strPass.toString(),Toast.LENGTH_LONG).show();
                    }
                }).setNeutralButton("nothing",null);
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                }).setView(v);

        AlertDialog alertDialog=builder.create();
        alertDialog.show();

    }
}
