package com.example.sqlitepractica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private DataManager dataManager = new DataManager(MainActivity.this);
    private List<Coche> coches;
    public EditText nombre;
    public EditText apellido;
    public EditText telefono;
    public EditText marca;
    public EditText modelo;
    public EditText matricula;

    public RecyclerView recyclerView;

    public Button btnAdd;
    public Button btnSearch;
    public Button btnModify;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnAdd = findViewById(R.id.btnAdd);
        btnSearch = findViewById(R.id.btnSearch);
        btnModify = findViewById(R.id.btnModify);

        btnAdd.setOnClickListener(this);
        btnSearch.setOnClickListener(this);
        btnModify.setOnClickListener(this);

        matricula = findViewById(R.id.matricula);
        nombre = findViewById(R.id.name);
        apellido = findViewById(R.id.lastName);
        telefono = findViewById(R.id.phone);
        marca = findViewById(R.id.carBrand);
        modelo = findViewById(R.id.carModel);


        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        coches = dataManager.getAllCoches();

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        RecyclerViewApp adapter = new RecyclerViewApp(coches);
        recyclerView.setAdapter(adapter);


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnAdd) {
            if (matricula.getText().toString().equals("")) {
                Toast toast = Toast.makeText(getApplicationContext(), "Introduce una matricula", Toast.LENGTH_SHORT);
                toast.show();
            } else {
                Coche coche = new Coche(matricula.getText().toString(), nombre.getText().toString(), apellido.getText().toString(), telefono.getText().toString(), marca.getText().toString(), modelo.getText().toString());
                DataManager dataManager = new DataManager(MainActivity.this);
                dataManager.addCoches(coche);
                Toast toast = Toast.makeText(getApplicationContext(), "Coche añadido", Toast.LENGTH_SHORT);
                toast.show();
            }
        }

    }
}