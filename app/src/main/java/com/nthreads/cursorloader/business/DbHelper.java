package com.nthreads.cursorloader.business;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Nauman Zubair on 1/27/2016.
 */
public class DbHelper {
    private static final String DATABASE_NAME = "nthreads";
    private static final int DATABASE_VERSION = 1;
    private SQLiteDatabase database; // database object
    private DatabaseOpenHelper databaseOpenHelper; // database helper

    private static final String KEY_ID = "_id";
    private static final String KEY_NAME = "_name";
    private static final String KEY_NUMBER = "_name";
    private static final String KEY_IMAGE_URI = "_image_uri";

    private static final String TBL_CONTACTS = "tb_contacts";

    private static final String CREATE_COMMAND = "CREATE TABLE " + TBL_CONTACTS + "("
            + KEY_ID + "INTEGER primary key autoincrement,"
            + KEY_NAME + " TEXT,"
            + KEY_NUMBER + " INTEGER,"
            + KEY_IMAGE_URI + " TEXT)";


    public DbHelper(Context context) {
        databaseOpenHelper = new DatabaseOpenHelper(context, DATABASE_NAME,
                null, DATABASE_VERSION);
    }

    public void open() throws SQLException {
        if (database == null)
            database = databaseOpenHelper.getWritableDatabase();
    }

    public void close() {
        if (database != null)
            database.close(); // close the database connection
    }



    private class DatabaseOpenHelper extends SQLiteOpenHelper {
        public DatabaseOpenHelper(Context context, String name, CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_COMMAND);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
