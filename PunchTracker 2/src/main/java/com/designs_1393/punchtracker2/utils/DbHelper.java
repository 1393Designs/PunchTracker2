package com.designs_1393.punchtracker2.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbHelper extends SQLiteOpenHelper {

    public static final String TRACKER_TABLE = "tracker";
    public static final String KEY_ID = "_id";
    public static final String KEY_NUM_TRACKED = "num_tracked";
    public static final String KEY_VICTIM = "victim";

    private static final String DATABASE_NAME = "tracker.db";
    private static final int DATABASE_VERSION = 1;

    // Database creation sql statement
    private static final String DATABASE_CREATE = "create table "
            + TRACKER_TABLE + "(" + KEY_ID
            + " integer primary key autoincrement, "
            + KEY_VICTIM + " text not null, "
            + KEY_NUM_TRACKED + " integer not null);";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DbHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TRACKER_TABLE);
        onCreate(db);
    }
}