package com.example.gaby.adondevoy;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by GABY on 21/5/2017.
 */

public class CustomAdapter extends BaseAdapter {

    /*  @Override
      public int getCount() {
          return 0;
      }

      @Override
      public Object getItem(int position) {
          return null;
      }

      @Override
      public long getItemId(int position) {
          return 0;
      }

      @Override
      public View getView(int position, View convertView, ViewGroup parent) {
          return null;
      }
  }*/
    private Context context;
    private ArrayList<Lugar> items;

    public CustomAdapter(Activity activity, ArrayList data) {
        this.context = activity;
        this.items = data;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_lista, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Typeface tf_thin = Typeface.createFromAsset(
                context.getAssets(), "fonts/roboto_thin.ttf");

        viewHolder.itemNombre.setTypeface(tf_thin);
        viewHolder.itemTipo.setTypeface(tf_thin);

        Lugar currentItem = (Lugar) getItem(position);
        viewHolder.itemNombre.setText(currentItem.getTitulo());
        viewHolder.itemTipo.setText(currentItem.getContenido());
        viewHolder.itemImagen.setImageResource(currentItem.getImagen());

        return convertView;
    }

    private class ViewHolder {
        TextView itemNombre;
        TextView itemTipo;
        ImageView itemImagen;

        public ViewHolder(View view) {
            itemNombre = (TextView) view.findViewById(R.id.tvTitulo);
            itemTipo = (TextView) view.findViewById(R.id.tvSubtitulo);
            itemImagen = (ImageView) view.findViewById(R.id.ivImagen);
        }
    }
}

