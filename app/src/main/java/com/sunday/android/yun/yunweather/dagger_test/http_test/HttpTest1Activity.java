package com.sunday.android.yun.yunweather.dagger_test.http_test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.sunday.android.yun.yunweather.BaseApp;
import com.sunday.android.yun.yunweather.R;
import com.sunday.android.yun.yunweather.dagger_test.type_inject_test.test1.BClass;
import com.sunday.android.yun.yunweather.entity.Weather;
import com.sunday.android.yun.yunweather.http.Api;
import com.sunday.android.yun.yunweather.http.ApiClient;
import com.sunday.android.yun.yunweather.http.RxUtils;
import com.sunday.android.yun.yunweather.utils.ToastUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class HttpTest1Activity extends AppCompatActivity {


    @BindView(R.id.tvDo)
    Button tvDo;
    @BindView(R.id.tvInfo)
    TextView tvInfo;

    @Inject
    Api api;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_test1);
        ButterKnife.bind(this);
        AppComponent appComponent = ((BaseApp) getApplication()).getAppComponent();
        DaggerActivityComponent.builder().appComponent(appComponent).activityTest1Module(new ActivityTest1Module(new BClass("sd"))).build().inject(this);
    }

    @OnClick(R.id.tvDo)
    public void onViewClicked() {
        api.getMainInfo("杭州", ApiClient.APP_KEY)
                .doOnSubscribe((disposable) -> Log.i("-----","   请求中....."))
                .compose(RxUtils.schedulerTransformer(Schedulers.io()))
                .subscribe(new Consumer<Weather>() {
                    @Override
                    public void accept(Weather weather) throws Exception {
                        tvInfo.setText(weather.getHeWeather5().toString());
                    }
                },throwable ->   ToastUtils.showToast(getApplicationContext(), "网络异常"));

    }

}
