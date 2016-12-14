package cn.mycommons.xiaoxiazhihu.app;

import com.google.gson.TypeAdapterFactory;
import com.ryanharter.auto.value.gson.GsonTypeAdapterFactory;

/**
 * AdapterFactory <br/>
 * Created by xiaqiulei on 2016-12-14.
 */
@GsonTypeAdapterFactory
abstract class AdapterFactory implements TypeAdapterFactory {

    public static TypeAdapterFactory create() {
        return new AutoValueGson_AdapterFactory();
    }
}