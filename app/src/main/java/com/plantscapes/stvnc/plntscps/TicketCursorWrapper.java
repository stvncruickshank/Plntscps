package com.plantscapes.stvnc.plntscps;

import android.database.Cursor;
import android.database.CursorWrapper;

/**
 * Created by stvnc on 3/26/2018.
 */

public class TicketCursorWrapper extends CursorWrapper {

    public TicketCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    //get the vals directly from the db table
    public Ticket getRes() {
        String rName = getString(getColumnIndex(TicketSchema.TicketTable.Cols.R_NAME));
        String rDate = getString(
                getColumnIndex(TicketSchema.TicketTable.Cols.R_DATE));
        //String rTime = getString(getColumnIndex(ResSchema.ResTable.Cols.R_TIME));
        //String rPhone = getString(getColumnIndex(ResSchema.ResTable.Cols.R_PH));
        String rLocation = getString(getColumnIndex(TicketSchema.TicketTable.Cols.R_LOC));


        Ticket tix = new Ticket(rName, rDate, rLocation);

        return tix;
    }

}
