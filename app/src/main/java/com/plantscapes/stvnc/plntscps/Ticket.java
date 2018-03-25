package com.plantscapes.stvnc.plntscps;

/**
 * Created by stvnc on 3/25/2018.
 */

public class Ticket {

    public static final String TABLE_NAME = "Tickets";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_ACCT_NAME = "acct_name";
    public static final String COLUMN_DATE = "date";

    private int id;
    private String acct_name;
    private String date_written;


    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_ACCT_NAME + " TEXT,"
                    + COLUMN_DATE + " DATETIME DEFAULT CURRENT_TIMESTAMP"
                    + ")";

    public Ticket() {
    }

    public Ticket(int id, String note, String timestamp) {
        this.id = id;
        this.acct_name = note;
        this.date_written = timestamp;
    }

    public int getId() {
        return id;
    }

    public String getAcctName() {
        return acct_name;
    }

    public void setAcctName(String note) {
        this.acct_name = note;
    }

    public String getDateWritten() {
        return date_written;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDateWritten(String timestamp) {
        this.date_written = timestamp;
    }
}
