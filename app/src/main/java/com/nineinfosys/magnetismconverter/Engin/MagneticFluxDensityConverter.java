package com.nineinfosys.magnetismconverter.Engin;
import java.util.ArrayList;


public class MagneticFluxDensityConverter {


    private double tesla   ,weberpersquare   ,weberpersquarecentimeter ,weberpersquareinch  ,maxwellpersquaremeter   , maxwellpersquarecentimeter   ,maxwellpersquareinch   ,gauss   ,linepersquarecentimeter  ,linepersquareinch  ,gamma  ;
    private String conversionFrom;
    private double edtValue;


    public MagneticFluxDensityConverter(String conversionFrom, int edtValue) {
        // TODO Auto-generated constructor stub
        this.conversionFrom = conversionFrom;
        this.edtValue = edtValue;
    }

    public ArrayList<ConversionResults> calculateMagneticFluxDensityConversion()
    {

        ArrayList<ConversionResults> converterArray = new ArrayList<ConversionResults>();

        ConversionResults results= new ConversionResults();

        switch(conversionFrom)
        {




            case "Tesla - T":

                tesla=(edtValue)*1;
                weberpersquare=(edtValue)*1;
                weberpersquarecentimeter=(edtValue)*0.0001;
                weberpersquareinch=(edtValue)*0.00064516;
                maxwellpersquaremeter=(edtValue)*1;
                maxwellpersquarecentimeter=(edtValue)*10000;
                maxwellpersquareinch=(edtValue)*64516;
                gauss=(edtValue)*10000;
                linepersquarecentimeter=(edtValue)*10000;
                linepersquareinch=(edtValue)*64516;
                gamma=(edtValue)*1000000000;

                break;

            case "Weber/square meter - Wb/m²":
                tesla=(edtValue)*1;
                weberpersquare=(edtValue)*1;
                weberpersquarecentimeter=(edtValue)*0.0001;
                weberpersquareinch=(edtValue)*0.00064516;
                maxwellpersquaremeter=(edtValue)*1;
                maxwellpersquarecentimeter=(edtValue)*10000;
                maxwellpersquareinch=(edtValue)*64516;
                gauss=(edtValue)*10000;
                linepersquarecentimeter=(edtValue)*10000;
                linepersquareinch=(edtValue)*64516;
                gamma=(edtValue)*1000000000;

                break;

            case  "Weber/square centimeter - Wb/cm²":

                tesla=(edtValue)*10000;
                weberpersquare=(edtValue)*10000;
                weberpersquarecentimeter=(edtValue)*1;
                weberpersquareinch=(edtValue)*6.4516;
                maxwellpersquaremeter=(edtValue)*10000;
                maxwellpersquarecentimeter=(edtValue)*100000000;
                maxwellpersquareinch=(edtValue)*645160000;
                gauss=(edtValue)*100000000;
                linepersquarecentimeter=(edtValue)*100000000;
                linepersquareinch=(edtValue)*645160000;
                gamma=(edtValue)*10000000000000.0;


                break;

            case "Weber/square inch - Wb/in²":

                tesla=(edtValue)*1550.0031;
                weberpersquare=(edtValue)*1550.0031;
                weberpersquarecentimeter=(edtValue)*0.15500031;
                weberpersquareinch=(edtValue)*1;
                maxwellpersquaremeter=(edtValue)*1550.0031;
                maxwellpersquarecentimeter=(edtValue)*15500031;
                maxwellpersquareinch=(edtValue)*100000000;
                gauss=(edtValue)*15500031;
                linepersquarecentimeter=(edtValue)*15500031;
                linepersquareinch=(edtValue)*100000000;
                gamma=(edtValue)*1550003100006.0;


                break;

            case "Maxwell/square meter - Mx/m²":

                tesla=(edtValue)*1;
                weberpersquare=(edtValue)*1;
                weberpersquarecentimeter=(edtValue)*0.0001;
                weberpersquareinch=(edtValue)*0.00064516;
                maxwellpersquaremeter=(edtValue)*1;
                maxwellpersquarecentimeter=(edtValue)*10000;
                maxwellpersquareinch=(edtValue)*64516;
                gauss=(edtValue)*10000;
                linepersquarecentimeter=(edtValue)*10000;
                linepersquareinch=(edtValue)*64516;
                gamma=(edtValue)*1000000000;


                break;

            case "Maxwell/square centimeter - Mx/cm²":

                tesla=(edtValue)*0.0001;
                weberpersquare=(edtValue)*0.0001;
                weberpersquarecentimeter=(edtValue)*1.E-8;
                weberpersquareinch=(edtValue)*6.4516E-8;
                maxwellpersquaremeter=(edtValue)*0.0001;
                maxwellpersquarecentimeter=(edtValue)*1;
                maxwellpersquareinch=(edtValue)*6.4516;
                gauss=(edtValue)*1;
                linepersquarecentimeter=(edtValue)*1;
                linepersquareinch=(edtValue)*6.4516;
                gamma=(edtValue)*100000;


                break;

            case "Maxwell/square inch - Mx/in²":

                tesla=(edtValue)*0.0000155;
                weberpersquare=(edtValue)*0.0000155;
                weberpersquarecentimeter=(edtValue)*1.5500031E-9;
                weberpersquareinch=(edtValue)*1.E-8;
                maxwellpersquaremeter=(edtValue)*0.0000155;
                maxwellpersquarecentimeter=(edtValue)*0.15500031;
                maxwellpersquareinch=(edtValue)*1;
                gauss=(edtValue)*0.15500031;
                linepersquarecentimeter=(edtValue)*0.15500031;
                linepersquareinch=(edtValue)*1;
                gamma=(edtValue)*15500.031;


                break;

            case "Gauss - G":

                tesla=(edtValue)*0.0001;
                weberpersquare=(edtValue)*0.0001;
                weberpersquarecentimeter=(edtValue)*1.E-8;
                weberpersquareinch=(edtValue)*6.4516E-8;
                maxwellpersquaremeter=(edtValue)*0.0001;
                maxwellpersquarecentimeter=(edtValue)*1;
                maxwellpersquareinch=(edtValue)*6.4516;
                gauss=(edtValue)*1;
                linepersquarecentimeter=(edtValue)*1;
                linepersquareinch=(edtValue)*6.4516;
                gamma=(edtValue)*100000;


                break;

            case "Line/square centimeter - L/cm²":

                tesla=(edtValue)*0.0001;
                weberpersquare=(edtValue)*0.0001;
                weberpersquarecentimeter=(edtValue)*1.E-8;
                weberpersquareinch=(edtValue)*6.4516E-8;
                maxwellpersquaremeter=(edtValue)*0.0001;
                maxwellpersquarecentimeter=(edtValue)*1;
                maxwellpersquareinch=(edtValue)*6.4516;
                gauss=(edtValue)*1;
                linepersquarecentimeter=(edtValue)*1;
                linepersquareinch=(edtValue)*6.4516;
                gamma=(edtValue)*100000;


                break;

            case  "Line/square inch - L/in²":

                tesla=(edtValue)*0.0000155;
                weberpersquare=(edtValue)*0.0000155;
                weberpersquarecentimeter=(edtValue)*1.5500031E-9;
                weberpersquareinch=(edtValue)*1.E-8;
                maxwellpersquaremeter=(edtValue)*0.0000155;
                maxwellpersquarecentimeter=(edtValue)*0.15500031;
                maxwellpersquareinch=(edtValue)*1;
                gauss=(edtValue)*0.15500031;
                linepersquarecentimeter=(edtValue)*0.15500031;
                linepersquareinch=(edtValue)*1;
                gamma=(edtValue)*15500.031;


                break;

            case "Gamma - gamma":

                tesla=(edtValue)*1.E-9;
                weberpersquare=(edtValue)*1.E-9;
                weberpersquarecentimeter=(edtValue)*1.E-13;
                weberpersquareinch=(edtValue)*6.4516E-13;
                maxwellpersquaremeter=(edtValue)*1.E-9;
                maxwellpersquarecentimeter=(edtValue)*0.00001;
                maxwellpersquareinch=(edtValue)*0.000064516;
                gauss=(edtValue)*0.00001;
                linepersquarecentimeter=(edtValue)*0.00001;
                linepersquareinch=(edtValue)*0.000064516;
                gamma=(edtValue)*1;


                break;

        }



        results.setTesla( tesla) ;
        results. setWeberpersquare( weberpersquare);
        results. setWeberpersquarecentimeter( weberpersquarecentimeter) ;
        results. setWeberpersquareinch( weberpersquareinch) ;

        results. setMaxwellpersquaremeter( maxwellpersquaremeter);
        results. setMaxwellpersquareinch( maxwellpersquareinch);
        results. setMaxwellpersquarecentimeter( maxwellpersquarecentimeter);
        results. setGauss( gauss) ;
        results. setLinepersquarecentimeter( linepersquarecentimeter) ;

        results. setLinepersquareinch( linepersquareinch) ;

        results. setGamma( gamma);



        converterArray.add(results);
        return converterArray;


    }

