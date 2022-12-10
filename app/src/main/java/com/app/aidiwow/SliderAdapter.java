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
            R.drawable.ttimg2,
            R.drawable.ttimg5,
            R.drawable.ttimg8,
            R.drawable.ttimg3,
            R.drawable.ttimg4,
            R.drawable.ttimg6,
            R.drawable.ttimg7,
            R.drawable.ttimg9,
            R.drawable.ttimg10

    };

    public String[] slide_headings = new String[] {
            "The 3P's – The Primary Goals of First Aid",
            "The 3C's of First Aid",
            "ABCD of First Aid",
            "Burn",
            "Nosebleed",
            "Cardiopulmonary resuscitation (CPR)",
            "First aid bag",
            "Friedrich Esmarch",
            "Wound / Cut",
            "Sunburn"
    };

    public String[] slide_desc = new String[]{
            "The 3P's: \n\nPreserve life. \nPrevent further injury. \nPromote recovery.",
            "First aid C's: \n\nCheck \nCall \n Care",
            "Use the Airway, \nBreathing, \nCirculation, \nDisability, \nExposure \n\n(ABCDE) approach to assess and treat the patient",
            "The best thing to apply on second degree burn are: \n\nWater \nMake sure to wash it with running water for at least 10 mins. \n\nIce \nApply ice on the wounded area for at least 10 mins.",
            "Tilt your head back if you have a nosebleed\n\nThis is a very common tip that many are advised to follow. However, this can make things uncomfortable. If you are bleeding from the nose, keep your head at the level and squeeze the nose tip and hold a cloth to absorb the excess bleeding\n",
            "The correct ratio of chest compressions to rescue breaths\n\n 30 compressions : 2 rescue breaths. \n\n(CPR) is a lifesaving technique that's useful in many emergencies, such as a heart attack or near drowning, in which someone's breathing or heartbeat has stopped.",
            "All first-aid boxes should have a white cross on a green background. \n\n First aid boxes usually contains: \nSterile band-aids, \ngauze pads, \nbandages, \nand adhesive tape are an essential part of any first-aid kit.",
            "The Founder of Modern First Aid \n\n Esmarch was one of the greatest authorities on hospital management and military surgery. His Handbuch der kriegschirurgischen Technik was written for a prize offered by the empress Augusta, on the occasion of the Vienna Exhibition of 1877, for the best handbook for the battlefield of surgical appliances and operations.",
            "The best way to treat wounds and/or cuts \n\n Wash with soap and water, \ncover with a sterile bandage",
            "The best way to treat sunburn using:\n\n Moisturiser \nLotion \nAloe vera gel"
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
