package com.nineinfosys.magnetismconverter.Supporter;

/**
 * Created by AndriodDev5 on 22-04-2017.
 */

public class ItemList {
    private String unitnameshortform;
    private String unitvaluename;
    private String unitname;
    private String unitvalue;

    public ItemList(String unitnameshortform,String unitname,String unitvalue,String unitvaluename) {
        this.unitnameshortform = unitnameshortform;
        this.unitname = unitname;
        this.unitvalue = unitvalue;
        this.unitvaluename = unitvaluename;
    }

    public String getUnitname() {
        return unitname;
    }

    public void setUnitname(String unitname) {
        this.unitname = unitname;
    }

    public String getUnitvalue() {
        return unitvalue;
    }

    public void setUnitvalue(String unitvalue) {
        this.unitvalue = unitvalue;
    }

    public String getUnitnameshortform() {
        return unitnameshortform;
    }

    public void setUnitnameshoertform(String unitnameshortform) {
        this.unitnameshortform = unitnameshortform;
    }

    public String getUnitvaluename() {
        return unitvaluename;
    }

    public void setUnitvaluename(String unitvaluename) {
        this.unitvaluename = unitvaluename;
    }
}

