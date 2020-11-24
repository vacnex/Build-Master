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
import io.vacnex.buildmaster.adapter.SsdAdapter;
import io.vacnex.buildmaster.model.SSD;



public class Dialog_ssd extends AppCompatActivity {
    RecyclerView rvDialogSsd;
    SsdAdapter ssdAdapter;
    EditText svSsd;
    List<SSD> _ssd = new ArrayList<>();
    List<SSD> mSsdAll = new ArrayList<>();
    SSD[] ssds ;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_ssd);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        Context context = this;
        Init();
        Searchrv();
        RecyclerviewItemClick(context);
    }
    private void Init() {
        rvDialogSsd = findViewById(R.id.rvDialogSsd);
        svSsd = findViewById(R.id.svSsd);
        i = getIntent();
        ssds = (SSD[]) i.getSerializableExtra("dialog_ssd");
        InitSsdList();
    }

    private void InitSsdList() {
        for (int i = 0; i < ssds.length; i++) {
            _ssd.add(ssds[i]);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        ssdAdapter = new SsdAdapter(this,_ssd);
        rvDialogSsd.setAdapter(ssdAdapter);
        rvDialogSsd.setLayoutManager(linearLayoutManager);
    }

    private void RecyclerviewItemClick(Context context) {
        rvDialogSsd.addOnItemTouchListener(
                new Dialog_ssd.RecyclerItemClickListener(context, rvDialogSsd ,new Dialog_ssd.RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View v, int position) {
                        SSD clickedSsdItem = _ssd.get(position);
//                            Toast.makeText(v.getContext(), "You clicked " + clickedCpuItem.getmName(), Toast.LENGTH_SHORT).show();
                        i.putExtra("dialog_ssd_name",clickedSsdItem.getmName());
                        setResult(5,i);
                        finish();
                    }
                    @Override public void onLongItemClick(View view, int position) {
                    }
                })
        );
    }
    public static class RecyclerItemClickListener implements RecyclerView.OnItemTouchListener {
        private Dialog_ssd.RecyclerItemClickListener.OnItemClickListener mListener;
        public interface OnItemClickListener {
            public void onItemClick(View view, int position);
            public void onLongItemClick(View view, int position);
        }
        GestureDetector mGestureDetector;
        public RecyclerItemClickListener(Context context, final RecyclerView recyclerView, Dialog_ssd.RecyclerItemClickListener.OnItemClickListener listener) {
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
        svSsd.addTextChangedListener(new TextWatcher() {
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
        List<SSD> newList = new ArrayList<>();
        if (text.toString().isEmpty())
        {
            newList.addAll(_ssd);
        }else {
            for (SSD ssditem: _ssd){
                if (ssditem.getmName().toLowerCase().contains(text.toString().toLowerCase())){
                    newList.add(ssditem);
                }
            }
        }
        mSsdAll.clear();
        mSsdAll.addAll(newList);
        ssdAdapter = new SsdAdapter(this,mSsdAll);
        rvDialogSsd.setAdapter(ssdAdapter);
        ssdAdapter.notifyDataSetChanged();
    }

}