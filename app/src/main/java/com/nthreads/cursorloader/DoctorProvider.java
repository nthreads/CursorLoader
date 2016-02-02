package com.nthreads.cursorloader;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.Nullable;

import com.nthreads.cursorloader.business.DbHelper;

public class DoctorProvider extends ContentProvider {
    public DoctorProvider() {
    }

    private static final String PROVIDER_NAME = "com.nthreads.cursorloader.business.DoctorProvider";
    public static final Uri CONTENT_URI = Uri.parse("content://" + PROVIDER_NAME + "/doctors" );

    private DbHelper dbHelper;

    /** Constants to identify the requested operation */
    private static final int DOCTORS = 1;
    private static final UriMatcher uriMatcher ;
    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(PROVIDER_NAME, "doctors", DOCTORS);
    }

    @Override
    public boolean onCreate() {
        dbHelper = new DbHelper(getContext());
        dbHelper.open();

        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        if(uriMatcher.match(uri) == DOCTORS){

            Cursor cursor = dbHelper.getAllContacts();


            return cursor;
        }else{
            return null;
        }
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
