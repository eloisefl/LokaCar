package com.example.eechedelongchamp2017.lokacar.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.eechedelongchamp2017.lokacar.R;
import com.example.eechedelongchamp2017.lokacar.bo.Tarif;
import com.example.eechedelongchamp2017.lokacar.bo.TypeLocatif;
import com.example.eechedelongchamp2017.lokacar.bo.Voiture;

import java.util.List;

public class MesVoituresGenreAdapter extends ArrayAdapter<Voiture> {

    private List<Voiture> voitures;
    private Context c;
    private int res;

    public MesVoituresGenreAdapter(@NonNull Context context,
                   int resource, @NonNull List<Voiture> objects) {
        super(context, resource, objects);
        this.voitures = objects;
        this.c = context;
        this.res = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder viewHolder;

        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(convertView == null){
            convertView = inflater.inflate(res, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.voiture_detail_immatriculation = convertView.findViewById(R.id.voiture_detail_immatriculation);
            viewHolder.voiture_detail_location = convertView.findViewById(R.id.voiture_detail_location);
            viewHolder.voiture_detail_disponibilite = convertView.findViewById(R.id.voiture_detail_disponibilite);
            viewHolder.voiture_detail_photo = convertView.findViewById(R.id.voiture_detail_photo) ;

            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Voiture voiture = getItem(position);

        viewHolder.voiture_detail_immatriculation.setText(voitures.get(position).getImmatriculation());

        String estLoue = "Non";
        if (voitures.get(position).isLoue())
            estLoue = "Oui";
        viewHolder.voiture_detail_location.setText(estLoue);

        String estDisponible = "Oui";
        if (!voitures.get(position).isDisponible())
            estLoue = "Non";
        viewHolder.voiture_detail_disponibilite.setText(estDisponible);

        int tarif = 0;
        TypeLocatif typeL = voitures.get(position).getTypeLocatif();
        List<Tarif> tarifs = typeL.getTarifs();
        // viewHolder.voiture_detail_saisonHaute.setText(voitures.get(position).getImmatriculation());
        // viewHolder.voiture_detail_saisonBasse.setText(voitures.get(position).getImmatriculation());

        viewHolder.voiture_detail_photo.setImageResource(R.drawable.porscheuse);

        return convertView;
    }

    /*
     * ViewHolder
     */
    static class ViewHolder {
        TextView voiture_detail_immatriculation;
        TextView voiture_detail_location;
        TextView voiture_detail_disponibilite;
        ImageView voiture_detail_photo;
        TextView voiture_detail_saisonHaute;
        TextView voiture_detail_saisonBasse;
    }
}
