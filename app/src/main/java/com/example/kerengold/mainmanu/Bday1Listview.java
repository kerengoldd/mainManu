package com.example.kerengold.mainmanu;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class Bday1Listview extends AppCompatActivity {

    BdayDBhelper myDB;
    int CURRENT_YEAR = Calendar.getInstance().get(Calendar.YEAR);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bday1_listview);

        ListView list = (ListView)findViewById(R.id.listBirth);
        myDB = new BdayDBhelper(this);

        ArrayList<String> theList = new ArrayList<>();
        Cursor data = myDB.getListContents();

        if(data.getCount() == 0) {
            Toast.makeText(Bday1Listview.this, "The Database is empty!", Toast.LENGTH_SHORT).show();
        }
        else {
            while(data.moveToNext()) {
                theList.add("Full name: " + data.getString(0) + " ("+(CURRENT_YEAR - parseDate(data.getString(1))) +" years old)\n" +
                        "Birthday: " + data.getString(1) + "\n" +
                        "Comment: " + data.getString(2));
                ListAdapter listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,theList);
                list.setAdapter(listAdapter);
            }
        }
    }
    public int parseDate(String date) {

        String symbol = "/";
        String[] parse = date.split(symbol);
        return Integer.parseInt(parse[2]);
    }
}