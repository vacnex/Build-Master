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
import io.vacnex.buildmaster.adapter.PsuAdapter;
import io.vacnex.buildmaster.model.PSU;

public class Dialog_psu extends AppCompatActivity {
    RecyclerView rvDialogPsu;
    PsuAdapter psuAdapter;
    EditText svPsu;
    List<PSU> _psu = new ArrayList<>();
    List<PSU> _mpsuAll = new ArrayList<>();
    PSU[] psus ;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_psu);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        Context context = this;
        Init();
        Searchrv();
        RecyclerviewItemClick(context);
    }
    private void Init() {
        rvDialogPsu = findViewById(R.id.rvDialogPsu);
        svPsu = findViewById(R.id.svPsu);
        i = getIntent();
        psus = (PSU[]) i.getSerializableExtra("dialog_psu");
        InitPSUList();
    }

    private void InitPSUList() {
        for (int i = 0; i < psus.length; i++) {
            _psu.add(psus[i]);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        psuAdapter = new PsuAdapter(this,_psu);
        rvDialogPsu.setAdapter(psuAdapter);
        rvDialogPsu.setLayoutManager(linearLayoutManager);
    }
    private void RecyclerviewItemClick(Context context){
        rvDialogPsu.addOnItemTouchListener(
                new Dialog_psu.RecyclerItemClickListener(context, rvDialogPsu ,new Dialog_psu.RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View v, int position) {
                        PSU clickedPSUItem = _psu.get(position);
//                            Toast.makeText(v.getContext(), "You clicked " + clickedCpuItem.getmName(), Toast.LENGTH_SHORT).show();
                        i.putExtra("dialog_psu_name",clickedPSUItem.getmName());
                        setResult(7,i);
                        finish();
                    }
                    @Override public void onLongItemClick(View view, int position) {
                    }
                })
        );
    }
    public static class RecyclerItemClickListener implements RecyclerView.OnItemTouchListener {
        private Dialog_psu.RecyclerItemClickListener.OnItemClickListener mListener;
        public interface OnItemClickListener {
            public void onItemClick(View view, int position);
            public void onLongItemClick(View view, int position);
        }
        GestureDetector mGestureDetector;
        public RecyclerItemClickListener(Context context, final RecyclerView recyclerView, Dialog_psu.RecyclerItemClickListener.OnItemClickListener listener) {
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
        svPsu.addTextChangedListener(new TextWatcher() {
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
        List<PSU> newList = new ArrayList<>();
        if (text.toString().isEmpty())
        {
            newList.addAll(_psu);
        }else {
            for (PSU psuitem: _psu){
                if (psuitem.getmName().toLowerCase().contains(text.toString().toLowerCase())){
                    newList.add(psuitem);
                }
            }
        }
        _mpsuAll.clear();
        _mpsuAll.addAll(newList);
        psuAdapter = new PsuAdapter(this,_mpsuAll);
        rvDialogPsu.setAdapter(psuAdapter);
        psuAdapter.notifyDataSetChanged();
    }
}