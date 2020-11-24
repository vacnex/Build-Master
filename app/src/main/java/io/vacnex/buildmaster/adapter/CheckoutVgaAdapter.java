package io.vacnex.buildmaster.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

import io.vacnex.buildmaster.model.Vga;

public class CheckoutVgaAdapter extends BaseAdapter {
    final ArrayList<Vga> listVga;

    CheckoutVgaAdapter(ArrayList<Vga> listVga) {
        this.listVga = listVga;
    }

    @Override
    public int getCount() {
        return listVga.size();
    }

    @Override
    public Object getItem(int position) {
        return listVga.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
