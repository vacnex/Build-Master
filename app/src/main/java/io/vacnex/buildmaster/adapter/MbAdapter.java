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
import io.vacnex.buildmaster.model.Mainbroad;
import io.vacnex.buildmaster.model.Vga;

public class MbAdapter extends RecyclerView.Adapter<MbAdapter.ViewHolder> {
    private final List<Mainbroad> mMb;
    private Context mContext;

    public MbAdapter(Context c,List<Mainbroad> mb ) {
        this.mMb = mb;
        this.mContext = c;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtMbItemName,txtMbItemMan,txtMbItemChipset,txtMbItemSocket,txtMbItemFormFactor,txtRamItemPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtMbItemName = itemView.findViewById(R.id.txtMbItemName);
            txtMbItemMan = itemView.findViewById(R.id.txtMbItemMan);
            txtMbItemChipset = itemView.findViewById(R.id.txtMbItemChipset);
            txtMbItemSocket = itemView.findViewById(R.id.txtMbItemSocket);
            txtMbItemFormFactor = itemView.findViewById(R.id.txtMbItemFormFactor);
            txtRamItemPrice = itemView.findViewById(R.id.txtRamItemPrice);
        }
    }
    @NonNull
    @Override
    public MbAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.mb_item_part, parent, false);
        return new MbAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MbAdapter.ViewHolder holder, int position) {
        final Mainbroad mainbroad = mMb.get(position);

        holder.txtMbItemName.setText(mainbroad.getmName());
        holder.txtMbItemMan.setText((mContext.getResources().getString(R.string.mb_man) +"\n"+ mainbroad.getmMan()));
        holder.txtMbItemChipset.setText((mContext.getResources().getString(R.string.mb_chipset) +"\n"+ mainbroad.getmChipset()));
        holder.txtMbItemSocket.setText((mContext.getResources().getString(R.string.mb_socket) +"\n"+ mainbroad.getmSocketm()));
        holder.txtMbItemFormFactor.setText((mContext.getResources().getString(R.string.mb_formfactor) +"\n"+ mainbroad.getmFormFactor()));
        holder.txtRamItemPrice.setText((mContext.getResources().getString(R.string.part_price) + mainbroad.getmPrice()));
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
        return mMb.size();
    }


}
