package com.example.newyorktimes_exercise_1115;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.newyorktimes_exercise_1115.NewYorkTimesAPI.NYArticleLoader;

import java.util.ArrayList;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String> titles;
    ArrayList<String> publishDates;
    ArrayList<String> authors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Initialization();
    }

    //Load Data
    private  void Initialization()
    {
        if(AcquireNYArticles())
        {
            initializeListView();
            SetListViewClickListener();
        }
    }

    //Draw ListView
    private void initializeListView()
    {
        listView =(ListView)findViewById((R.id.listView));
        ListViewAdapter listViewAdapter = new ListViewAdapter(this, titles, publishDates, authors);
        listView.setAdapter(listViewAdapter);
        SetListViewClickListener();
    }

    //Acquire NY Articles using API
    private boolean AcquireNYArticles()
    {
        NYArticleLoader articleLoader = new NYArticleLoader(this);
        titles = articleLoader.AcquireAllTitles();
        publishDates = articleLoader.AcquireAllPublishedDates();
        authors = articleLoader.AcquireAllAuthors();

        if(titles.size() == 0 || publishDates.size() == 0 || authors.size() == 0)
        {
            Toast.makeText(this,"Failed to load articles", Toast.LENGTH_SHORT).show();
            return false;
        }
        else
        {
            return true;
        }
    }

    //Set Click Event in listview
    private void SetListViewClickListener()
    {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                String _title = titles.get(position);
                String _author= authors.get(position);
                String _date = publishDates.get(position);

                Intent intent = new Intent(MainActivity.this, ArticleDetails.class);
                intent.putExtra("KEY_DATE", _title);
                intent.putExtra("KEY_AUTHOR", _author);
                intent.putExtra("KEY_DATE", _date);
                startActivity(intent);

            }
        });
    }

}
