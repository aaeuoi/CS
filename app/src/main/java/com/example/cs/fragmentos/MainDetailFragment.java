package com.example.cs.fragmentos;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
public class MainDetailFragment extends Fragment {

    private int id_drawable;
    private ArrayList<curso> cursos_drawable = new ArrayList<curso>();
    private static final String ARG_IMAGE = "imagen";
    private int imagen;

    public static MainDetailFragment newInstance(int imagen) {
        MainDetailFragment fragment = new MainDetailFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_IMAGE, imagen);
        fragment.setArguments(args);
        fragment.setRetainInstance(true);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null) {
            imagen = getArguments().getInt(ARG_IMAGE);
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

    public MainDetailFragment() {
        // constructor por defecto, requerido
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

//        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_destacados, container, false);
        View rootView = null;

        try {
            rootView = (View) inflater.inflate(R.layout.fragment_main, container, false);

            ImageView imagenView = rootView.findViewById(R.id.detalles_image);
            imagenView.setImageResource(imagen);
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
