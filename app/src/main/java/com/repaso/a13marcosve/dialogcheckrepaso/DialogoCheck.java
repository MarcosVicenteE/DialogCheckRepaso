package com.repaso.a13marcosve.dialogcheckrepaso;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class DialogoCheck extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogo_check);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dialogo_check, menu);
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


    protected Dialog onCreateDialog(int id) {
        final TextView texto = (TextView) findViewById(R.id.txtvTexto);
        AlertDialog.Builder venta = new AlertDialog.Builder(this);
        venta.setTitle(getString(R.string.tituloDialog));
        Resources res = getResources();
        final String[] vehiculos = res.getStringArray(R.array.vehiculos);
        final boolean[] seleccion = new boolean[]{false, true, false, true, false, false, false};
        // Non incluír mensaxe dentro de este tipo de diálogo!!!
        venta.setMultiChoiceItems(R.array.vehiculos, seleccion, new DialogInterface.OnMultiChoiceClickListener() {
            public void onClick(DialogInterface dialog, int opcion, boolean isChecked) {
                // Evento que ocorre cando o usuario selecciona unha opción
                if (isChecked)
                    seleccion[opcion] = true;

                else
                    seleccion[opcion] = false;
            }
        });
        venta.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int boton) {
                texto.setText("");
                int i = 0;
                for (boolean slect : seleccion) {
                    if (slect) {
                        texto.append(vehiculos[i] + "\n");
                    }
                    i++;
                }
            }
        });
        venta.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int boton) {
                Toast.makeText(getApplicationContext(), "Premeches 'Cancelar'", Toast.LENGTH_SHORT).show();
            }
        });
        return venta.create();
    }

    //EVENTO BOTON
    public void onClick(View view) {
        showDialog(1);

    }
}
