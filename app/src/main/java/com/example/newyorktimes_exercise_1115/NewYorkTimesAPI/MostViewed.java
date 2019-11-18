package com.example.newyorktimes_exercise_1115.NewYorkTimesAPI;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MostViewed
{

    private List<Article> results;

    public ArrayList<Article> getResults()
    {
        return new ArrayList<>(results);
    }

    public MostViewed(ArrayList<Article> acquiredResults)
    {
        this.results = new ArrayList<>();
        for(Article a : acquiredResults)
        {
            results.add(a);
        }
    }
}
