package io.vacnex.buildmaster.Dialog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
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
import io.vacnex.buildmaster.adapter.CpuAdapter;
import io.vacnex.buildmaster.model.CPU;

public class Dialog_cpu extends AppCompatActivity {
    RecyclerView rvDialogCpu;
    CpuAdapter cpuAdapter;
    List<CPU> _cpu = new ArrayList<>();
    Intent i;
    List<CPU> amdCpus = new ArrayList<>();
    List<CPU> IntelCpus = new ArrayList<>();
    EditText svCPU;
    List<CPU> mCpuAll = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_cpu);
        Context context = this;
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        Init();
        Searchrv();
        RecyclerviewItemClick(context);
    }
    //region Init control func
    private void Init(){
        rvDialogCpu = findViewById(R.id.rvDialogCpu);
        svCPU = findViewById(R.id.svCPU);
        i = getIntent();
        if (i.getSerializableExtra("dialog_cpu") == null)
        {
            amdCpus = (List<CPU>) i.getSerializableExtra("dialog_amd_cpu");
        } else {
            IntelCpus = (List<CPU>) i.getSerializableExtra("dialog_cpu");
        }
        InitCpuList();
    }
    //endregion
    //region Init cpu list
    private void InitCpuList() {
        if (IntelCpus.size() >0){
            for (int i = 0; i < IntelCpus.size(); i++) {
                _cpu.add(IntelCpus.get(i));
            }
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            cpuAdapter = new CpuAdapter(this,_cpu);
            rvDialogCpu.setAdapter(cpuAdapter);
            rvDialogCpu.setLayoutManager(linearLayoutManager);
        }
        else{
            for (int i = 0; i < amdCpus.size(); i++) {
                _cpu.add(amdCpus.get(i));
            }
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            cpuAdapter = new CpuAdapter(this,_cpu);
            rvDialogCpu.setAdapter(cpuAdapter);
            rvDialogCpu.setLayoutManager(linearLayoutManager);
        }

    }
    //endregion
    //region pass item data to previous activity func and handle item click func for pass data
    private void RecyclerviewItemClick(Context context){
        rvDialogCpu.addOnItemTouchListener(
                new RecyclerItemClickListener(context, rvDialogCpu ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View v, int position) {
//                        Log.i("test","item ");
                        CPU clickedCpuItem = _cpu.get(position);
                        if (svCPU.getText().toString().isEmpty()) {
//                            Toast.makeText(v.getContext(), "You clicked " + clickedCpuItem.getmName(), Toast.LENGTH_SHORT).show();
                            i.putExtra("dialog_cpu_name",clickedCpuItem.getmName());
                            setResult(1,i);
                            finish();
                        } else {
                            CPU clickedCpuSearchItem = mCpuAll.get(position);
                            i.putExtra("dialog_cpu_name",clickedCpuSearchItem.getmName());
                            setResult(1,i);
                            finish();
//                            Toast.makeText(v.getContext(), "You clicked " + clickedCpuSearchItem.getmName(), Toast.LENGTH_SHORT).show();
                        }

                    }
                    @Override public void onLongItemClick(View view, int position) {
                    }
                })
        );
    }
    public static class RecyclerItemClickListener implements RecyclerView.OnItemTouchListener {
        private OnItemClickListener mListener;
        public interface OnItemClickListener {
            public void onItemClick(View view, int position);
            public void onLongItemClick(View view, int position);
        }
        GestureDetector mGestureDetector;
        public RecyclerItemClickListener(Context context, final RecyclerView recyclerView, OnItemClickListener listener) {
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
    //region Search func
    private void Searchrv(){
        svCPU.addTextChangedListener(new TextWatcher() {
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
        List<CPU> newList = new ArrayList<>();
            if (text.toString().isEmpty())
            {
                newList.addAll(_cpu);
            }else {
                for (CPU cpuitem: _cpu){
                    if (cpuitem.getmName().toLowerCase().contains(text.toString().toLowerCase())){
                        newList.add(cpuitem);
                    }
                }
            }
        mCpuAll.clear();
        mCpuAll.addAll(newList);
        cpuAdapter = new CpuAdapter(this,mCpuAll);
        rvDialogCpu.setAdapter(cpuAdapter);
        cpuAdapter.notifyDataSetChanged();
    }
    //endregion


}