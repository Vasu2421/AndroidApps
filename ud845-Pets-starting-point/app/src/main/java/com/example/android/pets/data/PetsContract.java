package com.example.android.pets.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by Vasu Sharma on 10-10-2017.
 */

public final class PetsContract {


    public static final String CONTENT_AUTHORITY="com.example.android.pets";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://"+CONTENT_AUTHORITY);
    public static final String PATH_PETS = "pets";



    public static final class PetsEntry implements BaseColumns{
        public static final String TABLE_NAME="pets";
        public static final String _ID=BaseColumns._ID;
        public static final String COLUMN_NAME="name";
        public static final String COLUMN_BREED="breed";
        public static final String COLUMN_GENDER="gender";
        public static final String COLUMN_WEIGHT="weight";

        public static final int GENDER_UNKNOWN=0;
        public static final int GENDER_MALE=1;
        public static final int GENDER_FEMALE=2;

        public static boolean isValidGender(int gender){
            return gender == GENDER_MALE || gender == GENDER_FEMALE ||
                    gender == GENDER_UNKNOWN;
        }

        public static final Uri CONTENT_URI =
                Uri.withAppendedPath(BASE_CONTENT_URI,PATH_PETS);


//        MIME Format:-

//       "vnd.android.cursor.dir   /     com.example.android.pets    /      pets"

        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY +
                        "/" + PATH_PETS;


        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY +
                        "/" + PATH_PETS;

    }
}
