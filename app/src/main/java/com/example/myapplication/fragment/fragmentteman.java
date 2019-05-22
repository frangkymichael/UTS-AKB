package com.example.myapplication.fragment;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.model.Friends;
import com.example.myapplication.adapter.teman;

import java.util.ArrayList;


//tanggal pengeerjaan : 20-05-2019
//nim  : 10116569
//nama : Frangky michael
//kelas: IF 13

/**
 * A simple {@link Fragment} subclass.
 */
public class fragmentteman extends Fragment {

    private RecyclerView Daftarteman;
    private teman teman;
    private ArrayList<Friends> data;
    private FloatingActionButton tombol ;

    public fragmentteman() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_teman, container, false);
        Daftarteman= view.findViewById(R.id.list_view);
        tombol = view.findViewById(R.id.fab_add);

        data = new ArrayList<>();
        Friends f0 = new Friends("10116568","Fairus", "IF-13", "08184116898", "fairuzday@gmail.com", "instagram.com/fairuzday");
        Friends f1 = new Friends("12312039","andi", "IF-12", "085255161561", "andi123@gmail.com", "facebook.com/andi123");
        Friends f2 = new Friends("10210201","Ayu", "IF-11", "08242140212", "ayyusafitri@gmail.com", "instagram.com/ayu21");
       data.add(f0);
        data.add(f1);
        data.add(f2);
        teman = new teman(data, getContext(), new teman.ClickHandler() {
            @Override
            public void onItemClick(int position) {
                showOption(position, data.get(position));
            }
        });

        tombol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setData(-1, null);
            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        Daftarteman.setLayoutManager(linearLayoutManager);
        Daftarteman.setAdapter(teman);
        return view;
    }
    private void showOption(final int position, final Friends friends){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        String[] action = {"Edit","Delete"};
        builder.setTitle("Share This !");
        builder.setItems(action, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 0) {
                    setData(position, friends);
                }
                else {
                    deleteData(position);
                }
            }
        });
        builder.create().show();

    }
    private void setData(final int i, Friends friends){
        final Dialog d = new Dialog(getContext());
        View v = LayoutInflater.from(getContext()).inflate(R.layout.dialog_edit, null, false);

        final EditText eNim, eName, eClass, ePhone, eEmail, eSosmed;
        Button btnSave;

        eNim = v.findViewById(R.id.edit_nim);
        eName = v.findViewById(R.id.edit_name);
        eClass = v.findViewById(R.id.edit_class);
        ePhone = v.findViewById(R.id.edit_phone);
        eEmail = v.findViewById(R.id.edit_email);
        eSosmed = v.findViewById(R.id.edit_sosmed);
        btnSave = v.findViewById(R.id.save_edit);

        if (i != -1) {
            eNim.setText(friends.getFnim());
            eName.setText(friends.getFname());
            eClass.setText(friends.getFclass());
            ePhone.setText(friends.getFphone());
            eEmail.setText(friends.getFemail());
            eSosmed.setText(friends.getFsosmed());
        }

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (eNim.getText().toString().isEmpty() &&
                        eName.getText().toString().isEmpty() &&
                        eClass.getText().toString().isEmpty() &&
                        ePhone.getText().toString().isEmpty() &&
                        eEmail.getText().toString().isEmpty() &&
                        eSosmed.getText().toString().isEmpty())
                {
                    Toast.makeText(getContext(), "Fill The Field", Toast.LENGTH_SHORT).show();
                }else {
                    Friends newFriend = new Friends(
                            eNim.getText().toString(),
                            eName.getText().toString(),
                            eClass.getText().toString(),
                            ePhone.getText().toString(),
                            eEmail.getText().toString(),
                            eSosmed.getText().toString()
                    );
                    if (i != -1) {
                        data.set(i, newFriend);
                    }else {
                        data.add(newFriend);
                    }
                    Daftarteman.setAdapter(teman);
                    ((teman) teman).notifyDataSetChanged();
                    d.dismiss();
                }
            }
        });
        d.setContentView(v);
        d.show();
    }
    private void deleteData(int position){
        data.remove(position);
        teman.notifyDataSetChanged();
    }
}