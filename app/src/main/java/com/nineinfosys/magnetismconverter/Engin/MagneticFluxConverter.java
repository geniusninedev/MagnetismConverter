package com.nineinfosys.magnetismconverter.Engin;
import java.util.ArrayList;


public class MagneticFluxConverter {

    private double weber,miliweber,microweber,voltsecond,unitpole,megaline,kiloline,line,maxwell,teslasquaremeter,teslasquarcentimeter,gaussquaremeter,magneticfluxquantum;

    private double edtValue;
    private String conversionFrom;


    public MagneticFluxConverter(String conversionFrom, int edtValue) {
        // TODO Auto-generated constructor stub
        this.conversionFrom = conversionFrom;
        this.edtValue = edtValue;
    }

    public ArrayList<ConversionResults> calculateMagnetConversion()
    {

        ArrayList<ConversionResults> converterArray = new ArrayList<ConversionResults>();

        ConversionResults results= new ConversionResults();

        switch(conversionFrom)
        {
            case "Weber - Wb":

                weber=(edtValue)*1;
                miliweber=(edtValue)*1000;
                microweber=(edtValue)*1000000;
                voltsecond=(edtValue)*1;
                unitpole=(edtValue)*7957747.1546;
                megaline=(edtValue)*100;
                kiloline=(edtValue)*100000;
                line=(edtValue)*100000000;
                maxwell=(edtValue)*100000000;
                teslasquaremeter=(edtValue)*1;
                teslasquarcentimeter=(edtValue)*10000;
                gaussquaremeter=(edtValue)*100000000;
                magneticfluxquantum=(edtValue)*483597670318520.0;


                break;

            case "Miliweber - mWb":

                weber=(edtValue)*0.001;
                miliweber=(edtValue)*1;
                microweber=(edtValue)*1000;
                voltsecond=(edtValue)*0.001;
                unitpole=(edtValue)*7957.7471546;
                megaline=(edtValue)*0.1;
                kiloline=(edtValue)*100;
                line=(edtValue)*100000;
                maxwell=(edtValue)*100000;
                teslasquaremeter=(edtValue)*0.001;
                teslasquarcentimeter=(edtValue)*10;
                gaussquaremeter=(edtValue)*100000;
                magneticfluxquantum=(edtValue)*483597670319.0;

                break;

            case "Microweber - μWb":

                weber=(edtValue)*0.000001;
                miliweber=(edtValue)*0.001;
                microweber=(edtValue)*1;
                voltsecond=(edtValue)*0.000001;
                unitpole=(edtValue)*7.9577471546;
                megaline=(edtValue)*0.0001;
                kiloline=(edtValue)*0.1;
                line=(edtValue)*100;
                maxwell=(edtValue)*100;
                teslasquaremeter=(edtValue)*0.000001;
                teslasquarcentimeter=(edtValue)*0.01;
                gaussquaremeter=(edtValue)*100;
                magneticfluxquantum=(edtValue)*483597670.32;

                break;

            case "Volt second - V*s":

                weber=(edtValue)*1;
                miliweber=(edtValue)*1000;
                microweber=(edtValue)*1000000;
                voltsecond=(edtValue)*1;
                unitpole=(edtValue)*7957747.1546;
                megaline=(edtValue)*100;
                kiloline=(edtValue)*100000;
                line=(edtValue)*100000000;
                maxwell=(edtValue)*100000000;
                teslasquaremeter=(edtValue)*1;
                teslasquarcentimeter=(edtValue)*10000;
                gaussquaremeter=(edtValue)*100000000;
                magneticfluxquantum=(edtValue)*483597670318520.0;

                break;

            case "Unit pole - u":

                weber=(edtValue)*1.256637061E-7;
                miliweber=(edtValue)*0.0001256637;
                microweber=(edtValue)*0.1256637061;
                voltsecond=(edtValue)*1.256637061E-7;
                unitpole=(edtValue)*1;
                megaline=(edtValue)*0.0000125664;
                kiloline=(edtValue)*0.0125663706;
                line=(edtValue)*12.566370614;
                maxwell=(edtValue)*12.566370614;
                teslasquaremeter=(edtValue)*1.256637061E-7;
                teslasquarcentimeter=(edtValue)*0.0012566371;
                gaussquaremeter=(edtValue)*12.566370614;
                magneticfluxquantum=(edtValue)*60770675.535;

                break;

            case "Mega line - megaLine":

                weber=(edtValue)*0.01;
                miliweber=(edtValue)*10;
                microweber=(edtValue)*10000;
                voltsecond=(edtValue)*0.1;
                unitpole=(edtValue)*79577.471546;
                megaline=(edtValue)*1;
                kiloline=(edtValue)*1000;
                line=(edtValue)*1000000.0;
                maxwell=(edtValue)*1000000;
                teslasquaremeter=(edtValue)*0.01;
                teslasquarcentimeter=(edtValue)*100;
                gaussquaremeter=(edtValue)*1000000;
                magneticfluxquantum=(edtValue)*4835976703185.0;

                break;

            case "Kilo line - kiloLine":

                weber=(edtValue)*0.00001;
                miliweber=(edtValue)*0.01;
                microweber=(edtValue)*10;
                voltsecond=(edtValue)*0.00001;
                unitpole=(edtValue)*79.577471546;
                megaline=(edtValue)*0.001;
                kiloline=(edtValue)*1;
                line=(edtValue)*1000;
                maxwell=(edtValue)*1000;
                teslasquaremeter=(edtValue)*0.00001;
                teslasquarcentimeter=(edtValue)*1000;
                gaussquaremeter=(edtValue)*0.1;
                magneticfluxquantum=(edtValue)*4835976703.2;

                break;

            case "Line - line":

                weber=(edtValue)*1.E-8;
                miliweber=(edtValue)*0.00001;
                microweber=(edtValue)*0.01;
                voltsecond=(edtValue)*1.E-8;
                unitpole=(edtValue)*0.0795774715;
                megaline=(edtValue)*0.000001;
                kiloline=(edtValue)*0.001;
                line=(edtValue)*1;
                maxwell=(edtValue)*1;
                teslasquaremeter=(edtValue)*1.E-8;
                teslasquarcentimeter=(edtValue)*0.0001;
                gaussquaremeter=(edtValue)*1;
                magneticfluxquantum=(edtValue)*4835976.7032;

                break;

            case "Maxwell - Mx":

                weber=(edtValue)*1.E-8;
                miliweber=(edtValue)*0.00001;
                microweber=(edtValue)*0.01;
                voltsecond=(edtValue)*1.E-8;
                unitpole=(edtValue)*0.0795774715;
                megaline=(edtValue)*0.000001;
                kiloline=(edtValue)*0.001;
                line=(edtValue)*1;
                maxwell=(edtValue)*1;
                teslasquaremeter=(edtValue)*1.E-8;
                teslasquarcentimeter=(edtValue)*0.0001;
                gaussquaremeter=(edtValue)*1;
                magneticfluxquantum=(edtValue)*4835976.7032;

                break;

            case "Tesla square meter - T*m²":

                weber=(edtValue)*1;
                miliweber=(edtValue)*1000;
                microweber=(edtValue)*1000000;
                voltsecond=(edtValue)*1;
                unitpole=(edtValue)*7957747.1546;
                megaline=(edtValue)*100;
                kiloline=(edtValue)*100000;
                line=(edtValue)*100000000;
                maxwell=(edtValue)*100000000;
                teslasquaremeter=(edtValue)*1;
                teslasquarcentimeter=(edtValue)*10000;
                gaussquaremeter=(edtValue)*100000000;
                magneticfluxquantum=(edtValue)*483597670318520.0;

                break;

            case "Tesla square centimeter - T*cm²":

                weber=(edtValue)*0.0001;
                miliweber=(edtValue)*0.1;
                microweber=(edtValue)*100;
                voltsecond=(edtValue)*0.0001;
                unitpole=(edtValue)*795.77471546;
                megaline=(edtValue)*0.01;
                kiloline=(edtValue)*10;
                line=(edtValue)*10000;
                maxwell=(edtValue)*10000;
                teslasquaremeter=(edtValue)*0.0001;
                teslasquarcentimeter=(edtValue)*1;
                gaussquaremeter=(edtValue)*10000;
                magneticfluxquantum=(edtValue)*48359767032.0;

                break;

            case "Gauss square meter - gauss*m²":

                weber=(edtValue)*1.E-8;
                miliweber=(edtValue)*0.00001;
                microweber=(edtValue)*0.01;
                voltsecond=(edtValue)*1.E-8;
                unitpole=(edtValue)*0.0795774715;
                megaline=(edtValue)*0.000001;
                kiloline=(edtValue)*0.001;
                line=(edtValue)*1;
                maxwell=(edtValue)*1;
                teslasquaremeter=(edtValue)*1.E-8;
                teslasquarcentimeter=(edtValue)*0.0001;
                gaussquaremeter=(edtValue)*1;
                magneticfluxquantum=(edtValue)*4835976.7032;

                break;

            case "Magnetic flux quantum":

                weber=(edtValue)*2.067834609E-15;
                miliweber=(edtValue)*2.067834609E-12;
                microweber=(edtValue)*2.067834609E-9;
                voltsecond=(edtValue)*2.067834609E-15;
                unitpole=(edtValue)*1.645530498E-8;
                megaline=(edtValue)*2.067834609E-13;
                kiloline=(edtValue)*2.067834609E-10;
                line=(edtValue)*2.067834609E-7;
                maxwell=(edtValue)*2.067834609E-7;
                teslasquaremeter=(edtValue)*2.067834609E-15;
                teslasquarcentimeter=(edtValue)*2.067834609E-11;
                gaussquaremeter=(edtValue)*2.067834609E-7;
                magneticfluxquantum=(edtValue)*1;

                break;

        }
        results.setWeber(weber);
        results.setMiliweber(miliweber);
        results.setMicroweber(microweber);
        results.setVoltsecond(voltsecond);
        results.setUnitpole(unitpole);
        results.setMegaline(megaline);
        results.setKiloline(kiloline);
        results.setLine(line);
        results.setMaxwell(maxwell);
        results.setTeslasquaremeter(teslasquaremeter);
        results.setTeslasquarcentimeter(teslasquarcentimeter);
        results.setGaussquaremeter(gaussquaremeter);
        results.setMagneticfluxquantum(magneticfluxquantum);

        converterArray.add(results);
        return converterArray;
    }
    public class ConversionResults{
        private double weber,miliweber,microweber,voltsecond,unitpole,megaline,kiloline,line,maxwell,teslasquaremeter,teslasquarcentimeter,gaussquaremeter,magneticfluxquantum;

