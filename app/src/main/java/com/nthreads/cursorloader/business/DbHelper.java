package com.nthreads.cursorloader.business;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

import com.nthreads.cursorloader.entity.Doctor;

/**
 * Package Name : com.nthreads.cursorloader.business
 * Created by Muhammad Nauman Zubair on 1/27/2016 4:08 PM
 * Copyright (c) 2016 nthreads. All rights reserved.
 */

public class DbHelper {
    private static final String DATABASE_NAME = "nthreads";
    private static final int DATABASE_VERSION = 1;
    private SQLiteDatabase database; // database object
    private DatabaseOpenHelper databaseOpenHelper; // database helper

    private static final String KEY_ID = "_id";
    private static final String KEY_NAME = "_name";
    private static final String KEY_NUMBER = "_number";

    private static final String TBL_CONTACTS = "tb_contacts";

    private static final String CREATE_COMMAND = "CREATE TABLE " + TBL_CONTACTS + "("
            + KEY_ID + "INTEGER primary key autoincrement,"
            + KEY_NAME + " TEXT,"
            + KEY_NUMBER + " INTEGER";


    public DbHelper(Context context) {
        databaseOpenHelper = new DatabaseOpenHelper(context, DATABASE_NAME,
                null, DATABASE_VERSION);
    }

    public Cursor getAllContacts() {
        return database.query(TBL_CONTACTS, new String[]{KEY_ID, KEY_NAME, KEY_NUMBER}
                , null, null, null, null, KEY_NAME);
    }

    public void open() throws SQLException {
        if (database == null)
            database = databaseOpenHelper.getWritableDatabase();
    }

    public void close() {
        if (database != null)
            database.close(); // close the database connection
    }

    public boolean isOpened() {
        return database.isOpen();
    }

    public void insert(Doctor doctor) {
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, doctor.getName());
        values.put(KEY_NUMBER, doctor.getNumber());

        database.insert(TBL_CONTACTS, null, values);
    }

    private class DatabaseOpenHelper extends SQLiteOpenHelper {
        public DatabaseOpenHelper(Context context, String name, CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_COMMAND);

            insert(new Doctor("Nauman Zubair", 123456789));
            insert(new Doctor("Jonathan", 123456789));
            insert(new Doctor("Jenny Li", 123456789));
            insert(new Doctor("Cyndi Wu", 123456789));
            insert(new Doctor("Richard Xi", 123456789));

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
