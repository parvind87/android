package com.example.deepamgoel.newsy.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.deepamgoel.newsy.R;
import com.example.deepamgoel.newsy.ui.home.ArticleList.ArticleListFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeFragment extends Fragment {

    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;

    private ViewPagerAdapter adapter;
    private List<String> sectionList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sectionList = Arrays.asList(getResources().getStringArray(R.array.category_array));

        adapter = new ViewPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        setUpPage();
    }

    private void setUpPage() {
        for (int i = 0; i < sectionList.size(); i++) {
            Fragment fragment = ArticleListFragment.newInstance(sectionList.get(i));
            adapter.addFragment(fragment, sectionList.get(i));
            adapter.notifyDataSetChanged();
        }
    }
}
