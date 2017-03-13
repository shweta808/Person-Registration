package com.example.shwetashahane.assignment2;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;



public class StateList extends ListFragment implements AdapterView.OnItemClickListener {

    onStateItemSelectListener stateSelected;
    public static final String STATE = "state";

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        stateSelected = (onStateItemSelectListener) context;
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
        ArrayAdapter stateAdapter = ArrayAdapter.createFromResource(getActivity(), getArguments().getInt(STATE), android.R.layout.simple_list_item_1);
        setListAdapter(stateAdapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String[] states = getResources().getStringArray(getArguments().getInt(STATE));

        stateSelected.onStateItemSelected(states[position]);
    }

    public interface onStateItemSelectListener {
        void onStateItemSelected(String state);
    }
}