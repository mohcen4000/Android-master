package com.uc2.dzprostatecare.AAChartCoreLib.AAOptionsModel;

public class AALabel {
    public String text;
    public Object style;

    public AALabel text(String prop) {
        text = prop;
        return this;
    }

    public AALabel style(Object prop) {
        style = prop;
        return this;
    }
}