package cn.mycommons.xiaoxiazhihu.biz.api.impl.retrofit;

import android.arch.lifecycle.LiveData;

import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetAllThemesResponse;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetLastThemeResponse;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetLongCommentsResponse;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetNewsResponse;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetShortCommentsResponse;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetStartInfoResponse;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetStoryExtraResponse;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetThemeResponse;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * IZhihuApi <br/>
 * Created by xiaqiulei on 2016-01-10.
 */
public interface IZhihuRetrofitApi {

    @GET("api/4/start-image/{width}*{height}")
    LiveData<GetStartInfoResponse> getStartInfoResponse(@Path("width") int width, @Path("height") int height);

    @GET("api/4/themes")
    LiveData<GetAllThemesResponse> getAllThemesResponse();

    @GET("/api/4/news/latest")
    LiveData<GetLastThemeResponse> getLastThemeResponse();

    @GET("api/4/news/{id}")
    LiveData<GetNewsResponse> getNewsResponse(@Path("id") int id);

    @GET("api/4/theme/{id}")
    LiveData<GetThemeResponse> getThemeResponse(@Path("id") int id);

    @GET("api/4/story-extra/{id}")
    LiveData<GetStoryExtraResponse> getStoryExtraResponse(@Path("id") int id);

    @GET("api/4/story/{id}/short-comments")
    LiveData<GetShortCommentsResponse> getShortComments(@Path("id") int id);

    @GET("api/4/story/{id}/long-comments")
    LiveData<GetLongCommentsResponse> getLongComments(@Path("id") int id);
}