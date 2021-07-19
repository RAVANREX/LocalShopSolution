package com.example.mymonohari;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import org.jetbrains.annotations.NotNull;

public class ViewPagerAdapter extends FragmentStateAdapter {
    private Context context;
    int totaltab;
    public ViewPagerAdapter(FragmentManager fm, Lifecycle lifecycle, int totaltab) {
        super(fm,lifecycle);
        this.context=context;
        this.totaltab=totaltab;
    }



    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                DashProductTab dashProductTab=new DashProductTab();
                return dashProductTab;
            case 1:
                DashShopTab dashShopTab=new DashShopTab();
                return dashShopTab;
            default:
                return null;
        }

    }

    @Override
    public int getItemCount() {
        return totaltab;
    }
}
