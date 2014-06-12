package com.designs_1393.punchtracker2.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.designs_1393.punchtracker2.Victim;

import java.util.ArrayList;
import java.util.List;

public class VictimDataSource {

    private SQLiteDatabase database;
    private DbHelper dbHelper;
    private String[] allColumns = {
        DbHelper.KEY_ID,
        DbHelper.KEY_VICTIM,
        DbHelper.KEY_NUM_TRACKED,
    };

    public VictimDataSource(Context context) {
        dbHelper = new DbHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public boolean isOpen() {
        return database.isOpen();
    }

    public boolean addVictim(Victim newVictim) {
        ContentValues values = new ContentValues();
        values.put(DbHelper.KEY_VICTIM, newVictim.getVictimName());
        values.put(DbHelper.KEY_NUM_TRACKED, 0);

        return (database.insert(DbHelper.TRACKER_TABLE, null, values) > 0);
    }

    public void deleteVictim(Victim victim) {
        long id = victim.getId();
        database.delete(DbHelper.TRACKER_TABLE, DbHelper.KEY_ID
                + " = " + id, null);
    }

    public boolean abandonShip() {
        return database.delete(DbHelper.TRACKER_TABLE, null, null) > 0;
    }

    public List<Victim> getAllVictims() {
        List<Victim> victims = new ArrayList<Victim>();

        Cursor cursor = database.query(DbHelper.TRACKER_TABLE,
                allColumns, null, null, null, null, DbHelper.KEY_VICTIM);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Victim victim = cursorToVictim(cursor);
            victims.add(victim);
            cursor.moveToNext();
        }
        cursor.close();

        return victims;
    }

    public Victim getSub(int position) {
        List<Victim> subs = getAllVictims();
        try {
            return subs.get(position);
        } catch (Exception e) {
            return new Victim();
        }
    }

    private Victim cursorToVictim(Cursor cursor) {
        Victim victim = new Victim();
        victim.setId(cursor.getLong(0));
        victim.setVictimName(cursor.getString(1));
        victim.setTrackedNumber(cursor.getInt(2));
        return victim;
    }

}
