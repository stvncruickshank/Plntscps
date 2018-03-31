package com.plantscapes.stvnc.plntscps;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by stvnc on 3/25/2018.
 */

public class dbHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "TicketsDB.db";

    public dbHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //create the db!
        Log.d("CriminalIntent", Log.getStackTraceString(new Exception()));

        db.execSQL("create table " + TicketSchema.TicketTable.NAME + "(" +
                " _id integer primary key autoincrement, " +
                TicketSchema.TicketTable.Cols.R_NAME + ", " +
                TicketSchema.TicketTable.Cols.R_DATE + ", " +
                //ResSchema.ResTable.Cols.R_TIME + ", " +
                TicketSchema.TicketTable.Cols.R_LOC +
                //ResSchema.ResTable.Cols.R_PH +
                ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
