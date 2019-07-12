package com.example.cs.modelos;

import android.content.Context;
import android.content.res.Resources;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class areas {
    // Datos del areas
    protected area[] cas_areas;

    public areas() {
        super();
    }

    public areas(area[] v4) {
        super();
        this.cas_areas = v4;
    }

    public area[] getAreas() {
        return cas_areas;
    }

    public void setAreas(area[] cas_areas) {
        this.cas_areas = cas_areas;
    }

    private void cargarAreas(Context context) {
        Resources res = null;
        String[] r = null;
        area[] ar = null;
        area a = null;
        for (int i = 0; i < 8; i++) {
            r = res.getStringArray(res.getIdentifier("R.array.a_" + "i", "array", context.getPackageName()));
            try {
                a = new area(Integer.parseInt(r[0]),String.valueOf(r[1]));
                ar[i] = a;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        cas_areas = ar;
    }
}