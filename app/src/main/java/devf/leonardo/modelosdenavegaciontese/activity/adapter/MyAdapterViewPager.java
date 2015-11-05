package devf.leonardo.modelosdenavegaciontese.activity.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import devf.leonardo.modelosdenavegaciontese.R;
import devf.leonardo.modelosdenavegaciontese.activity.model.ModelFragmentPager;

/**
 * Created by LEONARDO on 24/09/2015.
 */
public class MyAdapterViewPager extends FragmentPagerAdapter {

    private List<ModelFragmentPager> pagerList = new ArrayList<>();
    private int[] imagesId = {R.drawable.ic_android_black_24dp,
            R.drawable.ic_account_box_black_24dp,
            R.drawable.ic_build_black_24dp};
    private Context context;


    public MyAdapterViewPager(FragmentManager fm, List<ModelFragmentPager> pagerList) {
        super(fm);
        this.pagerList = pagerList;
        this.context = context;
    }


    @Override
    public Fragment getItem(int position) {
        return pagerList.get(position).getPager();

    }

    @Override
    public int getCount() {
        return pagerList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {


        return pagerList.get(position).getTitle();
    }
}
