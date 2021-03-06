package com.example.android.pets.data;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;
import com.example.android.pets.data.PetsContract.PetsEntry;
import com.example.android.pets.R;

/**
 * Created by Vasu Sharma on 25-10-2017.
 */

public class PetCursorAdapter extends CursorAdapter {

    public PetCursorAdapter(Context context, Cursor c) {
        super(context, c , 0 /*flags*/ );
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.list_item,viewGroup,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView nameTextView = (TextView)view.findViewById(R.id.name);
        TextView summaryTextView = (TextView)view.findViewById(R.id.summary);

        //cursor is on the right row automatically
        int nameColumnIndex = cursor.getColumnIndex(PetsEntry.COLUMN_NAME);
        int breedColumnIndex = cursor.getColumnIndex(PetsEntry.COLUMN_BREED);

        String name = cursor.getString(nameColumnIndex);
        String breed = cursor.getString(breedColumnIndex);
        if (TextUtils.isEmpty(breed)){
            breed=context.getString(R.string.unknown_breed);
        }

        nameTextView.setText(name);
        summaryTextView.setText(breed);
    }
}
