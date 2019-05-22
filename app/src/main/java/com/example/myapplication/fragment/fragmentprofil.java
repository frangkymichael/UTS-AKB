package com.example.myapplication.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;


//tanggal pengeerjaan : 20-05-2019
//nim  : 10116569
//nama : Frangky michael
//kelas: IF 13

/**
 * A simple {@link Fragment} subclass.
 */
public class fragmentprofil extends Fragment {


    public fragmentprofil() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profil, container, false);
    }

}
