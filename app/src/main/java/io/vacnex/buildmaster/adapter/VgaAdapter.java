package io.vacnex.buildmaster.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import io.vacnex.buildmaster.R;
import io.vacnex.buildmaster.model.Vga;

public class VgaAdapter extends RecyclerView.Adapter<VgaAdapter.ViewHolder> {
    
    private final List<Vga> mVga;
    private Context mContext;

    public VgaAdapter(Context c, List<Vga> vga) {
        this.mContext = c;
        this.mVga = vga;
    }
    
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtVgaItemName,txtVgaItemF,txtVgaItemBF,txtVgaItemVram,txtVgaItemTdp,txtVgaItemPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtVgaItemName = itemView.findViewById(R.id.txtVgaItemName);
            txtVgaItemF = itemView.findViewById(R.id.txtVgaItemF);
            txtVgaItemBF = itemView.findViewById(R.id.txtVgaItemBF);
            txtVgaItemVram = itemView.findViewById(R.id.txtVgaItemVram);
            txtVgaItemTdp = itemView.findViewById(R.id.txtVgaItemTdp);
            txtVgaItemPrice = itemView.findViewById(R.id.txtVgaItemPrice);
        }
    }
    
    @NonNull
    @Override
    public VgaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.vga_item_part, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VgaAdapter.ViewHolder holder, int position) {
        final Vga vga = mVga.get(position);

        holder.txtVgaItemName.setText(vga.getmName());
        holder.txtVgaItemPrice.setText((mContext.getResources().getString(R.string.part_price) + vga.getmPrice()));
        holder.txtVgaItemF.setText((mContext.getResources().getString(R.string.vga_basef) + vga.getmBase()));
        holder.txtVgaItemBF.setText((mContext.getResources().getString(R.string.vga_boostf) + vga.getmBoost()));
        holder.txtVgaItemVram.setText((mContext.getResources().getString(R.string.vga_vram) + vga.getmVram()));
        holder.txtVgaItemTdp.setText((mContext.getResources().getString(R.string.vga_tdp) + vga.getmTDP()));
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public int getItemViewType(int position) {
        return position;
    }
    @Override
    public int getItemCount() {
        return mVga.size();
    }
}
