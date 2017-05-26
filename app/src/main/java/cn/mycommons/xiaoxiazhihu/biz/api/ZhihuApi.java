package cn.mycommons.xiaoxiazhihu.biz.api;

import android.arch.lifecycle.LiveData;

import cn.mycommons.xiaoxiazhihu.biz.pojo.request.ext.GetAllThemesRequest;
import cn.mycommons.xiaoxiazhihu.biz.pojo.request.ext.GetLastThemeRequest;
import cn.mycommons.xiaoxiazhihu.biz.pojo.request.ext.GetLongCommentsRequest;
import cn.mycommons.xiaoxiazhihu.biz.pojo.request.ext.GetNewsRequest;
import cn.mycommons.xiaoxiazhihu.biz.pojo.request.ext.GetShortCommentsRequest;
import cn.mycommons.xiaoxiazhihu.biz.pojo.request.ext.GetStartInfoRequest;
import cn.mycommons.xiaoxiazhihu.biz.pojo.request.ext.GetStoryExtraRequest;
import cn.mycommons.xiaoxiazhihu.biz.pojo.request.ext.GetThemeRequest;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetAllThemesResponse;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetLastThemeResponse;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetLongCommentsResponse;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetNewsResponse;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetShortCommentsResponse;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetStartInfoResponse;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetStoryExtraResponse;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetThemeResponse;

/**
 * ZhihuApi <br/>
 * Created by xiaqiulei on 2015-12-30.
 */
public interface ZhihuApi {

    // 1.启动界面图像获取
    LiveData<GetStartInfoResponse> getStartInfoResponse(GetStartInfoRequest request);

    // 9.主题日报列表查看
    LiveData<GetAllThemesResponse> getAllThemesResponse(GetAllThemesRequest request);

    // 3.最新消息
    LiveData<GetLastThemeResponse> getLastThemeResponse(GetLastThemeRequest request);

    // 4.消息内容获取与离线下载
    LiveData<GetNewsResponse> getNewsResponse(GetNewsRequest request);

    // 10. 主题日报内容查看
    LiveData<GetThemeResponse> getThemeResponse(GetThemeRequest request);

    // 6.新闻额外信息
    LiveData<GetStoryExtraResponse> getStoryExtraResponse(GetStoryExtraRequest request);

    // 8.新闻对应短评论查看
    LiveData<GetShortCommentsResponse> getShortComments(GetShortCommentsRequest request);

    // 7.新闻对应长评论查看
    LiveData<GetLongCommentsResponse> getLongComments(GetLongCommentsRequest request);
}