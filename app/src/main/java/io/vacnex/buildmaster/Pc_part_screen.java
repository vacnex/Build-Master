package io.vacnex.buildmaster;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import io.vacnex.buildmaster.adapter.CaseAdapter;
import io.vacnex.buildmaster.adapter.CpuAdapter;
import io.vacnex.buildmaster.adapter.CpuCoolingAdapter;
import io.vacnex.buildmaster.adapter.FanAdapter;
import io.vacnex.buildmaster.adapter.HddAdapter;
import io.vacnex.buildmaster.adapter.MbAdapter;
import io.vacnex.buildmaster.adapter.MonitorAdapter;
import io.vacnex.buildmaster.adapter.PsuAdapter;
import io.vacnex.buildmaster.adapter.RamAdapter;
import io.vacnex.buildmaster.adapter.SsdAdapter;
import io.vacnex.buildmaster.adapter.VgaAdapter;
import io.vacnex.buildmaster.adapter.VgaCoolingAdapter;
import io.vacnex.buildmaster.model.CPU;
import io.vacnex.buildmaster.model.CPUCooling;
import io.vacnex.buildmaster.model.Case;
import io.vacnex.buildmaster.model.Fan;
import io.vacnex.buildmaster.model.HDD;
import io.vacnex.buildmaster.model.Mainbroad;
import io.vacnex.buildmaster.model.Monitor;
import io.vacnex.buildmaster.model.PSU;
import io.vacnex.buildmaster.model.Ram;
import io.vacnex.buildmaster.model.SSD;
import io.vacnex.buildmaster.model.Vga;
import io.vacnex.buildmaster.model.VgaCooling;


