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
import com.nineinfosys.magnetismconverter.ConverterActivityList.ConversionFluxListActivity;
import com.nineinfosys.magnetismconverter.Engin.MagneticFluxConverter;
import com.nineinfosys.magnetismconverter.R;
import com.nineinfosys.magnetismconverter.Supporter.Settings;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MagneticFluxActivity extends AppCompatActivity implements View.OnClickListener,TextWatcher  {

    //declaration of designing tools
    private Spinner spinnerConvertFrom,spinnerConvertTo;
    private EditText editTextValue,editTextValueTo;
    private static final int REQUEST_CODE = 100;

    private FloatingActionButton buttonList,buttonShare,buttonMail,buttonCopy;
    private SwitchCompat switchChangeType;
    List<String> listForceFirstfrom,listFirstForceTo,listForcefrom,listForceTo;
    private String stringSpinnerFrom,stringSpinnerTo;
    private TextView textViewBasicUnit,textViewAllUnit,textViewConvert;
    double doubleEdittextvalue=1.0;
    private int basicunit=3;
    private int allunit=13;
    DecimalFormat formatter = null;

    MagneticFluxConverter.ConversionResults item;
     private String  strWeber = null;
     private String  strMiliweber  = null;
     private String   strmicroweber  = null;
     private String  strVoltsecond = null;
     private String     strUnitpole = null;
     private String    strMegaline = null;
     private String  strKiloline = null;
     private String  strLine = null;
     private String strMaxwell = null;
     private String  strTeslasquaremeter = null;
     private String  strTeslasquarcentiemeter = null;
     private String  strGaussquaremeter = null;
     private String strMagneticfluxquantum = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_converter);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#03a9f4")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Magnetic Flux");


        formatsetting();

        MobileAds.initialize(MagneticFluxActivity.this, getString(R.string.ads_app_id));
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
        buttonCopy.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorskyblue)));
        buttonList.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorskyblue)));
        buttonShare.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorskyblue)));
        buttonMail.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorskyblue)));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            textViewConvert.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorskyblue)));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#007ac1"));
        }

        DrawableCompat.setTintList(DrawableCompat.wrap(switchChangeType.getThumbDrawable()),ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorskyblue)));
        textViewBasicUnit.setText(String.valueOf("Basic Units("+basicunit+")"));
        textViewAllUnit.setText(String.valueOf("All Units("+allunit+")"));


        //adding value to spinner
        listForceFirstfrom = new ArrayList<String>();
        listFirstForceTo = new ArrayList<String>();

        //for first time running spinner
        listForceFirstfrom.add("Weber - Wb ");
        listForceFirstfrom.add("Miliweber - mWb");
        listForceFirstfrom.add("Microweber - μWb");

        listFirstForceTo.add("Weber - Wb ");
        listFirstForceTo.add("Miliweber - mWb");
        listFirstForceTo.add("Microweber - μWb");

        // Creating adapter for spinner
        ArrayAdapter<String> Adapter = new ArrayAdapter<String>(MagneticFluxActivity.this,android.R.layout.simple_spinner_item, listForceFirstfrom);
        ArrayAdapter<String> AdapterTempTo = new ArrayAdapter<String>(MagneticFluxActivity.this,android.R.layout.simple_spinner_item, listFirstForceTo);


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

                listForcefrom = new ArrayList<String>();
                listForceTo = new ArrayList<String>();
                String stringSwitchSate=String.valueOf(isChecked);
                String strBasic="Basic";
                String strAdvance="All";
                switch(stringSwitchSate)
                {

                    case "false":
                        Snackbar.make(buttonView, "You switched to "+strBasic+" Units", Snackbar.LENGTH_LONG).setAction("ACTION",null).show();
                        listForcefrom.clear();
                        listForceTo.clear();
                        listForcefrom.add("Weber - Wb");
                        listForcefrom.add("Miliweber - mWb");
                        listForcefrom.add("Microweber - μWb");


                        //2 spinner
                        listForceTo.add("Weber - Wb");
                        listForceTo.add("Miliweber - mWb");
                        listForceTo.add("Microweber - μWb");



                        break;

                    case "true":
                        Snackbar.make(buttonView, "You switched to "+strAdvance+" Units", Snackbar.LENGTH_LONG).setAction("ACTION",null).show();
                        listForcefrom.clear();
                        listForceTo.clear();
                        listForcefrom.add("Weber - Wb");
                        listForcefrom.add("Miliweber - mWb");
                        listForcefrom.add("Microweber - μWb");
                        listForcefrom.add("Volt second - V*s");
                        listForcefrom.add("Unit pole - u");
                        listForcefrom.add("Mega line - megaLine");
                        listForcefrom.add("Kilo line - kiloLine");
                        listForcefrom.add("Line - line");
                        listForcefrom.add("Maxwell - Mx");
                        listForcefrom.add("Tesla square meter - T*m²");
                        listForcefrom.add("Tesla square centimeter - T*cm²");
                        listForcefrom.add("Gauss square meter - gauss*m²");
                        listForcefrom.add("Magnetic flux quantum");

                        //2 spinner
                        listForceTo.add("Weber - Wb");
                        listForceTo.add("Miliweber - mWb");
                        listForceTo.add("Microweber - μWb");
                        listForceTo.add("Volt second - V*s");
                        listForceTo.add("Unit pole - u");
                        listForceTo.add("Mega line - megaLine");
                        listForceTo.add("Kilo line - kiloLine");
                        listForceTo.add("Line - line");
                        listForceTo.add("Maxwell - Mx");
                        listForceTo.add("Tesla square meter - T*m²");
                        listForceTo.add("Tesla square centimeter - T*cm²");
                        listForceTo.add("Gauss square meter - gauss*m²");
                        listForceTo.add("Magnetic flux quantum");

                        break;
                }
                // Creating adapter for spinner
                ArrayAdapter<String> Adapter2 = new ArrayAdapter<String>(MagneticFluxActivity.this,android.R.layout.simple_spinner_item, listForcefrom);
                ArrayAdapter<String> AdapterTempTo2 = new ArrayAdapter<String>(MagneticFluxActivity.this,android.R.layout.simple_spinner_item, listForceTo);


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
                Intent i=new Intent(this,ConversionFluxListActivity.class);
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

        }
        catch (NumberFormatException e) {
            doubleEdittextvalue = 0;

        }


    }
    public void calcualteValue(String strSpinnerFromvalue1,String strSpinnerTovalue2,double doubleEdittextvalue1)
    {


        try {

            MagneticFluxConverter c = new MagneticFluxConverter(strSpinnerFromvalue1, (int) doubleEdittextvalue1);
            ArrayList<MagneticFluxConverter.ConversionResults> results = c.calculateMagnetConversion();
            int length = results.size();
            for (int i = 0; i < length; i++) {
                item = results.get(i);

                strWeber = String.valueOf(formatter.format(item.getWeber()));
                strMiliweber = String.valueOf(formatter.format(item.getMiliweber()));
                strmicroweber = String.valueOf(formatter.format(item.getMicroweber()));
                strVoltsecond = String.valueOf(formatter.format(item.getVoltsecond()));

                strUnitpole = String.valueOf(formatter.format(item.getUnitpole()));
                strMegaline = String.valueOf(formatter.format(item.getMegaline()));
                strKiloline = String.valueOf(formatter.format(item.getKiloline()));
                strLine = String.valueOf(formatter.format(item.getLine()));

                strMaxwell = String.valueOf(formatter.format(item.getMaxwell()));
                strTeslasquaremeter = String.valueOf(formatter.format(item.getTeslasquaremeter()));
                strTeslasquarcentiemeter = String.valueOf(formatter.format(item.getTeslasquarcentimeter()));
                strGaussquaremeter = String.valueOf(formatter.format(item.getGaussquaremeter()));
                strMagneticfluxquantum = String.valueOf(formatter.format(item.getMagneticfluxquantum()));


                switch(strSpinnerFromvalue1) {
                    case "Weber - Wb":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Miliweber - mWb":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Microweber - μWb":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Volt second - V*s":
                        conversion(strSpinnerTovalue2);
                        break;

                    case "Unit pole - u":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Mega line - megaLine":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Kilo line - kiloLine":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Line - line":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Maxwell - Mx":
                        conversion(strSpinnerTovalue2);
                        break;
                    case  "Tesla square meter - T*m²":
                        conversion(strSpinnerTovalue2);
                        break;
                    case  "Tesla square centimeter - T*cm²":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Gauss square meter - gauss*m²":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Magnetic flux quantum":
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


            case "Weber - Wb":
                editTextValueTo.setText(strWeber);
                break;
            case  "Miliweber - mWb":
                editTextValueTo.setText(strMiliweber);
                break;
            case   "Microweber - μWb":
                editTextValueTo.setText(strmicroweber);
                break;
            case "Volt second - V*s":
                editTextValueTo.setText(strVoltsecond);
                break;

            case "Unit pole - u":
                editTextValueTo.setText(strUnitpole);
                break;
            case "Mega line - megaLine":
                editTextValueTo.setText(strMegaline);
                break;
            case "Kilo line - kiloLine":
                editTextValueTo.setText(strKiloline);
                break;
            case "Line - line":
                editTextValueTo.setText(strLine);
                break;
            case "Maxwell - Mx":
                editTextValueTo.setText(strMaxwell);
                break;
            case  "Tesla square meter - T*m²":
                editTextValueTo.setText(strTeslasquaremeter);
                break;
            case   "Tesla square centimeter - T*cm²":
                editTextValueTo.setText(strTeslasquarcentiemeter);
                break;
            case "Gauss square meter - gauss*m²":
                editTextValueTo.setText(strGaussquaremeter);
                break;
            case "Magnetic flux quantum":
                editTextValueTo.setText(strMagneticfluxquantum);
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