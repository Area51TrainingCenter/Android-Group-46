package com.area51.clase01.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.area51.clase01.modelos.Marca;
import com.area51.clase01.modelos.Producto;

import java.util.ArrayList;

public class MetodoSQLite {
    private ManageOpenSqlite conexion;

    public MetodoSQLite(Context context) {
        conexion = new ManageOpenSqlite(context);
    }

    public ArrayList<Marca> obtenerMarcas() {
        SQLiteDatabase db = conexion.getReadableDatabase();
        //db.beginTransaction();
        Cursor cursor =
                db.rawQuery("select * from marca", null);

        ArrayList<Marca> lista = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                Marca marca = new Marca(
                        cursor.getInt(cursor.getColumnIndex("id")),
                        cursor.getString(cursor.getColumnIndex("nombre"))
                );
                lista.add(marca);
            } while (cursor.moveToNext());
        }
        //db.endTransaction();
        /*if (db.isOpen())
            db.close();*/
        return lista;
    }

    public ArrayList<Producto> obtenerProductos() {
        SQLiteDatabase db = conexion.getReadableDatabase();
        Cursor cursor = db.rawQuery(
                "select a.id, " +
                        "a.nombre, " +
                        "a.modelo, " +
                        "a.color, " +
                        "b.id as 'idMarca', " +
                        "b.nombre as 'marca' " +
                        "from producto a " +
                        "inner join marca b on a.idMarca=b.id",
                null);
        ArrayList<Producto> lista = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                Producto producto = new Producto();
                producto.setId(cursor.getInt(cursor.getColumnIndex("id")));
                producto.setNombre(cursor.getString(cursor.getColumnIndex("nombre")));
                producto.setMarca(cursor.getString(cursor.getColumnIndex("marca")));
                producto.setModelo(cursor.getString(cursor.getColumnIndex("modelo")));
                producto.setIdMarca(cursor.getInt(cursor.getColumnIndex("idMarca")));
                producto.setColor(cursor.getString(cursor.getColumnIndex("color")));
                lista.add(producto);
            } while (cursor.moveToNext());
        }
        return lista;
    }

    public long registrarMarca(Marca marca) {
        SQLiteDatabase db = conexion.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("nombre", marca.getNombre());

        return db.insert("marca", null, values);
    }

    public void registrarProducto(Producto producto) {
        SQLiteDatabase db = conexion.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("nombre", producto.getNombre());
        values.put("idMarca", producto.getIdMarca());
        values.put("modelo", producto.getModelo());
        values.put("color", producto.getColor());

        db.insert("producto", null, values);
    }

    public int eliminarProductoPorId(int id) {
        SQLiteDatabase db = conexion.getWritableDatabase();
        int result = 0;
        try {
            db.beginTransaction();
            result = db.delete("producto", "id=?",
                    new String[]{String.valueOf(id)});
            db.setTransactionSuccessful();
        } catch (Exception e) {

        }
        db.endTransaction();
        return result;
    }

    public int actualizarProducto(Producto producto) {
        SQLiteDatabase db = conexion.getWritableDatabase();
        int result = 0;
        db.beginTransaction();

        ContentValues values = new ContentValues();
        values.put("nombre", producto.getNombre());
        values.put("idMarca", producto.getIdMarca());
        values.put("modelo", producto.getModelo());
        values.put("color", producto.getColor());
        result = db.update("productos", values, "id=?",
                new String[]{String.valueOf(producto.getId())});

        db.setTransactionSuccessful();
        db.endTransaction();
        return result;
    }
}
