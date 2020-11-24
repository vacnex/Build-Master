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
import io.vacnex.buildmaster.model.PSU;

public class PsuAdapter extends RecyclerView.Adapter<PsuAdapter.ViewHolder>{

    private final List<PSU> mPsu;
    private Context mContext;

    public PsuAdapter(Context c, List<PSU> psu) {
        this.mContext = c;
        this.mPsu = psu;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtPsuItemName,txtPsuItemIn,txtPsuItemMax,txtPsuItemOut,txtPsuItemStandard,txtPsuItemPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtPsuItemName = itemView.findViewById(R.id.txtPsuItemName);
            txtPsuItemIn = itemView.findViewById(R.id.txtPsuItemIn);
            txtPsuItemMax = itemView.findViewById(R.id.txtPsuItemMax);
            txtPsuItemOut = itemView.findViewById(R.id.txtPsuItemOut);
            txtPsuItemStandard = itemView.findViewById(R.id.txtPsuItemStandard);
            txtPsuItemPrice = itemView.findViewById(R.id.txtPsuItemPrice);
        }
    }


    @NonNull
    @Override
    public PsuAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.psu_item_part, parent, false);
        return new PsuAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PsuAdapter.ViewHolder holder, int position) {
        final PSU psu = mPsu.get(position);

        holder.txtPsuItemName.setText(psu.getmName());
        holder.txtPsuItemPrice.setText((mContext.getResources().getString(R.string.part_price) + psu.getmPrice()));
        holder.txtPsuItemIn.setText((mContext.getResources().getString(R.string.psu_in) + psu.getmIn()));
        holder.txtPsuItemMax.setText((mContext.getResources().getString(R.string.psu_max) + psu.getmMax()));
        holder.txtPsuItemOut.setText((mContext.getResources().getString(R.string.psu_out) + psu.getmOut()));
        holder.txtPsuItemStandard.setText((mContext.getResources().getString(R.string.psu_standard) + psu.getmStandard()));

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
        return mPsu.size();
    }
}
