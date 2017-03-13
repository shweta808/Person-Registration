package com.example.shwetashahane.assignment2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


public class COuntryStateActivity extends AppCompatActivity implements CountryList.onCountryItemSelectListener, StateList.onStateItemSelectListener {

    private String selCountry;
    private String selState;
    private TextView textState;


    public static final String STATE = "state";
    public static final String COUNTRY = "country";


    public static final int CHINA = 0;
    public static final int INDIA = 1;
    public static final int MEXICO = 2;
    public static final int USA = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_state);
        textState = (TextView) findViewById(R.id.text_view_state);
        textState.setVisibility(View.INVISIBLE);

        if (getSupportFragmentManager().findFragmentById(R.id.countryFrame) == null) {
            CountryList countryFrag = new CountryList();
            FragmentManager fManager = getSupportFragmentManager();
            FragmentTransaction fTransaction = fManager.beginTransaction();
            fTransaction.add(R.id.countryFrame, countryFrag);
            fTransaction.commit();
        }

    }
    public void onDone(View view) {
        Intent intent = new Intent();
        intent.putExtra(STATE, selState);
        intent.putExtra(COUNTRY, selCountry);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

    public void onCancel(View view) {
        Intent intent = new Intent();
        setResult(Activity.RESULT_CANCELED, intent);
        finish();
    }

    @Override
    public void onCountryItemSelected(int cIndex) {
        textState.setVisibility(View.VISIBLE);
        String[] countries = getResources().getStringArray(R.array.countries);
        selCountry = countries[cIndex];

        Bundle bundle = new Bundle();

        switch (cIndex) {
            case CHINA:
                bundle.putInt(STATE, R.array.china);
                break;

            case INDIA:
                bundle.putInt(STATE, R.array.india);
                break;

            case MEXICO:
                bundle.putInt(STATE, R.array.mexico);
                break;

            case USA:
                bundle.putInt(STATE, R.array.usa);
                break;

        }

        StateList stateFrag = new StateList();
        stateFrag.setArguments(bundle);

        FragmentManager fManager = getSupportFragmentManager();
        FragmentTransaction fTransaction = fManager.beginTransaction();

        if (getSupportFragmentManager().findFragmentById(R.id.stateFrame) != null) {

            fTransaction.replace(R.id.stateFrame, stateFrag);

        } else {
            fTransaction.add(R.id.stateFrame, stateFrag);
        }

        fTransaction.commit();

    }

    @Override
    public void onStateItemSelected(String state) {

        selState = state;
    }


}
