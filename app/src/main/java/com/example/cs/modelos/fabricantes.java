package com.example.cs.modelos;

import android.content.Context;
import android.content.res.Resources;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class fabricantes {
    // Datos del fabricante
    // Datos del fabricante
    protected fabricante[] cas_fabricantes;

    public fabricantes() {
        super();
    }

    public fabricantes(fabricante[] v4) {
        super();
        this.cas_fabricantes = v4;
    }

    public fabricante[] getCursos() {
        return cas_fabricantes;
    }

    public void setCursos(fabricante[] cas_fabricantes) {
        this.cas_fabricantes = cas_fabricantes;
    }

    private void cargarCursos(Context context) {
        Resources res = null;
        String[] r = null;
        fabricante[] fa = null;
        fabricante f = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        for (int i = 0; i < 11; i++) {
            r = res.getStringArray(res.getIdentifier("R.array.f_" + "i", "array", context.getPackageName()));
            try {
                f = new fabricante(Integer.parseInt(r[0]),String.valueOf(r[1]));
                fa[i] = f;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        cas_fabricantes = fa;
    }}
