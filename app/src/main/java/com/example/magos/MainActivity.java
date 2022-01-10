package com.example.magos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener, MenuItem.OnMenuItemClickListener {

    EditText nombre, nombreMago, edad;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         nombre = findViewById(R.id.nombre);
         nombreMago = findViewById(R.id.nombreMago);
         edad = findViewById(R.id.edad);

        Button botonGuardar = findViewById(R.id.guardar);
        botonGuardar.setOnClickListener(this);

        Spinner elemento = findViewById(R.id.elemento);
        elemento.setOnItemSelectedListener(this);
        Spinner elementoDoble = findViewById(R.id.elemento2);
        elementoDoble.setOnItemSelectedListener(this);
        String elementos[] =
                {"Selecciona un elemento", "Luz", "Oscuridad", "Vacio", "Fuego", "Agua", "Naturaleza", "Viento", "Plasma", "Magnetismo", "Roca", "Metal", "Hielo"};
        String elementosDobles[] =
                {"Selecciona un elemento", "Fuego", "Agua", "Naturaleza", "Viento", "Plasma", "Magnetismo", "Roca", "Metal", "Hielo"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, elementos);
        elemento.setAdapter(adapter);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, elementosDobles);
        elementoDoble.setAdapter(adapter2);

        db = openOrCreateDatabase("MagosDB", Context.MODE_PRIVATE, null);
        db.execSQL(
                "CREATE TABLE IF NOT EXISTS Magos(id INTEGER PRIMARY KEY, nombre VARCHAR, nombre_mago VARCHAR, edad INTEGER, elemento VARCHAR, magia_doble BOOLEAN, elemento_extra VARCHAR);");

    }

    @Override
    public void onClick(View v) {
        if (nombre.getText().toString().equals(null) || nombreMago.getText().toString().equals(null)){
            Toast error = Toast.makeText(this, "introduce datos", Toast.LENGTH_SHORT);
            error.show();
        }else {
            db.execSQL(
                    "INSERT INTO Magos VALUES ('" + nombre.getText().toString() + "','" + nombreMago.getText().toString() + "')");
            Toast toast = Toast.makeText(this, "Datos guardados", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {

        return false;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
}