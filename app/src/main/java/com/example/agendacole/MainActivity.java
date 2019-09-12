package com.example.agendacole;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnGuardar, btnBuscar, btnBorrar, btnActualizar;
    EditText etId, etNombres, etTelefonos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGuardar = (Button)findViewById(R.id.btn_Guardar);
        btnBuscar = (Button)findViewById(R.id.btn_Buscar);
        btnBorrar = (Button)findViewById(R.id.btn_Borrar);
        btnActualizar = (Button)findViewById(R.id.btn_Actualizar);

        etId = (EditText)findViewById(R.id.et_Id);
        etNombres = (EditText)findViewById(R.id.et_Nombres);
        etTelefonos = (EditText)findViewById(R.id.et_Telefonos);

        final AyudaBD ayudaBD = new AyudaBD(getApplicationContext());

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SQLiteDatabase db = ayudaBD.getWritableDatabase();
                ContentValues valores = new ContentValues();
                valores.put(AyudaBD.DatosTabla.COLUMNA_ID, etId.getText().toString());
                valores.put(AyudaBD.DatosTabla.COLUMNA_NOMBRES,etNombres.getText().toString());
                valores.put(AyudaBD.DatosTabla.COLUMNA_TELEFONOS,etTelefonos.getText().toString());

                Long IdGuardado = db.insert(AyudaBD.DatosTabla.NOMBRE_TABLA, AyudaBD.DatosTabla.COLUMNA_ID,valores);
                Toast.makeText(getApplicationContext(),"Se guardo el dato:  " + IdGuardado,Toast.LENGTH_LONG).show();

            }

        });
        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
