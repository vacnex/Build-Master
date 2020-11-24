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
import io.vacnex.buildmaster.model.Case;

public class CaseAdapter extends RecyclerView.Adapter<CaseAdapter.ViewHolder> {

    private final List<Case> mCase;
    private Context mContext;

    public CaseAdapter(Context c, List<Case> casee) {
        this.mContext = c;
        this.mCase = casee;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtCaseItemName,txtCaseItemType,txtCaseItemMainSp,txtCaseItemGlass,txtCaseItemSize,txtCaseItemPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtCaseItemName = itemView.findViewById(R.id.txtCaseItemName);
            txtCaseItemType = itemView.findViewById(R.id.txtCaseItemType);
            txtCaseItemMainSp = itemView.findViewById(R.id.txtCaseItemMainSp);
            txtCaseItemGlass = itemView.findViewById(R.id.txtCaseItemGlass);
            txtCaseItemSize = itemView.findViewById(R.id.txtCaseItemSize);
            txtCaseItemPrice = itemView.findViewById(R.id.txtCaseItemPrice);
        }
    }
    @NonNull
    @Override
    public CaseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.case_item_part, parent, false);
        return new CaseAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CaseAdapter.ViewHolder holder, int position) {
        final Case casee = mCase.get(position);

        holder.txtCaseItemName.setText(casee.getmName());
        holder.txtCaseItemType.setText((mContext.getResources().getString(R.string.case_type) + casee.getmType()));
        holder.txtCaseItemMainSp.setText((mContext.getResources().getString(R.string.case_mainsp) + casee.getmMainSP()));
        holder.txtCaseItemGlass.setText((mContext.getResources().getString(R.string.case_glass) + casee.getmGlass()));
        holder.txtCaseItemSize.setText((mContext.getResources().getString(R.string.case_size) + casee.getmSize()));
        holder.txtCaseItemPrice.setText((mContext.getResources().getString(R.string.part_price) + casee.getmPrice()));
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
        return mCase.size();
    }
}
