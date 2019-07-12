package com.example.cs.fragmentos;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.cs.R;
import com.example.cs.modelos.curso;

import java.util.ArrayList;


/**
 *
 * @author vale
 * @since  2-8-2018
 *
 * Clase que infla cada vista (foto), para que sea usada por el FragmentAdaptarFotos
 */
public class InfoDetailFragment extends Fragment {

    private int id_drawable;
    private ArrayList<curso> cursos_drawable = new ArrayList<curso>();
    //        private static final String ARG_IMAGE = "imagen";
//        private int imagen;
    private static final String ARG_AREA = "area";
    private String area;
    private static final String ARG_CAT = "categoria";
    private String categoria;
    private static final String ARG_SUBCAT = "subcategoria";
    private String subcategoria;
    private static final String ARG_SKU = "sku";
    private String sku;
    private static final String ARG_NOMBRE = "nombre";
    private String nombre;
    private static final String ARG_DUR = "duracion";
    private String duracion;
    private static final String ARG_INI = "inicio";
    private String inicio;
    private static final String ARG_FORMATO = "formato";
    private String formato;
    private static final String ARG_IDIOMA = "idioma";
    private String idioma;
    private static final String ARG_MOD = "modalidad";
    private String modalidad;
    private static final String ARG_FAB = "fabricante";
    private String fabricante;
    private static final String ARG_NIVEL = "nivel";
    private String nivel;
    private static final String ARG_OFICIAL = "oficial";
    private String oficial;
    private static final String ARG_DOC = "documentacion";
    private String documentacion;
    private static final String ARG_DESC = "descripcion";
    private String descripcion;
    private static final String ARG_OBJ = "objetivos";
    private String objetivos;
    private static final String ARG_AUD = "audiencia";
    private String audiencia;
    private static final String ARG_CON = "contenidos";
    private String contenidos;
    private static final String ARG_IMA = "image";
    private String image;
    private static final String ARG_PDF = "pdf";
    private String pdf;
    private static final String ARG_DEST = "destacado";
    private String destacado;

    public static InfoDetailFragment newInstance(String area, String cat, String subc, String sku,
                                                 String nombre, String dur, String ini,
                                                 String formato, String idioma, String mod,
                                                 String fab, String nivel, String ofi, String doc,
                                                 String desc, String obj, String aud, String con,
                                                 String img, String pdf, String dest) {
        InfoDetailFragment fragment = new InfoDetailFragment();
        Bundle args = new Bundle();
//            args.putInt(ARG_IMAGE, imagen);
        args.putString(ARG_AREA, area);
        args.putString(ARG_CAT, cat);
        args.putString(ARG_SUBCAT, subc);
        args.putString(ARG_SKU, nombre);
        args.putString(ARG_NOMBRE, nombre);
        args.putString(ARG_DUR, dur);
        args.putString(ARG_INI, ini);
        args.putString(ARG_FORMATO, formato);
        args.putString(ARG_IDIOMA, idioma);
        args.putString(ARG_MOD, mod);
        args.putString(ARG_FAB, fab);
        args.putString(ARG_NIVEL, nivel);
        args.putString(ARG_OFICIAL, ofi);
        args.putString(ARG_DOC, doc);
        args.putString(ARG_DESC, desc);
        args.putString(ARG_OBJ, obj);
        args.putString(ARG_AUD, aud);
        args.putString(ARG_CON, con);
        args.putString(ARG_IMA, img);
        args.putString(ARG_PDF, pdf);
        args.putString(ARG_DEST, dest);
        fragment.setArguments(args);
        fragment.setRetainInstance(true);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null) {
//                imagen = getArguments().getInt(ARG_IMAGE);
            area = getArguments().getString(ARG_AREA);
            categoria = getArguments().getString(ARG_CAT);
            subcategoria = getArguments().getString(ARG_SUBCAT);
            sku = getArguments().getString(ARG_SKU);
            nombre = getArguments().getString(ARG_NOMBRE);
            duracion = getArguments().getString(ARG_DUR);
            inicio = getArguments().getString(ARG_INI);
            formato = getArguments().getString(ARG_FORMATO);
            idioma = getArguments().getString(ARG_IDIOMA);
            modalidad = getArguments().getString(ARG_MOD);
            fabricante = getArguments().getString(ARG_FAB);
            nivel = getArguments().getString(ARG_NIVEL);
            oficial = getArguments().getString(ARG_OFICIAL);
            documentacion = getArguments().getString(ARG_DOC);
            descripcion = getArguments().getString(ARG_DESC);
            objetivos = getArguments().getString(ARG_OBJ);
            audiencia = getArguments().getString(ARG_AUD);
            contenidos = getArguments().getString(ARG_CON);
            image = getArguments().getString(ARG_IMA);
            pdf = getArguments().getString(ARG_PDF);
            destacado = getArguments().getString(ARG_DEST);
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

    public InfoDetailFragment() {
        // constructor por defecto, requerido
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

//        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_destacados, container, false);
        View rootView = null;

        try {
            rootView = (View) inflater.inflate(R.layout.fragment_info, container, false);

//            ImageView imagenView = (ImageView) rootView.findViewById(R.id.imageView1);
//            imagenView.setImageResource(imagen);
            TextView textView0 =  rootView.findViewById(R.id.detalles_area);
            textView0.setText(area);
            TextView textView1 =  rootView.findViewById(R.id.detalles_categoria);
            textView1.setText(categoria);
            TextView textView2 =  rootView.findViewById(R.id.detalles_subcategoria);
            textView2.setText(subcategoria);
            TextView textView3 =  rootView.findViewById(R.id.detalles_sku);
            textView3.setText(sku);
            TextView textView4 =  rootView.findViewById(R.id.detalles_nombre);
            textView4.setText(nombre);
            TextView textView5 =  rootView.findViewById(R.id.detalles_duracion);
            textView5.setText(duracion);
            TextView textView6 =  rootView.findViewById(R.id.detalles_inicio);
            textView6.setText(inicio);
            TextView textView7 =  rootView.findViewById(R.id.detalles_formato);
            textView7.setText(formato);
            TextView textView8 =  rootView.findViewById(R.id.detalles_idioma);
            textView8.setText(idioma);
            TextView textView9 =  rootView.findViewById(R.id.detalles_modalidad);
            textView9.setText(modalidad);
            TextView textView10 =  rootView.findViewById(R.id.detalles_fabricante);
            textView10.setText(fabricante);
            TextView textView11 =  rootView.findViewById(R.id.detalles_nivel);
            textView11.setText(nivel);
            TextView textView12 =  rootView.findViewById(R.id.detalles_oficial);
            textView12.setText(oficial);
            TextView textView13 =  rootView.findViewById(R.id.detalles_documentacion);
            textView13.setText(documentacion);
            TextView textView14 =  rootView.findViewById(R.id.detalles_descripcion);
            textView14.setText(descripcion);
            TextView textView15 =  rootView.findViewById(R.id.detalles_objetivos);
            textView15.setText(objetivos);
            TextView textView16 =  rootView.findViewById(R.id.detalles_audiencia);
            textView16.setText(audiencia);
            TextView textView17 =  rootView.findViewById(R.id.detalles_contenidos);
            textView17.setText(contenidos);
            TextView textView18 =  rootView.findViewById(R.id.detalles_image);
            textView18.setText(image);
            TextView textView19 =  rootView.findViewById(R.id.detalles_pdf);
            textView19.setText(pdf);
            TextView textView20 =  rootView.findViewById(R.id.detalles_destacado);
            textView20.setText(destacado);
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
