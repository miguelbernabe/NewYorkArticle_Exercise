package com.example.newyorktimes_exercise_1115.NewYorkTimesAPI;

import com.example.newyorktimes_exercise_1115.MainActivity;
import com.example.newyorktimes_exercise_1115.R;
import java.io.IOException;
import java.util.ArrayList;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NYArticleLoader
{
    OkHttpClient client;
    Request request;
    public String acquiredData;
    MainActivity mainActivity;
    ArticleDetailsExtractor articleDetailsExtractor;
    public NYArticleLoader(MainActivity mA)
    {
        mainActivity = mA;
        InitializeHttp();
        AcquireNYDataFromServer123();

    }

    private void InitializeHttp()
    {
        String url = R.string.baseURL +
                     R.string.section + "/" +
                     R.string.time_period +
                     R.string.query + R.string.api_key;

        client = new OkHttpClient();
        request = new Request.Builder()
                .url(url)
                .build();
    }

    //Perform @GET using API
    private void AcquireNYDataFromServer123()
    {
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e)
            {
                e.printStackTrace();
                mainActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException
            {
                if(response.isSuccessful())
                {
                    acquiredData = response.body().string();
                    mainActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            articleDetailsExtractor = new ArticleDetailsExtractor(acquiredData);
                        }
                    });
                }

            }
        });
    }

    public ArrayList<String> AcquireAllTitles()
    {
        return articleDetailsExtractor.getListofTitles();
    }

    public ArrayList<String> AcquireAllAuthors()
    {
        return articleDetailsExtractor.getListofAuthors();
    }

    public ArrayList<String> AcquireAllPublishedDates()
    {
        return articleDetailsExtractor.getListofPublishedDate();
    }
}

