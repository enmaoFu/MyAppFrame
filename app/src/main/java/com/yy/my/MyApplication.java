package com.yy.my;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.log.LoggerInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * 当前应用的 Application
 * @author enmaoFu
 * @date 2016年09月13日
 * @time 13:05
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        initOkHttpUtils();
        initFresco();

    }

    /**
     * 初始化 okHttpUtils
     */
    public void initOkHttpUtils(){

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new LoggerInterceptor("okhttp"))
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                        //其他配置
                .build();

        OkHttpUtils.initClient(okHttpClient);

    }

    /**
     * 初始化 Fresco 图片异步加载缓存框架
     * 使用例：
     * 1.在xml布局文件中, 加入命名空间
     *   xmlns:fresco="http://schemas.android.com/apk/res-auto"
     * 2.加入SimpleDraweeView:
     *   <com.facebook.drawee.view.SimpleDraweeView
            android:id="@+id/my_image_view"
            android:layout_width="130dp"
            android:layout_height="130dp"
            fresco:placeholderImage="@drawable/my_drawable"
        />
       3.开始加载图片:
         Uri uri = Uri.parse("https://raw.githubusercontent.com/facebook/fresco/gh-pages/static/logo.png");
         SimpleDraweeView draweeView = (SimpleDraweeView) findViewById(R.id.my_image_view);
         draweeView.setImageURI(uri);
     */
    public void initFresco(){

        Fresco.initialize(this);

    }

}
