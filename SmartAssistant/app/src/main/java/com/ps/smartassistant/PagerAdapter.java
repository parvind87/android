package com.ps.smartassistant;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {
    int tabcount;

    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabcount=behavior;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new HomeFragment();
            case 1:
                return new ExpensesFragment();
            case 2:
                return new ElectricityFragment();
            case 3:
                return new CreditCardFragment();
            case 4:
                return new InsurancesFragment();
            case 5:
                return new InternetFragment();
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return tabcount;
    }
}
