package com.sunday.android.yun.yunweather.dagger_test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.sunday.android.yun.yunweather.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestActivity extends AppCompatActivity implements MyContract.View {

    @BindView(R.id.btn)
    Button btn;
    @BindView(R.id.tvInfo)
    TextView tvInfo;

    @Inject
    MyPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);

        DaggerMyComponent.builder().myModel(new MyModel(this)).build().inject(this);

    }

    @OnClick(R.id.btn)
    public void onViewClicked() {
        presenter.loadData("test");
    }

    @Override
    public void show(Object o) {
        tvInfo.setText("返回值");
    }
}
