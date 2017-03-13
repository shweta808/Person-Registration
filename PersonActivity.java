package com.example.shwetashahane.assignment2;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.*;
import android.view.*;
import android.content.*;
import android.support.design.widget.*;
import android.graphics.*;


public class PersonActivity extends AppCompatActivity {

    private static final int INTENT_BIRTHDATE_REQUEST = 1;
    private static final int INTENT_COUNTRYSTATE_REQUEST=2;
    public static final String STATE = "state";
    public static final String COUNTRY = "country";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);
        Button doneButton = (Button) findViewById(R.id.doneButton);
        doneButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                saveData();
            }
        });
        restoreData();
        Button setButton = (Button) findViewById(R.id.setButton);
        setButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setBirthDate();
            }
        });

        Button selectButton = (Button) findViewById(R.id.selectButton);
        selectButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setCountryNState();
            }
        });
    }

    public void setBirthDate() {
        Intent setBd = new Intent(this, BirthdateActivity.class);
        startActivityForResult(setBd, INTENT_BIRTHDATE_REQUEST);
    }
    public void setCountryNState(){
        Intent setBd = new Intent(this, COuntryStateActivity.class);
        startActivityForResult(setBd, INTENT_COUNTRYSTATE_REQUEST);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == INTENT_BIRTHDATE_REQUEST) {
            if (resultCode == RESULT_OK) {
                String birth_date = data.getStringExtra("BD");
                EditText birthdateText = (EditText) this.findViewById(R.id.birthdateText);
                birthdateText.setText(birth_date);
                Log.i("Birth", birth_date);

            }

        } else if (requestCode == INTENT_COUNTRYSTATE_REQUEST) {
            if (resultCode == RESULT_OK) {
                EditText countrystateText = (EditText) this.findViewById(R.id.countrystateText);
                countrystateText.setText(data.getStringExtra(COUNTRY) + ", " + data.getStringExtra(STATE));

            }
        }
    }

    private void restoreData() {
        SharedPreferences settings = getPreferences(MODE_PRIVATE);
        EditText nameText = (EditText) this.findViewById(R.id.nameText);
        nameText.setText(settings.getString("FIRST_NAME", ""));
        EditText lastNameText = (EditText) this.findViewById(R.id.lastNameText);
        lastNameText.setText(settings.getString("LAST_NAME", ""));
        EditText ageText = (EditText) this.findViewById(R.id.ageText);
        ageText.setText(settings.getString("AGE", ""));
        EditText emailIdText = (EditText) this.findViewById(R.id.emailIdText);
        emailIdText.setText(settings.getString("Email_ID", ""));
        EditText phoneText = (EditText) this.findViewById(R.id.phoneText);
        phoneText.setText(settings.getString("Phone", ""));
        EditText birthdateText = (EditText) this.findViewById(R.id.birthdateText);
        birthdateText.setText(settings.getString("Birthdate", ""));
        EditText countrystateText = (EditText) this.findViewById(R.id.countrystateText);
        countrystateText.setText(settings.getString("Country&State", ""));
    }


    private void saveData() {
        SharedPreferences settings = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        EditText nameText = (EditText) this.findViewById(R.id.nameText);
        String nameContents = nameText.getText().toString();
        editor.putString("FIRST_NAME", nameContents);
        EditText lastNameText = (EditText) this.findViewById(R.id.lastNameText);
        String lastNameContents = lastNameText.getText().toString();
        editor.putString("LAST_NAME", lastNameContents);
        EditText ageText = (EditText) this.findViewById(R.id.ageText);
        String ageContents = ageText.getText().toString();
        editor.putString("AGE", ageContents);
        EditText emailIdText = (EditText) this.findViewById(R.id.emailIdText);
        String emailIdContents = emailIdText.getText().toString();
        editor.putString("Email_ID", emailIdContents);
        EditText phoneText = (EditText) this.findViewById(R.id.phoneText);
        String phoneContents = phoneText.getText().toString();
        editor.putString("Phone", phoneContents);
        EditText birthdateText = (EditText) this.findViewById(R.id.birthdateText);
        String birthdateContents = birthdateText.getText().toString();
        editor.putString("Birthdate", birthdateContents);
        EditText countrystateText = (EditText) this.findViewById(R.id.countrystateText);
        String countryContents = countrystateText.getText().toString();
        editor.putString("Country&State", countryContents);
        editor.commit();
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) findViewById(R.id
               .coordinatorLayout);
        Snackbar snackbar = Snackbar
                .make(coordinatorLayout, "Person Registration is successful", Snackbar.LENGTH_LONG);
        View snackbarView = snackbar.getView();
        snackbarView.setBackgroundColor(Color.DKGRAY);
        snackbar.show();
    }




}
