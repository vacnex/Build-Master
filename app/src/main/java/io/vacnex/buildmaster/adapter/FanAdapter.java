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
import io.vacnex.buildmaster.model.Fan;

public class FanAdapter extends RecyclerView.Adapter<FanAdapter.ViewHolder> {

    private final List<Fan> mFan;
    private Context mContext;

    public FanAdapter(Context c, List<Fan> fan) {
        this.mContext = c;
        this.mFan = fan;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtFanItemName,txtFanItemDb,txtFanItemType,txtFanItemRpm,txtFanItemSize,txtFanItemPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtFanItemName = itemView.findViewById(R.id.txtFanItemName);
            txtFanItemDb = itemView.findViewById(R.id.txtFanItemDb);
            txtFanItemType = itemView.findViewById(R.id.txtFanItemType);
            txtFanItemRpm = itemView.findViewById(R.id.txtFanItemRpm);
            txtFanItemSize = itemView.findViewById(R.id.txtFanItemSize);
            txtFanItemPrice = itemView.findViewById(R.id.txtFanItemPrice);
        }
    }
    @NonNull
    @Override
    public FanAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.fan_item_part, parent, false);
        return new FanAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FanAdapter.ViewHolder holder, int position) {
        final Fan fan = mFan.get(position);

        holder.txtFanItemName.setText(fan.getmName());
        holder.txtFanItemDb.setText((mContext.getResources().getString(R.string.fan_db) + fan.getmDB()));
        holder.txtFanItemType.setText((mContext.getResources().getString(R.string.fan_type) + fan.getmType()));
        holder.txtFanItemRpm.setText((mContext.getResources().getString(R.string.fan_rpm) + fan.getmRPM()));
        holder.txtFanItemSize.setText((mContext.getResources().getString(R.string.fan_size) + fan.getmSize()));
        holder.txtFanItemPrice.setText((mContext.getResources().getString(R.string.part_price) + fan.getmPrice()));
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
        return mFan.size();
    }
}
