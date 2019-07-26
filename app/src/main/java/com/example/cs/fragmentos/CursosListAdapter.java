package com.example.cs.fragmentos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.cs.R;
import com.example.cs.MainActivity;
import com.example.cs.modelos.cursodetallado;

import java.util.ArrayList;

/**
 * @author aaeu.oi
 * <p>
 * @since 15-07-2019
 */

public class CursosListAdapter extends ArrayAdapter<cursodetallado> {
    private static final String TAG = "CursosListAdapter";
    private Context mContext;
    int mResource;

    public CursosListAdapter(Context context, int resource, ArrayList<cursodetallado> object) {
        super(context, resource, object);
        mContext = context;
        mResource = resource;
    }
    @Override
    public int getViewTypeCount() {
        return getCount();
    }
    @Override
    public int getItemViewType(int position) {

        return position;
    }

    public int getCount(ArrayList<cursodetallado> arrayCursodetallado) {
        return arrayCursodetallado.size();
    }

    public cursodetallado getItem(int position, ArrayList<cursodetallado> arrayCursodetallado) {
        return arrayCursodetallado.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        try {

                String a = getItem(position).getArea();
                String c = getItem(position).getCategoria();
                String s = getItem(position).getSubcategoria();
                String k = getItem(position).getSku();
                String n = getItem(position).getNombre();
                String d = getItem(position).getDuracion();
                String i = getItem(position).getInicio();
                String m = getItem(position).getModalidad();
                String f = getItem(position).getFabricante();
                String p = getItem(position).getDescripcion();
                String o = getItem(position).getObjetivos();
                String t = getItem(position).getContenidos();
                String g = getItem(position).getImage();
                String e = getItem(position).getDestacado();
                cursodetallado cudet = new cursodetallado(a, c, s, k, n, d, i, m, f, p, o, t, g, e);

            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource, parent, false);

                TextView tvA = (TextView) convertView.findViewById(R.id.detalles_area);
                TextView tvC = (TextView) convertView.findViewById(R.id.detalles_categoria);
                TextView tvS = (TextView) convertView.findViewById(R.id.detalles_subcategoria);
//        TextView tvK = (TextView) convertView.findViewById(R.id.detalles_sku);
                TextView tvN = (TextView) convertView.findViewById(R.id.detalles_nombre);
                TextView tvD = (TextView) convertView.findViewById(R.id.detalles_duracion);
                TextView tvI = (TextView) convertView.findViewById(R.id.detalles_inicio);
                TextView tvM = (TextView) convertView.findViewById(R.id.detalles_modalidad);
                TextView tvF = (TextView) convertView.findViewById(R.id.detalles_fabricante);
//        TextView tvP = (TextView) convertView.findViewById(R.id.detalles_descripcion);
//        TextView tvO = (TextView) convertView.findViewById(R.id.detalles_objetivos);
//        TextView tvT = (TextView) convertView.findViewById(R.id.detalles_contenidos);
//        TextView tvG = (TextView) convertView.findViewById(R.id.detalles_image);
                TextView tvE = (TextView) convertView.findViewById(R.id.detalles_destacado);

                tvA.setText(a);
                tvC.setText(c);
                tvS.setText(s);
//        tvK.setText(k);
                tvN.setText(n);
                tvD.setText(d);
                tvI.setText(i);
                tvM.setText(m);
                tvF.setText(f);
        /*
        tvP.setText(p);
        tvO.setText(o);
        tvT.setText(t);
        tvG.setText(g);
        */
                tvE.setText(e);
                /*
                Button btn = convertView.findViewById(R.id.button_ver);
                btn.setFocusable(false);
                btn.setClickable(false);
                */
                return convertView;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
