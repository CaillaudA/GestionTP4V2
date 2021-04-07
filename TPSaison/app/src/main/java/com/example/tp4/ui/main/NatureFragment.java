package com.example.tp4.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.tp4.R;

public class NatureFragment extends Fragment {

    private static Context lol;
    private String title;
    private int page;
    private int[] img;
    private static final String ARG_SECTION_NUMBER = "numero_page";
    private static final String ARG_SECTION_TITLE = "titre_page";
    private static final String ARG_SECTION_IMG = "image";
    private static ViewPager ViewPager;


    public static NatureFragment newInstance(Context con, int position, String title, int[] img, ViewPager pager) {
        NatureFragment fragment = new NatureFragment();
        Bundle args = new Bundle();
        lol = con;
        args.putInt(ARG_SECTION_NUMBER, position);
        args.putString(ARG_SECTION_TITLE, title);
        args.putIntArray(ARG_SECTION_IMG, img);
        fragment.setArguments(args);
        ViewPager = pager;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt(ARG_SECTION_NUMBER, 0);
        title = getArguments().getString(ARG_SECTION_TITLE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        //TextView tvLabel = (TextView) view.findViewById(R.id.section_label);
        //tvLabel.setText(page + " -- " + title);
       // ImageView image = (ImageView) view.findViewById(R.id.imageView);

        int img[] = getArguments().getIntArray(ARG_SECTION_IMG);
        final ImageView[] myTextViews = new ImageView[img.length];


        for(int k = 0; k < img.length; k++)
        {
            int  e = k;
            ImageView rowTextView = new ImageView(lol);
            LinearLayout ll = view.findViewById(R.id.contenye);
            rowTextView.setImageResource(img[k]);
            ll.addView(rowTextView);

            rowTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    ViewPager.setCurrentItem(e);

                }
            });

        }
        return view;
    }
}
