package com.example.cs.modelos;

import android.content.Context;
import android.content.res.Resources;

public class subcategorias {
    // Datos del subcategorias
    protected subcategoria[] cas_subcategorias;

    public subcategorias() {
        super();
    }

    public subcategorias(subcategoria[] v4) {
        super();
        this.cas_subcategorias = v4;
    }

    public subcategoria[] getSubcategorias() {
        return cas_subcategorias;
    }

    public void setSubcategorias(subcategoria[] cas_subcategorias) {
        this.cas_subcategorias = cas_subcategorias;
    }

    private void cargarSubcategorias(Context context) {
        Resources res = null;
        String[] r = null;
        subcategoria[] sca = null;
        subcategoria sc = null;
        for (int i = 0; i < 14; i++) {
            r = res.getStringArray(res.getIdentifier("R.array.sca_" + "i", "array", context.getPackageName()));
            try {
                sc = new subcategoria(Integer.parseInt(r[0]),String.valueOf(r[1]),Integer.parseInt(r[2]));
                sca[i] = sc;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        cas_subcategorias = sca;
    }
}