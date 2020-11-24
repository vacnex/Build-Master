package io.vacnex.buildmaster;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.vacnex.buildmaster.Dialog.Dialog_case;
import io.vacnex.buildmaster.Dialog.Dialog_cpu;
import io.vacnex.buildmaster.Dialog.Dialog_cpucool;
import io.vacnex.buildmaster.Dialog.Dialog_fan;
import io.vacnex.buildmaster.Dialog.Dialog_hdd;
import io.vacnex.buildmaster.Dialog.Dialog_mb;
import io.vacnex.buildmaster.Dialog.Dialog_monitor;
import io.vacnex.buildmaster.Dialog.Dialog_psu;
import io.vacnex.buildmaster.Dialog.Dialog_ram;
import io.vacnex.buildmaster.Dialog.Dialog_ssd;
import io.vacnex.buildmaster.Dialog.Dialog_vga;
import io.vacnex.buildmaster.Dialog.Dialog_vgacool;
import io.vacnex.buildmaster.model.CPU;
import io.vacnex.buildmaster.model.CPUCooling;
import io.vacnex.buildmaster.model.Case;
import io.vacnex.buildmaster.model.Checkout;
import io.vacnex.buildmaster.model.Fan;
import io.vacnex.buildmaster.model.HDD;
import io.vacnex.buildmaster.model.Mainbroad;
import io.vacnex.buildmaster.model.Monitor;
import io.vacnex.buildmaster.model.PSU;
import io.vacnex.buildmaster.model.Ram;
import io.vacnex.buildmaster.model.SSD;
import io.vacnex.buildmaster.model.Vga;
import io.vacnex.buildmaster.model.VgaCooling;

