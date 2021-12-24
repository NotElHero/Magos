package com.example.magos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botonGuardar = findViewById(R.id.guardar);
        botonGuardar.setOnClickListener(this);

        Spinner elemento = findViewById(R.id.elemento);
        elemento.setOnItemSelectedListener(this);
        Spinner elementoDoble = findViewById(R.id.elemento2);
        elementoDoble.setOnItemSelectedListener(this);
        String elementos[] =
                {"Luz", "Oscuridad", "Vacio", "Fuego", "Agua", "Naturaleza", "Viento", "Plasma", "Magnetismo", "Roca", "Metal", "Hielo"};
        String elementosDobles[] =
                {"Fuego", "Agua", "Naturaleza", "Viento", "Plasma", "Magnetismo", "Roca", "Metal", "Hielo"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, elementos);
        elemento.setAdapter(adapter);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, elementosDobles);
        elementoDoble.setAdapter(adapter2);

    }

    @Override
    public void onClick(View v) {
        Toast toast = Toast.makeText(this, "Datos guardados", Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}