package com.vogella.android.done;

import android.content.Context;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LocalAttractionsAdapter extends RecyclerView.Adapter<LocalAttractionsAdapter.ViewHolder> {

    // A List of attractions objects.
    private List<LocalAttractions> mAttractions;

    private OnItemListener mOnItemListener;


    //Constructor -1
    //parameter 1 - List of Attractions objects
    //parameter 2 - OnItemListener from the fragment
    //OnItemListener is the listener from the fragments activity
    public LocalAttractionsAdapter(List<LocalAttractions> Attractions, OnItemListener onItemListener) {
        mAttractions = Attractions;
        this.mOnItemListener = onItemListener;

    }

    //Constructor -2 for Fragments that don't implement onItemListener Attractions - Park Fragment
    public LocalAttractionsAdapter(List<LocalAttractions> Attractions) {
        mAttractions = Attractions;
        this.mOnItemListener = null;

    }


    // A class within the LocalAttractionsAdapter
    //RecyclerView needs a ViewHolder class
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //The following variables where created because item_local_attractions.xml contains these views.
        public ImageView restaurantImageView;
        public TextView restaurantNameTextView;
        public TextView addressTextView;
        public ImageView phoneImageView;


        OnItemListener onItemListener;


        //Constructor
        //Parameter 2 OnItemListener is the listener from the fragments
        public ViewHolder(View itemView, OnItemListener onItemListener) {
            //Calling the RecyclerView.ViewHolder constructor
            super(itemView);


            restaurantNameTextView = (TextView) itemView.findViewById(R.id.name);
            restaurantImageView = (ImageView) itemView.findViewById(R.id.restaurantImage);
            addressTextView = (TextView) itemView.findViewById(R.id.address);
            phoneImageView = (ImageView) itemView.findViewById(R.id.phoneImage);

            //This listener is set to each individual view holder.
            //Inside the RecyclerView, each item is a View holder.

            if (onItemListener == null) {
                //don't set a click listener
            } else {
                this.onItemListener = onItemListener;


                //Once the itemView is click, the onClick method gets called.
                itemView.setOnClickListener(this);
            }


        }


        @Override
        public void onClick(View v) {
            //Pass the adapter position to onItemListener
            //The computer or the compiler calls the OnItemClick method in the Fragment
            onItemListener.OnItemClick(getAdapterPosition());
        }
    }

    //RecyclerView.adapter<E> is a interface so onCreateViewHolder and onBindViewHolder had to be overwritten.
    @NonNull
    @Override
    public LocalAttractionsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View attractionsView = inflater.inflate(R.layout.item_local_attractions, parent, false);

        ViewHolder viewHolder = new ViewHolder(attractionsView, mOnItemListener);
        return viewHolder;


    }

    //Binding the data from the localAttractions object to the view in item_local_attractions.xml
    @Override
    public void onBindViewHolder(@NonNull LocalAttractionsAdapter.ViewHolder holder, int position) {

        LocalAttractions localAttractions = mAttractions.get(position);

        ImageView imageViewRestaurant = holder.restaurantImageView;
        imageViewRestaurant.setImageResource(localAttractions.getmImage());

        TextView textViewRestaurantName = holder.restaurantNameTextView;
        textViewRestaurantName.setText(localAttractions.getmNameOfRestaurant());

        TextView textViewAddress = holder.addressTextView;
        textViewAddress.setText(localAttractions.getmAddress());
        Linkify.addLinks(textViewAddress, Linkify.MAP_ADDRESSES);
        textViewAddress.setLinksClickable(true);

        ImageView phoneIconView = holder.phoneImageView;

        //Park Fragment does not have a phone number.
        if (localAttractions.isPhoneImageSet()) {
            phoneIconView.setImageResource(localAttractions.getmImagePhone());


        } else {

            phoneIconView.setVisibility(View.GONE);
        }


    }

    //Return the number of LocalAttractionsObject
    @Override
    public int getItemCount() {
        return mAttractions.size();
    }


    //Custom Listener
    public interface OnItemListener {
        void OnItemClick(int position);

    }


}
