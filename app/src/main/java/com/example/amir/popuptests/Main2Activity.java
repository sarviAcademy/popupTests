package com.example.amir.popuptests;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class Main2Activity extends AppCompatActivity {
String FileName="mytext.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    private  void saveFile(String Filename,String Content)
    {
        FileOutputStream fout=null;
        try {
            fout=openFileOutput(Filename,MODE_APPEND);
            fout.write(Content.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(fout!=null)
            {
                try {
                    fout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    private String readFromFile(String Filename)
    {
        FileInputStream in=null;
        StringBuilder stringBuilder=new StringBuilder();
        try {
            in=openFileInput(Filename);
            InputStreamReader inputStreamReader=new InputStreamReader(in, Charset.forName("UTF-8"));

            int reader=0;
            while((reader=inputStreamReader.read())!=-1)
            {
                stringBuilder.append((char)reader);

            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(in!=null)
            {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return stringBuilder.toString();
    }

    public void onSave(View view) {
        EditText txt=findViewById(R.id.content);
        saveFile(FileName,txt.getText().toString());
        Toast.makeText(getApplicationContext(),"File Is Saved!!!!",Toast.LENGTH_LONG).show();
        txt.setText("");
    }

    public void onLoad(View view) {
        EditText txt=findViewById(R.id.Loaded);
        txt.setText(readFromFile(FileName));
    }
}
