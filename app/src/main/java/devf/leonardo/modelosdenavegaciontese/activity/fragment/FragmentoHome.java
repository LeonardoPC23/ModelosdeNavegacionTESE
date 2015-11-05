package devf.leonardo.modelosdenavegaciontese.activity.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import devf.leonardo.modelosdenavegaciontese.R;
import devf.leonardo.modelosdenavegaciontese.activity.adapter.MyAdapterViewPager;
import devf.leonardo.modelosdenavegaciontese.activity.model.ModelFragmentPager;

/**
 * Created by LEONARDO on 04/11/2015.
 */
public class FragmentoHome extends Fragment {
    TabLayout tabLayout;
    ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tabLayout = (TabLayout) view.findViewById(R.id.myTabLayout);
        viewPager = (ViewPager) view.findViewById(R.id.myViewPager);

        MyAdapterViewPager myAdapterViewPager = new MyAdapterViewPager(getChildFragmentManager(), createPager());
        viewPager.setAdapter(myAdapterViewPager);
        tabLayout.setupWithViewPager(viewPager);
        setupIcon();
    }
    private void setupIcon() {
        int[] tabIcon = {R.drawable.ic_android_black_24dp,
                R.drawable.ic_account_box_black_24dp,
                R.drawable.ic_build_black_24dp};

        tabLayout.getTabAt(0).setIcon(tabIcon[0]);
        tabLayout.getTabAt(1).setIcon(tabIcon[1]);
        tabLayout.getTabAt(2).setIcon(tabIcon[2]);
    }
    public List<ModelFragmentPager> createPager() {
        List<ModelFragmentPager> modelFramentPagers = new ArrayList<>();

        modelFramentPagers.add(new ModelFragmentPager(new FragmentoAndroid(), ""));
        modelFramentPagers.add(new ModelFragmentPager(new FragmentoAssigment(), ""));
        modelFramentPagers.add(new ModelFragmentPager(new FragmentoBuild(), ""));

        return modelFramentPagers;
    }

}
