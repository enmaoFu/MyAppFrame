package com.yy.my.base;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.builder.GetBuilder;
import com.zhy.http.okhttp.builder.PostFormBuilder;
import com.zhy.http.okhttp.callback.BitmapCallback;
import com.zhy.http.okhttp.callback.FileCallBack;
import com.zhy.http.okhttp.callback.StringCallback;
import com.zhy.http.okhttp.request.RequestCall;

import java.io.File;

/**
 * 基础的网络请求封装类
 * @author enmaoFu
 * @date 2016年09月13日
 */
public class BaseHttp {

    /**
     * get 网络请求
     * @param url 接口地址
     * @param GetBuilder 参数
     * @param stringCallback 回调
     */
    public static void getRequest(String url, GetBuilder GetBuilder, StringCallback stringCallback){

        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(stringCallback);

    }

    /**
     * post 网络请求
     * @param url 接口地址
     * @param postFormBuilder 参数
     * @param stringCallback 回调
     */
    public static void postRequest(String url, PostFormBuilder postFormBuilder,StringCallback stringCallback){

        OkHttpUtils
                .post()
                .url(url)
                .build()
                .execute(stringCallback);
    }

    /**
     * post 普通上传文件
     * @param url 接口地址
     * @param file 文件
     * @param stringCallback 回调
     */
    public static void uploadFileOrdinary(String url, File file, StringCallback stringCallback){

        OkHttpUtils
                .postFile()
                .url(url)
                .file(file)
                .build()
                .execute(stringCallback);

    }

    /**
     * post 表单上传文件 (支持单多个文件)
     * 调用这个接口传递参数:
     * PostFormBuilder.addFile("mFile", "test1.txt", file2)
     * addFile 的第一个参数为文件的key，即类别表单中<input type="file" name="mFile"/>的name属性。
     * addFile 的第二个参数为文件名字
     * addFile 的第三个参数为目标文件
     * @param url 接口地址
     * @param postFormBuilder 参数
     * @param stringCallback 回调
     */
    public static void uploadFileForm(String url, PostFormBuilder postFormBuilder, StringCallback stringCallback){

        OkHttpUtils.post()
                .url(url)
                .build()
                .execute(stringCallback);

    }

    /**
     * 下载文件
     * 创建 FileCallBack 回调时，需要在 FileCallBack 里传两个参数：
     * destFileDir 目标文件存储的文件夹路径
     * destFileName 目标文件存储的文件名
     * @param url 接口地址
     * @param fileCallBack 回调
     */
    public static void downloadFile(String url, FileCallBack fileCallBack){

        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(fileCallBack);

    }

    /**
     * 显示图片
     * 成功后调用 ImageView.setImageBitmap(bitmap) 显示图片
     * @param url 接口地址
     * @param bitmapCallback 回调
     */
    public static void showImage(String url, BitmapCallback bitmapCallback){

        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(bitmapCallback);

    }

    /**
     * 根据 url 取消请求
     * @param url 接口地址
     */
    public static void cancelRequest(String url){

        RequestCall call = OkHttpUtils.get().url(url).build();
        call.cancel();

    }

}
