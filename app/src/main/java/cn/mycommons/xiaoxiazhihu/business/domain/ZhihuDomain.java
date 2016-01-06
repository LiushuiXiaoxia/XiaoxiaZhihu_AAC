package cn.mycommons.xiaoxiazhihu.business.domain;

import cn.mycommons.xiaoxiazhihu.business.pojo.response.ext.GetAllThemesResponse;
import cn.mycommons.xiaoxiazhihu.business.pojo.response.ext.GetLastThemeResponse;
import cn.mycommons.xiaoxiazhihu.business.pojo.response.ext.GetLongCommentsResponse;
import cn.mycommons.xiaoxiazhihu.business.pojo.response.ext.GetNewsResponse;
import cn.mycommons.xiaoxiazhihu.business.pojo.response.ext.GetShortCommentsResponse;
import cn.mycommons.xiaoxiazhihu.business.pojo.response.ext.GetStartInfoResponse;
import cn.mycommons.xiaoxiazhihu.business.pojo.response.ext.GetStoryExtraResponse;
import cn.mycommons.xiaoxiazhihu.business.pojo.response.ext.GetThemeResponse;
import rx.Observable;

/**
 * ZhihuDomain <br/>
 * Created by xiaqiulei on 2015-12-30.
 */
public interface ZhihuDomain {

    Observable<GetStartInfoResponse> getStartInfo(int width, int height);

    Observable<GetAllThemesResponse> getAllThemes();

    Observable<GetLastThemeResponse> getLastTheme();

    Observable<GetNewsResponse> getNewsById(int id);

    Observable<GetThemeResponse> getThemeById(int id);

    Observable<GetStoryExtraResponse> getStoryExtraById(int id);

    Observable<GetShortCommentsResponse> getShortCommentsById(int id);

    Observable<GetLongCommentsResponse> getLongCommentsById(int id);
}