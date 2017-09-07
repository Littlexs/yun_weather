package com.sunday.android.yun.yunweather.dagger_test.leak_test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.sunday.android.yun.yunweather.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LeakMainActivity extends AppCompatActivity {


    @BindView(R.id.tvDo)
    Button tvDo;
    @BindView(R.id.tvInfo)
    TextView tvInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak_test1);
        ButterKnife.bind(this);
        tvDo.setText("进入泄漏页面");
    }

    @OnClick(R.id.tvDo)
    public void onViewClicked() {
        Intent intent = new Intent(LeakMainActivity.this,LeakTest1Activity.class);
        startActivity(intent);
    }

}
