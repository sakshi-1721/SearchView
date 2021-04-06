package com.example.searchview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SearchView searchView;
    ListView listView;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView=findViewById(R.id.searchView);
        listView=findViewById(R.id.listView);

        list = new ArrayList<>();
        list.add("vivo mobiles");
        list.add("tecno spark power 2");
        list.add("laptops");
        list.add("watches");
        list.add("refrigerator");
        list.add("shoes");

        adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);
        searchView.setOnQueryTextListener(new androidx.appcompat.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
//                if (list.contains(query))
//                {
//                    adapter.getFilter().filter(query);
//                }
//                else
//                {
//                    Toast.makeText(MainActivity.this, "No data Found", Toast.LENGTH_SHORT).show();
//                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
    }
}