package com.trabalho.redes.redes;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    // save the path where a new file will be created
    // it will be saved at device's internal storage
    public String path =  Environment.getExternalStorageDirectory().getAbsolutePath() + "/teste";

    final Thread t = new Thread(new Runnable() {

        @Override
        public void run() {
            try {
                Socket sock = new Socket("192.168.0.14", 13267);

                // sendfile
                File myFile = new File(path + "/ArquivoTeste.txt");
                byte[] mybytearray = new byte[(int) myFile.length()];

                FileInputStream fis = new FileInputStream(myFile);
                BufferedInputStream bis = new BufferedInputStream(fis);
                bis.read(mybytearray, 0, mybytearray.length);

                OutputStream os = sock.getOutputStream();

                os.write(mybytearray, 0, mybytearray.length);

                os.flush();

                sock.close();
            } catch (IOException e) {

            }
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // create the folder where the file will be saved
        File dir = new File(path);
        dir.mkdir();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // create the file that will be sent
                File teste = new File(path + "/ArquivoTeste.txt");
                // save the file in the device
                Save(teste, "teste123");
                Snackbar.make(view, "Arquivo criado com sucesso", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                t.start();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static void Save(File file, String data)
    {
        FileOutputStream newFile = null;
        try {
            newFile = new FileOutputStream(file);
            newFile.write(data.getBytes());
            newFile.close();
        }catch(IOException e){
            System.out.println(e);
        }

    }



}
