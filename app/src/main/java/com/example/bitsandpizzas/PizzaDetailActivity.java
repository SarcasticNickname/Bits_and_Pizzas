package com.example.bitsandpizzas;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

public class PizzaDetailActivity extends AppCompatActivity {

    public static final String PIZZA_EXTRA_ID = "extra_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Set the toolbar as activities action bar
        Toolbar toolbar = findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);

        // Display the details of pizza;
        int pizzaId = (int)getIntent().getExtras().get(PIZZA_EXTRA_ID);
        // Getting pizzas name
        String pizzaName = Pizza.pizzas[pizzaId].getName();
        // Setting pizzas name to text view
        TextView textView = findViewById(R.id.detail_text);
        textView.setText(pizzaName);

        // Getting pizzas image resource id
        int pizzaImageId = Pizza.pizzas[pizzaId].getImageResourceId();
        // Getting image view for pizza image
        ImageView imageView = findViewById(R.id.detail_image);
        // Setting pizzas image to the view
        imageView.setImageDrawable(ContextCompat.getDrawable(this, pizzaImageId));
        // Setting images description
        imageView.setContentDescription(pizzaName);
    }
}