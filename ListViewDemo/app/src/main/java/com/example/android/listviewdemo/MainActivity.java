package com.example.android.listviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView myListView;

    public void listCreator(int timesTable){

        final ArrayList<Integer> table = new ArrayList<Integer>();

        for(int i=0; i<10; i++){
            table.add(timesTable*(i+1));
        }

        ArrayAdapter<Integer> arrayAdapter= new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_activated_1, table);

        myListView.setAdapter(arrayAdapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myListView= findViewById(R.id.myListView);

        SeekBar seekBar = findViewById(R.id.seekBar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min=1;
                int timesTable;
                if(progress<min){
                    timesTable=min;
                    seekBar.setProgress(min);
                }
                else{
                    timesTable=progress;
                }

                listCreator(timesTable);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        listCreator(10);

    }
}
