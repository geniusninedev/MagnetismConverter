package com.nineinfosys.magnetismconverter.ConverterActivityList;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.print.PrintHelper;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;


import com.nineinfosys.magnetismconverter.Adapter.RecyclerViewConversionListAdapter;
import com.nineinfosys.magnetismconverter.Engin.MagneticFluxConverter;
import com.nineinfosys.magnetismconverter.R;
import com.nineinfosys.magnetismconverter.Supporter.ItemList;
import com.nineinfosys.magnetismconverter.Supporter.Settings;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ConversionFluxListActivity extends AppCompatActivity implements TextWatcher {

    List<ItemList> list = new ArrayList<ItemList>();
    private  String stringSpinnerFrom;
    private double doubleEdittextvalue;
    private EditText edittextConversionListvalue;
    private TextView textconversionFrom,textViewConversionShortform;
    View ChildView ;
    DecimalFormat formatter = null;
    private static final int REQUEST_CODE = 100;
    private File imageFile;
    private Bitmap bitmap;
    private PrintHelper printhelper;


    private RecyclerView rView;
    RecyclerViewConversionListAdapter rcAdapter;
    List<ItemList> rowListItem,rowListItem1;
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
        setContentView(R.layout.activity_conversion_list);
        //keyboard hidden first time
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        //customize toolbar
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#03a9f4")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Conversion Report");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#007ac1"));
        }

        //format of decimal pint
        formatsetting();

        edittextConversionListvalue=(EditText)findViewById(R.id.edittextConversionListvalue) ;
        textconversionFrom=(TextView) findViewById(R.id.textViewConversionFrom) ;
        textViewConversionShortform=(TextView) findViewById(R.id.textViewConversionShortform) ;
        //get the value from temperture activity
        stringSpinnerFrom = getIntent().getExtras().getString("stringSpinnerFrom");
        doubleEdittextvalue= getIntent().getExtras().getDouble("doubleEdittextvalue");
        edittextConversionListvalue.setText(String.valueOf(doubleEdittextvalue));

        NamesAndShortform(stringSpinnerFrom);


        //   Toast.makeText(this,"string1 "+stringSpinnerFrom,Toast.LENGTH_LONG).show();
        rowListItem = getAllunitValue(stringSpinnerFrom,doubleEdittextvalue);

        //Initializing Views
        rView = (RecyclerView) findViewById(R.id.recyclerViewConverterList);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(new GridLayoutManager(this, 1));


        //Initializing our superheroes list
        rcAdapter = new RecyclerViewConversionListAdapter(this,rowListItem);
        rView.setAdapter(rcAdapter);

        edittextConversionListvalue.addTextChangedListener(this);



    }

    private void NamesAndShortform(String stringSpinnerFrom) {
        switch(stringSpinnerFrom)
        {

            case "Weber - Wb":
                textconversionFrom.setText("Weber");
                textViewConversionShortform.setText("Wb");
                break;

            case  "Miliweber - mWb":
                textconversionFrom.setText("Miliweber");
                textViewConversionShortform.setText("mWb");

                break;
            case  "Microweber - μWb":
                textconversionFrom.setText("Microweber");
                textViewConversionShortform.setText("μWb");
                break;
            case "Volt second - V*s":
                textconversionFrom.setText("Volt second");
                textViewConversionShortform.setText("V*s");
                break;
            case "Unit pole - u":
                textconversionFrom.setText("Unit pole");
                textViewConversionShortform.setText("u");
                break;
            case  "Mega line - megaLine":
                textconversionFrom.setText("Mega line");
                textViewConversionShortform.setText("megaLine");
                break;
            case   "Kilo line - kiloLine":
                textconversionFrom.setText("Kilo line");
                textViewConversionShortform.setText("kiloLine");
                break;
            case "Line - line ":
                textconversionFrom.setText("Line");
                textViewConversionShortform.setText("line");
                break;
            case "Maxwell - Mx":
                textconversionFrom.setText("Maxwell");
                textViewConversionShortform.setText("Mx");
                break;
            case  "Tesla square meter - T*m²":
                textconversionFrom.setText("Tesla square meter");
                textViewConversionShortform.setText("T*m²");
                break;
            case "Tesla square centimeter - T*cm²":
                textconversionFrom.setText("Tesla square centimeter");
                textViewConversionShortform.setText("T*cm²");
                break;
            case "Gauss square meter - gauss*m²":
                textconversionFrom.setText("Gauss square meter");
                textViewConversionShortform.setText("gauss*m²");
                break;
            case "Magnetic flux quantum":
                textconversionFrom.setText("Magnetic flux quantum");
                textViewConversionShortform.setText("fluxquantum");
                break;


        }
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

    private List<ItemList> getAllunitValue(String strSpinnerFrom,double doubleEdittextvalue1) {
        MagneticFluxConverter c = new MagneticFluxConverter(strSpinnerFrom,(int)doubleEdittextvalue1);
        ArrayList<MagneticFluxConverter.ConversionResults> results = c.calculateMagnetConversion();
        int length = results.size();
        for (int i = 0; i < length; i++) {
            MagneticFluxConverter.ConversionResults item = results.get(i);


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




            list.add(new ItemList("Wb","Weber",strWeber,"Wb"));
            list.add(new ItemList("mWb","Miliweber",strMiliweber,"mWb"));
            list.add(new ItemList("μWb","Microweber",strmicroweber,"μWb"));
            list.add(new ItemList("V*s","Volt second",strVoltsecond,"V*s"));
            list.add(new ItemList("u ","Maxwell/square meter",strUnitpole,"u "));


            list.add(new ItemList("megaLine","Mega line ",strMegaline,"megaLine"));
            list.add(new ItemList("kiloLine","Kilo line",strKiloline,"kiloLine"));
            list.add(new ItemList("line"," Line",strLine,"line"));
            list.add(new ItemList("Mx  ","Maxwell",strMaxwell,"Mx"));
            list.add(new ItemList("T*m²","Tesla square meter",strTeslasquaremeter,"T*m²"));
            list.add(new ItemList("T*cm²","Tesla square centimeter",strTeslasquarcentiemeter,"T*cm²"));
            list.add(new ItemList("gauss*m²","Gauss square meter ",strGaussquaremeter,"gauss*m²"));
            list.add(new ItemList("fluxquantum","Magnetic flux quantum",strMagneticfluxquantum,"fluxquantum"));

        }
        return list;

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {


        rowListItem.clear();
        try {

            double value = Double.parseDouble(edittextConversionListvalue.getText().toString().trim());

            rowListItem1 = getAllunitValue(stringSpinnerFrom,value);


            rcAdapter = new RecyclerViewConversionListAdapter(this,rowListItem1);
            rView.setAdapter(rcAdapter);

        }
        catch (NumberFormatException e) {
            doubleEdittextvalue = 0;

        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Take appropriate action for each action item click
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
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
