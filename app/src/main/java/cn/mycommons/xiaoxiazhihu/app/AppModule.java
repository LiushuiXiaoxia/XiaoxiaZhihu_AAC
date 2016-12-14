package cn.mycommons.xiaoxiazhihu.app;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import cn.mycommons.xiaoxiazhihu.biz.api.ZhihuApi;
import cn.mycommons.xiaoxiazhihu.biz.api.impl.OkHttpUtil;
import cn.mycommons.xiaoxiazhihu.biz.api.impl.okhttp.ZhihuApiOkHttpImpl;
import cn.mycommons.xiaoxiazhihu.biz.api.impl.retrofit.IZhihuRetorfitApi;
import cn.mycommons.xiaoxiazhihu.biz.api.impl.retrofit.RetrofitUtil;
import cn.mycommons.xiaoxiazhihu.biz.api.impl.retrofit.ZhihuApiRetrofitImpl;
import cn.mycommons.xiaoxiazhihu.biz.domain.ZhihuDomain;
import cn.mycommons.xiaoxiazhihu.biz.domain.impl.ZhihuDomainImpl;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * AppModule <br/>
 * Created by xiaqiulei on 2016-06-29.
 */

@Module
class AppModule {

    @Provides
    ZhihuDomain providerZhihuDomain(ZhihuApi zhihuApi) {
        return new ZhihuDomainImpl(zhihuApi);
    }

    @Provides
    ZhihuApi providerZhihuApi(IZhihuRetorfitApi zhihuRetorfitApi) {
        return new ZhihuApiRetrofitImpl(zhihuRetorfitApi);
    }

    // @Provides
    ZhihuApi providerZhihuApi(OkHttpClient client) {
        return new ZhihuApiOkHttpImpl(client);
    }

    @Provides
    @Singleton
    OkHttpClient providerOkHttpClient() {
        return OkHttpUtil.newOkHttpClient();
    }

    @Provides
    IZhihuRetorfitApi providerIZhihuRetorfitApi(OkHttpClient client, Gson gson) {
        return RetrofitUtil.createApi(IZhihuRetorfitApi.class, client, gson);
    }

    @Provides
    @Singleton
    Gson providerGson() {
        return new GsonBuilder().registerTypeAdapterFactory(AdapterFactory.create()).create();
    }
}