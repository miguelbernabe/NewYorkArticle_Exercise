package com.example.newyorktimes_exercise_1115;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ArticleDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_details);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        InitializeControls();
    }

    private void InitializeControls()
    {
        Intent intent = getIntent();
        String title = intent.getStringExtra("KEY_TITLE");
        String author = intent.getStringExtra("KEY_AUTHOR");
        String date = intent.getStringExtra("KEY_DATE");

        TextView textViewTitle = (TextView)findViewById(R.id.textView_titleDetails);
        TextView textViewAuthor = (TextView)findViewById(R.id.textView_authorDetails);
        TextView textViewPublishedDate =(TextView)findViewById(R.id.textView_publishedDateDetails);

        textViewTitle.setText(title);
        textViewAuthor.setText(author);
        textViewAuthor.setText(date);
    }

}
