package com.example.eechedelongchamp2017.lokacar.adapter;

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

public class RecycledVoituresGenreAdapter
        extends RecyclerView.Adapter<RecycledVoituresGenreAdapter.ViewHolder> {

    private List<Voiture> voitures;
    private ListeVoituresFragment.OnListFragmentInteractionListener listener;

    /*
     * ViewHolder
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View myview;
        public final TextView voiture_detail_immatriculation;
        public final TextView voiture_detail_location;
        public final TextView voiture_detail_disponibilite;
        public final ImageView voiture_detail_photo;
        public Voiture mItem;

        public ViewHolder(View view) {
            super(view);
            myview = view;
            voiture_detail_immatriculation = view.findViewById(R.id.voiture_detail_immatriculation);
            voiture_detail_location = view.findViewById(R.id.voiture_detail_location);
            voiture_detail_disponibilite = view.findViewById(R.id.voiture_detail_disponibilite);
            voiture_detail_photo = view.findViewById(R.id.voiture_detail_photo) ;
        }
    }

    public RecycledVoituresGenreAdapter(
            List<Voiture> items,
            ListeVoituresFragment.OnListFragmentInteractionListener dalistener)
    {
        voitures = items;
        listener = dalistener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view =
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.fragment_listevoitures_content,
                                parent, false);

        return new RecycledVoituresGenreAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        holder.mItem = voitures.get(position);

        holder.voiture_detail_immatriculation.setText(voitures.get(position).getImmatriculation());

        String estLoue = "Non";
        if (voitures.get(position).isLoue())
            estLoue = "Oui";
        holder.voiture_detail_location.setText(estLoue);

        String estDisponible = "Oui";
        if (!voitures.get(position).isDisponible())
            estLoue = "Non";
        holder.voiture_detail_disponibilite.setText(estDisponible);

        holder.voiture_detail_photo.setImageResource(R.drawable.porscheuse);

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
