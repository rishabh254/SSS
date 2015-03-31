package com.sss.FragmentEbook;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.sss.Category.Chemical;
import com.sss.Category.Civil;
import com.sss.Category.ComputerScience;
import com.sss.Category.Electrical;
import com.sss.Category.Fiction;
import com.sss.Util.Information;
import com.sss.Category.Mathematics;
import com.sss.Adapter.MayankAdapter;
import com.sss.Category.Mechanical;
import com.sss.Category.Others;
import com.sss.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentCategory#newInstance} factory method to
 * create an instance of this fragment.
 */
public class
        FragmentCategory extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    RecyclerView recyclerView;
    MayankAdapter adapter;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public FragmentCategory() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentCategory.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentCategory newInstance(String param1, String param2) {
        FragmentCategory fragment = new FragmentCategory();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public static List<Information> getData() {
        //load only static data inside a drawer
        List<Information> data = new ArrayList<>();
        int[] icons = {R.drawable.ic_number1, R.drawable.ic_number1, R.drawable.ic_number2,
                R.drawable.ic_number3, R.drawable.ic_number4, R.drawable.ic_number4,
                R.drawable.ic_action_settings, R.drawable.ic_action_settings};
        String[] titles = {"Computer Science", "Electrical", "Fiction", "Mathematics", "Mechanical", "Chemical", "Civil", "Others"};
        for (int i = 0; i < titles.length; i++) {
            Information current = new Information();
            current.iconId = icons[i % icons.length];
            current.title = titles[i % titles.length];
            data.add(current);
        }
        return data;
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
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.categoryWise);
        adapter = new MayankAdapter(getActivity(), getData());

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(getActivity(), "You Clicked" + getData().get(position).title, Toast.LENGTH_LONG).show();

                switch (position) {
                    case 0:
                        startActivity(new Intent(getActivity(), ComputerScience.class));
                        break;
                    case 1:
                        startActivity(new Intent(getActivity(), Electrical.class));
                        break;
                    case 2:
                        startActivity(new Intent(getActivity(), Fiction.class));
                        break;
                    case 3:
                        startActivity(new Intent(getActivity(), Mathematics.class));
                        break;
                    case 4:
                        startActivity(new Intent(getActivity(), Mechanical.class));
                        break;
                    case 5:
                        startActivity(new Intent(getActivity(), Chemical.class));
                        break;
                    case 6:
                        startActivity(new Intent(getActivity(), Civil.class));
                        break;
                    case 7:
                        startActivity(new Intent(getActivity(), Others.class));
                        break;
                }
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        recyclerView.setAdapter(adapter);
        return view;
    }

    public static interface ClickListener {
        public void onClick(View view, int position);

        public void onLongClick(View view, int position);
    }

    static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }
    }
}
