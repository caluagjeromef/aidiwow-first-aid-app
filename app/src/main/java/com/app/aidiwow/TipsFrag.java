package com.app.aidiwow;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.text.Html;
import android.transition.Slide;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.maps.model.Dot;


public class TipsFrag extends Fragment {

    private ViewPager viewPager;
    private LinearLayout dotsLayout;

    private TextView[] Dots;

    private SliderAdapter sliderAdapter;
    private Button btnNext;
    private Button btnPrev;
    private int currentPage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tips, container, false);

        viewPager = (ViewPager) view.findViewById(R.id.idViewPager);
        dotsLayout = (LinearLayout) view.findViewById(R.id.idDotsLayout);
        sliderAdapter = new SliderAdapter(getActivity());
        viewPager.setAdapter(sliderAdapter);
        viewPager.addOnPageChangeListener(viewListener);

        btnNext = (Button) view.findViewById(R.id.idBtnNext);
        btnPrev = (Button) view.findViewById(R.id.idBtnPrev);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(currentPage+1);
            }
        });
        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(currentPage-1);
            }
        });

        addDotsIndicator(0);
        return view;
    }

    public void addDotsIndicator(int position){
        Dots = new TextView[10];
        dotsLayout.removeAllViews();

        for(int i=0; i< Dots.length; i++) {
            Dots[i] = new TextView(getActivity());
            Dots[i].setText(Html.fromHtml("&#8226;",Html.FROM_HTML_MODE_COMPACT));
            Dots[i].setTextSize(35);
            Dots[i].setTextColor(getResources().getColor(R.color.red));
            dotsLayout.addView(Dots[i]);
        }
        if(Dots.length > 0){
            Dots[position].setTextColor(getResources().getColor(R.color.red1));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            addDotsIndicator(position);
            currentPage = position;

            if (position==0){
                btnNext.setEnabled(true);
                btnPrev.setEnabled(false);
                btnPrev.setVisibility(View.INVISIBLE);

                btnNext.setText("Next");
                btnPrev.setText("");
            }
            else if (position==Dots.length-1){
                btnNext.setEnabled(true);
                btnPrev.setEnabled(true);
                btnPrev.setVisibility(View.VISIBLE);

                btnNext.setText("");
                btnPrev.setText("Previous");
            }
            else {
                btnNext.setEnabled(true);
                btnPrev.setEnabled(true);
                btnPrev.setVisibility(View.VISIBLE);

                btnNext.setText("Next");
                btnPrev.setText("Previous");
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

}