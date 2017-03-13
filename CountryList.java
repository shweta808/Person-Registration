package com.example.shwetashahane.assignment2;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;



public class CountryList extends ListFragment implements AdapterView.OnItemClickListener {

    onCountryItemSelectListener countrySelected;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        countrySelected = (onCountryItemSelectListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_view, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter countryAdapter = ArrayAdapter.createFromResource(getActivity(),R.array.countries, android.R.layout.simple_list_item_1);
        setListAdapter(countryAdapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        countrySelected.onCountryItemSelected(position);
    }

    public interface onCountryItemSelectListener {
        void onCountryItemSelected(int position);
    }
}