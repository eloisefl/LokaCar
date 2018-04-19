package com.example.eechedelongchamp2017.lokacar.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.eechedelongchamp2017.lokacar.R;
import com.example.eechedelongchamp2017.lokacar.bo.Tarif;

import java.util.List;

public class TarifArrayAdapter extends ArrayAdapter<Tarif> {

    private List<Tarif> tarifs;
    private Context c;
    private int res;

    public TarifArrayAdapter(@NonNull Context context, int resource,
                             int textviewId, @NonNull List<Tarif> objects) {
        super(context, resource, textviewId, objects);
        this.tarifs = objects;
        this.c = context;
        this.res = resource;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView,
                                @NonNull ViewGroup parent) {
        return createItemView(position, convertView, parent);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView,
                        @NonNull ViewGroup parent) {
        return createItemView(position, convertView, parent);
    }

    private View createItemView(int position, View convertView, ViewGroup parent){

        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view = inflater.inflate(res, parent, false);

        TextView spinnerprix_typelocatif = (TextView) view.findViewById(R.id.spinnerprix_typelocatif);
        TextView spinnerprix_saison = (TextView) view.findViewById(R.id.spinnerprix_saison);
        TextView spinnerprix_prix = (TextView) view.findViewById(R.id.spinnerprix_prix);

        Tarif tarif = tarifs.get(position);

        spinnerprix_typelocatif.setText(tarif.getTypeLocatif().getNom());
        String saison;
        if (tarif.isSaisonHaute()) saison = "Saison haute";
        else saison = "Saison basse";
        spinnerprix_saison.setText(saison);
        spinnerprix_prix.setText(tarif.getPrixJournalier()+" €");

        return view;
    }

}
