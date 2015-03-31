package com.sss.FragmentEbook;


import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.Highlight;
import com.github.mikephil.charting.utils.PercentFormatter;
import com.sss.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentEbookStatistics#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentEbookStatistics extends Fragment implements OnSeekBarChangeListener, OnChartValueSelectedListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    protected String[] mParties = new String[]{
            "Computer Science", "Electrical", "Fiction", "Mathematics", "Mechanical", "Chemical", "Civil", "Others"
    };
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private PieChart mChart;
    private SeekBar mSeekBarX, mSeekBarY;
    private TextView tvX, tvY;
    private Typeface tf;

    public FragmentEbookStatistics() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentEbookStatistics.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentEbookStatistics newInstance(String param1, String param2) {
        FragmentEbookStatistics fragment = new FragmentEbookStatistics();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ebook_statistics, container, false);
        tvX = (TextView) view.findViewById(R.id.tvXMax);
        mSeekBarX = (SeekBar) view.findViewById(R.id.seekBar1);
        mSeekBarX.setOnSeekBarChangeListener(this);
        mChart = (PieChart) view.findViewById(R.id.chart1);
        mChart.setUsePercentValues(true);
// change the color of the center-hole
// mChart.setHoleColor(Color.rgb(235, 235, 235));
        mChart.setHoleColorTransparent(true);
        //tf = Typeface.createFromAsset(getActivity().getAssets(), "OpenSans-Regular.ttf");
        // mChart.setCenterTextTypeface(Typeface.createFromAsset(getActivity().getAssets(), "OpenSans-Light.ttf"));
        mChart.setHoleRadius(60f);
        mChart.setDescription("");
        mChart.setDrawCenterText(true);
        mChart.setDrawHoleEnabled(true);
        mChart.setRotationAngle(0);
// enable rotation of the chart by touch
        mChart.setRotationEnabled(true);
// mChart.setUnit(" €");
// mChart.setDrawUnitsInChart(true);
// add a selection listener
        mChart.setOnChartValueSelectedListener(this);
// mChart.setTouchEnabled(false);
        mChart.setCenterText("% of Various Books ");
        setData(3, 100);
        mChart.animateXY(1500, 1500);
// mChart.spin(2000, 0, 360);
        Legend l = mChart.getLegend();
        l.setPosition(Legend.LegendPosition.RIGHT_OF_CHART);
        l.setXEntrySpace(7f);
        l.setYEntrySpace(5f);


        return view;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        tvX.setText("" + (mSeekBarX.getProgress() + 1));
        setData(mSeekBarX.getProgress(),7.0f);
    }

    private void setData(int count, float range) {
        float mult = count;
        ArrayList<Entry> yVals1 = new ArrayList<Entry>();
// IMPORTANT: In a PieChart, no values (Entry) should have the same
// xIndex (even if from different DataSets), since no values can be
// drawn above each other.
        for (int i = 0; i < count + 1; i++) {
            yVals1.add(new Entry((float) (Math.random() * mult) + mult / 5, i));
        }
        ArrayList<String> xVals = new ArrayList<String>();
        for (int i = 0; i < count + 1; i++)
            xVals.add(mParties[i % mParties.length]);
        PieDataSet dataSet = new PieDataSet(yVals1, "Books Results");
        dataSet.setSliceSpace(3f);
// add a lot of colors
        ArrayList<Integer> colors = new ArrayList<Integer>();
        for (int c : ColorTemplate.VORDIPLOM_COLORS)
            colors.add(c);
        for (int c : ColorTemplate.JOYFUL_COLORS)
            colors.add(c);
        for (int c : ColorTemplate.COLORFUL_COLORS)
            colors.add(c);
        for (int c : ColorTemplate.LIBERTY_COLORS)
            colors.add(c);
        for (int c : ColorTemplate.PASTEL_COLORS)
            colors.add(c);
        colors.add(ColorTemplate.getHoloBlue());
        dataSet.setColors(colors);
        PieData data = new PieData(xVals, dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.WHITE);
        data.setValueTypeface(tf);
        mChart.setData(data);
// undo all highlights
        mChart.highlightValues(null);
        mChart.invalidate();
    }


    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {
        if (e == null)
            return;
        Log.i("VAL SELECTED",
                "Value: " + e.getVal() + ", xIndex: " + e.getXIndex()
                        + ", DataSet index: " + dataSetIndex);
    }

    @Override
    public void onNothingSelected() {
        Log.i("PieChart", "nothing selected");
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

}
