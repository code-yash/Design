package com.mycompany.foodkart.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Rating {

    String ratingId;
    private List<Integer> rating;
    private List<String> comment;
    int totalRatings;

    public Rating() {
        this.ratingId = UUID.randomUUID().toString();
        this.rating = new ArrayList<>();
        this.comment = new ArrayList<>();
        this.totalRatings = 0;
    }

    public void addRatingAndComment(int ratings, String comment) {
        this.rating.add(ratings);
        this.comment.add(comment);
        this.totalRatings += ratings;
    }

    public void addRating(int ratings) {
        this.rating.add(ratings);
        this.comment.add(null);
        this.totalRatings += ratings;
    }

    public double getAvgRating() {
        return totalRatings / (rating.size() * 1.0);
    }

    public List<Integer> getRating() {
        return rating;
    }

    public List<String> getComment() {
        return comment;
    }

}
