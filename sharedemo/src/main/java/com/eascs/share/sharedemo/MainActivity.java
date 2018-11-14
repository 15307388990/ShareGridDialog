package com.eascs.share.sharedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_1;
    private Button btn_2;
    private Button btn_3;
    private Button btn_4;
    private Button btn_5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }


    private void initView() {
        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_4 = (Button) findViewById(R.id.btn_4);
        btn_5 = (Button) findViewById(R.id.btn_5);

        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_1:
                YDShareUtils.showGoodsDetailShareDialog(MainActivity.this);
                break;
            case R.id.btn_2:
                YDShareUtils.showActivityShareDialog(MainActivity.this);
                break;
            case R.id.btn_3:
                YDShareUtils.showInvoiceShareDialog(MainActivity.this);
                break;
            case R.id.btn_4:
                YDShareUtils.showFundShareDialog(MainActivity.this);
                break;
            case R.id.btn_5:
                YDShareUtils.showOtherDialog(MainActivity.this);
                break;
        }
    }
}
