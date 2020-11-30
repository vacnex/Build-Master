package io.vacnex.buildmaster;


import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

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

public class MainActivity extends AppCompatActivity {
    //region CPU DATABASE
    public CPU[] cpus = {
            new CPU("Intel Core i9-10850K","Comet Lake","14 nm","10","20","3.60 GHz" ,"5.20 GHz" ,"20 MB","125 W","128 GB","DDR4-2933","Intel UHD Graphics 630","FCLGA1200","None", "$453 - $464"),
            new CPU("Intel Core i9-10885H","Comet Lake","14 nm","8","16","2.40 GHz" ,"5.30 GHz" ,"16 MB","45 W","128 GB","DDR4-2933","Intel® UHD Graphics 630","FCBGA1440","None", "$556"),
            new CPU("Intel Core i9-10900","Comet Lake","14 nm","10","20","2.80 GHz" ,"5.20 GHz" ,"20 MB","65 W","128 GB","DDR4-2933","Intel® UHD Graphics 630","FCLGA1200","None", "$439 - $449"),
            new CPU("Intel Core i9-10900F","Comet Lake","14 nm","10","20","2.80 GHz" ,"5.20 GHz" ,"20 MB","65 W","128 GB","DDR4-2933","None","FCLGA1200","None", "$488 - $499"),
            new CPU("Intel Core i9-i9-10900KF","Comet Lake","14 nm","10","20","3.70 GHz" ,"5.30 GHz" ,"20 MB","95 W","128 GB","DDR4-2933","None","FCLGA1200","None", "$463 - $474"),
            new CPU("Intel Core i9-10900T","Comet Lake","14 nm","10","20","1.90 GHz" ,"4.60 GHz" ,"20 MB","35 W","128 GB","DDR4-2933","Intel® UHD Graphics 630","FCLGA1200","None", "$439"),
            new CPU("Intel Core i9-10900X X","Cascade Lake","14 nm","10","20","3.70 GHz" ,"4.50 GHz" ,"19,25 MB","165 W","256 GB","DDR4-2933","None","FCLGA2066","None", "$590 - $599"),
            new CPU("Intel Core i9-10920X X","Cascade Lake","14 nm","12","24","3.50 GHz" ,"4.60 GHz" ,"19,25 MB","165 W","256 GB","DDR4-2933","None","FCLGA2066","None", "$689 - $700"),
            new CPU("Intel Core i9-10940X X","Cascade Lake","14 nm","14","28","3.30 GHz" ,"4.60 GHz" ,"19,25 MB","165 W","256 GB","DDR4-2933","None","FCLGA2066","None", "$784 - $797"),
            new CPU("Intel Core i9-10980HK","Comet Lake","14 nm","8","16","2.40 GHz" ,"5.30 GHz" ,"16 MB","65 W","128 GB","DDR4-2933","Intel® UHD Graphics 630","FCBGA1440","None", "$583"),
            new CPU("Intel Core i9-10980XE","Cascade Lake","14 nm","18","36","3.00 GHz" ,"4.60 GHz" ,"24,75 MB","165 W","256 GB","DDR4-2933","None","FCLGA2066","None", "$979 - $1000"),
            new CPU("Intel Core i9-9800X X","SkyLake","14 nm","8","16","3.80 GHz" ,"4.40 GHz" ,"16,5 MB","165 W","128 GB","DDR4-2666","None","FCLGA2066","None", "$589 - $599"),
            new CPU("Intel Core i9-9820X X X","SkyLake","14 nm","10","20","3.30 GHz" ,"4.10 GHz" ,"16,5 MB","165 W","128 GB","DDR4-2666","None","FCLGA2066","None", "$889 - $899"),
            new CPU("Intel Core i9-9880H","Coffee Lake","14 nm","8","16","2.30 GHz" ,"4.80 GHz" ,"16 MB","35 W","128 GB","DDR4-2666 LPDDR3-2133","Intel UHD Graphics 630","FCBGA1440","None", "$556"),
            new CPU("Intel Core i9-9900","Coffee Lake","14 nm","8","16","3.10 GHz" ,"5.00 GHz" ,"16 MB","65 W","128 GB","DDR4-2666","Intel UHD Graphics 630","FCLGA1151","None", "$439 - $449"),
            new CPU("Intel Core i9-9900K","Coffee Lake","14 nm","8","16","3.60 GHz" ,"5.00 GHz" ,"16 MB","95 W","128 GB","DDR4-2666","Intel UHD Graphics 630","FCLGA1151","None", "$488 - $499"),
            new CPU("Intel Core i9-9900KF","Coffee Lake","14 nm","8","16","3.60 GHz" ,"5.00 GHz" ,"16 MB","95 W","128 GB","DDR4-2666","None","FCLGA1151","None", "$463 - $474"),
            new CPU("Intel Core i9-9900KS","Coffee Lake","14 nm","8","16","4.00 GHz" ,"5.00 GHz" ,"16 MB","127 W","128 GB","DDR4-2666","Intel UHD Graphics 630","FCLGA1151","None", "$524"),
            new CPU("Intel Core i9-9900T","Coffee Lake","14 nm","8","16","2.10 GHz" ,"4.40 GHz" ,"16 MB","35 W","128 GB","DDR4-2666","Intel UHD Graphics 630","FCLGA1151","None", "$439"),
            new CPU("Intel Core i9-9900X X","SkyLake","14 nm","10","20","3.50 GHz" ,"4.40 GHz" ,"16 MB","165 W","128 GB","DDR4-2666","None","FCLGA2066","None", "$989 - $999"),
            new CPU("Intel Core i9-9920X X","SkyLake","14 nm","12","24","3.50 GHz" ,"4.40 GHz" ,"19.25 MB","165 W","128 GB","DDR4-2666","None","FCLGA2066","None", "$1189 - $1199"),
            new CPU("Intel Core i9-9940X X","SkyLake","14 nm","14","28","3.30 GHz" ,"4.40 GHz" ,"19.25 MB","165 W","128 GB","DDR4-2666","None","FCLGA2066","None", "$1387 - $1399"),
            new CPU("Intel Core i9-9940X X","SkyLake","14 nm","16","32","3.10 GHz" ,"4.40 GHz" ,"22 MB","165 W","128 GB","DDR4-2666","None","FCLGA2066","None", "$1387 - $1399"),
            new CPU("Intel Core i9-9980HK","Coffee Lake","14 nm","8","16","2.40 GHz" ,"5.00 GHz" ,"16 MB","45 W","128 GB","DDR4-2666, LPDDR3-2133","Intel UHD Graphics 630","FCBGA1440","None", "$583"),
            new CPU("Intel Core i9-9980XE","SkyLake","14 nm","18","36","3.00 GHz" ,"4.40 GHz" ,"24,75 MB","165 W","128 GB","DDR4-2666","None","FCLGA2066","None", "$1979 - $1999"),
            new CPU("Intel Core i9-8950HK","Coffee Lake","14 nm","6","12","2.90 GHz" ,"4.80 GHz" ,"12 MB","45 W","64 GB","DDR4-2666, LPDDR3-2133","Intel UHD Graphics 630","FCBGA1440","None", "$583"),
            new CPU("Intel Core i9-7900X X","SkyLake","14 nm","10","20","3.30 GHz" ,"4.30 GHz" ,"13,75 MB","140 W","128 GB","DDR4-2666","None","FCLGA2066","None", "$989"),
            new CPU("Intel Core i9-7920X X","SkyLake","14 nm","12","24","2.90 GHz" ,"4.30 GHz" ,"16,5 MB","140 W","128 GB","DDR4-2666","None","FCLGA2066","None", "$1189"),
            new CPU("Intel Core i9-7940X X","SkyLake","14 nm","14","28","3.10 GHz" ,"4.30 GHz" ,"19,25 MB","165 W","128 GB","DDR4-2666","None","FCLGA2066","None", "$1387"),
            new CPU("Intel Core i9-7960X X","SkyLake","14 nm","16","32","2.80 GHz" ,"4.20 GHz" ,"22 MB","165 W","128 GB","DDR4-2666","None","FCLGA2066","None", "$1189"),
            new CPU("Intel Core i9-7980XE","SkyLake","14 nm","18","36","2.60 GHz" ,"4.20 GHz" ,"24,75 MB","165 W","128 GB","DDR4-2666","None","FCLGA2066","None", "$1189"),
            new CPU("AMD Ryzen Threadripper 3990X","Matisse","7 nm","64","128","2.90 GHz" ,"4.30 GHz" ,"4 MB + 32 MB + 256 MB","280 W","256 GB","DDR4-3200","None","sTRX4","None", "~$4000"),

    };    //endregion
    //region Vga DATABASE
    public Vga[] vgas = {
            new Vga("MSI GTX 1650 VENTUS XS 4GB OC","Turing","896","1485 MHz","1740 MHz","4 GB", "GDDR5","128 bit","PCIe 3.0 x16","75 W","350 W","1x DVI\n1x HDMI\n1x DisplayPort","None","$191,53 - $364.34"),
    };
    //endregion
    //region Ram DATABASE
    public Ram[] rams = {
            new Ram("Ram PC Kingston","DDR3L","8 GB","1600 MHz","CL11","None", "","N/A"),
            new Ram("Ram PC Corsair Vengeance RGB Pro","DDR4","16 GB","3000 MHz","CL16-20-20-38","Yes", "RGB + OverClock","N/A"),
            new Ram("Ram Laptop G.Skill","DDR3","4 GB","1600 MHz","CL11","None", "","N/A"),
            new Ram("Ram Laptop Crucial","DDR4","32 GB","2666 MHz","CL19","None", "","N/A"),
    };
    //endregion
    //region Mainbroad DATABASE
    public Mainbroad[] mbs = {
            new Mainbroad("Asrock B450M Steel Legend","Asrock","AM4","Micro-ATX ","AMD B450","DDR4", "3533 MHz","2 Channel 4 slots","1x PCI-E 3.0 x16 @ x16\n 1x PCI-E 3.0 x16 @ x4\n 1x PCI-E 2.0 x1 @ x1","AMD: yes\n Nvidia: no","4x SATA3","","N/A"),
            new Mainbroad("Gigabyte B550I Aorus Pro AX","Gigabyte","AM4","Mini-ITX","AMD B550","DDR4", "4866 MHz","2 Channel 2 slots","1x PCI-E 4.0 x16 @ x16","No","4x SATA3","","N/A"),
            new Mainbroad("Gigabyte Z490 Aorus Pro AX","Gigabyte","LGA 1200","ATX","Intel Z490","DDR4", "5000 MHz","2 Channel 4 slots","1x PCI-E 3.0 x16 @ \n1x PCI-E 3.0 x16 @ x8\n 1x PCI-E 3.0 x16 @ x4\n 2x PCI-E 2.0 x1 @ x1","AMD: yes\n Nvidia: yes","6x SATA3","","N/A"),
            new Mainbroad("Gigabyte Z490 Aorus Xtreme Waterforce","Gigabyte","LGA 1200","E-ATX ","Intel Z490","DDR4", "5000 MHz","2 Channel 4 slots","1x PCI-E 3.0 x16 @ \n1x PCI-E 3.0 x16 @ x8\n 1x PCI-E 3.0 x16 @ x4","AMD: yes\n Nvidia: yes","6x SATA3","","N/A"),
    };
    //endregion
    //region SSD DATABASE
    public SSD[] ssds = {
            new SSD("Samsung 970 EVO Plus","PCIe Gen3 x4 NVMe","M.2 2280","1 TB ","3300 MB/s","3500 MB/s", "600 TB","Samsung V-NAND TLC 96-Layers","","N/A"),

    };//endregion
    //region Hdd DTABASE
    public HDD[] hdds = { new HDD("Seagate SkyHawkAi 12TB","Sata III", "3.5 inch","12 TB","~ 250 MB/s","~ 250 MB/s","","7200","256 MB","","N/A")
    };//endregion
    //region Psu DataBase
    public PSU[] psus = { new PSU("Golden Field 600ALP","100 - 240V", "","600W","80 Plus White","1 x 24-pin Main 1 x 8-pin (4+4) CPU 2 x 8-pin (6+2) PCIE 5 x SATA","ATX","","N/A")
    };//endregion
    //region Cpu cooling DataBase
    public CPUCooling[] cpucools = {
            new CPUCooling("Cooler Master Hyper 212","Copper","Aluminium","2x 140x150x25 or 2x 120x120x25"," Intel LGA2066, LGA2011-0 & LGA2011-3 (Square ILM), LGA1156, LGA1155, LGA1151, LGA1150 &\nAMD AM2, AM2+, AM3, AM3+, FM1, FM2, FM2+ (backplate required), AM4 (included since 2019, older coolers require NM-AM4-UxS)","","","","N/A")
    };//endregion
    //region Vga cooling DataBase
    public VgaCooling[] vgacools = {
    };//endregion
    //region Case DataBase
    public Case[] cases = {
            new Case("XIGMATEK NYX 3F RGB","MICRO/MINI TOWER","398 x 195 x 326 mm","Black","Micro-ATX, ITX","USB3.0 x 1 - USB2.0 x1 - Audio in/out x 1 (HD Audio)","2 Tempered Glass","3 FAN XIGMATEK X20F","","Rear 120mm","","N/A")
    };//endregion
    //region Fan DataBase
    public Fan[] fans = {
            new Fan("Deepcool CF 120 Addressable-RGB","120mm","Fan Case","500-1500RPM","27 dBA","Yes","Yes","","N/A")
    };//endregion
    // region Monitor DataBase
    public Monitor[] monitors = {
            new Monitor("LG 24MP59G-P","IPS","16:9","1920 x 1080","75Hz","17W","D-Sub(VGA), Displayport , HDMI","No","Yes","None","","N/A")
    };//endregion
    View tool_bar;
    ImageButton ibtnArchive,ibtnSetting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitControl();
        InitToolbar();
        AlertDialog.Builder builder = new AlertDialog.Builder(this,R.style.AlertDialogTheme);
        builder.setTitle(R.string.dialogTitle).setMessage(R.string.dialogMes);
        builder.setPositiveButton(R.string.dialogOK, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        final AlertDialog dialog = builder.create();
        dialog.show();


    }

