package com.nineinfosys.magnetismconverter.Engin;

import java.util.ArrayList;


public class MagnetomotiveForceConverter {



    private double  ampereturn   , kiloampereturn  ,  milliampereturn ,abampereturn ,gilbert  ;
    private double edtValue;
    private String conversionFrom;


    public MagnetomotiveForceConverter(String conversionFrom, int edtValue) {
        // TODO Auto-generated constructor stub
        this.conversionFrom = conversionFrom;
        this.edtValue = edtValue;
    }

    public ArrayList<ConversionResults> calculateMagnetomotiveForceConversion()
    {

        ArrayList<ConversionResults> converterArray = new ArrayList<ConversionResults>();

        ConversionResults results= new ConversionResults();

        switch(conversionFrom)
        {
            case  "Ampere turn - At":

                ampereturn=(edtValue)*1;
                kiloampereturn=(edtValue)*0.001;
                milliampereturn=(edtValue)*1000;
                abampereturn=(edtValue)*0.1;
                gilbert=(edtValue)*1.256637062;


                break;


            case   "Kiloampere turn - kAt":

                ampereturn=(edtValue)*1000;
                kiloampereturn=(edtValue)*1;
                milliampereturn=(edtValue)*1000000;
                abampereturn=(edtValue)*100;
                gilbert=(edtValue)*1256.637062;


                break;

            case "Milliampere turn - mAt":

                ampereturn=(edtValue)*0.001;
                kiloampereturn=(edtValue)*0.000001;
                milliampereturn=(edtValue)*1;
                abampereturn=(edtValue)*0.0001;
                gilbert=(edtValue)*0.0012566371;


                break;

            case  "Abampere turn - abAt":

                ampereturn=(edtValue)*10;
                kiloampereturn=(edtValue)*0.01;
                milliampereturn=(edtValue)*10000;
                abampereturn=(edtValue)*1;
                gilbert=(edtValue)*12.56637062;


                break;

            case "Gilbert - Gi":

                ampereturn=(edtValue)*0.7957747151;
                kiloampereturn=(edtValue)*0.0007957747;
                milliampereturn=(edtValue)*795.7747151;
                abampereturn=(edtValue)*0.0795774715;
                gilbert=(edtValue)*1;




        }



        results. setAmpereturn( ampereturn);

        results. setKiloampereturn( kiloampereturn);

        results. setMilliampereturn( milliampereturn) ;


        results. setAbampereturn( abampereturn);

        results. setGilbert( gilbert);


        converterArray.add(results);
        return converterArray;

    }



    public class ConversionResults{
        private double  ampereturn   , kiloampereturn  ,  milliampereturn ,abampereturn ,gilbert  ;

        public double getAmpereturn() {
            return ampereturn;
        }

        public void setAmpereturn(double ampereturn) {
            this.ampereturn = ampereturn;
        }

        public double getKiloampereturn() {
            return kiloampereturn;
        }

        public void setKiloampereturn(double kiloampereturn) {
            this.kiloampereturn = kiloampereturn;
        }

        public double getMilliampereturn() {
            return milliampereturn;
        }

        public void setMilliampereturn(double milliampereturn) {
            this.milliampereturn = milliampereturn;
        }

        public double getAbampereturn() {
            return abampereturn;
        }

        public void setAbampereturn(double abampereturn) {
            this.abampereturn = abampereturn;
        }

        public double getGilbert() {
            return gilbert;
        }

        public void setGilbert(double gilbert) {
            this.gilbert = gilbert;
        }


    }


    }


