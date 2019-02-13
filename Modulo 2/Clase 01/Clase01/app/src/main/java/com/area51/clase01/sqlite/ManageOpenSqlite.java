package com.area51.clase01.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class ManageOpenSqlite extends SQLiteOpenHelper {
    public ManageOpenSqlite(@Nullable Context context) {
        super(context, "clase1.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(
                "create table marca(" +
                        "id integer primary key autoincrement," +
                        "nombre text)"
        );
        sqLiteDatabase.execSQL(
                "create table producto(" +
                        "id integer primary key autoincrement," +
                        "nombre text," +
                        "modelo text," +
                        "color text," +
                        "idMarca integer)"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
