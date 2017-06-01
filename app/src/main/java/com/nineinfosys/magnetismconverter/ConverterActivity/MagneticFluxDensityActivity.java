package com.nineinfosys.magnetismconverter.ConverterActivity;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.nineinfosys.magnetismconverter.ConverterActivityList.ConversionMagneticFluxListActivity;
import com.nineinfosys.magnetismconverter.Engin.MagneticFluxDensityConverter;
import com.nineinfosys.magnetismconverter.R;
import com.nineinfosys.magnetismconverter.Supporter.Settings;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MagneticFluxDensityActivity extends AppCompatActivity implements View.OnClickListener,TextWatcher  {

    //declaration of designing tools
    private Spinner spinnerConvertFrom,spinnerConvertTo;
    private EditText editTextValue,editTextValueTo;
    private static final int REQUEST_CODE = 100;
    private FloatingActionButton buttonList,buttonShare,buttonMail,buttonCopy;
    private SwitchCompat switchChangeType;
    List<String> listFluxFirstfrom,listFirstFluxTo,listFluxfrom,listFluxTo;
    private String stringSpinnerFrom,stringSpinnerTo;
    private TextView textViewBasicUnit,textViewAllUnit,textViewConvert;
    double doubleEdittextvalue=1.0;
    private int basicunit=3;
    private int allunit=11;
    DecimalFormat formatter = null;

    MagneticFluxDensityConverter.ConversionResults item;

     private String   strTesla = null;
     private String   strWeberpersquare = null;
     private String   strWeberpersquarecentimeter = null;
     private String   strWeberpersquareinch = null;
     private String   strMaxwellpersquaremeter = null;
     private String   strMaxwellpersquarecentimeter = null;
     private String   strMaxwellpersquareinch = null;
     private String   strGauss = null;
     private String   strLinepersquarecentimeter = null;
     private String   strLinepersquareinch = null;
     private String   strGamma = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_converter);

        //customize toolbar
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#757575")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Magnetic Flux Density");


        formatsetting();

        MobileAds.initialize(MagneticFluxDensityActivity.this, getString(R.string.ads_app_id));
        AdView mAdView = (AdView) findViewById(R.id.adViewUnitConverter);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        //keyboard hidden first time
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        //initalization of tools and variables
        spinnerConvertFrom=(Spinner)findViewById(R.id.spinnerConvertFrom);
        spinnerConvertTo=(Spinner)findViewById(R.id.spinnerConvertTo);
        textViewBasicUnit=(TextView)findViewById(R.id.textViewBasicUnit);
        textViewAllUnit=(TextView)findViewById(R.id.textViewAllUnit);
        editTextValue=(EditText)findViewById(R.id.edittextFrom);
        editTextValueTo=(EditText)findViewById(R.id.edittextTo);
        textViewConvert=(TextView) findViewById(R.id.buttonUnitConverter);
        buttonCopy=(FloatingActionButton)findViewById(R.id.button_copy);
        buttonList=(FloatingActionButton) findViewById(R.id.button_list_fullreport);
        buttonShare=(FloatingActionButton)findViewById(R.id.button_list_share);
        buttonMail=(FloatingActionButton)findViewById(R.id.button_list_mail);
        switchChangeType=(SwitchCompat)findViewById(R.id.switchButton);


        //setting button color dynamically
        buttonCopy.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorBlack)));
        buttonList.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorBlack)));
        buttonShare.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorBlack)));
        buttonMail.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorBlack)));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            textViewConvert.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorBlack)));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#494949"));
        }

        DrawableCompat.setTintList(DrawableCompat.wrap(switchChangeType.getThumbDrawable()),ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorBlack)));
        textViewBasicUnit.setText(String.valueOf("Basic Units("+basicunit+")"));
        textViewAllUnit.setText(String.valueOf("All Units("+allunit+")"));


        //adding value to spinner
        listFluxFirstfrom = new ArrayList<String>();
        listFirstFluxTo = new ArrayList<String>();

        //for first time running spinner
        listFluxFirstfrom.add("Tesla - T ");
        listFluxFirstfrom.add("Weber/square meter - Wb/m²");
        listFluxFirstfrom.add("Weber/square centimeter - Wb/cm²");


        listFirstFluxTo.add("Tesla - T ");
        listFirstFluxTo.add("Weber/square meter - Wb/m²");
        listFirstFluxTo.add("Weber/square centimeter - Wb/cm²");



        // Creating adapter for spinner
        ArrayAdapter<String> Adapter = new ArrayAdapter<String>(MagneticFluxDensityActivity.this,android.R.layout.simple_spinner_item, listFluxFirstfrom);
        ArrayAdapter<String> AdapterTempTo = new ArrayAdapter<String>(MagneticFluxDensityActivity.this,android.R.layout.simple_spinner_item, listFirstFluxTo);


        // Drop down layout style - list view with radio button
        Adapter.setDropDownViewResource(android.R.layout.simple_list_item_checked);
        AdapterTempTo.setDropDownViewResource(android.R.layout.simple_list_item_checked);

        // attaching data adapter to spinner
        spinnerConvertFrom.setAdapter(Adapter);
        spinnerConvertTo.setAdapter(AdapterTempTo);

        //switch converttype
        switchChangeType.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                listFluxfrom = new ArrayList<String>();
                listFluxTo = new ArrayList<String>();
                String stringSwitchSate=String.valueOf(isChecked);
                String strBasic="Basic";
                String strAdvance="All";
                switch(stringSwitchSate)
                {

                    case "false":
                        Snackbar.make(buttonView, "You switched to "+strBasic+" Units", Snackbar.LENGTH_LONG).setAction("ACTION",null).show();
                        listFluxfrom.clear();
                        listFluxTo.clear();
                        listFluxfrom.add("Tesla - T ");
                        listFluxfrom.add("Weber/square meter - Wb/m²");
                        listFluxfrom.add("Weber/square centimeter - Wb/cm²");



                        //2 spinner
                        listFluxTo.add("Tesla - T ");
                        listFluxTo.add("Weber/square meter - Wb/m²");
                        listFluxTo.add("Weber/square centimeter - Wb/cm²");


                        break;

                    case "true":
                        Snackbar.make(buttonView, "You switched to "+strAdvance+" Units", Snackbar.LENGTH_LONG).setAction("ACTION",null).show();
                        listFluxfrom.clear();
                        listFluxTo.clear();
                        listFluxfrom.add("Tesla - T ");
                        listFluxfrom.add("Weber/square meter - Wb/m²");
                        listFluxfrom.add("Weber/square centimeter - Wb/cm²");
                        listFluxfrom.add("Weber/square inch - Wb/in²");
                        listFluxfrom.add("Maxwell/square meter - Mx/m²");
                        listFluxfrom.add("Maxwell/square centimeter - Mx/cm²");
                        listFluxfrom.add("Maxwell/square inch - Mx/in²");

                        listFluxfrom.add("Gauss - G");
                        listFluxfrom.add("Line/square centimeter - L/cm²");
                        listFluxfrom.add("Line/square inch - L/in²");
                        listFluxfrom.add("Gamma - gamma ");



                        //2 spinner
                        listFluxTo.add("Tesla - T ");
                        listFluxTo.add("Weber/square meter - Wb/m²");
                        listFluxTo.add("Weber/square centimeter - Wb/cm²");
                        listFluxTo.add("Weber/square inch - Wb/in²");
                        listFluxTo.add("Maxwell/square meter - Mx/m²");
                        listFluxTo.add("Maxwell/square centimeter - Mx/cm²");
                        listFluxTo.add("Maxwell/square inch - Mx/in²");

                        listFluxTo.add("Gauss - G");
                        listFluxTo.add("Line/square centimeter - L/cm²");
                        listFluxTo.add("Line/square inch - L/in²");
                        listFluxTo.add("Gamma - gamma");


                        break;
                }
                // Creating adapter for spinner
                ArrayAdapter<String> Adapter2 = new ArrayAdapter<String>(MagneticFluxDensityActivity.this,android.R.layout.simple_spinner_item, listFluxfrom);
                ArrayAdapter<String> AdapterTempTo2 = new ArrayAdapter<String>(MagneticFluxDensityActivity.this,android.R.layout.simple_spinner_item, listFluxTo);


                // Drop down layout style - list view with radio button
                Adapter2.setDropDownViewResource(android.R.layout.simple_list_item_checked);
                AdapterTempTo2.setDropDownViewResource(android.R.layout.simple_list_item_checked);

                // attaching data adapter to spinner
                spinnerConvertFrom.setAdapter(Adapter2);
                spinnerConvertTo.setAdapter(AdapterTempTo2);


            }
        });

        editTextValue.addTextChangedListener(this);
        buttonList.setOnClickListener(this);
        buttonShare.setOnClickListener(this);
        buttonMail.setOnClickListener(this);
        buttonCopy.setOnClickListener(this);

        textViewConvert.setOnClickListener(this);
        spinnerConvertFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if(editTextValue.getText().toString().trim().equals(""))
                {
                    Snackbar.make(adapterView, "Provide Unit Value for Conversion", Snackbar.LENGTH_LONG).setAction("ACTION",null).show();
                }
                else
                {
                    doubleEdittextvalue = Double.parseDouble(editTextValue.getText().toString().trim());
                    stringSpinnerFrom = spinnerConvertFrom.getSelectedItem().toString().trim();
                    stringSpinnerTo = spinnerConvertTo.getSelectedItem().toString().trim();

                    calcualteValue(stringSpinnerFrom, stringSpinnerTo, doubleEdittextvalue);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinnerConvertTo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if(editTextValue.getText().toString().trim().equals(""))
                {
                    Snackbar.make(adapterView, "Provide Unit Value for Conversion", Snackbar.LENGTH_LONG).setAction("ACTION",null).show();
                }
                else {
                    doubleEdittextvalue = Double.parseDouble(editTextValue.getText().toString().trim());
                    stringSpinnerFrom = spinnerConvertFrom.getSelectedItem().toString().trim();
                    stringSpinnerTo = spinnerConvertTo.getSelectedItem().toString().trim();

                    calcualteValue(stringSpinnerFrom, stringSpinnerTo, doubleEdittextvalue);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void formatsetting() {
        //fetching value from sharedpreference
        SharedPreferences sharedPreferences =this.getSharedPreferences(Settings.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        //Fetching thepatient_mobile_Number value form sharedpreferences
        String  FormattedString = sharedPreferences.getString(Settings.Format_Selected_SHARED_PREF,"Thousands separator");
        String DecimalplaceString= sharedPreferences.getString(Settings.Decimal_Place_Selected_SHARED_PREF,"2");
        Settings settings=new Settings(FormattedString,DecimalplaceString);
        formatter= settings.setting();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.buttonUnitConverter:
                //switch spinner value
                int spinner1Index = spinnerConvertFrom.getSelectedItemPosition();
                spinnerConvertFrom.setSelection(spinnerConvertTo.getSelectedItemPosition());
                spinnerConvertTo.setSelection(spinner1Index );
                break;

            case R.id.button_list_fullreport:
                doubleEdittextvalue= Double.parseDouble(editTextValue.getText().toString().trim());
                Intent i=new Intent(this,ConversionMagneticFluxListActivity.class);
                i.putExtra("stringSpinnerFrom", stringSpinnerFrom);
                i.putExtra("doubleEdittextvalue", doubleEdittextvalue);
                startActivity(i);
                break;

            case R.id.button_copy:
                String text= editTextValueTo.getText().toString().trim();
                android.content.ClipboardManager clipboardMgr = (android.content.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("Copied text", text);
                clipboardMgr.setPrimaryClip(clip);
                Snackbar.make(v, "Conversion Value Copied", Snackbar.LENGTH_LONG).setAction("ACTION",null).show();
                break;

            case R.id.button_list_share:
                String textTo= editTextValueTo.getText().toString().trim();
                String textFrom= editTextValueTo.getText().toString().trim();

                String shareMessage=textFrom+" "+stringSpinnerFrom+": "+textTo+" "+stringSpinnerTo;

                try {
                    Intent share = new Intent();
                    share.setAction("android.intent.action.SEND");
                    share.setType("text/plain");
                    share.putExtra("android.intent.extra.TEXT",shareMessage);
                    startActivity(Intent.createChooser(share, ""));

                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            case R.id.button_list_mail:
                String textmailTo= editTextValueTo.getText().toString().trim();
                String textmailFrom= editTextValueTo.getText().toString().trim();
                String message= textmailTo+" "+stringSpinnerFrom+" :  "+textmailFrom+"  "+stringSpinnerTo;
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{ });
                email.putExtra(Intent.EXTRA_SUBJECT, "Conversion Details");
                email.putExtra(Intent.EXTRA_TEXT,message );
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Select Email Client"));
                break;

        }

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

        try {

            doubleEdittextvalue = Double.parseDouble(editTextValue.getText().toString().trim());
            stringSpinnerFrom = spinnerConvertFrom.getSelectedItem().toString().trim();
            stringSpinnerTo = spinnerConvertTo.getSelectedItem().toString().trim();
            calcualteValue(stringSpinnerFrom,stringSpinnerTo,doubleEdittextvalue);

            //   Toast.makeText(this, "string12" + stringSpinnerFrom + "\n string13" + stringSpinnerTo + "string14" + doubleEdittextvalue, Toast.LENGTH_LONG).show();
        }
        catch (NumberFormatException e) {
            doubleEdittextvalue = 0;

        }


    }
    public void calcualteValue(String strSpinnerFromvalue1,String strSpinnerTovalue2,double doubleEdittextvalue1)
    {


        try {

            MagneticFluxDensityConverter c = new MagneticFluxDensityConverter(strSpinnerFromvalue1, (int) doubleEdittextvalue1);
            ArrayList<MagneticFluxDensityConverter.ConversionResults> results = c.calculateMagneticFluxDensityConversion();
            int length = results.size();
            for (int i = 0; i < length; i++) {
                item = results.get(i);

                strTesla = String.valueOf(formatter.format(item.getTesla()));
                strWeberpersquare = String.valueOf(formatter.format(item.getWeberpersquare()));
                strWeberpersquarecentimeter = String.valueOf(formatter.format(item.getWeberpersquarecentimeter()));

                strWeberpersquareinch = String.valueOf(formatter.format(item.getWeberpersquareinch()));
                strMaxwellpersquaremeter = String.valueOf(formatter.format(item.getMaxwellpersquaremeter()));
                strMaxwellpersquarecentimeter = String.valueOf(formatter.format(item.getMaxwellpersquarecentimeter()));
                strMaxwellpersquareinch = String.valueOf(formatter.format(item.getMaxwellpersquareinch()));
                strGauss = String.valueOf(formatter.format(item.getGauss()));
                strLinepersquarecentimeter = String.valueOf(formatter.format(item.getLinepersquarecentimeter()));
                strLinepersquareinch = String.valueOf(formatter.format(item.getLinepersquareinch()));
                strGamma = String.valueOf(formatter.format(item.getGamma()));


                switch(strSpinnerFromvalue1) {
                    case "Tesla - T":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Weber/square meter - Wb/m²":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Weber/square centimeter - Wb/cm²":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Weber/square inch - Wb/in²":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Maxwell/square meter - Mx/m²":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Maxwell/square centimeter - Mx/cm²":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Maxwell/square inch - Mx/in²":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Gauss - G":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Line/square centimeter - L/cm²":
                        conversion(strSpinnerTovalue2);
                        break;
                    case  "Line/square inch - L/in²":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Gamma - gamma":
                        conversion(strSpinnerTovalue2);
                        break;

                }


            }


        }
        catch (NumberFormatException e) {
            doubleEdittextvalue = 0;

        }

    }

    private void conversion(String strSpinnerTovalue2) {
        switch (strSpinnerTovalue2) {


            case "Tesla - T":
                editTextValueTo.setText(strTesla);
                break;
            case  "Weber/square meter - Wb/m²":
                editTextValueTo.setText(strWeberpersquare);
                break;
            case  "Weber/square centimeter - Wb/cm²":
                editTextValueTo.setText(strWeberpersquarecentimeter);
                break;
            case "Weber/square inch - Wb/in²":
                editTextValueTo.setText(strWeberpersquareinch);
                break;
            case "Maxwell/square meter - Mx/m²":
                editTextValueTo.setText(strMaxwellpersquaremeter);
                break;
            case  "Maxwell/square centimeter - Mx/cm²":
                editTextValueTo.setText(strMaxwellpersquarecentimeter);
                break;
            case   "Maxwell/square inch - Mx/in²":
                editTextValueTo.setText(strMaxwellpersquareinch);
                break;
            case "Gauss - G":
                editTextValueTo.setText(strGauss);
                break;
            case "Line/square centimeter - L/cm²":
                editTextValueTo.setText(strLinepersquarecentimeter);
                break;
            case "Line/square inch - L/in²":
                editTextValueTo.setText(strLinepersquareinch);
                break;
            case "Gamma - gamma":
                editTextValueTo.setText(strGamma);
                break;



        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == android.R.id.home) {

            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                this.finish();
                return true;
        }
        return super.onKeyDown(keyCode, event);
    }



}