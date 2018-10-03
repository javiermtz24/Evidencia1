package com.example.javiermtz.evidencia1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.view.Menu;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    public static final String EXTRA_NOMBRE = "com.example.javiermtz.evidencia1.EXTRA_NOMBRE";
    public static final String EXTRA_APELLIDOP = "com.example.javiermtz.evidencia1.EXTRA_APELLIDOP";
    public static final String EXTRA_APELLIDOM = "com.example.javiermtz.evidencia1.EXTRA_APELLIDOM";
    public static final String EXTRA_FECHA = "com.example.javiermtz.evidencia1.EXTRA_FECHA";
    public static final String EXTRA_ENTIDAD = "com.example.javiermtz.evidencia1.EXTRA_ENTIDAD";
    public static final String EXTRA_GENERO = "com.example.javiermtz.evidencia1.EXTRA_GENERO";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //SPINNER INIT
        @SuppressLint("WrongViewCast") Spinner spinner = findViewById(R.id.spinnerEnt);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.entidad, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        //SPINNER INIT
        Spinner spinnerGender = findViewById(R.id.spinnerSexo);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.arrayGenero, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGender.setAdapter(adapter2);

        //INTENT ACTIVITY 2
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
    }

    //OPEN ACTIVITY 2 AND SEND DATA
    public void openActivity2(){
        EditText name = (EditText) findViewById(R.id.name);
        String nombre = name.getText().toString();

        EditText lastName1 = (EditText) findViewById(R.id.lastName1);
        String apellidoP = lastName1.getText().toString();

        EditText lastName2 = (EditText) findViewById(R.id.lastName2);
        String apellidoM = lastName2.getText().toString();

        EditText date = (EditText) findViewById(R.id.date);
        int fecha = Integer.parseInt(date.getText().toString());

        Spinner spinnerEnt = (Spinner) findViewById(R.id.spinnerEnt);
        String entidadF = spinnerEnt.getSelectedItem().toString();

        Spinner spinnerSexo = (Spinner) findViewById(R.id.spinnerSexo);
        String genero = spinnerSexo.getSelectedItem().toString();


        Intent intent = new Intent(this, Activity2.class);
        intent.putExtra(EXTRA_NOMBRE, nombre);
        intent.putExtra(EXTRA_APELLIDOP, apellidoP);
        intent.putExtra(EXTRA_APELLIDOM, apellidoM);
        intent.putExtra(EXTRA_FECHA, fecha);
        intent.putExtra(EXTRA_ENTIDAD, entidadF);
        intent.putExtra(EXTRA_GENERO, genero);

        startActivity(intent);
    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        String text = parent.getItemAtPosition(position).toString();
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    //MENU
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.cerrar_sesion:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}