package com.ak93.horizontallistexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements HorizontalListItemClickListener {

    RecyclerView recyclerView, recyclerView1;
    RecyclerView.LayoutManager layoutManager, layoutManager1;
    HorizontalListAdapter horizontalListAdapter,horizontalListAdapter1;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        init();
    }

    private void init(){
        //Create a dataset for our recycler views
        ArrayList<String> itemList = new ArrayList<>();
        itemList.add("Item 0");
        itemList.add("Item 1");
        itemList.add("Item 2");
        itemList.add("Item 3");
        itemList.add("Item 4");
        itemList.add("Item 5");
        itemList.add("Item 6");
        itemList.add("Item 7");
        itemList.add("Item 8");
        itemList.add("Item 9");

        //Create a RecyclerView object
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        //Create a RecyclerView object
        recyclerView1 = (RecyclerView)findViewById(R.id.recycler_view1);
        recyclerView1.setHasFixedSize(true);

        //Create and set a layout manager for the RecyclerView
        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);

        //Create and set a layout manager for the RecyclerView
        layoutManager1 = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView1.setLayoutManager(layoutManager1);

        //Create and set a ListAdapter for the RecyclerView and set an onItemClickListener
        horizontalListAdapter = new HorizontalListAdapter(this,itemList,"List 1");
        horizontalListAdapter.setOnItemClickListener(this);
        recyclerView.setAdapter(horizontalListAdapter);

        //Create and set a ListAdapter for the RecyclerView and set an onItemClickListener
        horizontalListAdapter1 = new HorizontalListAdapter(this,itemList,"List 2");
        horizontalListAdapter1.setOnItemClickListener(this);
        recyclerView1.setAdapter(horizontalListAdapter1);

    }

    @Override
    public void onHorizontalListItemClick(String adapterTag, int position) {
        //React to onItemClick events based on which adapter sent them and the position of
        // the clicked item
        Log.i(TAG,"onHorizontalListItemClick: adapter_tag = "+adapterTag+" item position: "+position);
        Toast.makeText(this,"onHorizontalListItemClick: adapter_tag = "+adapterTag+
                " item position: "+position,Toast.LENGTH_SHORT).show();
    }
}
