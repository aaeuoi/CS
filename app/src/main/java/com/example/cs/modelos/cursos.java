package com.example.cs.modelos;

import android.content.Context;
//import android.content.res.Resources;
import android.content.res.Resources;
import android.view.View;

import com.example.cs.R;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.lang.String;

public class cursos {
    // Datos del curso
    protected curso[] cas_cursos;

    public cursos() {
        super();
    }

    public cursos(curso[] v4) {
        super();
        this.cas_cursos = v4;
    }

    public curso[] getCursos(View.OnClickListener onClickListener) {
        return cas_cursos;
    }
    public curso[] getCursos() {
        return cas_cursos;
    }

    public void setCursos(curso[] cas_cursos) {
        this.cas_cursos = cas_cursos;
    }

    public void setCursos() {
        Resources res = null;
        String[] r = null;
        curso[] cu = null;
        curso c = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        for (int i = 0; i < 11; i++) {
//            int identificador = res.getIdentifier("R.array.cu_" + "i", "array", context.getPackageName());
            r = identificador(i,res,r);
            //r = res.getStringArray(R.array.cu_0);
            try {
                c = new curso(Integer.parseInt(r[0]), Integer.parseInt(r[1]), Integer.parseInt(r[2]),
                        String.valueOf(r[3]), String.valueOf(r[4]), Integer.parseInt(r[5]),
                        String.valueOf(r[6]), String.valueOf(r[7]), String.valueOf(r[8])
                        , Integer.parseInt(r[9]), String.valueOf(r[10]), String.valueOf(r[11]),
                        String.valueOf(r[12]), String.valueOf(r[13]), String.valueOf(r[14]),
                        String.valueOf(r[15]), String.valueOf(r[16]), String.valueOf(r[17]),
                        String.valueOf(r[18]), Integer.parseInt(r[19]));
                cu[i] = c;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        cas_cursos = cu;
    }
    private String [] identificador (int i, Resources res, String[] r) {
        switch (i)
        {
            case 0:
                return res.getStringArray(R.array.cu_0);
            case 1:
                return res.getStringArray(R.array.cu_1);
            case 2:
                return res.getStringArray(R.array.cu_2);
            case 3:
                return res.getStringArray(R.array.cu_3);
            case 4:
                return res.getStringArray(R.array.cu_4);
            case 5:
                return res.getStringArray(R.array.cu_5);
            case 6:
                return res.getStringArray(R.array.cu_6);
            case 7:
                return res.getStringArray(R.array.cu_7);
            case 8:
                return res.getStringArray(R.array.cu_8);
            case 9:
                return res.getStringArray(R.array.cu_9);
            case 10:
                return res.getStringArray(R.array.cu_10);
                default:
            break;
        }
        return res.getStringArray(R.array.cu_0);

    }
    public String[] getNombres() {
        String[] nombres = null;
        for (int i=0;i < cas_cursos.length;i++) {
            nombres[i] = cas_cursos[i].getNombre();
        }
        return nombres;
    }
    public curso[] getCurso() {
        curso[] c = null;
        for (int i=0;i < cas_cursos.length;i++) {
            c[i] = cas_cursos[i];
        }
        return c;
    }

}