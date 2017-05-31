package com.nineinfosys.magnetismconverter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.nineinfosys.magnetismconverter.ConverterActivity.MagneticFieldStrengthActivity;
import com.nineinfosys.magnetismconverter.ConverterActivity.MagneticFluxActivity;
import com.nineinfosys.magnetismconverter.ConverterActivity.MagneticFluxDensityActivity;
import com.nineinfosys.magnetismconverter.ConverterActivity.MagnetomotiveForceActivity;


public class SearchActivity extends AppCompatActivity implements TextWatcher {


    // List view
    private ListView lv;

    private String selectedItem;
    // Listview Adapter
    ArrayAdapter<String> adapter;

    // Search EditText
    EditText inputSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        //customize toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Search Unit");


        // Listview Data
        String listitem[] = {

                //magnetism
                "Ampere/meter - A/m",
                "Ampere turn/meter - At/m",
                "Kiloampere/meter - kA/m",
                "Oersted - Oe",

                //magneticflux
                "Weber - Wb",
                "Miliweber - mWb",
                "Microweber - μWb",
                "Volt second - V*s",
                "Unit pole - u",
                "Mega line - megaLine",
                "Kilo line - kiloLine",
                "Line - line",
                "Maxwell - Mx",
                "Tesla square meter - T*m²",
                "Tesla square centimeter - T*cm²",
                "Gauss square meter - gauss*m²",
                "Magnetic flux quantum",

                //magnetic flux density
                "Tesla - T",
                "Weber/square meter - Wb/m²",
                "Weber/square centimeter - Wb/cm²",
                "Weber/square inch - Wb/in²",
                "Maxwell/square meter - Mx/m²",
                "Maxwell/square centimeter - Mx/cm²",
                "Maxwell/square inch - Mx/in²",

                //magnemotive
                "Ampere turn - At",
                "Kiloampere turn - kAt",
                "Milliampere turn - mAt",
                "Abampere turn - abAt",
                "Gilbert - Gi"



        };

        lv = (ListView) findViewById(R.id.list_view);
        inputSearch = (EditText) findViewById(R.id.inputSearch);

        // Adding items to listview
        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.product_name, listitem);
        lv.setAdapter(adapter);

        /*Collections.sort(lv, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareToIgnoreCase(s2);
            }
        });*/

        inputSearch.addTextChangedListener(this);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView adapterView, View view, int position, long id) {

                //Do some more stuff here and launch new activity
                selectedItem = (String) adapterView.getItemAtPosition(position);
                //  Toast.makeText(SearchActivity.this,"Position"+selectedItem,Toast.LENGTH_LONG).show();
                switch (selectedItem) {


                    //magnetism field strength
                    case "Ampere/meter - A/m" : magneticfieldstrenght(); break;
                    case "Ampere turn/meter - At/m" : magneticfieldstrenght(); break;
                    case "Kiloampere/meter - kA/m" : magneticfieldstrenght(); break;
                    case "Oersted - Oe" : magneticfieldstrenght(); break;

                    //magnetic flux
                    case "Weber - Wb" : magneticflux(); break;
                    case "Miliweber - mWb" : magneticflux(); break;
                    case "Microweber - μWb" : magneticflux(); break;
                    case "Volt second - V*s" : magneticflux(); break;
                    case "Unit pole - u" : magneticflux(); break;
                    case "Mega line - megaLine" : magneticflux(); break;
                    case "Kilo line - kiloLine" : magneticflux(); break;
                    case "Line - line" : magneticflux(); break;
                    case "Maxwell - Mx" : magneticflux(); break;
                    case "Tesla square meter - T*m²" : magneticflux(); break;
                    case "Tesla square centimeter - T*cm²" : magneticflux(); break;
                    case "Gauss square meter - gauss*m²" : magneticflux(); break;
                    case "Magnetic flux quantum" : magneticflux(); break;

                    //magnetic flux density
                    case "Tesla - T" : magneticfluxdensity(); break;
                    case "Weber/square meter - Wb/m²" : magneticfluxdensity(); break;
                    case "Weber/square centimeter - Wb/cm²" : magneticfluxdensity(); break;
                    case "Weber/square inch - Wb/in²" : magneticfluxdensity(); break;
                    case "Maxwell/square meter - Mx/m²" : magneticfluxdensity(); break;
                    case "Maxwell/square centimeter - Mx/cm²" : magneticfluxdensity(); break;
                    case "Maxwell/square inch - Mx/in²" : magneticfluxdensity(); break;

                    //magnomotive
                    case "Ampere turn - At" : magnemotive(); break;
                    case "Kiloampere turn - kAt" : magnemotive(); break;
                    case "Milliampere turn - mAt" : magnemotive(); break;
                    case "Abampere turn - abAt" : magnemotive(); break;
                    case "Gilbert - Gi" : magnemotive(); break;


                }
            }
        });
        }

    private void magnemotive() {
        Intent i7=new Intent(SearchActivity.this,MagnetomotiveForceActivity.class);
        startActivity(i7);
    }

    private void magneticfluxdensity() {
        Intent i7=new Intent(SearchActivity.this,MagneticFluxDensityActivity.class);
        startActivity(i7);
    }

    private void magneticflux() {
        Intent i7=new Intent(SearchActivity.this,MagneticFluxActivity.class);
        startActivity(i7);
    }

    private void magneticfieldstrenght() {
        Intent i7=new Intent(SearchActivity.this,MagneticFieldStrengthActivity.class);
        startActivity(i7);
    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        SearchActivity.this.adapter.getFilter().filter(s);

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