    public class ConversionResults{

        private double tesla   ,weberpersquare   ,weberpersquarecentimeter ,weberpersquareinch  ,maxwellpersquaremeter   , maxwellpersquarecentimeter   ,maxwellpersquareinch   ,gauss   ,linepersquarecentimeter  ,linepersquareinch  ,gamma  ;

        public double getTesla() {
            return tesla;
        }

        public void setTesla(double tesla) {
            this.tesla = tesla;
        }

        public double getWeberpersquare() {
            return weberpersquare;
        }

        public void setWeberpersquare(double weberpersquare) {
            this.weberpersquare = weberpersquare;
        }

        public double getWeberpersquarecentimeter() {
            return weberpersquarecentimeter;
        }

        public void setWeberpersquarecentimeter(double weberpersquarecentimeter) {
            this.weberpersquarecentimeter = weberpersquarecentimeter;
        }

        public double getWeberpersquareinch() {
            return weberpersquareinch;
        }

        public void setWeberpersquareinch(double weberpersquareinch) {
            this.weberpersquareinch = weberpersquareinch;
        }

        public double getMaxwellpersquaremeter() {
            return maxwellpersquaremeter;
        }

        public void setMaxwellpersquaremeter(double maxwellpersquaremeter) {
            this.maxwellpersquaremeter = maxwellpersquaremeter;
        }