public class Pc_part_screen extends AppCompatActivity {
    RecyclerView rvCPUPartResult,rvVgaPartResult,rvMbPartResult,rvRamPartResult,rvSsdPartResult,rvHddPartResult,rvPsuPartResult,rvFanPartResult,rvCasePartResult,rvMonitorPartResult,rvCpuCoollingPartResult,rvVgaCoollingPartResult;
    CpuAdapter cpuAdapter;
    VgaAdapter vgaAdapter;
    RamAdapter ramAdapter;
    MbAdapter mbAdapter;
    SsdAdapter ssdAdapter;
    HddAdapter hddAdapter;
    PsuAdapter psuAdapter;
    FanAdapter fanAdapter;
    CaseAdapter caseAdapter;
    MonitorAdapter monitorAdapter;
    CpuCoolingAdapter cpucoolingcdapter;
    VgaCoolingAdapter VgaCoolingAdapter;
    RadioGroup rdgA,rdgB,rdgC;
    RadioButton rbCpu,rbVga,rbMb,rbRam,rbSsd,rbHdd,rbPsu,rbFan,rbCase,rbMonitor,rbCpuCoolling,rbVgaCoolling;
    EditText svPartSearch;
    //TODO: xử lý sự kiện click vào item trong recyclerview
    Intent i;
    //region declare list and array each model
    List<CPU> _cpu = new ArrayList<>();
    List<CPU> mCPuAll = new ArrayList<>();
    List<Vga> _vga = new ArrayList<>();
    List<Vga> mVgaAll = new ArrayList<>();
    List<Mainbroad> _mb = new ArrayList<>();
    List<Mainbroad> mMbAll = new ArrayList<>();
    List<Ram> _ram = new ArrayList<>();
    List<Ram> mRamAll = new ArrayList<>();
    List<SSD> _ssd = new ArrayList<>();
    List<HDD> _hdd = new ArrayList<>();
    List<PSU> _psu = new ArrayList<>();
    List<Case> _case = new ArrayList<>();
    List<Fan> _fan = new ArrayList<>();
    List<Monitor> _monitor = new ArrayList<>();
    List<CPUCooling> _cpucooling = new ArrayList<>();
    List<VgaCooling> _vgacooling = new ArrayList<>();
    CPU[] cpus ;
    Vga[] vgas ;
    Mainbroad[] mbs ;
    Ram[] rams ;
    SSD[] ssds ;
    HDD[] hdds ;
    PSU[] psus ;
    Case[] cases ;
    Fan[] fans ;
    Monitor[] monitors;
    CPUCooling[] cpucoolings ;
    VgaCooling[] vgacoolings ;
    //endregion
    //region get part data to list func
    private void initCpu() {
        for (int i = 0; i < cpus.length; i++) {
            _cpu.add(cpus[i]);
        }
    }
    private void initVga() {
        for (int i = 0; i < vgas.length; i++) {
            _vga.add(vgas[i]);
        }
    }
    private void initRam(){
        for (int i = 0; i < rams.length; i++) {
            _ram.add(rams[i]);
        }
    }
    private void initMb(){
        for (int i = 0; i < mbs.length; i++) {
            _mb.add(mbs[i]);
        }
    }
    private void initSsd() {
        for (int i = 0; i < ssds.length; i++) {
            _ssd.add(ssds[i]);
        }
    }
    private void initHdd() {
        for (int i = 0; i < hdds.length; i++) {
            _hdd.add(hdds[i]);
        }
    }
    private void initPsu(){
        for (int i = 0; i < psus.length; i++) {
            _psu.add(psus[i]);
        }
    }
    private void initFan(){
        for (int i = 0; i < fans.length; i++) {
            _fan.add(fans[i]);
        }
    }
    private void initCase() {
        for (int i = 0; i < cases.length; i++) {
            _case.add(cases[i]);
        }
    }
    private void initMonitor() {
        for (int i = 0; i < monitors.length; i++) {
            _monitor.add(monitors[i]);
        }
    }
    private void initCpuCooling(){
        for (int i = 0; i < cpucoolings.length; i++) {
            _cpucooling.add(cpucoolings[i]);
        }
    }
    private void initVgaCooling(){
        for (int i = 0; i < vgacoolings.length; i++) {
            _vgacooling.add(vgacoolings[i]);
        }
    }
    //endregion
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pc_part_screen);
        i = getIntent();
        cpus = (CPU[]) i.getSerializableExtra("pc_part_cpu");
        vgas = (Vga[]) i.getSerializableExtra("pc_part_vga");
        rams = (Ram[]) i.getSerializableExtra("pc_part_ram");
        mbs = (Mainbroad[]) i.getSerializableExtra("pc_part_mb");
        ssds = (SSD[]) i.getSerializableExtra("pc_part_ssd");
        hdds = (HDD[]) i.getSerializableExtra("pc_part_hdd");
        psus = (PSU[]) i.getSerializableExtra("pc_part_psu");
        fans = (Fan[]) i.getSerializableExtra("pc_part_fan");
        cases = (Case[]) i.getSerializableExtra("pc_part_case");
        monitors= (Monitor[]) i.getSerializableExtra("pc_part_monitor");
        cpucoolings = (CPUCooling[]) i.getSerializableExtra("pc_part_cpucool");
        vgacoolings = (VgaCooling[]) i.getSerializableExtra("pc_part_vgacool");
        initCpu();
        initVga();
        initRam();
        initMb();
        initSsd();
        initHdd();
        initPsu();
        initFan();
        initCase();
        initMonitor();
        initCpuCooling();
