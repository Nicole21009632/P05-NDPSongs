package sg.edu.rp.c346.id21009632.p05_ndpsongs;

import java.io.Serializable;

public class Song implements Serializable {

    private int id;
    private String title;
    private String singers;
    private int year;
    private int stars;

    public Song(int id, String title, String singers, int year, int stars) {
        this.id = id;
        this.title = title;
        this.singers = singers;
        this.year = year;
        this.stars = stars;
    }

    public int get_id() { return id; }
    public String getTitle() { return title; }
    public String getSingers() { return singers; }
    public int getYear() { return year; }
    public int getStar() { return stars; }

    public void setSongTitle(String title) {
        this.title = title;
    }
    public void setSingers(String singers) {
        this.singers = singers;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public void setStars(int stars) {
        this.stars = stars;
    }

    @Override
    public String toString() {
        String starRating = "";

        if (stars == R.id.star1) { starRating = "*"; }
        else if (stars == R.id.star2) { starRating = "**"; }
        else if (stars == R.id.star3) { starRating = "***"; }
        else if (stars == R.id.star4) { starRating = "****"; }
        else if (stars == R.id.star5) { starRating = "*****"; }

        return title + "\n" + singers + " - " + year + "\n" + starRating;
    }
}
