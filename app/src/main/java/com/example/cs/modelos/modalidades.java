package com.example.cs.modelos;

import android.content.Context;
import android.content.res.Resources;

import java.text.SimpleDateFormat;

public class modalidades {
    // Datos del modalidad
    protected modalidad[] cas_modalidades;

    public modalidades() {
        super();
    }

    public modalidades(modalidad[] v4) {
        super();
        this.cas_modalidades = v4;
    }

    public modalidad[] getModalidades() {
        return cas_modalidades;
    }

    public void setModalidades(modalidad[] cas_modalidades) {
        this.cas_modalidades = cas_modalidades;
    }

    private void cargarMmodalidades(Context context) {
        Resources res = null;
        String[] r = null;
        modalidad[] mo = null;
        modalidad m = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        for (int i = 0; i < 3; i++) {
            r = res.getStringArray(res.getIdentifier("R.array.m_" + "i", "array", context.getPackageName()));
            try {
                m = new modalidad(Integer.parseInt(r[0]),String.valueOf(r[1]));
                mo[i] = m;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        cas_modalidades = mo;
    }}
