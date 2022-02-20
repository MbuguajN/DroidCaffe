package com.james.mydroidcaffev1;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PageAdapter extends FragmentStatePagerAdapter {
    int mynumberofTabs;
    public PageAdapter(@NonNull FragmentManager fm, int numofTabs) {
        super(fm, numofTabs);
        this.mynumberofTabs=numofTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new DessertRecipeFragment();
            case 1: return new PastriesRecipeFragment();
            case 2: return new StoresFragment();
            default:return null;
        }
    }

    @Override
    public int getCount() {
        return mynumberofTabs;
    }
}
