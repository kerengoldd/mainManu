package com.example.kerengold.mainmanu;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class addBday extends AppCompatActivity {

    Button dateChoose, add;
    Context context;
    BdayDBhelper DBHelper;

    int year_x, month_x, day_x;
    final static int DIALOG_ID = 0;
    EditText fullname, commentText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bday);
        // Calander Info
        final Calendar cal = Calendar.getInstance();
        year_x = cal.get(Calendar.YEAR);
        month_x = cal.get(Calendar.MONTH);
        day_x = cal.get(Calendar.DAY_OF_MONTH);
        showDialogOnButtonClick();
        //
        fullname = (EditText)findViewById(R.id.fullnameText);
        commentText = (EditText)findViewById(R.id.commentText);
        add = (Button)findViewById(R.id.addButton);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = fullname.getText().toString();
                String birth = String.valueOf(day_x) + "/" + String.valueOf(month_x) + "/" + String.valueOf(year_x);
                String comment = commentText.getText().toString();
                if(name.equals("") || comment.equals("")) {
                    Toast.makeText(getBaseContext(),"complete all details",Toast.LENGTH_SHORT).show();
                    return;
                }
                addTolist(name, birth, comment);
            }
        });

    }

    public void addTolist(String name, String birth, String comment) {
        DBHelper = new BdayDBhelper(this);
        DBHelper.addFriend(name,birth,comment);
        Toast.makeText(getBaseContext(),"Data Saved!",Toast.LENGTH_SHORT).show();
        DBHelper.close();
    }

    public void showDialogOnButtonClick() {
        dateChoose = (Button)findViewById(R.id.dateButton);
        dateChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DIALOG_ID);
            }
        });
    }

    protected Dialog onCreateDialog(int id) {
        if (id == DIALOG_ID) {
            return new DatePickerDialog(this, dpickerListner, year_x, month_x, day_x);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener dpickerListner = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            year_x = year;
            month_x = month + 1;
            day_x = dayOfMonth;
            Toast.makeText(addBday.this, year_x + "/" + month_x + "/" + day_x,Toast.LENGTH_SHORT).show();
        }
    };



}