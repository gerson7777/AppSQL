package com.example.abyte.appsql;

import android.database.Cursor;
import android.database.SQLException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import Beans.UsuarioBeans;
import OpenHelper.SQLite_OpenHelper;

public class Principal extends AppCompatActivity {
 ListView lv;
    SQLite_OpenHelper helper = new SQLite_OpenHelper(this,"BD1",null,1);
    EditText txtNom;
    Button btnConsultarNom, btnTodos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        txtNom = (EditText) findViewById(R.id.txtNomCon);
        btnConsultarNom =(Button) findViewById(R.id.btnConsultarUsu);
        btnTodos= (Button) findViewById(R.id.btnMostrarTodos);


        btnConsultarNom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cargarUsuarios(txtNom.getText().toString());
                txtNom.setText("");
            }
        });


        btnTodos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cargarUsuarios("");

            }
        });

        lv= (ListView) findViewById(R.id.lbUsuarios);
        cargarUsuarios("");

    }

    private void cargarUsuarios(String nom){
        helper.abrir();
        Cursor cursor=null;
        try{
            if(nom == null || nom.length()==0){
                cursor= helper.listarUsuarios();
            }else{
                cursor=helper.listarUsuarioNom(nom);

                }
        }catch (SQLException e){
                e.printStackTrace();
        }
        ArrayList<UsuarioBeans> item = new ArrayList<UsuarioBeans>();
        do{
            UsuarioBeans u = new UsuarioBeans(cursor.getInt(0),cursor.getString(1),
                    cursor.getString(2),cursor.getString(3),cursor.getString(4));
            item.add(u);
        }while (cursor.moveToNext());
        ArrayAdapter<UsuarioBeans> adaptador = new ArrayAdapter<UsuarioBeans>
                (this, android.R.layout.simple_list_item_1,item);
        lv.setAdapter(adaptador);

    }
}
