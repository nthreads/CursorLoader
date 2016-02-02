package com.nthreads.cursorloader.adapter;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nthreads.cursorloader.R;

import static android.provider.ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME;
import static android.provider.ContactsContract.CommonDataKinds.Phone.NUMBER;
import static android.provider.ContactsContract.CommonDataKinds.Phone.PHOTO_URI;

/**
 * Created by Nauman Zubair on 1/17/2016.
 */
public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactHolder> {

    Cursor cursor;
    Context mContext;

    public ContactAdapter(Context context, Cursor cursor) {
        mContext = context;
        this.cursor = cursor;
    }

    @Override
    public ContactHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_contact, null);
        return new ContactHolder(view);
    }

    @Override
    public int getItemCount() {
        return cursor.getCount();
    }

    @Override
    public void onBindViewHolder(ContactHolder holder, int position) {
        cursor.moveToPosition(position);

        holder.tvContactName.setText(cursor.getString(cursor.getColumnIndex(DISPLAY_NAME)));
        holder.tvContactNumber.setText(cursor.getString(cursor.getColumnIndex(NUMBER)));
        String imageUri = cursor.getString(cursor.getColumnIndex(PHOTO_URI));

        try {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(mContext.getContentResolver(), Uri.parse(imageUri));
            holder.ivContactPhoto.setImageBitmap(bitmap);
        } catch (Exception e) {
            e.printStackTrace();
            holder.ivContactPhoto.setImageBitmap(null);
        }
    }

    class ContactHolder extends RecyclerView.ViewHolder {

        ImageView ivContactPhoto;
        TextView tvContactName, tvContactNumber;

        public ContactHolder(View itemView) {
            super(itemView);
            ivContactPhoto = (ImageView) itemView.findViewById(R.id.ivContactPhoto);
            tvContactName = (TextView) itemView.findViewById(R.id.tvContactName);
            tvContactNumber = (TextView) itemView.findViewById(R.id.tvContactNumber);
        }
    }
}
