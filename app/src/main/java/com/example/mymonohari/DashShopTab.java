package com.example.mymonohari;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.mymonohari.customer.ShopListAdapter;

public class DashShopTab extends Fragment {

    //Temporary Variables of Shop List
    String shopName[] = {"Monohari", "Saha Mudi", "MBazar", "More","Monohari", "Saha Mudi", "MBazar", "More"};
    String shopOwner[] = {"Rajib S", "Suman S", "Muntaj U", "Nishan T","Rajib S", "Suman S", "Muntaj U", "Nishan T"};
    String distance[] = {"1.5 km away", "500 m away", "2 km away", "1 km away","1.5 km away", "500 m away", "2 km away", "1 km away"};
    int img[] = {R.drawable.groceryimg, R.drawable.groceryimg, R.drawable.groceryimg, R.drawable.groceryimg,R.drawable.groceryimg, R.drawable.groceryimg, R.drawable.groceryimg, R.drawable.groceryimg};
    Context context;
    String direction;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        ViewGroup root =(ViewGroup) inflater.inflate(R.layout.dash_shop_tab,container,false);
        // <----------------Shop List View----------------------------->
        context= root.getContext();
        ListView shopList= root.findViewById(R.id.vendor_list);

        TextView dir=root.findViewById(R.id.textView2);
        direction=dir.toString();
        ShopListAdapter shopListAdapter=new ShopListAdapter(context,direction,shopName,shopOwner,distance,img);
        shopList.setAdapter(shopListAdapter);
        justifyListViewHeightBasedOnChildren(shopList);
        return root;
    }
    //<-----------------INFLATING FUNCTION TO Get inflated from Linear Layout------------------>
//    public void inflate_llayout(LinearLayout shopList, int position) {
//        LayoutInflater myinflater = getLayoutInflater();
//        View row = myinflater.inflate(R.layout.shop_row, shopList);
//        TextView shop_Name, shop_Owner, sdistance;
//        ImageView imgicon;
//        shop_Name = row.findViewById(R.id.shop_name);
//        shop_Owner = row.findViewById(R.id.shop_owner);
//        sdistance = row.findViewById(R.id.shop_distance);
//        imgicon = row.findViewById(R.id.shop_dp);
//
//        shop_Name.setText(shopName[position]);
//        shop_Owner.setText(shopOwner[position]);
//        sdistance.setText(distance[position]);
//        imgicon.setImageResource(img[position]);
//    }
    public void justifyListViewHeightBasedOnChildren (ListView listView) {

        ListAdapter adapter = listView.getAdapter();

        if (adapter == null) {
            return;
        }
        ViewGroup vg = listView;
        int totalHeight = 0;
        for (int i = 0; i < adapter.getCount(); i++) {
            View listItem = adapter.getView(i, null, vg);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams par = listView.getLayoutParams();
        par.height = totalHeight + (listView.getDividerHeight() * (adapter.getCount() - 1));
        listView.setLayoutParams(par);
        listView.requestLayout();
    }
}
