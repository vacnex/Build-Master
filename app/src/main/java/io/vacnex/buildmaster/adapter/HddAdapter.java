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
import io.vacnex.buildmaster.model.HDD;

public class HddAdapter  extends RecyclerView.Adapter<HddAdapter.ViewHolder> {
    private final List<HDD> mHdd;
    private Context mContext;

    public HddAdapter(Context c, List<HDD> hdd) {
        this.mContext = c;
        this.mHdd = hdd;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtHddItemName,txtHddItemType,txtHddItemSize,txtHddItemWrite,txtHddItemRead,txtHddItemPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtHddItemName = itemView.findViewById(R.id.txtHddItemName);
            txtHddItemType = itemView.findViewById(R.id.txtHddItemType);
            txtHddItemSize = itemView.findViewById(R.id.txtHddItemSize);
            txtHddItemWrite = itemView.findViewById(R.id.txtHddItemWrite);
            txtHddItemRead = itemView.findViewById(R.id.txtHddItemRead);
            txtHddItemPrice = itemView.findViewById(R.id.txtHddItemPrice);
        }
    }

    @NonNull
    @Override
    public HddAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.hdd_item_part, parent, false);
        return new HddAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HddAdapter.ViewHolder holder, int position) {
        final HDD hdd = mHdd.get(position);

        holder.txtHddItemName.setText(hdd.getmName());
        holder.txtHddItemPrice.setText((mContext.getResources().getString(R.string.part_price) + hdd.getMprice()));
        holder.txtHddItemType.setText((mContext.getResources().getString(R.string.hdd_type) + hdd.getmType()));
        holder.txtHddItemSize.setText((mContext.getResources().getString(R.string.hdd_size) + hdd.getmSize()));
        holder.txtHddItemWrite.setText((mContext.getResources().getString(R.string.hdd_write) + hdd.getmWrite()));
        holder.txtHddItemRead.setText((mContext.getResources().getString(R.string.hdd_read) + hdd.getmRead()));
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
        return mHdd.size();
    }

}
