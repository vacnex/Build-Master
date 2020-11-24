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
import io.vacnex.buildmaster.model.Monitor;

public class MonitorAdapter extends RecyclerView.Adapter<MonitorAdapter.ViewHolder> {

    private final List<Monitor> mMonitor;
    private Context mContext;

    public MonitorAdapter(Context c, List<Monitor> monitor) {
        this.mContext = c;
        this.mMonitor = monitor;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtMonitorItemName,txtMonitorItemPanel,txtMonitorItemHz,txtMonitorItemRatio,txtMonitorItemRes,txtMonitorItemPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtMonitorItemName = itemView.findViewById(R.id.txtMonitorItemName);
            txtMonitorItemPanel = itemView.findViewById(R.id.txtMonitorItemPanel);
            txtMonitorItemHz = itemView.findViewById(R.id.txtMonitorItemHz);
            txtMonitorItemRatio = itemView.findViewById(R.id.txtMonitorItemRatio);
            txtMonitorItemRes = itemView.findViewById(R.id.txtMonitorItemRes);
            txtMonitorItemPrice = itemView.findViewById(R.id.txtMonitorItemPrice);
        }
    }
    @NonNull
    @Override
    public MonitorAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.monitor_item_part, parent, false);
        return new MonitorAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MonitorAdapter.ViewHolder holder, int position) {
        final Monitor monitor = mMonitor.get(position);

        holder.txtMonitorItemName.setText(monitor.getmName());
        holder.txtMonitorItemPanel.setText((mContext.getResources().getString(R.string.mt_panel) + monitor.getmPanel()));
        holder.txtMonitorItemHz.setText((mContext.getResources().getString(R.string.mt_hz) + monitor.getmHz()));
        holder.txtMonitorItemRatio.setText((mContext.getResources().getString(R.string.mt_ratio) + monitor.getmRatio()));
        holder.txtMonitorItemRes.setText((mContext.getResources().getString(R.string.mt_res) + monitor.getmRes()));
        holder.txtMonitorItemPrice.setText((mContext.getResources().getString(R.string.part_price) + monitor.getmPrice()));
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
        return mMonitor.size();
    }
}
