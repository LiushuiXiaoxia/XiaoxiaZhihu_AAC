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
    private LastThemeStory[] stories;
    @SerializedName("description")
    private String description;
    @SerializedName("background")
    private String background;
    @SerializedName("color")
    private int color;
    @SerializedName("name")
    private String name;
    @SerializedName("image")
    private String image;
    @SerializedName("editors")
    private ThemeEditor[] editors;
    @SerializedName("image_srouce")
    private String imageSrouce;

    public LastThemeStory[] getStories() {
        return stories;
    }

    public void setStories(LastThemeStory[] stories) {
        this.stories = stories;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ThemeEditor[] getEditors() {
        return editors;
    }

    public void setEditors(ThemeEditor[] editors) {
        this.editors = editors;
    }

    public String getImageSrouce() {
        return imageSrouce;
    }

    public void setImageSrouce(String imageSrouce) {
        this.imageSrouce = imageSrouce;
    }

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