        public double getKiloline() {
            return kiloline;
        }

        public void setKiloline(double kiloline) {
            this.kiloline = kiloline;
        }

        public double getWeber() {
            return weber;
        }

        public void setWeber(double weber) {
            this.weber = weber;
        }

        public double getMiliweber() {
            return miliweber;
        }

        public void setMiliweber(double miliweber) {
            this.miliweber = miliweber;
        }

        public double getMicroweber() {
            return microweber;
        }

        public void setMicroweber(double microweber) {
            this.microweber = microweber;
        }

        public double getVoltsecond() {
            return voltsecond;
        }

        public void setVoltsecond(double voltsecond) {
            this.voltsecond = voltsecond;
        }

        public double getUnitpole() {
            return unitpole;
        }

        public void setUnitpole(double unitpole) {
            this.unitpole = unitpole;
        }

        public double getMegaline() {
            return megaline;
        }

        public void setMegaline(double megaline) {
            this.megaline = megaline;
        }

        public double getKiolline() {
            return kiloline;
        }

        public void setKiolline(double kiolline) {
            this.kiloline = kiolline;
        }

        public double getLine() {
            return line;
        }

        public void setLine(double line) {
            this.line = line;
        }

        public double getMaxwell() {
            return maxwell;
        }

        public void setMaxwell(double maxwell) {
            this.maxwell = maxwell;
        }

        public double getTeslasquaremeter() {
            return teslasquaremeter;
        }

        public void setTeslasquaremeter(double teslasquaremeter) {
            this.teslasquaremeter = teslasquaremeter;
        }

        public double getTeslasquarcentimeter() {
            return teslasquarcentimeter;
        }

        public void setTeslasquarcentimeter(double teslasquarcentimeter) {
            this.teslasquarcentimeter = teslasquarcentimeter;
        }

        public double getGaussquaremeter() {
            return gaussquaremeter;
        }

        public void setGaussquaremeter(double gaussquaremeter) {
            this.gaussquaremeter = gaussquaremeter;
        }

        public double getMagneticfluxquantum() {
            return magneticfluxquantum;
        }

        public void setMagneticfluxquantum(double magneticfluxquantum) {
            this.magneticfluxquantum = magneticfluxquantum;
        }







    }


}
