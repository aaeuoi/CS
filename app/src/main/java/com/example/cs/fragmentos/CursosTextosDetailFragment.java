package com.example.cs.fragmentos;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.cs.R;


/**
 *
 * @author aaeu.oi
 * @since  2019-07-16
 *
 * Clase que infla cada vista (listado), para que sea usada por el FragmentAdaptarFotos
 */

public class CursosTextosDetailFragment extends Fragment {

    //        private static final String ARG_IMAGE = "imagen";
//        private int imagen;
//    private static final String ARG_SKU = "sku";
//    private String sku;
    private static final String ARG_NOMBRE = "nombre";
    private String nombre;
    private static final String ARG_POSICION = "posicion";
    private String posicion;
    private static final String ARG_DE = "de";
    private String de;
    private static final String ARG_POSICION_FIN = "posicion_fin";
    private String posicion_fin;
    private static final String ARG_TITULO = "titulo";
    private String titulo;
    private static final String ARG_TEXTO = "texto";
    private String texto;

    public static CursosTextosDetailFragment newInstance(String nombre,
                                                         String posicion, String de, String posicion_fin,
                                                         String titulo, String texto) {
        CursosTextosDetailFragment fragment = new CursosTextosDetailFragment();
        Bundle args = new Bundle();
//            args.putInt(ARG_IMAGE, imagen);
//        args.putString(ARG_SKU, sku);
        args.putString(ARG_NOMBRE, nombre);
        args.putString(ARG_POSICION, posicion);
        args.putString(ARG_DE, de);
        args.putString(ARG_POSICION, posicion);
        args.putString(ARG_POSICION_FIN, posicion_fin);
        args.putString(ARG_TITULO, titulo);
        args.putString(ARG_TEXTO, texto);
        fragment.setArguments(args);
        fragment.setRetainInstance(true);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null) {
//                imagen = getArguments().getInt(ARG_IMAGE);
//            sku = getArguments().getString(ARG_SKU);
            nombre = getArguments().getString(ARG_NOMBRE);
            posicion = getArguments().getString(ARG_POSICION);
            de = getArguments().getString(ARG_DE);
            posicion_fin = getArguments().getString(ARG_POSICION_FIN);
            titulo = getArguments().getString(ARG_TITULO);
            texto = getArguments().getString(ARG_TEXTO);
        }
    }

    /**
     * @param args contiene la clave con el id de la foto (R.drawable) y es invocado automáticamente por su Adapter
     */
    @Override
    public void setArguments(Bundle args) {
        super.setArguments(args);
//        Log.d(getClass().getCanonicalName(), "SetArgumentsInvocado");
//        cursos_drawable = args.getParcelableArrayList("N_CURSOS");
//        id_drawable = args.getInt("N_FOTO");
    }

    public CursosTextosDetailFragment() {
        // constructor por defecto, requerido
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = null;

        try {
            rootView = (View) inflater.inflate(R.layout.fragment_cursos2, container, false);

//            ImageView imagenView = (ImageView) rootView.findViewById(R.id.imageView1);
//            imagenView.setImageResource(imagen);
            TextView textView0 =  rootView.findViewById(R.id.det_posicion);
            textView0.setText(posicion);
            TextView textView1 =  rootView.findViewById(R.id.det_posicion_fin);
            textView1.setText(posicion_fin);
//            TextView textView2 =  rootView.findViewById(R.id.det_sku);
//            textView2.setText(sku);
            TextView textView3 =  rootView.findViewById(R.id.det_nombre);
            textView3.setText(nombre);
            TextView textView4 =  rootView.findViewById(R.id.det_tit_texto);
            textView4.setText(titulo);
            TextView textView5 =  rootView.findViewById(R.id.det_texto);
            textView5.setText(texto);
            TextView textView6 =  rootView.findViewById(R.id.det_de);
            textView6.setText(de);
/*
            Group imageView = rootView.findViewById(R.id.content);
            Drawable drawable = getResources().getDrawable(this.id_drawable);
            */
//            imageView.setImageDrawable(drawable);

        } catch (Exception e) {
            Log.e("MENSAJE", e.getMessage());
        }


        return rootView;
    }
}
