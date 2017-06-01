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


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.nineinfosys.magnetismconverter.Adapter.RecyclerViewConversionListAdapter;
import com.nineinfosys.magnetismconverter.Engin.MagnetomotiveForceConverter;
import com.nineinfosys.magnetismconverter.R;
import com.nineinfosys.magnetismconverter.Supporter.ItemList;
import com.nineinfosys.magnetismconverter.Supporter.Settings;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ConversionMagnetomotiveForceList extends AppCompatActivity implements TextWatcher {

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
    private String strAmpereturn = null;
    private String strKiloampereturn  = null;
    private String strMilliampereturn  = null;
    private String strAbampereturn  = null;
    private String strGilbert  = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion_list);
        //keyboard hidden first time
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        //customize toolbar
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#d32f2f")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Conversion Report");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#9a0007"));
        }

        //format of decimal pint
        formatsetting();

        MobileAds.initialize(ConversionMagnetomotiveForceList.this, getString(R.string.ads_app_id));
        AdView mAdView = (AdView) findViewById(R.id.adViewUnitConverterList);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

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

            case "Ampere turn - At":
                textconversionFrom.setText("Ampere turn");
                textViewConversionShortform.setText("At");
                break;

            case  "Kiloampere turn - kAt":
                textconversionFrom.setText("Kiloampere turn");
                textViewConversionShortform.setText("kAt");

                break;
            case   "Milliampere turn - mAt":
                textconversionFrom.setText("Milliampere turn");
                textViewConversionShortform.setText("mAt");
                break;
            case "Abampere turn - abAt":
                textconversionFrom.setText("Abampere turn");
                textViewConversionShortform.setText("abAt");
                break;
            case  "Gilbert - Gi":
                textconversionFrom.setText("Gilbert");
                textViewConversionShortform.setText("Gi");
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
        MagnetomotiveForceConverter c = new MagnetomotiveForceConverter(strSpinnerFrom,(int)doubleEdittextvalue1);
        ArrayList<MagnetomotiveForceConverter.ConversionResults> results = c.calculateMagnetomotiveForceConversion();
        int length = results.size();
        for (int i = 0; i < length; i++) {
            MagnetomotiveForceConverter.ConversionResults item = results.get(i);



             strAmpereturn = String.valueOf(formatter.format(item.getAmpereturn()));
             strKiloampereturn = String.valueOf(formatter.format(item.getKiloampereturn()));
              strMilliampereturn = String.valueOf(formatter.format(item.getMilliampereturn()));
             strAbampereturn = String.valueOf(formatter.format(item.getAbampereturn()));
              strGilbert = String.valueOf(formatter.format(item.getGilbert()));



            list.add(new ItemList("At","Ampere turn",strAmpereturn,"At"));
            list.add(new ItemList("kAt","Kiloampere turn",strKiloampereturn,"kAt"));
            list.add(new ItemList("mAt","Milliampere turn ",strMilliampereturn,"mAt"));
            list.add(new ItemList("abAt","Abampere turn ",strAbampereturn,"abAt"));
            list.add(new ItemList("Gi","Gilbert",strGilbert,"Gi"));

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
