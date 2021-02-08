package com.vogella.android.done;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    //Need ViewPager and TabLayout for FrameLayout
    private ViewPager viewPager;
    private TabLayout tabLayout;


    //Fragments variable for the different Fragments created.
    private RestaurantsFragment restaurantsFragment;
    private ParksFragment parksFragment;
    private GymsFragment gymsFragment;
    private ChurchesFragment churchesFragment;

    //List of localAttractions objects
    private ArrayList<LocalAttractions> localAttractions;


    void setUpTabLayoutAndViewPager() {

        //Getting the viewPager and TabLayout in the activity_main.xml file
        viewPager = findViewById(R.id.frameContainer);
        tabLayout = findViewById(R.id.tabLayout);

        //Initializing the fragments
        restaurantsFragment = new RestaurantsFragment();
        parksFragment = new ParksFragment();
        gymsFragment = new GymsFragment();
        churchesFragment = new ChurchesFragment();


        //TabLayout needs a view pager and viewPager needs an adapter
        tabLayout.setupWithViewPager(viewPager);

        //Creating a ViewPagerAdapter
        //ViewPagerAdapter is a custom class created.
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), 0);


        //Adding Fragments to the viewPagerAdapter
        viewPagerAdapter.addFragment(restaurantsFragment, "Restaurants");
        viewPagerAdapter.addFragment(parksFragment, "Parks");
        viewPagerAdapter.addFragment(gymsFragment, "Gyms");
        viewPagerAdapter.addFragment(churchesFragment, "Churches");

        //Viewpager need an adapter
        viewPager.setAdapter(viewPagerAdapter);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpTabLayoutAndViewPager();

    }

}