//        initVgaCooling();
        InitControls();
        Searchrv();
    }
    private void InitControls() {
        //region declare id
        svPartSearch = findViewById(R.id.svPartSearch);
        rdgA = findViewById(R.id.rdgA);
        rdgB = findViewById(R.id.rdgB);
        rdgC = findViewById(R.id.rdgC);
        rdgA.clearCheck();
        rdgB.clearCheck();
        rdgC.clearCheck();
        rbCpu = findViewById(R.id.rbCpu);
        rbVga = findViewById(R.id.rbVga);
        rbMb = findViewById(R.id.rbMb);
        rbRam = findViewById(R.id.rbRam);
        rbSsd = findViewById(R.id.rbSsd);
        rbHdd = findViewById(R.id.rbHdd);
        rbPsu = findViewById(R.id.rbPsu);
        rbFan = findViewById(R.id.rbFan);
        rbCase = findViewById(R.id.rbCase);
        rbMonitor = findViewById(R.id.rbMonitor);
        rbCpuCoolling = findViewById(R.id.rbCpuCoolling);
        rbVgaCoolling = findViewById(R.id.rbVgaCoolling);
        rbMonitor = findViewById(R.id.rbMonitor);
        rvCPUPartResult = findViewById(R.id.rvCPUPartResult);
        rvVgaPartResult = findViewById(R.id.rvVgaPartResult);
        rvMbPartResult = findViewById(R.id.rvMbPartResult);
        rvRamPartResult = findViewById(R.id.rvRamPartResult);
        rvSsdPartResult = findViewById(R.id.rvSsdPartResult);
        rvHddPartResult = findViewById(R.id.rvHddPartResult);
        rvPsuPartResult = findViewById(R.id.rvPsuPartResult);
        rvFanPartResult = findViewById(R.id.rvFanPartResult);
        rvCasePartResult = findViewById(R.id.rvCasePartResult);
        rvMonitorPartResult = findViewById(R.id.rvMonitorPartResult);
        rvCpuCoollingPartResult = findViewById(R.id.rvCpuCoollingPartResult);
        rvVgaCoollingPartResult = findViewById(R.id.rvVgaCoollingPartResult);
        //endregion
        //region radio group
        rdgA.setOnCheckedChangeListener(listener1);
        rdgB.setOnCheckedChangeListener(listener2);
        rdgC.setOnCheckedChangeListener(listener3);
        //endregion
        rbVgaCoolling.setEnabled(false);
    }
    //region radio row 1
    private RadioGroup.OnCheckedChangeListener listener1 = new RadioGroup.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId != -1) {
                rdgB.setOnCheckedChangeListener(null);
                rdgB.clearCheck();
                rdgB.setOnCheckedChangeListener(listener2);
                rdgC.setOnCheckedChangeListener(null);
                rdgC.clearCheck();
                rdgC.setOnCheckedChangeListener(listener3);
                RadioButton checkedCpu = group.findViewById(R.id.rbCpu);
                RadioButton checkedVga = group.findViewById(R.id.rbVga);
                RadioButton checkedMb = group.findViewById(R.id.rbMb);
                if (checkedCpu.isChecked()){
                    rvVgaPartResult.setVisibility(View.INVISIBLE);
                    rvMbPartResult.setVisibility(View.INVISIBLE);
                    rvRamPartResult.setVisibility(View.INVISIBLE);
                    rvSsdPartResult.setVisibility(View.INVISIBLE);
                    rvHddPartResult.setVisibility(View.INVISIBLE);
                    rvPsuPartResult.setVisibility(View.INVISIBLE);
                    rvFanPartResult.setVisibility(View.INVISIBLE);
                    rvCasePartResult.setVisibility(View.INVISIBLE);
                    rvMonitorPartResult.setVisibility(View.INVISIBLE);
                    rvCpuCoollingPartResult.setVisibility(View.INVISIBLE);
                    rvVgaCoollingPartResult.setVisibility(View.INVISIBLE);                               rvCPUPartResult.setVisibility(View.VISIBLE);
                    InitCpuList();
//                    Toast toast=Toast.makeText(Pc_part_screen.this,"test",   Toast.LENGTH_SHORT);
//                    toast.show();
                }
                else if (checkedVga.isChecked()){
                    rvCPUPartResult.setVisibility(View.INVISIBLE);
                    rvMbPartResult.setVisibility(View.INVISIBLE);
                    rvRamPartResult.setVisibility(View.INVISIBLE);
                    rvSsdPartResult.setVisibility(View.INVISIBLE);
                    rvHddPartResult.setVisibility(View.INVISIBLE);
                    rvPsuPartResult.setVisibility(View.INVISIBLE);
                    rvFanPartResult.setVisibility(View.INVISIBLE);
                    rvCasePartResult.setVisibility(View.INVISIBLE);
                    rvMonitorPartResult.setVisibility(View.INVISIBLE);
                    rvCpuCoollingPartResult.setVisibility(View.INVISIBLE);
                    rvVgaCoollingPartResult.setVisibility(View.INVISIBLE);
                    rvVgaPartResult.setVisibility(View.VISIBLE);
                    rbSsd.setChecked(false);
                    rbMonitor.setChecked(false);
                    InitVgaList();
                }
                else if (checkedMb.isChecked()){
                    rvCPUPartResult.setVisibility(View.INVISIBLE);
                    rvVgaPartResult.setVisibility(View.INVISIBLE);
                    rvRamPartResult.setVisibility(View.INVISIBLE);
                    rvSsdPartResult.setVisibility(View.INVISIBLE);
                    rvHddPartResult.setVisibility(View.INVISIBLE);
                    rvPsuPartResult.setVisibility(View.INVISIBLE);
                    rvFanPartResult.setVisibility(View.INVISIBLE);
                    rvCasePartResult.setVisibility(View.INVISIBLE);
                    rvMonitorPartResult.setVisibility(View.INVISIBLE);
                    rvCpuCoollingPartResult.setVisibility(View.INVISIBLE);
                    rvVgaCoollingPartResult.setVisibility(View.INVISIBLE);
                    rvMbPartResult.setVisibility(View.VISIBLE);
                    InitMbList();
                }
                else {
                    rvCPUPartResult.setVisibility(View.INVISIBLE);
                    rvVgaPartResult.setVisibility(View.INVISIBLE);
                    rvMbPartResult.setVisibility(View.INVISIBLE);
                    rvSsdPartResult.setVisibility(View.INVISIBLE);
                    rvHddPartResult.setVisibility(View.INVISIBLE);
                    rvPsuPartResult.setVisibility(View.INVISIBLE);
                    rvFanPartResult.setVisibility(View.INVISIBLE);
                    rvCasePartResult.setVisibility(View.INVISIBLE);
                    rvMonitorPartResult.setVisibility(View.INVISIBLE);
                    rvCpuCoollingPartResult.setVisibility(View.INVISIBLE);
                    rvVgaCoollingPartResult.setVisibility(View.INVISIBLE);
                    rvRamPartResult.setVisibility(View.VISIBLE);
                    InitRamList();
                }
            }
        }
    };
    //endregion
    //region radio row 2
    private RadioGroup.OnCheckedChangeListener listener2 = new RadioGroup.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId != -1) {
                rdgA.setOnCheckedChangeListener(null);
                rdgA.clearCheck();
                rdgA.setOnCheckedChangeListener(listener1);
                rdgC.setOnCheckedChangeListener(null);
                rdgC.clearCheck();
                rdgC.setOnCheckedChangeListener(listener3);
                RadioButton checkedSSD = group.findViewById(R.id.rbSsd);
                RadioButton checkedHDD = group.findViewById(R.id.rbHdd);
                RadioButton checkedPsu = group.findViewById(R.id.rbPsu);
                if (checkedSSD.isChecked()){
                    rvCPUPartResult.setVisibility(View.INVISIBLE);
                    rvVgaPartResult.setVisibility(View.INVISIBLE);
                    rvMbPartResult.setVisibility(View.INVISIBLE);
                    rvRamPartResult.setVisibility(View.INVISIBLE);
                    rvHddPartResult.setVisibility(View.INVISIBLE);
                    rvPsuPartResult.setVisibility(View.INVISIBLE);
                    rvFanPartResult.setVisibility(View.INVISIBLE);
                    rvCasePartResult.setVisibility(View.INVISIBLE);
                    rvMonitorPartResult.setVisibility(View.INVISIBLE);
                    rvCpuCoollingPartResult.setVisibility(View.INVISIBLE);
                    rvVgaCoollingPartResult.setVisibility(View.INVISIBLE);
                    rvSsdPartResult.setVisibility(View.VISIBLE);
                    InitSsdList();
//                    Toast toast=Toast.makeText(Pc_part_screen.this,"test",   Toast.LENGTH_SHORT);
//                    toast.show();
                }
                else if (checkedHDD.isChecked()){
                    rvCPUPartResult.setVisibility(View.INVISIBLE);
                    rvVgaPartResult.setVisibility(View.INVISIBLE);
                    rvMbPartResult.setVisibility(View.INVISIBLE);
                    rvRamPartResult.setVisibility(View.INVISIBLE);
                    rvSsdPartResult.setVisibility(View.INVISIBLE);
                    rvPsuPartResult.setVisibility(View.INVISIBLE);
                    rvFanPartResult.setVisibility(View.INVISIBLE);
                    rvCasePartResult.setVisibility(View.INVISIBLE);
                    rvMonitorPartResult.setVisibility(View.INVISIBLE);
                    rvCpuCoollingPartResult.setVisibility(View.INVISIBLE);
                    rvVgaCoollingPartResult.setVisibility(View.INVISIBLE);
                    rvHddPartResult.setVisibility(View.VISIBLE);
                    InitHddList();
                }
                else if (checkedPsu.isChecked()){
                    rvCPUPartResult.setVisibility(View.INVISIBLE);
                    rvVgaPartResult.setVisibility(View.INVISIBLE);
                    rvMbPartResult.setVisibility(View.INVISIBLE);
                    rvRamPartResult.setVisibility(View.INVISIBLE);
                    rvSsdPartResult.setVisibility(View.INVISIBLE);
                    rvHddPartResult.setVisibility(View.INVISIBLE);
                    rvFanPartResult.setVisibility(View.INVISIBLE);
                    rvCasePartResult.setVisibility(View.INVISIBLE);
                    rvMonitorPartResult.setVisibility(View.INVISIBLE);
                    rvCpuCoollingPartResult.setVisibility(View.INVISIBLE);
                    rvVgaCoollingPartResult.setVisibility(View.INVISIBLE);
                    rvPsuPartResult.setVisibility(View.VISIBLE);
                    InitPsuList();
                }
                else {
                    rvCPUPartResult.setVisibility(View.INVISIBLE);
                    rvVgaPartResult.setVisibility(View.INVISIBLE);
                    rvMbPartResult.setVisibility(View.INVISIBLE);
                    rvRamPartResult.setVisibility(View.INVISIBLE);
                    rvSsdPartResult.setVisibility(View.INVISIBLE);
                    rvHddPartResult.setVisibility(View.INVISIBLE);
                    rvPsuPartResult.setVisibility(View.INVISIBLE);
                    rvCasePartResult.setVisibility(View.INVISIBLE);
                    rvMonitorPartResult.setVisibility(View.INVISIBLE);
                    rvCpuCoollingPartResult.setVisibility(View.INVISIBLE);
                    rvVgaCoollingPartResult.setVisibility(View.INVISIBLE);
                    rvFanPartResult.setVisibility(View.VISIBLE);
                    InitFanList();
                }
            }
        }
    };
    //endregion
    //region radio row 3
    private RadioGroup.OnCheckedChangeListener listener3 = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId != -1) {
                rdgA.setOnCheckedChangeListener(null);
                rdgA.clearCheck();
                rdgA.setOnCheckedChangeListener(listener1);
                rdgB.setOnCheckedChangeListener(null);
                rdgB.clearCheck();
                rdgB.setOnCheckedChangeListener(listener2);
                RadioButton checkedCase = group.findViewById(R.id.rbCase);
                RadioButton checkedMonitor = group.findViewById(R.id.rbMonitor);
                RadioButton checkedCpuCoolling = group.findViewById(R.id.rbCpuCoolling);
                if (checkedCase.isChecked()){
                    rvCPUPartResult.setVisibility(View.INVISIBLE);
                    rvVgaPartResult.setVisibility(View.INVISIBLE);
                    rvMbPartResult.setVisibility(View.INVISIBLE);
                    rvRamPartResult.setVisibility(View.INVISIBLE);
                    rvSsdPartResult.setVisibility(View.INVISIBLE);
                    rvHddPartResult.setVisibility(View.INVISIBLE);
                    rvPsuPartResult.setVisibility(View.INVISIBLE);
                    rvFanPartResult.setVisibility(View.INVISIBLE);
                    rvMonitorPartResult.setVisibility(View.INVISIBLE);
                    rvCpuCoollingPartResult.setVisibility(View.INVISIBLE);
                    rvVgaCoollingPartResult.setVisibility(View.INVISIBLE);
                    rvCasePartResult.setVisibility(View.VISIBLE);
                    InitCaseList();
//                    Toast toast=Toast.makeText(Pc_part_screen.this,"test",   Toast.LENGTH_SHORT);
//                    toast.show();
                    rbSsd.setChecked(false);
                    rbVga.setChecked(false);
                    rbCpu.setChecked(false);
                    rbMonitor.setChecked(false);
                }
                else if (checkedMonitor.isChecked()){
                    rvCPUPartResult.setVisibility(View.INVISIBLE);
                    rvVgaPartResult.setVisibility(View.INVISIBLE);
                    rvMbPartResult.setVisibility(View.INVISIBLE);
                    rvRamPartResult.setVisibility(View.INVISIBLE);
                    rvSsdPartResult.setVisibility(View.INVISIBLE);
                    rvHddPartResult.setVisibility(View.INVISIBLE);
                    rvPsuPartResult.setVisibility(View.INVISIBLE);
                    rvFanPartResult.setVisibility(View.INVISIBLE);
                    rvCasePartResult.setVisibility(View.INVISIBLE);
                    rvCpuCoollingPartResult.setVisibility(View.INVISIBLE);
                    rvVgaCoollingPartResult.setVisibility(View.INVISIBLE);
                    rvMonitorPartResult.setVisibility(View.VISIBLE);
                    InitMonitorList();
                }
                else if (checkedCpuCoolling.isChecked()){
                    rvCPUPartResult.setVisibility(View.INVISIBLE);
                    rvVgaPartResult.setVisibility(View.INVISIBLE);
                    rvMbPartResult.setVisibility(View.INVISIBLE);
                    rvRamPartResult.setVisibility(View.INVISIBLE);
                    rvSsdPartResult.setVisibility(View.INVISIBLE);
                    rvHddPartResult.setVisibility(View.INVISIBLE);
                    rvPsuPartResult.setVisibility(View.INVISIBLE);
                    rvFanPartResult.setVisibility(View.INVISIBLE);
                    rvCasePartResult.setVisibility(View.INVISIBLE);
                    rvMonitorPartResult.setVisibility(View.INVISIBLE);
                    rvVgaCoollingPartResult.setVisibility(View.INVISIBLE);
                    rvCpuCoollingPartResult.setVisibility(View.VISIBLE);
                    InitCpuCoollingList();
                }
                else {
                    rvCPUPartResult.setVisibility(View.INVISIBLE);
                    rvVgaPartResult.setVisibility(View.INVISIBLE);
                    rvMbPartResult.setVisibility(View.INVISIBLE);
                    rvRamPartResult.setVisibility(View.INVISIBLE);
                    rvSsdPartResult.setVisibility(View.INVISIBLE);
                    rvHddPartResult.setVisibility(View.INVISIBLE);
                    rvPsuPartResult.setVisibility(View.INVISIBLE);
                    rvFanPartResult.setVisibility(View.INVISIBLE);
                    rvCasePartResult.setVisibility(View.INVISIBLE);
                    rvMonitorPartResult.setVisibility(View.INVISIBLE);
                    rvCpuCoollingPartResult.setVisibility(View.INVISIBLE);
                    rvVgaCoollingPartResult.setVisibility(View.VISIBLE);
//                    InitVgaCoollingList();
                }
            }
        }
    };
    //endregion
    //region init part list func
    private void InitCpuList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        cpuAdapter = new CpuAdapter(this,_cpu);
        rvCPUPartResult.setAdapter(cpuAdapter);
        rvCPUPartResult.setLayoutManager(linearLayoutManager);
    }
    private void InitVgaList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        vgaAdapter = new VgaAdapter(this,_vga);
        rvVgaPartResult.setAdapter(vgaAdapter);
        rvVgaPartResult.setLayoutManager(linearLayoutManager);
    }
    private void InitRamList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        ramAdapter = new RamAdapter(this,_ram);
        rvRamPartResult.setAdapter(ramAdapter);
        rvRamPartResult.setLayoutManager(linearLayoutManager);
    }
    private void InitMbList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mbAdapter = new MbAdapter(this,_mb);
        rvMbPartResult.setAdapter(mbAdapter);
        rvMbPartResult.setLayoutManager(linearLayoutManager);
    }
    private void InitSsdList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        ssdAdapter = new SsdAdapter(this,_ssd);
        rvSsdPartResult.setAdapter(ssdAdapter);
        rvSsdPartResult.setLayoutManager(linearLayoutManager);
    }
    private void InitHddList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        hddAdapter = new HddAdapter(this,_hdd);
        rvHddPartResult.setAdapter(hddAdapter);
        rvHddPartResult.setLayoutManager(linearLayoutManager);
    }
    private void InitPsuList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        psuAdapter = new PsuAdapter(this,_psu);
        rvPsuPartResult.setAdapter(psuAdapter);
        rvPsuPartResult.setLayoutManager(linearLayoutManager);
    }
    private void InitFanList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        fanAdapter = new FanAdapter(this,_fan);
        rvFanPartResult.setAdapter(fanAdapter);
        rvFanPartResult.setLayoutManager(linearLayoutManager);
    }
    private void InitCaseList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        caseAdapter = new CaseAdapter(this,_case);
        rvCasePartResult.setAdapter(caseAdapter);
        rvCasePartResult.setLayoutManager(linearLayoutManager);
    }
    private void InitMonitorList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        monitorAdapter = new MonitorAdapter(this,_monitor);
        rvMonitorPartResult.setAdapter(monitorAdapter);
        rvMonitorPartResult.setLayoutManager(linearLayoutManager);
    }
    private void InitCpuCoollingList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        cpucoolingcdapter = new CpuCoolingAdapter(this,_cpucooling);
        rvCpuCoollingPartResult.setAdapter(cpucoolingcdapter);
        rvCpuCoollingPartResult.setLayoutManager(linearLayoutManager);
    }
