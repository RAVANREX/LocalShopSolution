package com.example.mymonohari.vendor;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mymonohari.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Vendor_Fragment_DashBoard extends Fragment {


    //<------------------------ PieChart ------------------------------------->
    PieChart pieChart;
    PieData pieData;
    PieDataSet pieDataSet;
    ArrayList pieEntries;


    //<------------------------ lineChart ------------------------------------->
    LineChart lineChart;
    LineData lineData;
    LineDataSet lineDataSet;
    ArrayList lineEntries;





    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {


        //<------------------------ Creating View for dashboard Fragment ------------------------------------->
        View view=inflater.inflate(R.layout.vendor_fragment_dashboard,container,false);
        /////////////////// END\Creating View for dashboard Fragment ////////////////////////////////





        /////////////////// BarChart ////////////////////////////////
        BarChart barChart=view.findViewById(R.id.barchart);

        ArrayList<BarEntry> barEntries=new ArrayList<>();
        barEntries.add(new BarEntry(2014,42));
        barEntries.add(new BarEntry(2015,40));
        barEntries.add(new BarEntry(2016,420));
        barEntries.add(new BarEntry(2017,0));
        barEntries.add(new BarEntry(2018,20));
        barEntries.add(new BarEntry(2019,41));
        barEntries.add(new BarEntry(2020,4));
        barEntries.add(new BarEntry(2021,2));
        barEntries.add(new BarEntry(2022,100));

        BarDataSet barDataSet=new BarDataSet(barEntries,"BArEntries");
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(16f);

        BarData barData=new BarData(barDataSet);
        barChart.setFitBars(true);
        barChart.setData(barData);
        barChart.getDescription().setText("bar Chart example");
        barChart.animateY(2000);
        /////////////////// END \BarChart ////////////////////////////////




        /////////////////// PieChart /////////////////////////////////////
        pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry(2f, 0));
        pieEntries.add(new PieEntry(4f, 1));
        pieEntries.add(new PieEntry(6f, 2));
        pieEntries.add(new PieEntry(8f, 3));
        pieEntries.add(new PieEntry(7f, 4));
        pieEntries.add(new PieEntry(3f, 5));

        pieChart = view.findViewById(R.id.pieChart);
        pieDataSet = new PieDataSet(pieEntries, "");
        pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        pieDataSet.setSliceSpace(2f);
        pieDataSet.setValueTextColor(Color.WHITE);
        pieDataSet.setValueTextSize(10f);
        pieDataSet.setSliceSpace(5f);
        /////////////////// END \PieChart ////////////////////////////////



        /////////////////// lineChart /////////////////////////////////////
        lineEntries = new ArrayList<>();
        lineEntries.add(new Entry(2f, 0));
        lineEntries.add(new Entry(4f, 1));
        lineEntries.add(new Entry(6f, 1));
        lineEntries.add(new Entry(8f, 3));
        lineEntries.add(new Entry(7f, 4));
        lineEntries.add(new Entry(3f, 3));

        lineChart = view.findViewById(R.id.lineChart);
        lineDataSet = new LineDataSet(lineEntries, "");
        lineData = new LineData(lineDataSet);
        lineChart.setData(lineData);
        lineDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        lineDataSet.setValueTextColor(Color.BLACK);
        lineDataSet.setValueTextSize(18f);
        /////////////////// END/lineChart /////////////////////////////////////





        return view;
    }
}
