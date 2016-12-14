package cn.mycommons.xiaoxiazhihu.biz.api;

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
import cn.mycommons.xiaoxiazhihu.core.net.AppException;

/**
 * ZhihuApi <br/>
 * Created by xiaqiulei on 2015-12-30.
 */
public interface ZhihuApi {

    // 1.启动界面图像获取
    GetStartInfoResponse getStartInfoResponse(GetStartInfoRequest request) throws AppException;

    // 9.主题日报列表查看
    GetAllThemesResponse getAllThemesResponse(GetAllThemesRequest request) throws AppException;

    // 3.最新消息
    GetLastThemeResponse getLastThemeResponse(GetLastThemeRequest request) throws AppException;

    // 4.消息内容获取与离线下载
    GetNewsResponse getNewsResponse(GetNewsRequest request) throws AppException;

    // 10. 主题日报内容查看
    GetThemeResponse getThemeResponse(GetThemeRequest request) throws AppException;

    // 6.新闻额外信息
    GetStoryExtraResponse getStoryExtraResponse(GetStoryExtraRequest request) throws AppException;

    // 8.新闻对应短评论查看
    GetShortCommentsResponse getShortComments(GetShortCommentsRequest request) throws AppException;

    // 7.新闻对应长评论查看
    GetLongCommentsResponse getLongComments(GetLongCommentsRequest request) throws AppException;
}