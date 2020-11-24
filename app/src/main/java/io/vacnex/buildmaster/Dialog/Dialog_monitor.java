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
import io.vacnex.buildmaster.adapter.MonitorAdapter;
import io.vacnex.buildmaster.model.Monitor;
import io.vacnex.buildmaster.model.Monitor;

public class Dialog_monitor extends AppCompatActivity {
    RecyclerView rvDialogMoniter;
    MonitorAdapter monitorAdapter;
    EditText svMonitor;
    List<Monitor> _monitor = new ArrayList<>();
    List<Monitor> mmonitorAll = new ArrayList<>();
    Monitor[] monitors ;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_monitor);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        Context context = this;
        Init();
        Searchrv();
        RecyclerviewItemClick(context);
    }
    private void Init() {
        rvDialogMoniter = findViewById(R.id.rvDialogMoniter);
        svMonitor = findViewById(R.id.svMonitor);
        i = getIntent();
        monitors = (Monitor[]) i.getSerializableExtra("dialog_monitor");
        InitMonitorList();
    }

    private void InitMonitorList() {
        for (int i = 0; i < monitors.length; i++) {
            _monitor.add(monitors[i]);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        monitorAdapter = new MonitorAdapter(this,_monitor);
        rvDialogMoniter.setAdapter(monitorAdapter);
        rvDialogMoniter.setLayoutManager(linearLayoutManager);
    }
    private void RecyclerviewItemClick(Context context){
        rvDialogMoniter.addOnItemTouchListener(
                new Dialog_monitor.RecyclerItemClickListener(context, rvDialogMoniter ,new Dialog_monitor.RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View v, int position) {
                        Monitor clickedMonitorItem = _monitor.get(position);
//                            Toast.makeText(v.getContext(), "You clicked " + clickedCpuItem.getmName(), Toast.LENGTH_SHORT).show();
                        i.putExtra("dialog_monitor_name",clickedMonitorItem.getmName());
                        setResult(12,i);
                        finish();
                    }
                    @Override public void onLongItemClick(View view, int position) {
                    }
                })
        );
    }
    public static class RecyclerItemClickListener implements RecyclerView.OnItemTouchListener {
        private Dialog_monitor.RecyclerItemClickListener.OnItemClickListener mListener;
        public interface OnItemClickListener {
            public void onItemClick(View view, int position);
            public void onLongItemClick(View view, int position);
        }
        GestureDetector mGestureDetector;
        public RecyclerItemClickListener(Context context, final RecyclerView recyclerView, Dialog_monitor.RecyclerItemClickListener.OnItemClickListener listener) {
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
        svMonitor.addTextChangedListener(new TextWatcher() {
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
        List<Monitor> newList = new ArrayList<>();
        if (text.toString().isEmpty())
        {
            newList.addAll(_monitor);
        }else {
            for (Monitor monitoritem: _monitor){
                if (monitoritem.getmName().toLowerCase().contains(text.toString().toLowerCase())){
                    newList.add(monitoritem);
                }
            }
        }
        mmonitorAll.clear();
        mmonitorAll.addAll(newList);
        monitorAdapter = new MonitorAdapter(this,mmonitorAll);
        rvDialogMoniter.setAdapter(monitorAdapter);
        monitorAdapter.notifyDataSetChanged();
    }
}