package com.example.tp4.ui.main;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.tp4.R;

import java.util.ArrayList;
import java.util.Locale;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentStatePagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};
    private final Context mContext;
    private static ViewPager page;

    public SectionsPagerAdapter(Context context, FragmentManager fm, ViewPager pager) {
        super(fm);
        mContext = context;
        page = pager;
    }
    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {

        int[] img1 = {R.drawable.printemps};
        int[] img2 = {R.drawable.ete};
        int[] img3 = {R.drawable.automne};
        int[] img4 = {R.drawable.hiver};
        int[] img5 = {R.drawable.printemps, R.drawable.ete, R.drawable.automne, R.drawable.hiver};

        switch (position)
            {
                case 0:
                    return NatureFragment.newInstance(mContext, 0, mContext.getString(R.string.titre_section0), img1 ,page);
                case 1:
                    return NatureFragment.newInstance(mContext,1, mContext.getString(R.string.titre_section1), img2, page);
                case 2:
                    return NatureFragment.newInstance(mContext,2, mContext.getString(R.string.titre_section2), img3, page);
                case 3:
                    return NatureFragment.newInstance(mContext,3, mContext.getString(R.string.titre_section3), img4, page);
                case 4:
                    return NatureFragment.newInstance(mContext,4, mContext.getString(R.string.titre_section3), img5, page);
            }
            return null;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        Locale l = Locale.getDefault();
        String titre="";
        Drawable icone=null;


        switch (position) {
            case 0:
                titre = mContext.getString(R.string.titre_section0).toUpperCase(l);
                icone = mContext.getResources().getDrawable(R.drawable.a);
                break;
            case 1:
                titre = mContext.getString(R.string.titre_section1).toUpperCase(l);
                icone = mContext.getResources().getDrawable(R.drawable.dabi);
                break;
            case 2:
                titre = mContext.getString(R.string.titre_section2).toUpperCase(l);
                icone = mContext.getResources().getDrawable(R.drawable.ds);
                break;
            case 3:
                titre = mContext.getString(R.string.titre_section3).toUpperCase(l);
                icone = mContext.getResources().getDrawable(R.drawable.ds);
                break;
            case 4:
                titre = mContext.getString(R.string.titre_section4).toUpperCase(l);
                icone = mContext.getResources().getDrawable(R.drawable.ds);
                break;
        }

        SpannableString sb = new SpannableString(" " + titre);
        icone.setBounds(0, 0, icone.getIntrinsicWidth(), icone.getIntrinsicHeight());
        ImageSpan span = new ImageSpan(icone, ImageSpan.ALIGN_BASELINE);
        sb.setSpan(span, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return sb;
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 5;
    }
}