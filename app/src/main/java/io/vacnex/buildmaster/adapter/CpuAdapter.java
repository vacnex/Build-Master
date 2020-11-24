package io.vacnex.buildmaster.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import io.vacnex.buildmaster.R;
import io.vacnex.buildmaster.model.CPU;


public class CpuAdapter extends RecyclerView.Adapter<CpuAdapter.ViewHolder>{

    private final List<CPU> mCpu;
    private Context mContext;

    public CpuAdapter(Context c, List<CPU> cpu) {
        this.mContext = c;
        this.mCpu = cpu;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtCpuItemName,txtCpuItemCores,txtCpuItemThreads,txtCpuItemCache,txtCpuItemTdp,txtCpuItemPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtCpuItemName = itemView.findViewById(R.id.txtCpuItemName);
            txtCpuItemCores = itemView.findViewById(R.id.txtCpuItemCores);
            txtCpuItemThreads = itemView.findViewById(R.id.txtCpuItemThreads);
            txtCpuItemCache = itemView.findViewById(R.id.txtCpuItemCache);
            txtCpuItemTdp = itemView.findViewById(R.id.txtCpuItemTdp);
            txtCpuItemPrice = itemView.findViewById(R.id.txtCpuItemPrice);
        }
    }


    @NonNull
    @Override
    public CpuAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.cpu_item_part, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CpuAdapter.ViewHolder holder, int position) {
        final CPU cpu = mCpu.get(position);

        holder.txtCpuItemName.setText(cpu.getmName());
        holder.txtCpuItemPrice.setText((mContext.getResources().getString(R.string.part_price) + cpu.getmPrice()));
        holder.txtCpuItemCores.setText((mContext.getResources().getString(R.string.cpu_cores) + cpu.getmNumCores()));
        holder.txtCpuItemThreads.setText((mContext.getResources().getString(R.string.cpu_threads) + cpu.getmNumThreads()));
        holder.txtCpuItemCache.setText((mContext.getResources().getString(R.string.cpu_cache) + cpu.getmCache()));
        holder.txtCpuItemTdp.setText((mContext.getResources().getString(R.string.cpu_tdp) + cpu.getmTdp()));

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
        return mCpu.size();
    }


}