package com.example.wzw.gameapp.presenter;

import com.example.wzw.gameapp.bean.ResontInfo;
import com.example.wzw.gameapp.request.ResponselnfoAPi;
import com.example.wzw.gameapp.ui.activity.MainActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @项目名称 :GameApp
 * @类描述 :
 * @创建人 : wzw
 * @创建时间 : 2018/5/27 17:31
 * @修改人：wzw
 * @修改时间：2018/5/27 17:31
 * @修改备注：
 */

public class MainPresenter {

    MainActivity mMainActivity;

    public MainPresenter(MainActivity mainActivity) {
        mMainActivity = mainActivity;
    }


    //retorfit简单使用步骤
    public Retrofit.Builder requeset(){
        Retrofit.Builder builder = new Retrofit.Builder();
        //服务器地址
        builder.baseUrl("");
        //创建gson解析
        builder.addConverterFactory(GsonConverterFactory.create());

        return builder;

    }


    public void request2(){
        Retrofit retrofit = requeset().build();

        ResponselnfoAPi api = retrofit.create(ResponselnfoAPi.class);
        Call<ResontInfo> call = api.login(123,"");

        call.enqueue(new Callback<ResontInfo>() {
            @Override
            public void onResponse(Call<ResontInfo> call, Response<ResontInfo> response) {
                //成功
            }

            @Override
            public void onFailure(Call<ResontInfo> call, Throwable t) {
                //失败
            }
        });
    }

    public String demo(){
        return "完成了小demo";
    }
}
