package com.nineinfosys.magnetismconverter.Supporter;

import java.text.DecimalFormat;

/**
 * Created by AndriodDev5 on 26-04-2017.
 */

public class Settings {

    //Keys for Sharedpreferences
    //This would be the name of our shared preferences
    public static final String SHARED_PREF_NAME = "mydecimalformat";

    //This would be used to store the email of current logged in user
    public static final String Format_Selected_SHARED_PREF = "currentformat";

    //This would be used to store the email of current logged in user
    public static final String Decimal_Place_Selected_SHARED_PREF = "decimalplacescurrentformat";

    //We will use this to store the boolean in sharedpreference to track user is loggedin or not
    public static final String Formatter_SHARED_PREF = "formatter";


    String  FormattedString,DecimalplaceString;
   DecimalFormat formatter = null;

    public Settings(String formattedString, String decimalplaceString) {
        FormattedString = formattedString;
        DecimalplaceString = decimalplaceString;
    }





   public DecimalFormat setting() {
       switch (FormattedString) {
           case "Thousands separator":
               switch (DecimalplaceString) {
                   case "1":
                       formatter = new DecimalFormat("#,###,###.0");
                       break;
                   case "2":
                       formatter = new DecimalFormat("#,###,###.00");
                       break;
                   case "3":
                       formatter = new DecimalFormat("#,###,###.000");
                       break;
                   case "4":
                       formatter = new DecimalFormat("#,###,###.0000");
                       break;
                   case "5":
                       formatter = new DecimalFormat("#,###,###.00000");
                       break;
                   case "6":
                       formatter = new DecimalFormat("#,###,###.000000");
                       break;
                   case "7":
                       formatter = new DecimalFormat("#,###,###.0000000");
                       break;
                   case "8":
                       formatter = new DecimalFormat("#,###,###.00000000");
                       break;
                   case "9":
                       formatter = new DecimalFormat("#,###,###.000000000");
                       break;
                   case "10":
                       formatter = new DecimalFormat("#,###,###.0000000000");
                       break;
               }

               break;
           case "Decimal Format":
               switch (DecimalplaceString) {
                   case "1":
                       formatter = new DecimalFormat("#######.0");
                       break;
                   case "2":
                       formatter = new DecimalFormat("#######.00");
                       break;
                   case "3":
                       formatter = new DecimalFormat("#######.000");
                       break;
                   case "4":
                       formatter = new DecimalFormat("#######.0000");
                       break;
                   case "5":
                       formatter = new DecimalFormat("#######.00000");
                       break;
                   case "6":
                       formatter = new DecimalFormat("#######.000000");
                       break;
                   case "7":
                       formatter = new DecimalFormat("#######.0000000");
                       break;
                   case "8":
                       formatter = new DecimalFormat("#######.00000000");
                       break;
                   case "9":
                       formatter = new DecimalFormat("#######.000000000");
                       break;
                   case "10":
                       formatter = new DecimalFormat("#######.0000000000");
                       break;
               }

               break;
           case "Exponential Format":
               switch (DecimalplaceString) {
                   case "1":
                        formatter = new DecimalFormat("0.##E0");
                       break;
                   case "2":
                       formatter = new DecimalFormat("0.##E0");
                       break;
                   case "3":
                       formatter = new DecimalFormat("0.##E0");
                       break;
                   case "4":
                       formatter = new DecimalFormat("0.##E0");
                       break;
                   case "5":
                       formatter = new DecimalFormat("0.##E0");
                       break;
                   case "6":
                       formatter = new DecimalFormat("0.##E0");
                       break;
                   case "7":
                       formatter = new DecimalFormat("0.##E0");
                       break;
                   case "8":
                       formatter = new DecimalFormat("0.##E0");
                       break;
                   case "9":
                       formatter = new DecimalFormat("0.##E0");
                       break;
                   case "10":
                       formatter = new DecimalFormat("0.##E0");
                       break;
               }


               break;
       }
       return formatter;

   }

}

