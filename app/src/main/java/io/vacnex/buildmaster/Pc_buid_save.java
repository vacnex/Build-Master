package io.vacnex.buildmaster;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Pc_buid_save extends AppCompatActivity {
    EditText SaveBuildName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pc_buid_save);
    }

    public void btnBackCheckoutScreenClick(View view) {
        finish();
    }

    public void btnSaveClick(View view) {
        SaveBuildName = findViewById(R.id.SaveBuildName);
        if( TextUtils.isEmpty(SaveBuildName.getText())){
            SaveBuildName.setError(getString(R.string.require));
        }else{
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);
        }
    }
}