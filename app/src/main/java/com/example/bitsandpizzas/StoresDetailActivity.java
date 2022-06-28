package com.example.bitsandpizzas;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

public class StoresDetailActivity extends AppCompatActivity {

    public static final String STORE_EXTRA_ID = "store_extra_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Set the toolbar as activities action bar
        Toolbar toolbar = findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);

        // Display the details;
        int storeId = (int)getIntent().getExtras().get(STORE_EXTRA_ID);
        // Getting name
        String storeName = Store.stores[storeId].getName();
        // Setting name to text view
        TextView textView = findViewById(R.id.detail_text);
        textView.setText(storeName);

        // Getting image resource id
        int storeImageId = Store.stores[storeId].getImageResourceId();
        // Getting image view for image
        ImageView imageView = findViewById(R.id.detail_image);
        // Setting image to the view
        imageView.setImageDrawable(ContextCompat.getDrawable(this, storeImageId));
        // Setting images description
        imageView.setContentDescription(storeName);
    }
}