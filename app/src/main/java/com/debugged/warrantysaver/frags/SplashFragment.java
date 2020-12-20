package com.debugged.warrantysaver.frags;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.Navigation;

import com.debugged.warrantysaver.R;
import com.debugged.warrantysaver.utils.WarrantyAppPreferences;

public class SplashFragment extends Fragment {

    private static final String TAG = "SplashFragment";
    private View mView;
    private FragmentActivity mActivity;

    private final int ANIMATE_DURATION = 200;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.splash, container, false);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                    if (WarrantyAppPreferences.isLoggedIn(mActivity)) {

                    } else {
                        Log.d(TAG, "run: false");
//                        Navigation.findNavController(requireActivity(), R.id.navHostFragment)
//                                .navigate(R.id.action_splashFragment_to_loginFragment);
                    }
            }
        },ANIMATE_DURATION);

        return mView;

    }
}