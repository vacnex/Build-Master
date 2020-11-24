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
import io.vacnex.buildmaster.adapter.FanAdapter;
import io.vacnex.buildmaster.model.Fan;

public class Dialog_fan extends AppCompatActivity {
    RecyclerView rvDialogFan;
    FanAdapter fanAdapter;
    EditText svFan;
    List<Fan> _fan = new ArrayList<>();
    List<Fan> mfanAll = new ArrayList<>();
    Fan[] fans ;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_fan);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        Context context = this;
        Init();
        Searchrv();
        RecyclerviewItemClick(context);
    }
    private void Init() {
        rvDialogFan = findViewById(R.id.rvDialogFan);
        svFan = findViewById(R.id.svFan);
        i = getIntent();
        fans = (Fan[]) i.getSerializableExtra("dialog_fan");
        InitFanList();
    }

    private void InitFanList() {
        for (int i = 0; i < fans.length; i++) {
            _fan.add(fans[i]);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        fanAdapter = new FanAdapter(this,_fan);
        rvDialogFan.setAdapter(fanAdapter);
        rvDialogFan.setLayoutManager(linearLayoutManager);
    }
    private void RecyclerviewItemClick(Context context){
        rvDialogFan.addOnItemTouchListener(
                new Dialog_fan.RecyclerItemClickListener(context, rvDialogFan ,new Dialog_fan.RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View v, int position) {
                        Fan clickedFanItem = _fan.get(position);
//                            Toast.makeText(v.getContext(), "You clicked " + clickedCpuItem.getmName(), Toast.LENGTH_SHORT).show();
                        i.putExtra("dialog_fan_name",clickedFanItem.getmName());
                        setResult(11,i);
                        finish();
                    }
                    @Override public void onLongItemClick(View view, int position) {
                    }
                })
        );
    }
    public static class RecyclerItemClickListener implements RecyclerView.OnItemTouchListener {
        private Dialog_fan.RecyclerItemClickListener.OnItemClickListener mListener;
        public interface OnItemClickListener {
            public void onItemClick(View view, int position);
            public void onLongItemClick(View view, int position);
        }
        GestureDetector mGestureDetector;
        public RecyclerItemClickListener(Context context, final RecyclerView recyclerView, Dialog_fan.RecyclerItemClickListener.OnItemClickListener listener) {
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
        svFan.addTextChangedListener(new TextWatcher() {
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
        List<Fan> newList = new ArrayList<>();
        if (text.toString().isEmpty())
        {
            newList.addAll(_fan);
        }else {
            for (Fan fanitem: _fan){
                if (fanitem.getmName().toLowerCase().contains(text.toString().toLowerCase())){
                    newList.add(fanitem);
                }
            }
        }
        mfanAll.clear();
        mfanAll.addAll(newList);
        fanAdapter = new FanAdapter(this,mfanAll);
        rvDialogFan.setAdapter(fanAdapter);
        fanAdapter.notifyDataSetChanged();
    }
}