//    private void InitVgaCoollingList() {
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        vgacoolingAdapter = new VgaCoolingAdapter(this,_vgacooling);
//        rvVgaCoollingPartResult.setAdapter(vgacoolingAdapter);
//        rvFanPartResult.setLayoutManager(linearLayoutManager);
//    }
    //endregion
    private void Searchrv(){
        svPartSearch.addTextChangedListener(new TextWatcher() {
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
    //TODO: thêm cho hdd psu cpucool case fan monitor
    private void filter(String text) {
        List<CPU> newCpuList = new ArrayList<>();
        List<Vga> newVgaList = new ArrayList<>();
        List<Mainbroad> newMbList = new ArrayList<>();
        List<Ram> newRamList = new ArrayList<>();
        if (text.isEmpty())
        {
            newCpuList.addAll(_cpu);
            newVgaList.addAll(_vga);
            newMbList.addAll(_mb);
            newRamList.addAll(_ram);
        }else {
            for (CPU cpuitem: _cpu){
                if (cpuitem.getmName().toLowerCase().contains(text.toString().toLowerCase())){
                    newCpuList.add(cpuitem);
                }
            }
            for (Vga vgaitem: _vga){
                if (vgaitem.getmName().toLowerCase().contains(text.toString().toLowerCase())){
                    newVgaList.add(vgaitem);
                }
            }
            for (Mainbroad mbitem: _mb){
                if (mbitem.getmName().toLowerCase().contains(text.toString().toLowerCase())){
                    newMbList.add(mbitem);
                }
            }
            for (Ram ramitem: _ram){
                if (ramitem.getmName().toLowerCase().contains(text.toString().toLowerCase())){
                    newRamList.add(ramitem);
                }
            }
        }
        mCPuAll.clear();
        mCPuAll.addAll(newCpuList);
        cpuAdapter = new CpuAdapter(this,mCPuAll);
        rvCPUPartResult.setAdapter(cpuAdapter);
        cpuAdapter.notifyDataSetChanged();

        mVgaAll.clear();
        mVgaAll.addAll(newVgaList);
        vgaAdapter = new VgaAdapter(this,mVgaAll);
        rvVgaPartResult.setAdapter(vgaAdapter);
        vgaAdapter.notifyDataSetChanged();

        mMbAll.clear();
        mMbAll.addAll(newMbList);
        mbAdapter = new MbAdapter(this,mMbAll);
        rvMbPartResult.setAdapter(mbAdapter);
        mbAdapter.notifyDataSetChanged();

        mRamAll.clear();
        mRamAll.addAll(newRamList);
        ramAdapter = new RamAdapter(this,mRamAll);
        rvRamPartResult.setAdapter(ramAdapter);
        ramAdapter.notifyDataSetChanged();

    }
    public void btnLaptopBackHomeClick(View view) {
        finish();
    }

}