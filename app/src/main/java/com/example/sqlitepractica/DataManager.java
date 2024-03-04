package com.example.sqlitepractica;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DataManager extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "parking";
    private static final String TABLE_COCHES = "coches";

    private static final String MATRICULA = "matricula";
    private static final String MARCA = "marca";
    private static final String MODELO = "modelo";
    private static final String NOMBRE = "nombre";
    private static final String APELLIDO = "apellido";
    private static final String TELEFONO = "telefono";

    public DataManager(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_COCHES + "(" + NOMBRE + " TEXT, " + APELLIDO + " TEXT, " + TELEFONO + " TEXT, " + MARCA + " TEXT, " + MODELO + " TEXT, " + MATRICULA + " TEXT PRIMARY KEY" + ")";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(("DROP TABLE IF EXISTS " + TABLE_COCHES));
        onCreate(db);
    }

    public void addCoches(Coche coche){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(NOMBRE, coche.getNombre());
        valores.put(APELLIDO, coche.getApellido());
        valores.put(TELEFONO, coche.getTelefono());
        valores.put(MARCA, coche.getMarca());
        valores.put(MODELO, coche.getModelo());
        valores.put(MATRICULA, coche.getMatricula());

        db.insert(TABLE_COCHES, null, valores);
    }

    public List<Coche> getAllCoches(){
        List<Coche> coches = new ArrayList<>();
        String selectTodos = "SELECT * FROM " + TABLE_COCHES;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectTodos, null);

        if (cursor.moveToFirst()){
            do {
                Coche coche = new Coche();
                coche.setNombre(cursor.getString(0));
                coche.setApellido(cursor.getString(1));
                coche.setTelefono(cursor.getString(2));
                coche.setMarca(cursor.getString(3));
                coche.setModelo(cursor.getString(4));
                coche.setMatricula(cursor.getString(5));


                coches.add(coche);
            } while (cursor.moveToNext());
        }
        return coches;
    }
}
