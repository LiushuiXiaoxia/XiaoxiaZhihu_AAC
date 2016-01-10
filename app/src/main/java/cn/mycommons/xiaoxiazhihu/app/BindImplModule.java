package cn.mycommons.xiaoxiazhihu.app;

import com.google.inject.AbstractModule;

import cn.mycommons.xiaoxiazhihu.business.api.ZhihuApi;
import cn.mycommons.xiaoxiazhihu.business.api.retrofit.ZhihuApiRetrofitImpl;
import cn.mycommons.xiaoxiazhihu.business.domain.ZhihuDomain;
import cn.mycommons.xiaoxiazhihu.business.domain.impl.ZhihuDomainImpl;

/**
 * BindImplModule <br/>
 * Created by xiaqiulei on 2015-12-30.
 */
public class BindImplModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(ZhihuDomain.class).to(ZhihuDomainImpl.class);
//        bind(ZhihuApi.class).to(ZhihuApiOkHttpImpl.class);
        bind(ZhihuApi.class).to(ZhihuApiRetrofitImpl.class);
    }
}