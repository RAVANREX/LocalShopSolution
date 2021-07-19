package com.example.mymonohari;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DashProductTab extends Fragment {
    RecyclerView recyclerView;
    StaticRV_Adapter adapter;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        ViewGroup root =(ViewGroup) inflater.inflate(R.layout.dash_product_tab,container,false);

        ArrayList<StaticRV_Model> itemList = new ArrayList<>();
        itemList.add(new StaticRV_Model(R.drawable.groceryimg, "Item1"));
        itemList.add(new StaticRV_Model(R.drawable.groceryimg, "Item2"));
        itemList.add(new StaticRV_Model(R.drawable.groceryimg, "Item3"));
        itemList.add(new StaticRV_Model(R.drawable.groceryimg, "Item4"));
        itemList.add(new StaticRV_Model(R.drawable.groceryimg, "Item5"));
        itemList.add(new StaticRV_Model(R.drawable.groceryimg, "Item6"));

        recyclerView = root.findViewById(R.id.rv_1);

        adapter = new StaticRV_Adapter(itemList);

        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        return root;
    }
}
