package com.plantscapes.stvnc.plntscps;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by stvnc on 3/25/2018.
 */

public class CreateTicket extends Fragment {

    public static TicketLab tLab;
    public CreateTicket() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_newtix, container, false);

        TicketLab.get(getActivity()).addTicket(new Ticket("binney street", "march 17 2018", "boston"));
        TicketLab.get(getActivity()).deleteTicket("hancock");
        //tLab.get(getActivity()).addTicket(new Ticket("hancock", "march 17, 2018", "boston"));
        return rootView;
    }

}