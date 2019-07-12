package com.example.cs.modelos;

import android.content.Context;
import android.content.res.Resources;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class convocatorias {
    // Datos del convocatorias
    protected convocatoria[] cas_convocatorias;

    public convocatorias() {
        super();
    }

    public convocatorias(convocatoria[] v4) {
        super();
        this.cas_convocatorias = v4;
    }

    public convocatoria[] getConvocatorias() {
        return cas_convocatorias;
    }

    public void setConvocatorias(convocatoria[] cas_convocatorias) {
        this.cas_convocatorias = cas_convocatorias;
    }

    private void cargarConvocatorias(Context context) {
        Resources res = null;
        String[] r = null;
        convocatoria[] co = null;
        convocatoria c = null;
        Date d = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        for (int i = 0; i < 5; i++) {
            r = res.getStringArray(res.getIdentifier("R.array.des_" + "i", "array", context.getPackageName()));
            try {
                d = format.parse(r[2]);
                c = new convocatoria(Integer.parseInt(r[0]),String.valueOf(r[1]),d,
                        String.valueOf(r[3]), String.valueOf(r[4]), String.valueOf(r[5]));
                co[i] = c;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        cas_convocatorias = co;
    }
}