public class Pc_build_screen extends AppCompatActivity {
    Switch swAmd;
    EditText txtSelCpu,txtSelVga,txtSelRam,txtSelMb,txtSelSsd,txtSelHdd,txtSelPsu,txtSelCpuCooling,txtSelVgaCooling,txtSelCase,txtSelFan,txtSelMonitor,txtVgaNum,txtRamNum,txtSsdNum,txtHddNum,txtFanNum,txtMonitorNum;
    Intent i;
    CPU[] cpus ;
    Vga[] vgas ;
    Ram[] rams ;
    Mainbroad[] mbs;
    SSD[] ssds;
    HDD[] hdds ;
    PSU[] psus;
    CPUCooling[] cpucools;
    VgaCooling[] vgacools;
    Case[] cases;
    Fan[] fans;
    Monitor[] monitors;
    List<CPU> amdCpus = new ArrayList<>();
    List<CPU> IntelCpus = new ArrayList<>();
    List<Mainbroad> amdMbs = new ArrayList<>();
    List<Mainbroad> intelMbs = new ArrayList<>();
    List<CPU> newcpu = new ArrayList<>();
    List<Vga> newvga = new ArrayList<>();
    List<Mainbroad> newmainbroad = new ArrayList<>();
    List<Ram> newram = new ArrayList<>();
    List<SSD> newssd = new ArrayList<>();
    List<HDD> newhdd = new ArrayList<>();
    List<PSU> newpsu = new ArrayList<>();
    List<CPUCooling> newcpucool = new ArrayList<>();
    List<Case> newcase = new ArrayList<>();
    List<Fan> newfan = new ArrayList<>();
    List<Monitor> newmonitor = new ArrayList<>();
    Checkout checkouts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pc_build);
        InitControl();
        onChangeSwich();
    }

    private void InitControl() {
        i = getIntent();
        txtSelCpu = findViewById(R.id.txtSelCpu);
        txtSelVga = findViewById(R.id.txtSelVga);
        txtSelRam = findViewById(R.id.txtSelRam);
        txtSelMb = findViewById(R.id.txtSelMb);
        txtSelSsd = findViewById(R.id.txtSelSsd);
        txtSelHdd = findViewById(R.id.txtSelHdd);
        txtSelPsu = findViewById(R.id.txtSelPsu);
        txtSelCpuCooling = findViewById(R.id.txtSelCpuCooling);
        txtSelVgaCooling = findViewById(R.id.txtSelVgaCooling);
        txtSelCase = findViewById(R.id.txtSelCase);
        txtSelFan = findViewById(R.id.txtSelFan);
        txtSelMonitor = findViewById(R.id.txtSelMonitor);
        txtVgaNum = findViewById(R.id.txtVgaNum);
        txtRamNum = findViewById(R.id.txtRamNum);
        txtSsdNum = findViewById(R.id.txtSsdNum);
        txtHddNum = findViewById(R.id.txtHddNum);
        txtFanNum = findViewById(R.id.txtFanNum);
        txtMonitorNum = findViewById(R.id.txtMoniterNum);
        swAmd = findViewById(R.id.swAmd);
        cpus = (CPU[]) i.getSerializableExtra("pc_build_cpu");
        vgas = (Vga[]) i.getSerializableExtra("pc_build_vga");
        rams = (Ram[]) i.getSerializableExtra("pc_build_ram");
        mbs = (Mainbroad[]) i.getSerializableExtra("pc_build_mb");
        ssds = (SSD[]) i.getSerializableExtra("pc_build_ssd");
        hdds = (HDD[]) i.getSerializableExtra("pc_build_hdd");
        psus = (PSU[]) i.getSerializableExtra("pc_build_psu");
        cpucools = (CPUCooling[]) i.getSerializableExtra("pc_build_cpucool");
        vgacools = (VgaCooling[]) i.getSerializableExtra("pc_build_vgacool");
        cases = (Case[]) i.getSerializableExtra("pc_build_case");
        fans = (Fan[]) i.getSerializableExtra("pc_build_fan");
        monitors = (Monitor[]) i.getSerializableExtra("pc_build_monitor");
        amdcpus();
        amdmbs();
    }

    private void onChangeSwich(){
        swAmd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                txtSelCpu.setText(getResources().getString(R.string.choose_cpu));
                txtSelMb.setText(getResources().getString(R.string.choose_mb));
            }
        });
    }
    private void amdcpus(){
        for (CPU cpuitem: cpus){
            if (cpuitem.getmName().toLowerCase().contains("amd")){
                amdCpus.add(cpuitem);
            } else {
                IntelCpus.add(cpuitem);
            }
        }
    }
    private void amdmbs(){
        for (Mainbroad mbitem: mbs){
            if (mbitem.getmChipset().toLowerCase().contains("amd")){
                amdMbs.add(mbitem);
            } else {
                intelMbs.add(mbitem);
            }
        }
    }

    public void btnBackhomeClick(View view) {
        finish();
    }
    public void btnNextClick(View view) {
        if( TextUtils.isEmpty(txtSelCpu.getText()) || TextUtils.isEmpty(txtSelVga.getText()) || TextUtils.isEmpty(txtSelRam.getText()) || TextUtils.isEmpty(txtSelMb.getText()) || TextUtils.isEmpty(txtSelSsd.getText()) || TextUtils.isEmpty(txtSelHdd.getText()) || TextUtils.isEmpty(txtSelCpuCooling.getText()) || TextUtils.isEmpty(txtSelVgaCooling.getText()) || TextUtils.isEmpty(txtSelCase.getText()) || TextUtils.isEmpty(txtSelFan.getText()) || TextUtils.isEmpty(txtSelMonitor.getText()) || TextUtils.isEmpty(txtMonitorNum.getText()) || TextUtils.isEmpty(txtVgaNum.getText()) || TextUtils.isEmpty(txtRamNum.getText()) || TextUtils.isEmpty(txtSsdNum.getText()) || TextUtils.isEmpty(txtHddNum.getText()) || TextUtils.isEmpty(txtFanNum.getText())){
            txtSelCpu.setError(getString(R.string.require));
            txtSelVga.setError(getString(R.string.require));
            txtSelRam.setError(getString(R.string.require));
            txtSelMb.setError(getString(R.string.require));
            txtSelSsd.setError(getString(R.string.require));
            txtSelHdd.setError(getString(R.string.require));
            txtSelPsu.setError(getString(R.string.require));
            txtSelCpuCooling.setError(getString(R.string.require));
            txtSelVgaCooling.setError(getString(R.string.require));
            txtSelCase.setError(getString(R.string.require));
            txtSelFan.setError(getString(R.string.require));
            txtSelMonitor.setError(getString(R.string.require));
            txtMonitorNum.setError(getString(R.string.require));
            txtVgaNum.setError(getString(R.string.require));
            txtRamNum.setError(getString(R.string.require));
            txtSsdNum.setError(getString(R.string.require));
            txtHddNum.setError(getString(R.string.require));
            txtFanNum.setError(getString(R.string.require));
        }else{
            newcpu.clear();
            newvga.clear();
            newmainbroad.clear();
            newram.clear();
            newssd.clear();
            newhdd.clear();
            newpsu.clear();
            newcpucool.clear();
            newcase.clear();
            newfan.clear();
            newmonitor.clear();
            for(CPU c : cpus) {
                if(c.getmName().equals(txtSelCpu.getText().toString()))
                    newcpu.add(c);
                
            }
            for(Vga v : vgas) {
                if(v.getmName().equals(txtSelVga.getText().toString())){
                    for (int i= 0 ; i<  Integer.parseInt(txtVgaNum.getText().toString());i++){
                        newvga.add(v);
                    }
                }
                
            }
            for(Mainbroad m : mbs) {

                if(m.getmName().equals(txtSelMb.getText().toString()))
                {
                    newmainbroad.add(m);
                }
                
            }
            for(Ram r : rams) {
                if(r.getmName().equals(txtSelRam.getText().toString())){
                    for (int i= 0 ; i<  Integer.parseInt(txtRamNum.getText().toString());i++){
                        newram.add(r);
                    }
                }
                
            }
            for(SSD s : ssds) {
                if(s.getmName().equals(txtSelSsd.getText().toString())){
                    for (int i= 0 ; i<  Integer.parseInt(txtSsdNum.getText().toString());i++){
                        newssd.add(s);
                    }
                }
                
            }
            for(HDD h : hdds) {
                if(h.getmName().equals(txtSelHdd.getText().toString())){
                    for (int i= 0 ; i<  Integer.parseInt(txtHddNum.getText().toString());i++){
                        newhdd.add(h);
                    }
                }
                
            }
            for(PSU p : psus) {
                if(p.getmName().equals(txtSelPsu.getText().toString()))
                    newpsu.add(p);
                
            }
            for(CPUCooling cc : cpucools) {
                if(cc.getmName().equals(txtSelCpuCooling.getText().toString()))
                    newcpucool.add(cc);
                
            }
            for(Case cs : cases) {
                if(cs.getmName().equals(txtSelCase.getText().toString()))
                    newcase.add(cs);
                
            }
            for(Fan f : fans) {
                if(f.getmName().equals(txtSelFan.getText().toString())){
                    for (int i= 0 ; i<  Integer.parseInt(txtFanNum.getText().toString());i++){
                        newfan.add(f);
                    }
                }
                
            }
            for(Monitor m : monitors) {
                if(m.getmName().equals(txtSelMonitor.getText().toString())){
                    for (int i= 0 ; i<  Integer.parseInt(txtMonitorNum.getText().toString());i++){
                        newmonitor.add(m);
                    }
                }
                
            }
            checkouts = new Checkout(newcpu,newvga,newmainbroad,newram,newssd,newhdd,newpsu,newcpucool,newcase,newfan,newmonitor);


            Intent intent = new Intent(Pc_build_screen.this,Pc_build_checkout.class);
            intent.putExtra("pc_build_checkout",checkouts);
            startActivity(intent);
        }

    }

    public void txtSelCpuClick(View view) {
        Intent intent = new Intent(Pc_build_screen.this, Dialog_cpu.class);
        if (swAmd.isChecked())
        {
            intent.putExtra("dialog_amd_cpu", (ArrayList<CPU>) amdCpus);
        }
        else   {
            intent.putExtra("dialog_cpu",(ArrayList<CPU>) IntelCpus);

        }
        startActivityForResult(intent,1);
    }
    public void txtSelVgaClick(View view) {
        Intent intent = new Intent(Pc_build_screen.this, Dialog_vga.class);
        intent.putExtra("dialog_vga", vgas);
        startActivityForResult(intent,2);
    }
    public void txtSelRamClick(View view) {
        Intent intent = new Intent(Pc_build_screen.this, Dialog_ram.class);
        intent.putExtra("dialog_ram", rams);
        startActivityForResult(intent,3);
    }
    public void txtSelMbClick(View view) {
        Toast.makeText(view.getContext(), "You clicked " + txtSelMb.getText().toString(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Pc_build_screen.this, Dialog_mb.class);
        if (swAmd.isChecked())
        {
            intent.putExtra("dialog_amd_mb", (ArrayList<Mainbroad>) amdMbs);
        }
        else   {
            intent.putExtra("dialog_mb",(ArrayList<Mainbroad>) intelMbs);
        }
        startActivityForResult(intent,4);
    }

    public void txtSelSsdClick(View view) {
        Intent intent = new Intent(Pc_build_screen.this, Dialog_ssd.class);
        intent.putExtra("dialog_ssd", ssds);
        startActivityForResult(intent,5);
    }
    public void txtSelHddClick(View view) {
        Intent intent = new Intent(Pc_build_screen.this, Dialog_hdd.class);
        intent.putExtra("dialog_hdd", hdds);
        startActivityForResult(intent,6);
    }

    public void txtSelPsuClick(View view) {
        Intent intent = new Intent(Pc_build_screen.this, Dialog_psu.class);
        intent.putExtra("dialog_psu", psus);
        startActivityForResult(intent,7);
    }

    public void txtSelCpuCoolingClick(View view) {
        Intent intent = new Intent(Pc_build_screen.this, Dialog_cpucool.class);
        intent.putExtra("dialog_cpucool", cpucools);
        startActivityForResult(intent,8);
    }

//    public void txtSelVgaCoolingClick(View view) {
//        Intent intent = new Intent(Pc_build_screen.this, Dialog_vgacool.class);
//        intent.putExtra("dialog_vgacool", vgacools);
//        startActivityForResult(intent,9);
//    }

    public void txtSelCaseClick(View view) {
        Intent intent = new Intent(Pc_build_screen.this, Dialog_case.class);
        intent.putExtra("dialog_case", cases);
        startActivityForResult(intent,10);
    }

    public void txtSelFanClick(View view) {
        Intent intent = new Intent(Pc_build_screen.this, Dialog_fan.class);
        intent.putExtra("dialog_fan", fans);
        startActivityForResult(intent,11);
    }

    public void txtSelMonitorClick(View view) {
        Intent intent = new Intent(Pc_build_screen.this, Dialog_monitor.class);
        intent.putExtra("dialog_monitor", monitors);
        startActivityForResult(intent,12);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == 1){
            txtSelCpu.setText(data.getSerializableExtra("dialog_cpu_name").toString());
        } else if (requestCode == 2 && resultCode == 2){
            txtSelVga.setText(data.getSerializableExtra("dialog_vga_name").toString());
        }else if (requestCode == 3 && resultCode == 3){
            txtSelRam.setText(data.getSerializableExtra("dialog_ram_name").toString());
        }else if (requestCode == 4 && resultCode == 4){
            txtSelMb.setText(data.getSerializableExtra("dialog_mb_name").toString());
        }else if (requestCode == 5 && resultCode == 5){
            txtSelSsd.setText(data.getSerializableExtra("dialog_ssd_name").toString());
        }else if (requestCode == 6 && resultCode == 6){
            txtSelHdd.setText(data.getSerializableExtra("dialog_hdd_name").toString());
        }else if (requestCode == 7 && resultCode == 7){
            txtSelPsu.setText(data.getSerializableExtra("dialog_psu_name").toString());
        }else if (requestCode == 8 && resultCode == 8){
            txtSelCpuCooling.setText(data.getSerializableExtra("dialog_cpucool_name").toString());
        }else if (requestCode == 9 && resultCode == 9){
            txtSelVgaCooling.setText(data.getSerializableExtra("dialog_vgacool_name").toString());
        }else if (requestCode == 10 && resultCode == 10){
            txtSelCase.setText(data.getSerializableExtra("dialog_case_name").toString());
        }else if (requestCode == 11 && resultCode == 11){
            txtSelFan.setText(data.getSerializableExtra("dialog_fan_name").toString());
        }else if (requestCode == 12 && resultCode == 12){
            txtSelMonitor.setText(data.getSerializableExtra("dialog_monitor_name").toString());
        }
    }



}