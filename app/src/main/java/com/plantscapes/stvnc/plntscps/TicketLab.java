package com.plantscapes.stvnc.plntscps;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.plantscapes.stvnc.plntscps.TicketSchema.TicketTable.Cols.R_DATE;
import static com.plantscapes.stvnc.plntscps.TicketSchema.TicketTable.Cols.R_LOC;
import static com.plantscapes.stvnc.plntscps.TicketSchema.TicketTable.Cols.R_NAME;

/**
 * Created by stvnc on 3/26/2018.
 */

public class TicketLab {
    public static TicketLab sTixLab;
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public static TicketLab get(Context context) {
        if (sTixLab == null) {
            sTixLab = new TicketLab(context);
        }

        return sTixLab;
    }

    public TicketLab(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new dbHelper(mContext)
                .getWritableDatabase();

    }

    public void addTicket(Ticket c) {
        ContentValues values = getContentValues(c);
        mDatabase.insert(TicketSchema.TicketTable.NAME, null, values);
    }

    public int deleteTicket(String name)
    {
        //do this as a WHERE statement to prevent SQL injection
        //if ACCTNAME == string name, then BYEEEEEEE
        return mDatabase.delete(TicketSchema.TicketTable.NAME,"ACCTNAME=?",new String[] {name});
    }

    public List<Ticket> getRes() {
        List<Ticket> crimes = new ArrayList<>();
        TicketCursorWrapper cursor = queryCrimes(null, null);
        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                crimes.add(cursor.getRes());
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }
        return crimes;
    }

    public Ticket getRes(UUID id) {
        TicketCursorWrapper cursor = queryCrimes(
                R_NAME + " = ?",
                new String[]{id.toString()}
        );
        try {
            if (cursor.getCount() == 0) {
                return null;
            }
            cursor.moveToFirst();
            return cursor.getRes();
        } finally {
            cursor.close();
        }
    }


    private TicketCursorWrapper queryCrimes(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                TicketSchema.TicketTable.NAME,
                null, // Columns - null selects all columns
                whereClause,
                whereArgs,
                null, // groupBy
                null, // having
                null  // orderBy
        );
        return new TicketCursorWrapper(cursor);
    }

    private static ContentValues getContentValues(Ticket tix) {
        ContentValues values = new ContentValues();
        values.put(TicketSchema.TicketTable.Cols.R_NAME, tix.getAcctName());
        values.put(TicketSchema.TicketTable.Cols.R_DATE, tix.getDateWritten().toString());
        //values.put(R_TIME, crime.getResTime());
        //values.put(R_PH, crime.getResPh());
        values.put(TicketSchema.TicketTable.Cols.R_LOC, tix.getLocation());

        return values;
    }
}
