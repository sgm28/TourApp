package com.vogella.android.done;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RestaurantsFragment} factory method to
 * create an instance of this fragment.
 * implements custom on  OnItemListener
 */
public class RestaurantsFragment extends Fragment implements LocalAttractionsAdapter.OnItemListener {

    //A list of local Attractions objects.
    //LocalAttractions is class that contains the data that will be bind with the recyclerview adapter.
    private ArrayList<LocalAttractions> localAttractions;

    public RestaurantsFragment() {
        // Required empty public constructor
    }


    //Fragment is an interface so onCreate and onCreateView had to be implemented
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the fragment Restaurants layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_restaurants, container, false);

        // Setup up the list
        localAttractions = new ArrayList<>();

        // Populating the localAttractions list with localAttractions objects
        localAttractions.add(new LocalAttractions(R.drawable.big_joes, getString(R.string.big_joes_restaurant_RestaurantsFragment), getString(R.string.big_joes_restaurant_address_RestaurantsFragment), getString(R.string.big_joes_restaurant_phone_RestaurantsFragment), R.drawable.twotone_phone_24));
        localAttractions.add(new LocalAttractions(R.drawable.la_bonte, getString(R.string.la_bonte_restaurant_RestaurantsFragment), getString(R.string.la_bonte_restaurant_address_RestaurantsFragment), getString(R.string.la_bonte_restaurant_phone_RestaurantsFragment), R.drawable.twotone_phone_24));
        localAttractions.add(new LocalAttractions(R.drawable.san_salvador_restaurant, getString(R.string.san_salvador_restaurant_RestaurantsFragment), getString(R.string.san_salvador_restaurant_address_RestaurantsFragment), getString(R.string.san_salvador_restaurant_phone_RestaurantsFragment), R.drawable.twotone_phone_24));
        localAttractions.add(new LocalAttractions(R.drawable.plaza_mexico, getString(R.string.plaza_mexico_restaurant_RestaurantsFragment), getString(R.string.mexico_restaurant_address_RestaurantsFragment), getString(R.string.mexico_restaurant_phone_RestaurantsFragment), R.drawable.twotone_phone_24));
        localAttractions.add(new LocalAttractions(R.drawable.flava_wingz_spot, getString(R.string.flava_wingz_restaurant_RestaurantsFragment), getString(R.string.flava_wingz_restaurant_address_RestaurantsFragment), getString(R.string.flava_wingz_restaurant_phone_RestaurantsFragment), R.drawable.twotone_phone_24));
        // Creating and initializing the RecyclerView
        RecyclerView rvAttractions = rootView.findViewById(R.id.rvRestaurant);

        // Recycler view needs a LayoutManger so LinerLayoutManger needs to be created
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());

        // Initializing the LayoutManger
        rvAttractions.setLayoutManager(linearLayoutManager);

        // RecyclerView needs an adapter as well.
        //this refers to the OnItemListener on Line 25
        LocalAttractionsAdapter localAttractionsAdapter = new LocalAttractionsAdapter(localAttractions, this);

        // Setting up the adapter.
        rvAttractions.setAdapter(localAttractionsAdapter);

        // Returning RootView
        return rootView;

    }


    @Override
    //This method is called from the LocalAttractionsAdapter.java file, The itemView.setadapter() inside the viewHolder class called this method
    public void OnItemClick(int position) {


        String phone = localAttractions.get(position).getmPhoneNumber();
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));


        PackageManager packageManager = getActivity().getPackageManager();
        //Have to check if there is an activity to handle the request
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent);
        } else {
            Log.d("Restaurant Fragments", "No Intent available to handle action");

        }
    }

}