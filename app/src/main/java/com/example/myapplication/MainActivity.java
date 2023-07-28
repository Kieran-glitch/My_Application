package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     private String[] permissions_mine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        permissions_mine=new String[]{Manifest.permission.CALL_PHONE};

        if(!hasPermissions(MainActivity.this,permissions_mine)){
            ActivityCompat.requestPermissions(MainActivity.this,permissions_mine,1);
        }
    }
    private boolean hasPermissions(Context context,String... PERMISSIONS) {
        if(context != null && PERMISSIONS != null){
            for(String permission:PERMISSIONS){
                if(ActivityCompat.checkSelfPermission(context,permission)!= PackageManager.PERMISSION_GRANTED){
                    return false;
                }
            }
        }
        return true;
    }
    public void onRequestPermissionsResult(int requestCode,String[] permissions,int[] grantResults){
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//Check if request code is granted.
        if (requestCode == 1) {
//if permission is granted
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Calling Permission is granted", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, "Calling Permission is denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
}

