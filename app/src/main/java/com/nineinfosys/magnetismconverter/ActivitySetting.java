package com.nineinfosys.magnetismconverter;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.nineinfosys.magnetismconverter.Supporter.Settings;


public class ActivitySetting extends AppCompatActivity {

    private  RadioButton radioButtonNumberFormatDecimal,radioButtonNumberFormatSeperator,radioButtonNumberFormatScientific;
    private RadioGroup radioGroupNumberFormat;
    private SeekBar seekbarDecimalPlaces;
    private TextView textViewDecimalPlacesvalues;
    private String FormattedString,DecimalplaceString;
    private SharedPreferences sharedPreferences;
    private int decimalPlacesValue = 0;
    private static final int REQUEST_CODE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        getSupportActionBar().setTitle("Settings");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        radioButtonNumberFormatDecimal=(RadioButton)findViewById(R.id.RadioNumberFormatDecimal);
        radioButtonNumberFormatSeperator=(RadioButton)findViewById(R.id.RadioNumberFormatSeperator);
        radioButtonNumberFormatScientific=(RadioButton)findViewById(R.id.RadioNumberFormatScientific);
        textViewDecimalPlacesvalues=(TextView)findViewById(R.id.textViewDecimalPlacesvalues);

        radioGroupNumberFormat=(RadioGroup)findViewById(R.id.radioGroupNumberFormat);
        seekbarDecimalPlaces = (SeekBar)findViewById(R.id.seekBarDecimalPlaces);



        //fetching value from sharedpreference
         sharedPreferences =this.getSharedPreferences(Settings.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        //Fetching thepatient_mobile_Number value form sharedpreferences
        FormattedString = sharedPreferences.getString(Settings.Format_Selected_SHARED_PREF,"Thousands separator");
        DecimalplaceString= sharedPreferences.getString(Settings.Decimal_Place_Selected_SHARED_PREF,"4");

        seekbarDecimalPlaces.setProgress(Integer.parseInt(DecimalplaceString));
        textViewDecimalPlacesvalues.setText("Decimal Places: "+DecimalplaceString);

            switch (FormattedString) {
                case "Thousands separator":
                    radioButtonNumberFormatSeperator.setChecked(true);
                    break;
                case "Decimal Format":
                    radioButtonNumberFormatDecimal.setChecked(true);
                    break;
                case "Exponential Format":
                    radioButtonNumberFormatScientific.setChecked(true);
                    break;
            }


        seekbarDecimalPlaces.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                decimalPlacesValue = progress;

                //Creating a shared preference
                sharedPreferences = ActivitySetting.this.getSharedPreferences(Settings.SHARED_PREF_NAME, Context.MODE_PRIVATE);

                //Creating editor to store values to shared preferences
                SharedPreferences.Editor editor = sharedPreferences.edit();

                //Adding values to editor
                editor.putBoolean(Settings.Formatter_SHARED_PREF, true);

                editor.putString(Settings.Decimal_Place_Selected_SHARED_PREF, String.valueOf(decimalPlacesValue));

                //Saving values to editor
                editor.commit();
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textViewDecimalPlacesvalues.setText("Decimal Places: "+seekBar.getProgress());

            }
        });

        radioGroupNumberFormat.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                radioButtonNumberFormatSeperator = (RadioButton)findViewById(radioGroup.getCheckedRadioButtonId());
                //For Changing Button Image
                if (radioButtonNumberFormatSeperator.getText().toString().trim().equals("Decimal Format")) {
                    String DecimalFormat="Decimal Format";
                    //Creating a shared preference
                    sharedPreferences = ActivitySetting.this.getSharedPreferences(Settings.SHARED_PREF_NAME, Context.MODE_PRIVATE);

                    //Creating editor to store values to shared preferences
                    SharedPreferences.Editor editor = sharedPreferences.edit();

                    //Adding values to editor
                    editor.putBoolean(Settings.Formatter_SHARED_PREF, true);
                    editor.putString(Settings.Format_Selected_SHARED_PREF, DecimalFormat);


                    //Saving values to editor
                    editor.commit();

                }else if (radioButtonNumberFormatSeperator.getText().toString().trim().equals("Thousands separator")) {

                String Thousandsseparator="Thousands separator";
                    //Creating a shared preference
                   sharedPreferences = ActivitySetting.this.getSharedPreferences(Settings.SHARED_PREF_NAME, Context.MODE_PRIVATE);

                    //Creating editor to store values to shared preferences
                    SharedPreferences.Editor editor = sharedPreferences.edit();

                    //Adding values to editor
                    editor.putBoolean(Settings.Formatter_SHARED_PREF, true);
                    editor.putString(Settings.Format_Selected_SHARED_PREF, Thousandsseparator);

                    //Saving values to editor
                    editor.commit();
                } else {
                    String Scientific="Exponential Format";
                    //Creating a shared preference
                     sharedPreferences = ActivitySetting.this.getSharedPreferences(Settings.SHARED_PREF_NAME, Context.MODE_PRIVATE);

                    //Creating editor to store values to shared preferences
                    SharedPreferences.Editor editor = sharedPreferences.edit();

                    //Adding values to editor
                    editor.putBoolean(Settings.Formatter_SHARED_PREF, true);
                    editor.putString(Settings.Format_Selected_SHARED_PREF, Scientific);

                    //Saving values to editor
                    editor.commit();
                }
            }

        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:

                finish();
                return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
