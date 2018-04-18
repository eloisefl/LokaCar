package com.example.eechedelongchamp2017.lokacar.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.eechedelongchamp2017.lokacar.R;
import com.example.eechedelongchamp2017.lokacar.adapter.RecycledVoituresAdapter;
import com.example.eechedelongchamp2017.lokacar.bo.Voiture;

public class ListeVoituresFragment extends Fragment {

    private RecyclerView recyclerview;
    private OnListFragmentInteractionListener listener;

    public ListeVoituresFragment() {

    }

    // Use : to create new instance of this fragment
    public static ListeVoituresFragment newInstance(String car_name, String nb_dispo) {

        ListeVoituresFragment fragment = new ListeVoituresFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            //
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout
        View view = inflater.inflate(R.layout.fragment_listevoitures_list,
                container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {

            Context context = view.getContext();

            // Declare the recycler view
            recyclerview = (RecyclerView) view;
            recyclerview.setLayoutManager(new LinearLayoutManager(context));

        }

        return view;
    }

    // Change adapter
    public void setAdapteer(RecycledVoituresAdapter adapter) {
        recyclerview.setAdapter(adapter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            listener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(Voiture item);
    }
}
