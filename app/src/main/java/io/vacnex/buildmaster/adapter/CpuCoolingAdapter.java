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
import io.vacnex.buildmaster.model.CPUCooling;

public class CpuCoolingAdapter extends RecyclerView.Adapter<CpuCoolingAdapter.ViewHolder>{

    private final List<CPUCooling> mCpuCool;
    private Context mContext;

    public CpuCoolingAdapter(Context c, List<CPUCooling> cpucool) {
        this.mContext = c;
        this.mCpuCool = cpucool;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtCpucoolItemName,txtCpucoolItemMatblock,txtCpucoolItemMatRad,txtCpucoolItemRadsize,txtCpucoolItemSocket,txtCpucoolItemPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtCpucoolItemName = itemView.findViewById(R.id.txtCpucoolItemName);
            txtCpucoolItemMatblock = itemView.findViewById(R.id.txtCpucoolItemMatblock);
            txtCpucoolItemMatRad = itemView.findViewById(R.id.txtCpucoolItemMatRad);
            txtCpucoolItemRadsize = itemView.findViewById(R.id.txtCpucoolItemRadsize);
            txtCpucoolItemSocket = itemView.findViewById(R.id.txtCpucoolItemSocket);
            txtCpucoolItemPrice = itemView.findViewById(R.id.txtCpucoolItemPrice);
        }
    }


    @NonNull
    @Override
    public CpuCoolingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.cpucool_item_part, parent, false);
        return new CpuCoolingAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CpuCoolingAdapter.ViewHolder holder, int position) {
        final CPUCooling cpucool = mCpuCool.get(position);

        holder.txtCpucoolItemName.setText(cpucool.getmName());
        holder.txtCpucoolItemPrice.setText((mContext.getResources().getString(R.string.part_price) + cpucool.getmPrice()));
        holder.txtCpucoolItemMatblock.setText((mContext.getResources().getString(R.string.cpuc_matblock) + cpucool.getmMatBlock()));
        holder.txtCpucoolItemMatRad.setText((mContext.getResources().getString(R.string.cpuc_matrad) + cpucool.getmMatRad()));
        holder.txtCpucoolItemRadsize.setText((mContext.getResources().getString(R.string.cpuc_radsize) + cpucool.getmRadSize()));
        holder.txtCpucoolItemSocket.setText((mContext.getResources().getString(R.string.cpuc_socket) + cpucool.getmSocketSP()));

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
        return mCpuCool.size();
    }


}
