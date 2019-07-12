package com.example.cs.modelos;

import android.content.Context;
import android.content.res.Resources;

public class categorias {
    // Datos del categorias
    protected categoria[] cas_categorias;

    public categorias() {
        super();
    }

    public categorias(categoria[] v4) {
        super();
        this.cas_categorias = v4;
    }

    public categoria[] getCategorias() {
        return cas_categorias;
    }

    public void setCategorias(categoria[] cas_categorias) {
        this.cas_categorias = cas_categorias;
    }

    private void cargarCategorias(Context context) {
        Resources res = null;
        String[] r = null;
        categoria[] ca = null;
        categoria c = null;
        for (int i = 0; i < 11; i++) {
            r = res.getStringArray(res.getIdentifier("R.array.ca_" + "i", "array", context.getPackageName()));
            try {
                c = new categoria(Integer.parseInt(r[0]),String.valueOf(r[1]),Integer.parseInt(r[2]));
                ca[i] = c;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        cas_categorias = ca;
    }
}