package cn.mycommons.xiaoxiazhihu.business.pojo.response.ext;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

import cn.mycommons.xiaoxiazhihu.business.pojo.bean.LastTemeTopStory;
import cn.mycommons.xiaoxiazhihu.business.pojo.bean.LastThemeStory;
import cn.mycommons.xiaoxiazhihu.business.pojo.response.BaseResponse;

/**
 * GetLastThemeResponse <br/>
 * Created by xiaqiulei on 2016-01-04.
 */
public class GetLastThemeResponse extends BaseResponse {

    @SerializedName("date")
    public String date;

    @SerializedName("stories")
    public LastThemeStory[] stories;

    @SerializedName("top_stories")
    public LastTemeTopStory[] topStories;

    @Override
    public String toString() {
        return "GetLastThemeResponse{" +
                "date='" + date + '\'' +
                ", stories=" + Arrays.toString(stories) +
                ", topStories=" + Arrays.toString(topStories) +
                "} " + super.toString();
    }
}