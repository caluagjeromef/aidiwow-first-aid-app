package com.app.aidiwow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import org.w3c.dom.Text;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context){
        this.context = context;
    }

    public int[] slide_images = new int[]{
            R.drawable.ttimg1,
            R.drawable.ic_chatbot,
            R.drawable.ic_chatbot
    };

    public String[] slide_headings = new String[] {
            "The 3p's – The Primary Goals of First Aid",
            "TRIVIA2",
            "TRIVIA3"
    };

    public String[] slide_desc = new String[]{
            "The 3 P's: \nPreserve life. \nPrevent further injury. \nPromote recovery.",
            "AAAAAAAAAAAAAAAAAAA",
            "YEEEEEEEEEEEEEEEEAA"
    };

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout,container,false);

          ImageView slideImageView = view.findViewById(R.id.imgTrivia);
          TextView slideHeading = view.findViewById(R.id.headingsTrivia);
          TextView slideDesc = view.findViewById(R.id.descTrivia);

          slideImageView.setImageResource(slide_images[position]);
          slideHeading.setText(slide_headings[position]);
          slideDesc.setText(slide_desc[position]);

          container.addView(view);

          return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
