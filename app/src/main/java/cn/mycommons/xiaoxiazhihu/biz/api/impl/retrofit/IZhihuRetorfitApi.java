package cn.mycommons.xiaoxiazhihu.biz.api.impl.retrofit;

import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetAllThemesResponse;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetLastThemeResponse;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetLongCommentsResponse;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetNewsResponse;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetShortCommentsResponse;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetStartInfoResponse;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetStoryExtraResponse;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetThemeResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * IZhihuApi <br/>
 * Created by xiaqiulei on 2016-01-10.
 */
public interface IZhihuRetorfitApi {

    @GET("api/4/start-image/{width}*{height}")
    Call<GetStartInfoResponse> getStartInfoResponse(@Path("width") int width, @Path("height") int height);

    @GET("api/4/themes")
    Call<GetAllThemesResponse> getAllThemesResponse();

    @GET("/api/4/news/latest")
    Call<GetLastThemeResponse> getLastThemeResponse();

    @GET("api/4/news/{id}")
    Call<GetNewsResponse> getNewsResponse(@Path("id") int id);

    @GET("api/4/theme/{id}")
    Call<GetThemeResponse> getThemeResponse(@Path("id") int id);

    @GET("api/4/story-extra/{id}")
    Call<GetStoryExtraResponse> getStoryExtraResponse(@Path("id") int id);

    @GET("api/4/story/{id}/short-comments")
    Call<GetShortCommentsResponse> getShortComments(@Path("id") int id);

    @GET("api/4/story/{id}/long-comments")
    Call<GetLongCommentsResponse> getLongComments(@Path("id") int id);
}