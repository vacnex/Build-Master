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
import io.vacnex.buildmaster.adapter.CpuAdapter;
import io.vacnex.buildmaster.adapter.MbAdapter;
import io.vacnex.buildmaster.adapter.VgaAdapter;
import io.vacnex.buildmaster.model.CPU;
import io.vacnex.buildmaster.model.Mainbroad;
import io.vacnex.buildmaster.model.Vga;


public class Dialog_mb extends AppCompatActivity {
    RecyclerView rvDialogMb;
    MbAdapter mbAdapter;
    EditText svMb;
    List<Mainbroad> _mb = new ArrayList<>();
    List<Mainbroad> mMbAll = new ArrayList<>();
    List<Mainbroad> amdMbs = new ArrayList<>();
    List<Mainbroad> intelMbs = new ArrayList<>();
    Mainbroad[] mbs ;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_mb);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        Context context = this;
        Init();
        Searchrv();
        RecyclerviewItemClick(context);
    }
    //region init vga control func
    private void Init() {
        rvDialogMb = findViewById(R.id.rvDialogMb);
        svMb = findViewById(R.id.svMb);
        i = getIntent();
        if (i.getSerializableExtra("dialog_mb") == null)
        {
            amdMbs = (List<Mainbroad>) i.getSerializableExtra("dialog_amd_mb");
        } else {
            intelMbs = (List<Mainbroad>) i.getSerializableExtra("dialog_mb");
        }

        InitMbList();
    }
    //endregion
    //region init vga list
    private void InitMbList() {
        if (intelMbs.size() >0){
            for (int i = 0; i < intelMbs.size(); i++) {
                _mb.add(intelMbs.get(i));
            }
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            mbAdapter = new MbAdapter(this,_mb);
            rvDialogMb.setAdapter(mbAdapter);
            rvDialogMb.setLayoutManager(linearLayoutManager);
        }
        else{
            for (int i = 0; i < amdMbs.size(); i++) {
                _mb.add(amdMbs.get(i));
            }
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            mbAdapter = new MbAdapter(this,_mb);
            rvDialogMb.setAdapter(mbAdapter);
            rvDialogMb.setLayoutManager(linearLayoutManager);
        }



    }
    //endregion
    //region pass item data to previous activity func and handle item click func for pass data
    private void RecyclerviewItemClick(Context context){
        rvDialogMb.addOnItemTouchListener(
                new Dialog_mb.RecyclerItemClickListener(context, rvDialogMb ,new Dialog_mb.RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View v, int position) {
                        Mainbroad clickedMbItem = _mb.get(position);
//                            Toast.makeText(v.getContext(), "You clicked " + clickedCpuItem.getmName(), Toast.LENGTH_SHORT).show();
                        i.putExtra("dialog_mb_name",clickedMbItem.getmName());
                        setResult(4,i);
                        finish();
                    }
                    @Override public void onLongItemClick(View view, int position) {
                    }
                })
        );
    }
    public static class RecyclerItemClickListener implements RecyclerView.OnItemTouchListener {
        private Dialog_mb.RecyclerItemClickListener.OnItemClickListener mListener;
        public interface OnItemClickListener {
            public void onItemClick(View view, int position);
            public void onLongItemClick(View view, int position);
        }
        GestureDetector mGestureDetector;
        public RecyclerItemClickListener(Context context, final RecyclerView recyclerView, Dialog_mb.RecyclerItemClickListener.OnItemClickListener listener) {
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
        svMb.addTextChangedListener(new TextWatcher() {
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
        List<Mainbroad> newList = new ArrayList<>();
        if (text.toString().isEmpty())
        {
            newList.addAll(_mb);
        }else {
            for (Mainbroad mbitem: _mb){
                if (mbitem.getmName().toLowerCase().contains(text.toString().toLowerCase())){
                    newList.add(mbitem);
                }
            }
        }
        mMbAll.clear();
        mMbAll.addAll(newList);
        mbAdapter = new MbAdapter(this,mMbAll);
        rvDialogMb.setAdapter(mbAdapter);
        mbAdapter.notifyDataSetChanged();
    }
    //endregion
}