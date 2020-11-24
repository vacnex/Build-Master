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
import io.vacnex.buildmaster.adapter.HddAdapter;
import io.vacnex.buildmaster.adapter.SsdAdapter;
import io.vacnex.buildmaster.model.HDD;
import io.vacnex.buildmaster.model.SSD;

public class Dialog_hdd extends AppCompatActivity {
    RecyclerView rvDialogHdd;
    HddAdapter hddAdapter;
    EditText svHDD;
    List<HDD> _hdd = new ArrayList<>();
    List<HDD> mHddAll = new ArrayList<>();
    HDD[] hdds ;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_hdd);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        Context context = this;
        Init();
        Searchrv();
        RecyclerviewItemClick(context);
    }
    private void Init() {
        rvDialogHdd = findViewById(R.id.rvDialogHdd);
        svHDD = findViewById(R.id.svHDD);
        i = getIntent();
        hdds = (HDD[]) i.getSerializableExtra("dialog_hdd");
        InitHddList();
    }

    private void InitHddList() {
        for (int i = 0; i < hdds.length; i++) {
            _hdd.add(hdds[i]);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        hddAdapter = new HddAdapter(this,_hdd);
        rvDialogHdd.setAdapter(hddAdapter);
        rvDialogHdd.setLayoutManager(linearLayoutManager);
    }

    private void RecyclerviewItemClick(Context context) {
        rvDialogHdd.addOnItemTouchListener(
                new Dialog_hdd.RecyclerItemClickListener(context, rvDialogHdd ,new Dialog_hdd.RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View v, int position) {
                        HDD clickedhddItem = _hdd.get(position);
//                            Toast.makeText(v.getContext(), "You clicked " + clickedCpuItem.getmName(), Toast.LENGTH_SHORT).show();
                        i.putExtra("dialog_hdd_name",clickedhddItem.getmName());
                        setResult(6,i);
                        finish();
                    }
                    @Override public void onLongItemClick(View view, int position) {
                    }
                })
        );
    }
    public static class RecyclerItemClickListener implements RecyclerView.OnItemTouchListener {
        private Dialog_hdd.RecyclerItemClickListener.OnItemClickListener mListener;
        public interface OnItemClickListener {
            public void onItemClick(View view, int position);
            public void onLongItemClick(View view, int position);
        }
        GestureDetector mGestureDetector;
        public RecyclerItemClickListener(Context context, final RecyclerView recyclerView, Dialog_hdd.RecyclerItemClickListener.OnItemClickListener listener) {
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

    private void Searchrv(){
        svHDD.addTextChangedListener(new TextWatcher() {
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
        List<HDD> newList = new ArrayList<>();
        if (text.toString().isEmpty())
        {
            newList.addAll(_hdd);
        }else {
            for (HDD hdditem: _hdd){
                if (hdditem.getmName().toLowerCase().contains(text.toString().toLowerCase())){
                    newList.add(hdditem);
                }
            }
        }
        mHddAll.clear();
        mHddAll.addAll(newList);
        hddAdapter = new HddAdapter(this,mHddAll);
        rvDialogHdd.setAdapter(hddAdapter);
        hddAdapter.notifyDataSetChanged();
    }
}