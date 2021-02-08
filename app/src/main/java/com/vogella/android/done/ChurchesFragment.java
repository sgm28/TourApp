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
 * Use the {@link ChurchesFragment} factory method to
 * create an instance of this fragment.
 */
public class ChurchesFragment extends Fragment implements LocalAttractionsAdapter.OnItemListener {

    //A list of local Attractions objects.
    //LocalAttractions is class that contains the data that will be bind with the recyclerview adapter.
    private ArrayList<LocalAttractions> localAttractions;

    public ChurchesFragment() {
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
        View rootView = inflater.inflate(R.layout.fragment_churches, container, false);

        // Setup up the list
        localAttractions = new ArrayList<>();

        // Populating the localAttractions list with localAttractions objects
        // I DO NOT OWN ANY OF THE PICTURES NO COPYRIGHT INTENT !
        localAttractions.add(new LocalAttractions(R.drawable.chrisitian_love_baptist_church, getString(R.string.Christian_Love_Baptist_Church_ChurchesFragment), getString(R.string.christian_love_baptist_church_address_ChurchesFragment), getString(R.string.christian_love_baptist_church_phone_ChurcesFragment), R.drawable.twotone_phone_24));
        localAttractions.add(new LocalAttractions(R.drawable.second_reformed_church, getString(R.string.second_reformed_church_ChurchesFragment), getString(R.string.second_reformed_church_address_ChurchesFragment), getString(R.string.second_reformed_church_phone_ChurchesFragment), R.drawable.twotone_phone_24));
        localAttractions.add(new LocalAttractions(R.drawable.transcend_worship_center, getString(R.string.transcend_wordship_center_ChurchesFragment), getString(R.string.transcend_wordship_center_address_ChurchesFragment), getString(R.string.transcend_wordship_center_phone_ChurchesFragment), R.drawable.twotone_phone_24));
        localAttractions.add(new LocalAttractions(R.drawable.irvington_united_methodist_church, getString(R.string.irvington_united_methodist_church_ChurchesFragment), getString(R.string.irvington_united_methodist_address_ChurchesFragment), getString(R.string.irvington_united_methodist_church_phone_ChurchesFragment), R.drawable.twotone_phone_24));
        localAttractions.add(new LocalAttractions(R.drawable.good_shepherd_parish, getString(R.string.good_shepherd_parish_ChurchesFragment), getString(R.string.good_shepard_church_address_ChurchesFragment), getString(R.string.good_shepard_church_phone_ChurchesFragment), R.drawable.twotone_phone_24));

        // Creating and initializing the RecyclerView
        RecyclerView rvAttractions = rootView.findViewById(R.id.rvChurches);

        // Recycler view needs a LayoutManger so LinerLayoutManger needs to be created
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());

        // Initializing the LayoutManger
        rvAttractions.setLayoutManager(linearLayoutManager);

        // RecyclerView needs an adapter as well.
        LocalAttractionsAdapter localAttractionsAdapter = new LocalAttractionsAdapter(localAttractions, this);

        // Setting up the adapter.
        rvAttractions.setAdapter(localAttractionsAdapter);

        // Returning RootView
        return rootView;

    }

    //Implements on OnItemClick in the adapter
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
            Log.d("Church Fragments", "No Intent available to handle action");

        }


    }
}