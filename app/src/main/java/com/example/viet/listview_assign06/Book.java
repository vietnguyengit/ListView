package com.example.viet.listview_assign06;

/**
 * Created by Viet on 10/5/2017.
 */

public class Book {


    private String mTitle;
    private int mRating;
    private int mImage;

    public Book(String title, int rating, int image) {
        mTitle = title;
        mRating = rating;
        mImage = image;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getRating() {
        String full_rating;
        full_rating = "Rating: "+ mRating;
        return full_rating;
    }

    public int getImage() {
        return mImage;
    }

}
