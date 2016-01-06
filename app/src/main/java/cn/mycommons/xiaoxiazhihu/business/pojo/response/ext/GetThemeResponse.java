package cn.mycommons.xiaoxiazhihu.business.pojo.response.ext;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

import cn.mycommons.xiaoxiazhihu.business.pojo.bean.LastThemeStory;
import cn.mycommons.xiaoxiazhihu.business.pojo.bean.ThemeEditor;
import cn.mycommons.xiaoxiazhihu.business.pojo.response.BaseResponse;

/**
 * GetThemeResponse <br/>
 * Created by xiaqiulei on 2016-01-04.
 */
public class GetThemeResponse extends BaseResponse {

    @SerializedName("stories")
    public LastThemeStory[] stories;
    @SerializedName("description")
    public String description;
    @SerializedName("background")
    public String background;
    @SerializedName("color")
    public int color;
    @SerializedName("name")
    public String name;
    @SerializedName("image")
    public String image;
    @SerializedName("editors")
    public ThemeEditor[] editors;
    @SerializedName("image_srouce")
    public String imageSrouce;

    @Override
    public String toString() {
        return "GetThemeResponse{" +
                "stories=" + Arrays.toString(stories) +
                ", description='" + description + '\'' +
                ", background='" + background + '\'' +
                ", color=" + color +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", editors=" + Arrays.toString(editors) +
                ", imageSrouce='" + imageSrouce + '\'' +
                "} " + super.toString();
    }
}