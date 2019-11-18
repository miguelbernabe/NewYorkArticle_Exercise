package com.example.newyorktimes_exercise_1115.NewYorkTimesAPI;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Article
{
    private String id;

    private String byline;

    private String title;

    private String published_date;

    private String getId() {
        return id;
    }

    public String getAuthor() {
        return byline;
    }

    public String getTitle() {
        return title;
    }

    public String getPublished_date() { return published_date; }


}