        public double getMaxwellpersquarecentimeter() {
            return maxwellpersquarecentimeter;
        }

        public void setMaxwellpersquarecentimeter(double maxwellpersquarecentimeter) {
            this.maxwellpersquarecentimeter = maxwellpersquarecentimeter;
        }

        public double getMaxwellpersquareinch() {
            return maxwellpersquareinch;
        }

        public void setMaxwellpersquareinch(double maxwellpersquareinch) {
            this.maxwellpersquareinch = maxwellpersquareinch;
        }

        public double getGauss() {
            return gauss;
        }

        public void setGauss(double gauss) {
            this.gauss = gauss;
        }

        public double getLinepersquarecentimeter() {
            return linepersquarecentimeter;
        }

        public void setLinepersquarecentimeter(double linepersquarecentimeter) {
            this.linepersquarecentimeter = linepersquarecentimeter;
        }

        public double getLinepersquareinch() {
            return linepersquareinch;
        }

        public void setLinepersquareinch(double linepersquareinch) {
            this.linepersquareinch = linepersquareinch;
        }

        public double getGamma() {
            return gamma;
        }

        public void setGamma(double gamma) {
            this.gamma = gamma;
        }


    }

   /* public static void main(String[] args) {
        // TODO Auto-generated method stub
        MagneticFluxDensity iA = new MagneticFluxDensity("tesla",1);

        ArrayList<MagneticFluxDensity.ConversionResults> results = iA.calculateMagneticFluxDensityConversion();
        int length = results.size();




        for(int i = 0; i <length; i++){

            MagneticFluxDensity.ConversionResults item  =  results.get(i);

            System.out.println("\n tesla - " +new DecimalFormat("##.################").format( item.getTesla())
                    +"\n weberpersquare- " +new DecimalFormat("##.################").format( item.getWeberpersquare())
                    +"\n weberpersquarecentimeter - " +new DecimalFormat("##.################").format( item.getWeberpersquarecentimeter())+
                    "\n weberpersquareinch - " +new DecimalFormat("##.################").format( item.getWeberpersquareinch())

                    +"\n maxwellpersquaremeter- " +new DecimalFormat("##.################").format( item.getMaxwellpersquaremeter())
                    +"\n maxwellpersquarecentimeter - " +new DecimalFormat("##.################").format( item.getMaxwellpersquarecentimeter())+
                    "\n maxwellpersquareinch - " +new DecimalFormat("##.################").format( item.getMaxwellpersquareinch())




                    +"\n gauss - " +new DecimalFormat("##.################").format( item.getGauss())+
                    "\n linepersquarecentimeter - " +new DecimalFormat("##.################").format( item.getLinepersquarecentimeter())


                    +"\n linepersquareinch - " +new DecimalFormat("##.################").format( item.getLinepersquareinch())+
                    "\n gamma - " +new DecimalFormat("##.################").format( item.getGamma())

            );



        }
    }
*/

}