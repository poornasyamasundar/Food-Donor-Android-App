
/*

This class wraps all the required information to store the user given comments into our database.
When we have to add/change/delete comments from the database, we pass in an object of FeedBack class to make the work simpler and easy to understand.
When we want to work with the feedback data and its corresponding database, we deal with these objects.
This has all the getters and setters

*/

package com.example.phase1;
import androidx.annotation.NonNull;

public class FeedBack {
    private String name;
    private int id;
    private int date;
    private int month;
    private int year;
    private String comment;

    FeedBack()
    {
        name = "";
        id = 0;
        date = 0;
        month = 0;
        year = 0;
        comment = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @NonNull
    @Override
    public String toString() {
        return "Donor{" +
                "name='" + name + '\'' +
                ", id=" + Integer.toString(id) +
                ", date='" + Integer.toString(date) + '\'' +
                ", month='" + Integer.toString(month) + '\'' +
                ", year=" + Integer.toString(year) +
                ", comment=" + comment +
                '}';
    }
}
