package com.example.valluvanpadasalai.Adaptar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.example.valluvanpadasalai.R;

import org.w3c.dom.Text;

public class LauncherAdaptar extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public LauncherAdaptar(Context context) {
        this.context = context;
    }
    public int[] slide_image = {
            R.drawable.learn,
            R.drawable.network,
            R.drawable.note_take,
            R.drawable.notfication
    };
    public String[] slide_heading = {
            "Learn & teach",
            "Connected with people",
            "Test",
            "Exam Notification"
    };
    public String[] slide_desc = {
            "Learn & teach",
            "Connected with people",
            "Test",
            "Exam Notification"
    };

    @Override
    public int getCount() {
        return slide_heading.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (ConstraintLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.launch_slide, container, false);

        ImageView slideImage = (ImageView)view.findViewById(R.id.launch_image);
        TextView slidehead = (TextView)view.findViewById(R.id.launch_head);
        TextView slidedesc = (TextView)view.findViewById(R.id.launch_desc);

        slideImage.setImageResource(slide_image[position]);
        slidehead.setText(slide_heading[position]);
        slidedesc.setText(slide_desc[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}
