package cn.mycommons.xiaoxiazhihu.app;

import android.arch.lifecycle.ViewModelProvider;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import cn.mycommons.xiaoxiazhihu.biz.api.ZhihuApi;
import cn.mycommons.xiaoxiazhihu.biz.api.impl.OkHttpUtil;
import cn.mycommons.xiaoxiazhihu.biz.api.impl.okhttp.ZhihuApiOkHttpImpl;
import cn.mycommons.xiaoxiazhihu.biz.api.impl.retrofit.IZhihuRetrofitApi;
import cn.mycommons.xiaoxiazhihu.biz.api.impl.retrofit.RetrofitUtil;
import cn.mycommons.xiaoxiazhihu.biz.api.impl.retrofit.ZhihuApiRetrofitImpl;
import cn.mycommons.xiaoxiazhihu.viewmodel.ViewModelFactory;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * AppModule <br/>
 * Created by xiaqiulei on 2016-06-29.
 */

@Module(subcomponents = ViewModelSubComponent.class)
class AppModule {

    // @Provides
    ZhihuApi providerZhihuApi(IZhihuRetrofitApi zhihuRetrofitApi) {
        return new ZhihuApiRetrofitImpl(zhihuRetrofitApi);
    }

    @Provides
    ZhihuApi providerZhihuApi(OkHttpClient client) {
        return new ZhihuApiOkHttpImpl(client);
    }

    @Provides
    @Singleton
    OkHttpClient providerOkHttpClient() {
        return OkHttpUtil.newOkHttpClient();
    }

    @Provides
    IZhihuRetrofitApi providerIZhihuRetrofitApi(OkHttpClient client, Gson gson) {
        return RetrofitUtil.createApi(IZhihuRetrofitApi.class, client, gson);
    }

    @Provides
    @Singleton
    Gson providerGson() {
        return new GsonBuilder().registerTypeAdapterFactory(AdapterFactory.create()).create();
    }

    @Singleton
    @Provides
    ViewModelProvider.Factory provideViewModelFactory(ViewModelSubComponent.Builder builder) {
        return new ViewModelFactory(builder.build());
    }
}