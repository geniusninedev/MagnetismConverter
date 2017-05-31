package com.nineinfosys.magnetismconverter.Engin;
import java.util.ArrayList;


public class MagneticFieldStrengthConverter {

    private double amperepermeter, ampereturnpermeter, kiloamperepermeter, oersted;
    private double edtValue;
    private String conversionFrom;


    public MagneticFieldStrengthConverter(String conversionFrom, int edtValue) {
        // TODO Auto-generated constructor stub
        this.conversionFrom = conversionFrom;
        this.edtValue = edtValue;
    }

    public ArrayList<ConversionResults> calculateMagneticFieldStrengthConversion() {

        ArrayList<ConversionResults> converterArray = new ArrayList<ConversionResults>();

        ConversionResults results = new ConversionResults();

        switch (conversionFrom) {
            case "Ampere/meter - A/m":

                amperepermeter = (edtValue) * 1;
                ampereturnpermeter = (edtValue) * 1;
                kiloamperepermeter = (edtValue) * 0.001;
                oersted = (edtValue) * 0.0125663706;

            break;

            case "Ampere turn/meter - At/m":

                amperepermeter = (edtValue) * 1;
                ampereturnpermeter = (edtValue) * 1;
                kiloamperepermeter = (edtValue) * 0.001;
                oersted = (edtValue) * 12.566370614;


                break;
            case "Kiloampere/meter - kA/m":

                amperepermeter = (edtValue) * 1000;
                ampereturnpermeter = (edtValue) * 1000;
                kiloamperepermeter = (edtValue) * 1;
                oersted = (edtValue) * 12.566370614;


                break;


            case "Oersted - Oe":

                amperepermeter = (edtValue) * 79.577471546;
                ampereturnpermeter = (edtValue) * 79.577471546;
                kiloamperepermeter = (edtValue) * 0.0795774715;
                oersted = (edtValue) * 1;


        }


        results.setAmpereturnpermeter(ampereturnpermeter);
        results.setAmperepermeter(amperepermeter);
        results.setKiloamperepermeter(kiloamperepermeter);

        results.setOersted(oersted);

        converterArray.add(results);
        return converterArray;

    }

    public class ConversionResults {
        private double amperepermeter, ampereturnpermeter, kiloamperepermeter, oersted;

        public double getAmperepermeter() {
            return amperepermeter;
        }

        public void setAmperepermeter(double amperepermeter) {
            this.amperepermeter = amperepermeter;
        }

        public double getAmpereturnpermeter() {
            return ampereturnpermeter;
        }

        public void setAmpereturnpermeter(double ampereturnpermeter) {
            this.ampereturnpermeter = ampereturnpermeter;
        }

        public double getKiloamperepermeter() {
            return kiloamperepermeter;
        }

        public void setKiloamperepermeter(double kiloamperepermeter) {
            this.kiloamperepermeter = kiloamperepermeter;
        }

        public double getOersted() {
            return oersted;
        }

        public void setOersted(double oersted) {
            this.oersted = oersted;
        }

    }



    }

