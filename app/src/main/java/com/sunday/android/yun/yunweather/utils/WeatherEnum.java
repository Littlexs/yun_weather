package com.sunday.android.yun.yunweather.utils;

/**
 * Created by yun_sheng on 2017/8/17.
 * 天气状况代码和图标序号
 */

public enum WeatherEnum {
    Sunny("晴",100),
    Cloudy("多云",101),
    FewClouds("少云",102),
    PartlyCloudy("晴间多云",103),
    Overcast("阴",104),
    Windy("有风",200),
    Calm("平静",201),
    LightBreeze("微风",202),
    Moderate("和风",203),
    FreshBreeze("清风",204),
    StrongBreeze("强风/劲风",205),
    HighWind("疾风",206),
    Gale("大风",207),
    StrongGale("烈风",208),
    Storm("风暴",209),
    ViolentStorm("狂爆风",210),
    Hurricane("飓风",211),
    Tornado("龙卷风",212),
    TropicalStorm("热带风暴",213),
    ShowerRain("阵雨",300),
    HeavyShowerRain("强阵雨",301),
    Thundershower("雷阵雨",302),
    HeavyThunderstorm("强雷阵雨",303),
    Hail("雷阵雨伴有冰雹",304),
    LightRain("小雨",305),
    ModerateRain("小雨",306),
    HeavyRain("大雨",307),
    ExtremeRain("极端降雨",308),
    DrizzleRain("毛毛雨/细雨",309),
    StormRain("暴雨",310),
    HeavyStorm("大暴雨",311),
    SevereStorm("特大暴雨",312),
    FreezingRain("冻雨",313),
    LightSnow("小雪",400),
    ModerateSnow("中雪",401),
    HeavySnow("大雪",402),
    Snowstorm("暴雪",403),
    Sleet("雨夹雪",404),
    RainAndSnow("雨雪天气",405),
    ShowerSnow("阵雨夹雪",406),
    SnowFlurry("阵雪",407),
    Mist("薄雾",500),
    Foggy("雾",501),
    Haze("霾",502),
    Sand("扬沙",503),
    Dust("浮尘",504),
    Duststorm("沙尘暴",507),
    Sandstorm("强沙尘暴",508),
    Hot("热",900),
    Cold("冷",901),
    Unknown("未知",999);

    private String name;
    private int index;
    private WeatherEnum(String name,int i){
        this.name = name;
        this.index = i;
    }
    @Override
    public String toString() {
        return this.index+"--"+this.name;
    }
}
