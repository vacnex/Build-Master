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
import io.vacnex.buildmaster.adapter.CaseAdapter;
import io.vacnex.buildmaster.model.Case;
import io.vacnex.buildmaster.model.Case;

public class Dialog_case extends AppCompatActivity {
    RecyclerView rvDialogCase;
    CaseAdapter caseAdapter;
    EditText svCase;
    List<Case> _case = new ArrayList<>();
    List<Case> mcaseAll = new ArrayList<>();
    Case[] cases ;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_case);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        Context context = this;
        Init();
        Searchrv();
        RecyclerviewItemClick(context);
    }
    private void Init() {
        rvDialogCase = findViewById(R.id.rvDialogCase);
        svCase = findViewById(R.id.svCase);
        i = getIntent();
        cases = (Case[]) i.getSerializableExtra("dialog_case");
        InitCaseList();
    }

    private void InitCaseList() {
        for (int i = 0; i < cases.length; i++) {
            _case.add(cases[i]);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        caseAdapter = new CaseAdapter(this,_case);
        rvDialogCase.setAdapter(caseAdapter);
        rvDialogCase.setLayoutManager(linearLayoutManager);
    }
    private void RecyclerviewItemClick(Context context){
        rvDialogCase.addOnItemTouchListener(
                new Dialog_case.RecyclerItemClickListener(context, rvDialogCase ,new Dialog_case.RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View v, int position) {
                        Case clickedCaseItem = _case.get(position);
//                            Toast.makeText(v.getContext(), "You clicked " + clickedCpuItem.getmName(), Toast.LENGTH_SHORT).show();
                        i.putExtra("dialog_case_name",clickedCaseItem.getmName());
                        setResult(10,i);
                        finish();
                    }
                    @Override public void onLongItemClick(View view, int position) {
                    }
                })
        );
    }
    public static class RecyclerItemClickListener implements RecyclerView.OnItemTouchListener {
        private Dialog_case.RecyclerItemClickListener.OnItemClickListener mListener;
        public interface OnItemClickListener {
            public void onItemClick(View view, int position);
            public void onLongItemClick(View view, int position);
        }
        GestureDetector mGestureDetector;
        public RecyclerItemClickListener(Context context, final RecyclerView recyclerView, Dialog_case.RecyclerItemClickListener.OnItemClickListener listener) {
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
        svCase.addTextChangedListener(new TextWatcher() {
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
        List<Case> newList = new ArrayList<>();
        if (text.toString().isEmpty())
        {
            newList.addAll(_case);
        }else {
            for (Case caseitem: _case){
                if (caseitem.getmName().toLowerCase().contains(text.toString().toLowerCase())){
                    newList.add(caseitem);
                }
            }
        }
        mcaseAll.clear();
        mcaseAll.addAll(newList);
        caseAdapter = new CaseAdapter(this,mcaseAll);
        rvDialogCase.setAdapter(caseAdapter);
        caseAdapter.notifyDataSetChanged();
    }
}