    //TODO: Thêm CPU i7 i5 i3 pentium
    //TODO: Thêm activity setting
    //TODO: thêm activity archive
    //TODO: Xử lý xự kiện cho nút archive
    //TODO: Xử lý xự kiện cho nút setting
    //TODO: Thêm các model còn lại
    //TODO: thêm các custom adapter cho từng model
    //TODO: thêm các dialog cho từng loại model
    //TODO: căn xuống dòng cho textview trong các row item
    private void InitControl() {
        tool_bar = (View)findViewById(R.id.tool_bar);
        ibtnArchive = (ImageButton)tool_bar.findViewById(R.id.ibtnArchive);
        ibtnSetting = (ImageButton)tool_bar.findViewById(R.id.ibtnSetting);
    }
    private void InitToolbar() {
        ibtnArchive.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            Toast.makeText(v.getContext(), "You clicked ibtnArchive", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(MainActivity.this, Archive.class);
            startActivity(i);
            }
        });

        ibtnSetting.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "You clicked ibtnSetting", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this, Settings.class);
                startActivity(i);
            }
        });
    }

    public void DesktopClick(View view) {
        Intent intent = new Intent(MainActivity.this, Pc_build_screen.class);
        intent.putExtra("pc_build_cpu",cpus);
        intent.putExtra("pc_build_vga",vgas);
        intent.putExtra("pc_build_ram",rams);
        intent.putExtra("pc_build_mb",mbs);
        intent.putExtra("pc_build_ssd",ssds);
        intent.putExtra("pc_build_hdd",hdds);
        intent.putExtra("pc_build_psu",psus);
        intent.putExtra("pc_build_cpucool",cpucools);
        intent.putExtra("pc_build_vgacool",vgacools);
        intent.putExtra("pc_build_case",cases);
        intent.putExtra("pc_build_fan",fans);
        intent.putExtra("pc_build_monitor",monitors);
        startActivity(intent);
    }
    public void LaptopClick(View view) {
        Toast toast=Toast.makeText(MainActivity.this,"Update Soon",   Toast.LENGTH_SHORT);
        toast.show();
    }
    public void PartClick(View view) {
        Intent intent = new Intent(MainActivity.this, Pc_part_screen.class);
        intent.putExtra("pc_part_cpu",cpus);
        intent.putExtra("pc_part_vga",vgas);
        intent.putExtra("pc_part_ram",rams);
        intent.putExtra("pc_part_mb",mbs);
        intent.putExtra("pc_part_ssd",ssds);
        intent.putExtra("pc_part_hdd",hdds);
        intent.putExtra("pc_part_psu",psus);
        intent.putExtra("pc_part_cpucool",cpucools);
        intent.putExtra("pc_part_vgacool",vgacools);
        intent.putExtra("pc_part_case",cases);
        intent.putExtra("pc_part_fan",fans);
        intent.putExtra("pc_part_monitor",monitors);

        startActivity(intent);
    }



}