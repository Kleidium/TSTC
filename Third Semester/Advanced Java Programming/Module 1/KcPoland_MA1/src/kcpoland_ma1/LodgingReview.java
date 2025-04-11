package kcpoland_ma1;


public class LodgingReview {
    //Member Variables//
    //All Lodging Reviews have the Name of Reviewer, Date of Review, Review Comments, and Review Rating.
    String name;
    String date;
    String comments;
    float rating;
    
    
    //Constructors//
    
    //Default Constructor
    LodgingReview() {
        name = "Default Reviewer Name";
        date = "Default Date";
        comments = "Default Comments";
        rating = 0.0f;
    }
    
    //Overloaded Constructor
    LodgingReview(String name, String date, String comments, float rating) {
        this.name = name;
        this.date = date;
        this.comments = comments;
        this.rating = rating;
    }
    
    
    //String Display Method//
    @Override
    public String toString() {
        return ("\nReviewer Name: " + name + "\nReview Date: " + date + "\nReview Comments: " + comments + "\nReview Rating: " + rating);
    }
}
