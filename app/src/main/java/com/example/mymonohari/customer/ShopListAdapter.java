package com.example.mymonohari.customer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.mymonohari.CustomerActivity;
import com.example.mymonohari.DashShopTab;
import com.example.mymonohari.R;

import org.jetbrains.annotations.NotNull;

public class ShopListAdapter extends ArrayAdapter<String>{
   

    Context context;
    String shopName[];
    String shopOwner[];
    String distance[];
    int img[];
    String direction;


    public ShopListAdapter(Context context, String direction, String[] shopName, String[] shopOwner, String[] distance, int[] img) {
        super(context, R.layout.shop_row,R.id.shop_name,distance);
        this.context=context;
        this.shopName=shopName;
        this.shopOwner=shopOwner;
        this.distance=distance;
        this.direction=direction;
        this.img=img;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row=inflater.inflate(R.layout.shop_row,parent,false);
        TextView shop_Name, shop_Owner,sdistance;
        ImageView imgicon;
        shop_Name=row.findViewById(R.id.shop_name);
        shop_Owner=row.findViewById(R.id.shop_owner);
        sdistance=row.findViewById(R.id.shop_distance);
        imgicon=row.findViewById(R.id.shop_dp);


        shop_Name.setText(shopName[position]);
        shop_Owner.setText(shopOwner[position]);
        sdistance.setText(distance[position]);
        imgicon.setImageResource(img[position]);
//        <-----CLICK EVENT-------------->
        row.setOnClickListener(v -> {
//            Fragment fragment2=new Fragment();
//            FragmentManager fragmentManager= fragment2.getParentFragmentManager();
//            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
//            fragmentTransaction.replace(R.id.scroll_view,fragment2,"tag");
//            fragmentTransaction.addToBackStack(null);

            Intent intent=new Intent(context, CustomerActivity.class);
            intent.putExtra("ShopImage",img[position]);
            intent.putExtra("ShopName",shopName[position]);
            intent.putExtra("ShopOwner",shopOwner[position]);
            intent.putExtra("Distance",distance[position]);
            intent.putExtra("Direction",direction);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);

        });
        return row;
    }
}
