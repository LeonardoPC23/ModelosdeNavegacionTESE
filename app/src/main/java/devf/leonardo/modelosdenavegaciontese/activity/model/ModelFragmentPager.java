package devf.leonardo.modelosdenavegaciontese.activity.model;

import android.support.v4.app.Fragment;

/**
 * Created by LEONARDO on 24/09/2015.
 */
public class ModelFragmentPager {
    private Fragment pager;
    private String title;

    public Fragment getPager() {
        return pager;
    }

    public String getTitle() {
        return title;
    }

    public ModelFragmentPager(Fragment pager, String title) {

        this.pager = pager;
        this.title = title;
    }
}
