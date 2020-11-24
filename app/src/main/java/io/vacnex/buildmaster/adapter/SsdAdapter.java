package io.vacnex.buildmaster.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import io.vacnex.buildmaster.Pc_part_screen;
import io.vacnex.buildmaster.R;
import io.vacnex.buildmaster.model.SSD;
import io.vacnex.buildmaster.model.Vga;

public class SsdAdapter extends RecyclerView.Adapter<SsdAdapter.ViewHolder> {
    private final List<SSD> mSsd;
    private Context mContext;

    public SsdAdapter(Context c, List<SSD> ssd) {
        this.mContext = c;
        this.mSsd = ssd;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtSsdItemName,txtSsdItemType,txtSsdItemSize,txtSsdItemWrite,txtSsdItemRead,txtSsdItemPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtSsdItemName = itemView.findViewById(R.id.txtSsdItemName);
            txtSsdItemType = itemView.findViewById(R.id.txtSsdItemType);
            txtSsdItemSize = itemView.findViewById(R.id.txtSsdItemSize);
            txtSsdItemWrite = itemView.findViewById(R.id.txtSsdItemWrite);
            txtSsdItemRead = itemView.findViewById(R.id.txtSsdItemRead);
            txtSsdItemPrice = itemView.findViewById(R.id.txtSsdItemPrice);
        }
    }

    @NonNull
    @Override
    public SsdAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.ssd_item_part, parent, false);
        return new SsdAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SsdAdapter.ViewHolder holder, int position) {
        final SSD ssd = mSsd.get(position);

        holder.txtSsdItemName.setText(ssd.getmName());
        holder.txtSsdItemPrice.setText((mContext.getResources().getString(R.string.part_price) + ssd.getMprice()));
        holder.txtSsdItemType.setText((mContext.getResources().getString(R.string.ssd_type) + ssd.getmType()));
        holder.txtSsdItemSize.setText((mContext.getResources().getString(R.string.ssd_size) + ssd.getmSize()));
        holder.txtSsdItemWrite.setText((mContext.getResources().getString(R.string.ssd_write) + ssd.getmWrite()));
        holder.txtSsdItemRead.setText((mContext.getResources().getString(R.string.ssd_read) + ssd.getmRead()));
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
        return mSsd.size();
    }

}
