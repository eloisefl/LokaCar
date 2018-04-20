package com.example.eechedelongchamp2017.lokacar.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.eechedelongchamp2017.lokacar.R;
import com.example.eechedelongchamp2017.lokacar.bo.Voiture;
import com.example.eechedelongchamp2017.lokacar.fragments.ListeVoituresFragment;

import java.util.List;

public class RecycledVoituresAdapter extends RecyclerView.Adapter<RecycledVoituresAdapter.ViewHolder> {

    private List<Voiture> voitures;
    private ListeVoituresFragment.OnListFragmentInteractionListener listener;

    /*
     * ViewHolder
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View myview;
        public final TextView voiture_nom;
        public final TextView voiture_dispo;
        public final ImageView voiture_photo;
        public Voiture mItem;

        public ViewHolder(View view) {
            super(view);
            myview = view;
            voiture_nom = view.findViewById(R.id.voiture_nom);
            voiture_dispo = view.findViewById(R.id.voiture_dispo);
            voiture_photo = view.findViewById(R.id.voiture_photo) ;
        }
    }

    public RecycledVoituresAdapter(
            List<Voiture> items,
            ListeVoituresFragment.OnListFragmentInteractionListener dalistener)
    {
        voitures = items;
        listener = dalistener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view =
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.fragment_listevoitures_content,
                                parent, false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        holder.mItem = voitures.get(position);

        holder.voiture_nom.setText(String.format("%s %s",
                voitures.get(position).getMarque().getNom(),
                voitures.get(position).getMarque().getModele().getNom())
        );
        holder.voiture_dispo.setText(String.format("%d", 2));
        holder.voiture_photo.setImageResource(R.drawable.porsche);

        holder.myview.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (null != listener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    listener.onListFragmentInteraction(holder.mItem);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return voitures.size();
    }
}
