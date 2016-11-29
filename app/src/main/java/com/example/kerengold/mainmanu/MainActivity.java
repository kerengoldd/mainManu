package com.example.kerengold.mainmanu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

     String[] lessons = {
             "hm1","hm2","hm3"
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
                Toast.makeText(view.getContext(),"jvgeh" +hm ,Toast.LENGTH_SHORT).show();

                if (i==0){
                    Intent c = new Intent(view.getContext(),MainActivity2.class);
                    startActivity(c);
                }

            }
        });





    }
}
