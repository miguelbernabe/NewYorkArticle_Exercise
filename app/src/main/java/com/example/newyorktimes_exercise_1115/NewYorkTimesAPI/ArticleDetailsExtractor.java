package com.example.newyorktimes_exercise_1115.NewYorkTimesAPI;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.util.ArrayList;

public class ArticleDetailsExtractor
{
    ObjectMapper objectMapper;
    String acquiredJsonData;
    MostViewed mostViewedArticles;

    public ArticleDetailsExtractor(String content)
    {
        acquiredJsonData = content;
        InitializeObjectMapper();
    }

    private void InitializeObjectMapper()
    {
            //Extract necessary properties from Json
            Gson gson = new Gson();
            mostViewedArticles = gson.fromJson(acquiredJsonData, MostViewed.class);
    }

    public ArrayList<String> getListofTitles()
    {
       return ReturnArticleProperty("title");
    }

    public ArrayList<String> getListofPublishedDate()
    {
        return(ReturnArticleProperty("published_date"));
    }
    public ArrayList<String> getListofAuthors()
    {
        return(ReturnArticleProperty("author"));
    }

    public ArrayList<String> ReturnArticleProperty(String property)
    {
        ArrayList<String> properties = new ArrayList<>();
        ArrayList<Article> listOfArticles = mostViewedArticles.getResults();

        if(property.compareToIgnoreCase("title") == 0)
        {
                  for(Article article : listOfArticles)
                  {
                      properties.add(article.getTitle());
                  }
                  return properties;
        }
        else if(property.compareToIgnoreCase("published_date") == 0)
        {
            for(Article article : listOfArticles)
            {
                properties.add(article.getPublished_date());
            }
            return properties;
        }
        else if(property.compareToIgnoreCase("author") == 0)
        {
            for(Article article : listOfArticles)
            {
                properties.add(article.getAuthor());
            }
            return properties;
        }
        else
        {
            ArrayList<String> x = new ArrayList<>(); //Not existing propery is queried.
            return x;
        }
    }
}
