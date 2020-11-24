package io.vacnex.buildmaster.Dialog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import io.vacnex.buildmaster.R;
import io.vacnex.buildmaster.adapter.VgaAdapter;
import io.vacnex.buildmaster.model.Vga;

public class Dialog_vga extends AppCompatActivity {
    RecyclerView rvDialogVga;
    VgaAdapter vgaAdapter;
    EditText svVga;
    List<Vga> _vga = new ArrayList<>();
    List<Vga> mVgaAll = new ArrayList<>();
    Vga[] vgas ;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_vga);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        Context context = this;
        Init();
        Searchrv();
        RecyclerviewItemClick(context);
    }
    //region init vga control func
    private void Init() {
        rvDialogVga = findViewById(R.id.rvDialogVga);
        svVga = findViewById(R.id.svVga);
        i = getIntent();
        vgas = (Vga[]) i.getSerializableExtra("dialog_vga");
        InitVgaList();
    }
    //endregion
    //region init vga list
    private void InitVgaList() {
        for (int i = 0; i < vgas.length; i++) {
            _vga.add(vgas[i]);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        vgaAdapter = new VgaAdapter(this,_vga);
        rvDialogVga.setAdapter(vgaAdapter);
        rvDialogVga.setLayoutManager(linearLayoutManager);
    }
    //endregion
    //region pass item data to previous activity func and handle item click func for pass data
    private void RecyclerviewItemClick(Context context){
        rvDialogVga.addOnItemTouchListener(
                new Dialog_vga.RecyclerItemClickListener(context, rvDialogVga ,new Dialog_vga.RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View v, int position) {
                        Vga clickedVgaItem = _vga.get(position);
//                            Toast.makeText(v.getContext(), "You clicked " + clickedCpuItem.getmName(), Toast.LENGTH_SHORT).show();
                        i.putExtra("dialog_vga_name",clickedVgaItem.getmName());
                        setResult(2,i);
                        finish();
                    }
                    @Override public void onLongItemClick(View view, int position) {
                    }
                })
        );
    }
    public static class RecyclerItemClickListener implements RecyclerView.OnItemTouchListener {
        private Dialog_vga.RecyclerItemClickListener.OnItemClickListener mListener;
        public interface OnItemClickListener {
            public void onItemClick(View view, int position);
            public void onLongItemClick(View view, int position);
        }
        GestureDetector mGestureDetector;
        public RecyclerItemClickListener(Context context, final RecyclerView recyclerView, Dialog_vga.RecyclerItemClickListener.OnItemClickListener listener) {
            mListener = listener;
            mGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }
                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && mListener != null) {
                        mListener.onLongItemClick(child, recyclerView.getChildAdapterPosition(child));
                    }
                }
            });
        }
        @Override public boolean onInterceptTouchEvent(RecyclerView view, MotionEvent e) {
            View childView = view.findChildViewUnder(e.getX(), e.getY());
            if (childView != null && mListener != null && mGestureDetector.onTouchEvent(e)) {
                mListener.onItemClick(childView, view.getChildAdapterPosition(childView));
                return true;
            }
            return false;
        }
        @Override public void onTouchEvent(RecyclerView view, MotionEvent motionEvent) { }
        @Override
        public void onRequestDisallowInterceptTouchEvent (boolean disallowIntercept){}
    }
    //endregion
    //region search func
    private void Searchrv(){
        svVga.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filter(s.toString());
            }
            @Override
            public void afterTextChanged(Editable s) {}
        });
    }
    private void filter(String text) {
        List<Vga> newList = new ArrayList<>();
        if (text.toString().isEmpty())
        {
            newList.addAll(_vga);
        }else {
            for (Vga vgaitem: _vga){
                if (vgaitem.getmName().toLowerCase().contains(text.toString().toLowerCase())){
                    newList.add(vgaitem);
                }
            }
        }
        mVgaAll.clear();
        mVgaAll.addAll(newList);
        vgaAdapter = new VgaAdapter(this,mVgaAll);
        rvDialogVga.setAdapter(vgaAdapter);
        vgaAdapter.notifyDataSetChanged();
    }
    //endregion
}