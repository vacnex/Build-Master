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
import io.vacnex.buildmaster.adapter.RamAdapter;
import io.vacnex.buildmaster.model.Ram;



public class Dialog_ram extends AppCompatActivity {
    RecyclerView rvDialogRam;
    RamAdapter ramAdapter;
    EditText svRam;
    List<Ram> _ram = new ArrayList<>();
    List<Ram> mramAll = new ArrayList<>();
    Ram[] rams ;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_ram);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        Context context = this;
        Init();
        Searchrv();
        RecyclerviewItemClick(context);
    }
    private void Init() {
        rvDialogRam = findViewById(R.id.rvDialogRam);
        svRam = findViewById(R.id.svRam);
        i = getIntent();
        rams = (Ram[]) i.getSerializableExtra("dialog_ram");
        InitRamList();
    }

    private void InitRamList() {
        for (int i = 0; i < rams.length; i++) {
            _ram.add(rams[i]);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        ramAdapter = new RamAdapter(this,_ram);
        rvDialogRam.setAdapter(ramAdapter);
        rvDialogRam.setLayoutManager(linearLayoutManager);
    }
    //region pass item data to previous activity func and handle item click func for pass data
    private void RecyclerviewItemClick(Context context){
        rvDialogRam.addOnItemTouchListener(
                new Dialog_ram.RecyclerItemClickListener(context, rvDialogRam ,new Dialog_ram.RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View v, int position) {
                        Ram clickedRamItem = _ram.get(position);
//                            Toast.makeText(v.getContext(), "You clicked " + clickedCpuItem.getmName(), Toast.LENGTH_SHORT).show();
                        i.putExtra("dialog_ram_name",clickedRamItem.getmName());
                        setResult(3,i);
                        finish();
                    }
                    @Override public void onLongItemClick(View view, int position) {
                    }
                })
        );
    }
    public static class RecyclerItemClickListener implements RecyclerView.OnItemTouchListener {
        private Dialog_ram.RecyclerItemClickListener.OnItemClickListener mListener;
        public interface OnItemClickListener {
            public void onItemClick(View view, int position);
            public void onLongItemClick(View view, int position);
        }
        GestureDetector mGestureDetector;
        public RecyclerItemClickListener(Context context, final RecyclerView recyclerView, Dialog_ram.RecyclerItemClickListener.OnItemClickListener listener) {
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
        svRam.addTextChangedListener(new TextWatcher() {
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
        List<Ram> newList = new ArrayList<>();
        if (text.toString().isEmpty())
        {
            newList.addAll(_ram);
        }else {
            for (Ram ramitem: _ram){
                if (ramitem.getmName().toLowerCase().contains(text.toString().toLowerCase())){
                    newList.add(ramitem);
                }
            }
        }
        mramAll.clear();
        mramAll.addAll(newList);
        ramAdapter = new RamAdapter(this,mramAll);
        rvDialogRam.setAdapter(ramAdapter);
        ramAdapter.notifyDataSetChanged();
    }
    //endregion
}