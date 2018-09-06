package com.coffee.qrcodescanner.ListActivityPack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.coffee.qrcodescanner.R;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    RecyclerView rc;
    ListAdapter listAdapter;

    List<person> personList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

      /*  RecyclerView rv= (RecyclerView)findViewById(R.id.mRecyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this));*/

        personList = new ArrayList<>();

        rc = findViewById(R.id.mRecyclerView);
        rc.setHasFixedSize(true);
        rc.setLayoutManager(new LinearLayoutManager(this));


        personList.add(new person("random"));
        personList.add(new person("random56"));
        personList.add(new person("random32"));
        personList.add(new person("random234"));
        personList.add(new person("random234"));
        personList.add(new person("random234"));
        personList.add(new person("random234"));
        personList.add(new person("random234"));
        personList.add(new person("random234"));
        personList.add(new person("random234"));
        personList.add(new person("random234"));
        personList.add(new person("random234"));
        personList.add(new person("random234"));
        personList.add(new person("random234"));

        listAdapter = new ListAdapter(this, personList);
        rc.setAdapter(listAdapter);

    }
}
