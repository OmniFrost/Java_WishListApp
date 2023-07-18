package com.izdeveloper.wishlistapp;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.EditText;
import android.os.Bundle;
import android.view.View;

public class AddItemActivity extends AppCompatActivity {

    private Storage allItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        allItems = Storage.getSingle();
    }

    public void proceed(View view) {
        EditText articleName, articleDescription;

        articleName = findViewById(R.id.txtAN);
        articleDescription = findViewById(R.id.txtDescr);

        String Name = articleName.getText().toString();
        String Descr = articleDescription.getText().toString();

        Article article = new Article(Name, Descr);

        allItems.addArticle(article);

    }
}
