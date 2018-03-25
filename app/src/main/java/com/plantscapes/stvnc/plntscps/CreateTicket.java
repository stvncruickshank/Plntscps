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

    public CreateTicket() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_newtix, container, false);

        return rootView;
    }

}