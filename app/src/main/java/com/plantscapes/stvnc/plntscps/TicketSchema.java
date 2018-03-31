package com.plantscapes.stvnc.plntscps;

/**
 * Created by stvnc on 3/26/2018.
 */

public class TicketSchema {

    public static final class TicketTable {
        public static final String NAME = "TicketLog";

        public static final class Cols {

            public static final String R_NAME = "ACCTNAME";
            public static final String R_DATE = "DATE";
            public static final String R_LOC = "LOCATION";

        }

        public static final int NUM_COLS = 3;
    }

}
