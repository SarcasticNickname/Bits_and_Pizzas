package com.example.bitsandpizzas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.GridLayoutManager;

public class PizzaFragment extends Fragment {

    public PizzaFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Creating view
        RecyclerView pizzaRecycler = (RecyclerView) inflater.inflate(
                R.layout.fragment_pizza, container, false);
        // Getting data for view
        String[] pizzaNames = new String[Pizza.pizzas.length];
        for (int i = 0; i < pizzaNames.length; i++) {
            pizzaNames[i] = Pizza.pizzas[i].getName();
        }

        int[] pizzaImages = new int[Pizza.pizzas.length];
        for (int i = 0; i < pizzaImages.length; i++) {
            pizzaImages[i] = Pizza.pizzas[i].getImageResourceId();
        }
        // Setting the adapter
        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(pizzaNames, pizzaImages);
        pizzaRecycler.setAdapter(adapter);
        // Setting the manager of views
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
        pizzaRecycler.setLayoutManager(gridLayoutManager);

        adapter.setListener(position -> {
            Intent intent = new Intent(getActivity(), PizzaDetailActivity.class);
            intent.putExtra(PizzaDetailActivity.PIZZA_EXTRA_ID, position);
            getActivity().startActivity(intent);
        });

        return pizzaRecycler;
    }
}