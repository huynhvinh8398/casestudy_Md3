package com.cg.untils;

import java.text.DecimalFormat;

public class AppUntils {
    public static String doubleToVND(double value) {
        String patternVND = ",###₫";
        DecimalFormat decimalFormat = new DecimalFormat(patternVND);
        return decimalFormat.format(value);
    }
}
