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
import io.vacnex.buildmaster.model.Ram;


public class RamAdapter extends RecyclerView.Adapter<RamAdapter.ViewHolder> {

    private final List<Ram> mRam;
    private Context mContext;

    public RamAdapter(Context c, List<Ram> ram) {
        this.mContext = c;
        this.mRam = ram;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtRamItemName,txtRamItemType,txtRamIteC,txtVgaItemBuss,txtRamItemSize,txtRamItemPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtRamItemName = itemView.findViewById(R.id.txtRamItemName);
            txtRamItemType = itemView.findViewById(R.id.txtRamItemType);
            txtRamIteC = itemView.findViewById(R.id.txtRamIteC);
            txtVgaItemBuss = itemView.findViewById(R.id.txtVgaItemBuss);
            txtRamItemSize = itemView.findViewById(R.id.txtRamItemSize);
            txtRamItemPrice = itemView.findViewById(R.id.txtRamItemPrice);
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.ram_item_part, parent, false);
        return new RamAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Ram ram = mRam.get(position);

        holder.txtRamItemName.setText(ram.getmName());
        holder.txtRamItemType.setText((mContext.getResources().getString(R.string.ram_type) + ram.getmType()));
        holder.txtRamIteC.setText((mContext.getResources().getString(R.string.ram_coolling) + ram.getmCooling()));
        holder.txtVgaItemBuss.setText((mContext.getResources().getString(R.string.ram_buss) + ram.getmBuss()));
        holder.txtRamItemSize.setText((mContext.getResources().getString(R.string.ram_size) + ram.getmSize()));
        holder.txtRamItemPrice.setText((mContext.getResources().getString(R.string.part_price) + ram.getmPrice()));
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
        return mRam.size();
    }
}
