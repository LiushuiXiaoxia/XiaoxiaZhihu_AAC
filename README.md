# XiaoxiaZhihu

---

参考知乎日报，使用网络上的[Api](https://github.com/izzyleung/ZhihuDailyPurify/wiki/%E7%9F%A5%E4%B9%8E%E6%97%A5%E6%8A%A5-API-%E5%88%86%E6%9E%90)，仿写了一个知乎日报客户端。

由于使用非正常手段获取Api，若被告知需停止共享与使用，本人会及时删除此页面与整个项目。

主要使用MVP架构，为了方便锻炼技术。

## 主要使用组件

```
    compile 'de.greenrobot:eventbus:2.4.0' // 事件传递
    compile 'com.google.code.gson:gson:2.4' // json
    compile 'com.jakewharton:butterknife:7.0.1' // 注解
    compile 'org.roboguice:roboguice:3.0.1' // 依赖注入
    provided 'org.roboguice:roboblender:3.0.1'
    compile 'com.squareup.okhttp:okhttp:2.4.0' // 网络请求
    compile 'com.squareup.okhttp:okhttp-urlconnection:2.4.0'
    compile 'com.squareup.okio:okio:1.6.0' // 
    compile 'io.reactivex:rxjava:1.1.0' // rx
    compile 'io.reactivex:rxandroid:1.1.0' / rx
    compile 'com.squareup.picasso:picasso:2.5.2' // 图片加载
    compile 'com.android.support:design:23.1.1' // md
```