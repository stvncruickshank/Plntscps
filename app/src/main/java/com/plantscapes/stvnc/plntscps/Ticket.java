package com.plantscapes.stvnc.plntscps;

/**
 * Created by stvnc on 3/25/2018.
 */

public class Ticket {

    private int id;
    private String acct_name;
    private String location;
    private String date_written;

    public Ticket() {
    }


    public Ticket(String name, String date, String loc){
        this.acct_name = name;
        this.date_written = date;
        this.location = loc;
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

    public void setDateWritten(String date){
        this.date_written = date;
    }
    public String getDateWritten() {
        return date_written;
    }

    public void setLocation(String loc){
        this.location = loc;
    }
    public String getLocation(){    return location;    }

    public void setId(int id) {
        this.id = id;
    }

    //public void setDateWritten(String timestamp) {
      //  this.date_written = timestamp;
    //}
}
