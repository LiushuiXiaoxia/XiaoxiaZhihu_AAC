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
    private String date;

    @SerializedName("stories")
    private LastThemeStory[] stories;

    @SerializedName("top_stories")
    private LastTemeTopStory[] topStories;


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public LastThemeStory[] getStories() {
        return stories;
    }

    public void setStories(LastThemeStory[] stories) {
        this.stories = stories;
    }

    public LastTemeTopStory[] getTopStories() {
        return topStories;
    }

    public void setTopStories(LastTemeTopStory[] topStories) {
        this.topStories = topStories;
    }

    @Override
    public String toString() {
        return "GetLastThemeResponse{" +
                "date='" + date + '\'' +
                ", stories=" + Arrays.toString(stories) +
                ", topStories=" + Arrays.toString(topStories) +
                "} " + super.toString();
    }
}