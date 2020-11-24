package io.vacnex.buildmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import io.vacnex.buildmaster.model.Checkout;
import io.vacnex.buildmaster.model.Fan;
import io.vacnex.buildmaster.model.HDD;
import io.vacnex.buildmaster.model.Monitor;
import io.vacnex.buildmaster.model.Ram;
import io.vacnex.buildmaster.model.SSD;
import io.vacnex.buildmaster.model.Vga;

public class Pc_build_checkout extends AppCompatActivity {
    TextView txtCpuName,txtCpuPrice,txtMbName,txtMbPrice,txtPsuName,txtPsuPrice,txtCpuCoolingName,txtCpuCoolingPrice,txtCaseName,txtCasePrice;
    ListView lvVga,lvRam,lvSsd,lvHdd,lvFan,lvMoniter;
    Checkout checkout;
    List<Vga> listvga;
    List<Ram> listram;
    List<SSD> listssd;
    List<HDD> listhdd;
    List<Fan> listfan;
    List<Monitor> listmonitor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pc_build_checkout);
        Init();
        Intent i = getIntent();
        checkout = null;
        checkout = (Checkout) i.getSerializableExtra("pc_build_checkout");
        listvga.addAll(checkout.getmVga());
        listram.addAll(checkout.getmRam());
        listssd.addAll(checkout.getmSsd());
        listhdd.addAll(checkout.getmHdd());
        listfan.addAll(checkout.getmFan());
        listmonitor.addAll(checkout.getmMonitor());

        txtCpuName.setText(checkout.getmCpu().get(0).getmName());
        txtCpuPrice.setText(checkout.getmCpu().get(0).getmPrice());

        txtMbName.setText(checkout.getmMainbroad().get(0).getmName());
        txtMbPrice.setText(checkout.getmMainbroad().get(0).getmPrice());

        txtPsuName.setText(checkout.getmPsu().get(0).getmName());
        txtPsuPrice.setText(checkout.getmPsu().get(0).getmPrice());

        txtCpuCoolingName.setText(checkout.getmCpuCool().get(0).getmName());
        txtCpuCoolingPrice.setText(checkout.getmCpuCool().get(0).getmPrice());

        txtCaseName.setText(checkout.getmCase().get(0).getmName());
        txtCasePrice.setText(checkout.getmCase().get(0).getmPrice());

        ArrayAdapter<Vga> arrayVgaAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listvga);
        ArrayAdapter<Ram> arrayRamAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listram);
        ArrayAdapter<SSD> arraySsdAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listssd);
        ArrayAdapter<HDD> arrayHddAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listhdd);
        ArrayAdapter<Fan> arrayFanAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listfan);
        ArrayAdapter<Monitor> arrayMonitorAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listmonitor);

        lvVga.setAdapter(arrayVgaAdapter);
        lvRam.setAdapter(arrayRamAdapter);
        lvSsd.setAdapter(arraySsdAdapter);
        lvHdd.setAdapter(arrayHddAdapter);
        lvFan.setAdapter(arrayFanAdapter);
        lvMoniter.setAdapter(arrayMonitorAdapter);
        Utility.setListViewHeightBasedOnChildren(lvVga);
        Utility.setListViewHeightBasedOnChildren(lvRam);
        Utility.setListViewHeightBasedOnChildren(lvSsd);
        Utility.setListViewHeightBasedOnChildren(lvHdd);
        Utility.setListViewHeightBasedOnChildren(lvFan);
        Utility.setListViewHeightBasedOnChildren(lvMoniter);
    }

    private void Init() {
        txtCpuName = findViewById(R.id.txtCpuName);
        txtCpuPrice = findViewById(R.id.txtCpuPrice);
        txtMbName = findViewById(R.id.txtMbName);
        txtMbPrice = findViewById(R.id.txtMbPrice);
        txtPsuName = findViewById(R.id.txtPsuName);
        txtPsuPrice = findViewById(R.id.txtPsuPrice);
        txtCpuCoolingName = findViewById(R.id.txtCpuCoolingName);
        txtCpuCoolingPrice = findViewById(R.id.txtCpuCoolingPrice);
        txtCaseName = findViewById(R.id.txtCaseName);
        txtCasePrice = findViewById(R.id.txtCasePrice);
        lvVga = findViewById(R.id.lvVga);
        lvRam = findViewById(R.id.lvRam);
        lvSsd = findViewById(R.id.lvSsd);
        lvHdd = findViewById(R.id.lvHdd);
        lvFan = findViewById(R.id.lvFan);
        lvMoniter = findViewById(R.id.lvMoniter);
        listvga = new ArrayList<>();
        listram = new ArrayList<>();
        listssd = new ArrayList<>();
        listhdd = new ArrayList<>();
        listfan = new ArrayList<>();
        listmonitor= new ArrayList<>();
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        txtCpuName.setText("");
//        txtCpuPrice.setText("");
//        txtMbName.setText("");
//        txtMbPrice.setText("");
//        txtPsuName.setText("");
//        txtPsuPrice.setText("");
//        txtCpuCoolingName.setText("");
//        txtCpuCoolingPrice.setText("");
//        txtCaseName.setText("");
//        txtCasePrice.setText("");
//        lvVga.setAdapter(null);
//        lvRam.setAdapter(null);
//        lvSsd.setAdapter(null);
//        lvHdd.setAdapter(null);
//        lvFan.setAdapter(null);
//        lvMoniter.setAdapter(null);
//    }

    public void btnBackBuildScreenClick(View view) {
        finish();
    }

    public void btnNextSaveScreenClick(View view) {
        Intent intent = new Intent(Pc_build_checkout.this,Pc_buid_save.class);
        startActivity(intent);
    }
}