package com.example.kerengold.mainmanu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

     String[] lessons = {
             "calculator","layout3_1","layout3_2","layout3_3","Birthday"
     };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lv =(ListView)findViewById(R.id.lv);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,lessons);

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String hm = (String) adapterView.getItemAtPosition(i);
                Toast.makeText(view.getContext(),"you press on  " +hm ,Toast.LENGTH_SHORT).show();

                if (i==0){
                    Intent c = new Intent(view.getContext(),MainActivity2.class);
                    startActivity(c);
                }
                if (i==1) {
                    Intent c = new Intent(view.getContext(),layout3_1.class);
                    startActivity(c);
                }
                if (i==2) {
                    Intent c = new Intent(view.getContext(),layout3_2.class);
                    startActivity(c);
                }
                if (i==3) {
                    Intent c = new Intent(view.getContext(),layout3_3.class);
                    startActivity(c);
                }
                if (i==4) {
                    Intent c = new Intent(view.getContext(),Bday1.class);
                    startActivity(c);
                }

            }
        });




    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)  {

        int id = item.getItemId();
        if ( id == R.id.action_settings){
            Intent intent = new Intent(this,SettingsActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);



    }
}

