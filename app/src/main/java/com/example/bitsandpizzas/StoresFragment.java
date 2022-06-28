package com.example.bitsandpizzas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class StoresFragment extends Fragment {

    public StoresFragment() {
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
        RecyclerView storesRecycle = (RecyclerView) inflater.inflate(
                R.layout.fragment_pasta, container, false);

        // Getting data for view
        String[] storeNames = new String[Store.stores.length];
        for (int i = 0; i < storeNames.length; ++i) {
            storeNames[i] = Store.stores[i].getName();
        }

        int[] storeImageResourceIds = new int[Store.stores.length];
        for (int i = 0; i < storeImageResourceIds.length; ++i) {
            storeImageResourceIds[i] = Store.stores[i].getImageResourceId();
        }

        // Setting adapter
        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(storeNames, storeImageResourceIds);
        storesRecycle.setAdapter(adapter);

        // Setting manager
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        storesRecycle.setLayoutManager(manager);

        // Setting listener for adapter
        adapter.setListener(position -> {
            Intent intent = new Intent(getActivity(), StoresDetailActivity.class);
            intent.putExtra(StoresDetailActivity.STORE_EXTRA_ID, position);
            getActivity().startActivity(intent);
        });

        return storesRecycle;
    }
}