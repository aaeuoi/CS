package com.example.cs.fragmentos;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.cs.modelos.curso;
import com.example.cs.modelos.cursos;

import java.util.ArrayList;
import java.util.List;

/**
 * @author aaeu.oi
 * @since 26-03-2019
 *
 * Es el marco que va proporcinando fotos al GaleriaFragement, almacennado para ello
 * la referencia a la colección de imágenes relativa al punto de interés en curso.
 * Emplea la clase FotoFragmentDeatil, para propicionar las vistas que se rendrizan en la Galeria
 */

public class FragmentAdapter extends FragmentPagerAdapter {

    private cursos array_cursos_actual ;
    public curso[] array_curso_actual ;

    List<Fragment> fragmentos;
    public FragmentAdapter(FragmentManager fm) {
        super(fm);
        fragmentos = new ArrayList();
    }

    public void agregarFragmentos(Fragment xfragmento){
        fragmentos.add(xfragmento);
    }


    @Override
    public Fragment getItem(int position) {
        return fragmentos.get(position);
    }

    @Override
    public int getCount() {
        return fragmentos.size();
    }


    public void setCursos()
    {
        array_cursos_actual.setCursos();
        array_curso_actual = array_cursos_actual.getCurso();
    }
/*
    @Override
    public Fragment getItem(int i) {
        CursosDetailFragment fragment = null;
        Bundle bundle = null;

        fragment = new CursosDetailFragment();
        bundle = new Bundle();

        bundle.putString("N_CURSO",  array_curso_actual[i].getNombre());//al fragment le damos un tag, que valdrá a la postre para la id del la foto en curso
        fragment.setArguments(bundle);


        return fragment;
    }
*/
}
