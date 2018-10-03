package com.example.javiermtz.evidencia1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Intent intent = getIntent();
        String nombre = intent.getStringExtra(MainActivity.EXTRA_NOMBRE);
        String apellidoP = intent.getStringExtra(MainActivity.EXTRA_APELLIDOP);
        String apellidoM = intent.getStringExtra(MainActivity.EXTRA_APELLIDOM);
        int fecha = intent.getIntExtra(MainActivity.EXTRA_FECHA, 0);
        String entidadF = intent.getStringExtra(MainActivity.EXTRA_ENTIDAD);
        String genero = intent.getStringExtra(MainActivity.EXTRA_GENERO);

        TextView name = (TextView) findViewById(R.id.name);
        TextView lastName1 = (TextView) findViewById(R.id.lastName1);
        TextView lastName2 = (TextView) findViewById(R.id.lastName2);
        TextView date = (TextView) findViewById(R.id.date);
        TextView spinnerEnt = (TextView) findViewById(R.id.spinnerEnt);
        TextView spinnerSexo = (TextView) findViewById(R.id.spinnerSexo);
        TextView curp = (TextView) findViewById(R.id.curp);


        name.setText(nombre);
        lastName1.setText(apellidoP);
        lastName2.setText(apellidoM);
        date.setText("" + fecha);
        spinnerEnt.setText(entidadF);
        spinnerSexo.setText(genero);

        String curpN = nombre;
        char n = curpN.charAt(0);

        String curpAP = apellidoP;
        char ap = curpAP.charAt(0);

        String curpAM = apellidoM;
        char am = curpAM.charAt(0);

        String curpE = entidadF;
        char ef = curpE.charAt(0);

        String curpS = genero;
        char s = curpS.charAt(0);

        String curpFinal = ap + "A" + am + n + fecha + s + ef;
        curp.setText(curpFinal);
    }

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
