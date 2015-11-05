package devf.leonardo.modelosdenavegaciontese.activity.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import devf.leonardo.modelosdenavegaciontese.R;

/**
 * Created by LEONARDO on 04/11/2015.
 */
public class FragmentoAndroid extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    //    return super.onCreateView(inflater, container, savedInstanceState);
    return  inflater.inflate(R.layout.fragment_android,container,false);
    }
}
