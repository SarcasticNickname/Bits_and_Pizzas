package com.example.bitsandpizzas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PastaFragment extends Fragment {
    public PastaFragment() {
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
        RecyclerView pastaRecycler =  (RecyclerView) inflater.inflate(
                R.layout.fragment_pasta, container, false);

        // Getting data
        String[] pastaNames = new String[Pasta.pastas.length];
        for (int i = 0; i < pastaNames.length; ++i) {
            pastaNames[i] = Pasta.pastas[i].getName();
        }

        int[] pastaImages = new int[Pasta.pastas.length];
        for (int i = 0; i < pastaImages.length; ++i) {
             pastaImages[i] = Pasta.pastas[i].getImageResourceId();
        }

        // Setting adapter
        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(pastaNames, pastaImages);
        pastaRecycler.setAdapter(adapter);
        // Setting manager
        StaggeredGridLayoutManager manager =
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL);
        pastaRecycler.setLayoutManager(manager);

        // Setting listener for adapter
        adapter.setListener(position -> {
            Intent intent = new Intent(getActivity(), PastaDetailActivity.class);
            intent.putExtra(PastaDetailActivity.PASTA_EXTRA_ID, position);
            getActivity().startActivity(intent);
        });

        return pastaRecycler;
    }
}