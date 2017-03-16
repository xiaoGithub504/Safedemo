package com.example.xiao.safetydemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void click(View v){
        switch (v.getId()){
            case R.id.btn_01:
                String cpuInfo = simulatorModule.readCpuInfo();
                if(simulatorModule.checkFiles()||(cpuInfo.contains("intel") || cpuInfo.contains("amd"))){  //检测是否是模拟器环境
                    Toast.makeText(MainActivity.this,"模拟器检测到了",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this,"模拟器检没有测到了",Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.btn_02:
                Intent intent=new Intent(MainActivity.this,TestActivity.class);
                startActivity(intent);
                break;
        }
    }
}
