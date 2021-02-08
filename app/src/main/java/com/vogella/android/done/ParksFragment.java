package com.vogella.android.done;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class ParksFragment extends Fragment {

    //A list of local Attractions objects.
    //LocalAttractions is class that contains the data that will be bind with the recyclerview adapter.
    private ArrayList<LocalAttractions> localAttractions;

    public ParksFragment() {
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
        View rootView = inflater.inflate(R.layout.fragment_parks, container, false);

        // Setup up the list
        localAttractions = new ArrayList<>();

        // Populating the localAttractions list with localAttractions objects
        // I DO NOT OWN ANY OF THE PICTURES! NO COPYRIGHT INTENT!
        localAttractions.add(new LocalAttractions(R.drawable.irvington_park, getString(R.string.irvington_park_ParkFragment), getString(R.string.irvington_park_address_ParkFragment)));
        localAttractions.add(new LocalAttractions(R.drawable.garden_state_chancellor_park, getString(R.string.garden_state_chancellor_park_ParkFragment), getString(R.string.garden_state_chancellor_park_address_ParkFragment)));
        localAttractions.add(new LocalAttractions(R.drawable.montgomery_park, getString(R.string.montgomery_park_ParkFragment), getString(R.string.montgomery_park_address_ParkFragment)));
        localAttractions.add(new LocalAttractions(R.drawable.parkway_playground, getString(R.string.parkway_playground_park_ParkFragment), getString(R.string.parkway_playground_park_address_ParkFragment)));
        localAttractions.add(new LocalAttractions(R.drawable.irvington_park, getString(R.string.futbol_ecuatoriano_ParkFragment), getString(R.string.futbol_ecuatoriano_park_address_ParkFragment)));

        // Creating and initializing the RecyclerView
        RecyclerView rvAttractions = rootView.findViewById(R.id.rvParks);

        // Recycler view needs a LayoutManger so LinerLayoutManger needs to be created
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());

        // Initializing the LayoutManger
        rvAttractions.setLayoutManager(linearLayoutManager);

        // RecyclerView needs an adapter as well.
        LocalAttractionsAdapter localAttractionsAdapter = new LocalAttractionsAdapter(localAttractions);

        // Setting up the adapter.
        rvAttractions.setAdapter(localAttractionsAdapter);

        // Returning RootView
        return rootView;

    }
}