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
 * Use the {@link GymsFragment} factory method to
 * create an instance of this fragment.
 */
public class GymsFragment extends Fragment implements LocalAttractionsAdapter.OnItemListener {

    //A list of local Attractions objects.
    //LocalAttractions is class that contains the data that will be bind with the recyclerview adapter.
    private ArrayList<LocalAttractions> localAttractions;

    public GymsFragment() {
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
        View rootView = inflater.inflate(R.layout.fragment_gyms, container, false);

        // Setup up the list
        localAttractions = new ArrayList<>();

        // Populating the localAttractions list with localAttractions objects
        // I DO NOT OWN ANY OF THE PICTURES NO COPYRIGHT INTENT !
        localAttractions.add(new LocalAttractions(R.drawable.nj_fitness, getString(R.string.nj_fitness_gym_fragment), getString(R.string.nj_fitness_address_gym_fragment), getString(R.string.pump_it_gym_phone_number_gym_fragment), R.drawable.twotone_phone_24));
        localAttractions.add(new LocalAttractions(R.drawable.blink_fitness, getString(R.string.blink_fitness_gym_fragment), getString(R.string.blink_fitness_gym_address_fragment), getString(R.string.blink_fitness_gym_phone_number_gym_fragment), R.drawable.twotone_phone_24));
        localAttractions.add(new LocalAttractions(R.drawable.pump_it_gym, getString(R.string.pump_it_gym_fragment), getString(R.string.pump_it_gym_address_gym_fragment), getString(R.string.nj_fitness_it_gym_phone_number_gym_fragment), R.drawable.twotone_phone_24));
        localAttractions.add(new LocalAttractions(R.drawable.planet_fitness, getString(R.string.planet_fitness_gym_fragment), getString(R.string.planet_fitness_gym_address_gym_fragment), getString(R.string.planet_fitness_gym_phone_number_gym_fragment), R.drawable.twotone_phone_24));


        // Creating and initializing the RecyclerView
        RecyclerView rvAttractions = rootView.findViewById(R.id.rvGyms);

        // Recycler view needs a LayoutManger so LinerLayoutManger needs to be created
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());

        // Initializing the LayoutManger
        rvAttractions.setLayoutManager(linearLayoutManager);

        // RecyclerView needs an adapter as well.
        // Using the location adapter constructor that accepts a Listener
        LocalAttractionsAdapter localAttractionsAdapter = new LocalAttractionsAdapter(localAttractions, this);

        // Setting up the adapter.
        rvAttractions.setAdapter(localAttractionsAdapter);

        // Returning RootView
        return rootView;

    }

    @Override
    //This method is called from the LocalAttractionsAdapter.java file, The itemView.setadapter() inside the viewHolder class called this method
    public void OnItemClick(int position) {

        String phoneNumber = localAttractions.get(position).getmPhoneNumber();
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phoneNumber, null));

        PackageManager packageManager = getActivity().getPackageManager();
        //Have to check if there is an activity to handle the request
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent);
        } else {
            Log.d("Gyms Fragments", "No Intent available to handle action");

        }


    }
}