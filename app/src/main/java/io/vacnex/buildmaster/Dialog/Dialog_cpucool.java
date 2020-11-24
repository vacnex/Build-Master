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
import io.vacnex.buildmaster.adapter.CpuCoolingAdapter;
import io.vacnex.buildmaster.model.CPUCooling;

public class Dialog_cpucool extends AppCompatActivity {
    RecyclerView rvDialogCpuCool;
    CpuCoolingAdapter cpuCoolingAdapter;
    EditText svCPUCool;
    List<CPUCooling> _cpucool = new ArrayList<>();
    List<CPUCooling> mCpuCoolAll = new ArrayList<>();
    CPUCooling[] cpucoolings ;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_cpucool);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        Context context = this;
        Init();
        Searchrv();
        RecyclerviewItemClick(context);
    }
    private void Init() {
        rvDialogCpuCool = findViewById(R.id.rvDialogCpuCool);
        svCPUCool = findViewById(R.id.svCPUCool);
        i = getIntent();
        cpucoolings = (CPUCooling[]) i.getSerializableExtra("dialog_cpucool");
        InitCpuCoolList();
    }

    private void InitCpuCoolList() {
        for (int i = 0; i < cpucoolings.length; i++) {
            _cpucool.add(cpucoolings[i]);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        cpuCoolingAdapter = new CpuCoolingAdapter(this,_cpucool);
        rvDialogCpuCool.setAdapter(cpuCoolingAdapter);
        rvDialogCpuCool.setLayoutManager(linearLayoutManager);
    }
    private void RecyclerviewItemClick(Context context){
        rvDialogCpuCool.addOnItemTouchListener(
                new Dialog_cpucool.RecyclerItemClickListener(context, rvDialogCpuCool ,new Dialog_cpucool.RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View v, int position) {
                        CPUCooling clickedCpuCoolItem = _cpucool.get(position);
//                            Toast.makeText(v.getContext(), "You clicked " + clickedCpuItem.getmName(), Toast.LENGTH_SHORT).show();
                        i.putExtra("dialog_cpucool_name",clickedCpuCoolItem.getmName());
                        setResult(8,i);
                        finish();
                    }
                    @Override public void onLongItemClick(View view, int position) {
                    }
                })
        );
    }
    public static class RecyclerItemClickListener implements RecyclerView.OnItemTouchListener {
        private Dialog_cpucool.RecyclerItemClickListener.OnItemClickListener mListener;
        public interface OnItemClickListener {
            public void onItemClick(View view, int position);
            public void onLongItemClick(View view, int position);
        }
        GestureDetector mGestureDetector;
        public RecyclerItemClickListener(Context context, final RecyclerView recyclerView, Dialog_cpucool.RecyclerItemClickListener.OnItemClickListener listener) {
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
        svCPUCool.addTextChangedListener(new TextWatcher() {
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
        List<CPUCooling> newList = new ArrayList<>();
        if (text.toString().isEmpty())
        {
            newList.addAll(_cpucool);
        }else {
            for (CPUCooling cpucoolitem: _cpucool){
                if (cpucoolitem.getmName().toLowerCase().contains(text.toString().toLowerCase())){
                    newList.add(cpucoolitem);
                }
            }
        }
        mCpuCoolAll.clear();
        mCpuCoolAll.addAll(newList);
        cpuCoolingAdapter = new CpuCoolingAdapter(this,mCpuCoolAll);
        rvDialogCpuCool.setAdapter(cpuCoolingAdapter);
        cpuCoolingAdapter.notifyDataSetChanged();
    }
}