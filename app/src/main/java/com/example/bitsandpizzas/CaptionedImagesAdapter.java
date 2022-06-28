package com.example.bitsandpizzas;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

public class CaptionedImagesAdapter extends
                RecyclerView.Adapter<CaptionedImagesAdapter.ViewHolder> {

    // For names and images on the card
    private final String[] captions;
    private final int[] imageIds;
    private Listener listener;



    // Adapter gets the data from constructor
    public CaptionedImagesAdapter(String[] captions, int[] imageIds) {
        this.captions = captions;
        this.imageIds = imageIds;
    }

    // Uses layout to create a view.
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        CardView cardView = (CardView) LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_captioned_image, viewGroup, false);
        return new ViewHolder(cardView);
    }

    // Fills the created view with data.
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        CardView cardView = viewHolder.cardView;
        ImageView imageView = (ImageView) cardView.findViewById(R.id.info_image);
        Drawable drawable =
                ContextCompat.getDrawable(cardView.getContext(), imageIds[position]);
        imageView.setImageDrawable(drawable);
        imageView.setContentDescription(captions[position]);
        TextView textView = (TextView) cardView.findViewById(R.id.info_text);
        textView.setText(captions[position]);
        cardView.setOnClickListener(view -> {
            if (listener != null) {
               listener.onClick(position);
            }
        });
    }

    // Returns cards number
    @Override
    public int getItemCount() {
        return captions.length;
    }

    // Every view holder represents a card view.
    public static class ViewHolder extends  RecyclerView.ViewHolder {

        CardView cardView;

        public ViewHolder(CardView view) {
            super(view);
            this.cardView = view;
        }
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    interface Listener {
        void onClick(int position);
    }
}
