package com.nthreads.cursorloader.business;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Package Name : com.nthreads.cursorloader.business
 * Created by Muhammad Nauman Zubair on 2/2/2016 5:08 PM
 * Copyright (c) 2016 Alpha Squared. All rights reserved.
 */
public class DoctorProvider extends ContentProvider {

    private static final String PROVIDER_NAME = "com.nthreads.cursorloader.business.DoctorProvider";
    @Override
    public boolean onCreate() {
        return false;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return null;
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
