package com.vogella.android.done;

//Date that will be displayed in the list
public class LocalAttractions {

    //The fields for all the Fragments
    private int mImage;
    private int mImagePhone;
    private String mAddress;
    private String mRating;
    private String mNameOfDish;
    private String mNameOfRestaurant;
    private String mIngredients;
    private String mPhoneNumber;
    private String mYoutubeLink;

    //Constructor for ParkFragment

    LocalAttractions(int mImageID, String mNameOfRestaurant, String mAddress) {
        this.mImage = mImageID;
        this.mNameOfRestaurant = mNameOfRestaurant;
        this.mAddress = mAddress;
        this.mImagePhone = -1;

    }

    //Constructor for RestaurantFragment
    LocalAttractions(int mImageID, String mNameOfRestaurant, String mAddress, String mPhoneNumber, int mImagePhone) {
        this.mImage = mImageID;
        this.mNameOfRestaurant = mNameOfRestaurant;
        this.mAddress = mAddress;
        this.mPhoneNumber = mPhoneNumber;
        this.mImagePhone = mImagePhone;
    }

    //Getters
    public int getmImage() {
        return mImage;
    }

    public String getmAddress() {
        return mAddress;
    }

    public String getmIngredients() {
        return mIngredients;
    }

    public String getmNameOfDish() {
        return mNameOfDish;
    }

    public String getmPhoneNumber() {
        return mPhoneNumber;
    }

    public String getmRating() {
        return mRating;
    }

    public String getmYoutubeLink() {
        return mYoutubeLink;
    }

    public String getmNameOfRestaurant() {
        return mNameOfRestaurant;
    }

    public int getmImagePhone() {
        return mImagePhone;
    }


    //Setters
    public void setmAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    public void setmImage(int mImage) {
        this.mImage = mImage;
    }

    public void setmIngredients(String mIngredients) {
        this.mIngredients = mIngredients;
    }

    public void setmNameOfDish(String mNameOfDish) {
        this.mNameOfDish = mNameOfDish;
    }

    public void setmNameOfRestaurant(String mNameOfRestaurant) {
        this.mNameOfRestaurant = mNameOfRestaurant;
    }

    public void setmPhoneNumber(String mPhoneNumber) {
        this.mPhoneNumber = mPhoneNumber;
    }

    public void setmRating(String mRating) {
        this.mRating = mRating;
    }

    public void setmYoutubeLink(String mYoutubeLink) {
        this.mYoutubeLink = mYoutubeLink;
    }

    public void setmImagePhone(int mImagePhone) {
        this.mImagePhone = mImagePhone;
    }

    public boolean isPhoneImageSet() {
        return this.mImagePhone != -1;
    }

}
