package com.example.magos;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class DB extends MainActivity {
    SQLiteDatabase db;
    ListView listaMagos;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.db_vista);

        listaMagos = findViewById(R.id.listaMagos);

        db = openOrCreateDatabase("MagosDB", Context.MODE_PRIVATE, null);
        db.execSQL(
                "CREATE TABLE IF NOT EXISTS Magos(id INTEGER PRIMARY KEY, nombre VARCHAR, nombre_mago VARCHAR, edad INTEGER, elemento VARCHAR, magia_doble BOOLEAN, elemento_extra VARCHAR);");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public void Ver(){
        ArrayAdapter<String> adapterVer;
        List<String>lista =new ArrayList<String>();
        Cursor c =db.rawQuery("SELECT * FROM Magos", null);
        while (c.moveToNext()){
            lista.add(c.getString(0)+" | "+c.getString(1));
        }
        db.close();
        adapterVer = new ArrayAdapter<>(getApplicationContext(), R.layout.db_vista, lista);
        listaMagos.setAdapter(adapterVer);
    }
}
