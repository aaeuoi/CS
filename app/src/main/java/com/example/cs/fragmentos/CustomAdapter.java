package com.example.cs.fragmentos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.cs.R;
import com.example.cs.actividades.CursosActivity;
import com.example.cs.modelos.cursodetallado;

import java.util.ArrayList;

/**
 * @author aaeu.oi
 * <p>
 * @since 15-07-2019
 */

public class CustomAdapter extends BaseAdapter {
    private Context context;


    public CustomAdapter(Context context, ArrayList sugerencias) {

        this.context = context;
    }

    @Override
    public int getViewTypeCount() {
        return getCount();
    }
    @Override
    public int getItemViewType(int position) {

        return position;
    }

    @Override
    public int getCount() {
        return CursosActivity.arrayCursodetalladoView.size();
    }

    @Override
    public Object getItem(int position) {
        return CursosActivity.arrayCursodetalladoView.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder(); LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.lv_item, null, true);


            holder.tvFruit = (TextView) convertView.findViewById(R.id.animal);
            holder.tvnumber = (TextView) convertView.findViewById(R.id.number);
            holder.btn_plus = (Button) convertView.findViewById(R.id.plus);
            holder.btn_minus = (Button) convertView.findViewById(R.id.minus);

            convertView.setTag(holder);
        }else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = (ViewHolder)convertView.getTag();
        }
/*
        holder.tvFruit.setText(CursosActivity.arrayCursodetalladoView.get(position).getDescripcion());
        holder.tvnumber.setText(String.valueOf(CursosActivity.arrayCursodetalladoView.get(position).getNombre()));


        holder.btn_plus.setTag(R.integer.btn_plus_view, convertView);
        holder.btn_plus.setTag(R.integer.btn_plus_pos, position);
        holder.btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View tempview = (View) holder.btn_plus.getTag(R.integer.btn_plus_view);
                TextView tv = (TextView) tempview.findViewById(R.id.number);
                Integer pos = (Integer) holder.btn_plus.getTag(R.integer.btn_plus_pos);

                int number = Integer.parseInt(tv.getText().toString()) + 1;
                tv.setText(String.valueOf(number));

                CursosActivity.arrayCursodetalladoView.get(pos).setNombre(number);

            }*/
        return convertView;
    }

    private class ViewHolder {

        protected Button btn_plus, btn_minus;
        private TextView tvFruit, tvnumber;

    }}
