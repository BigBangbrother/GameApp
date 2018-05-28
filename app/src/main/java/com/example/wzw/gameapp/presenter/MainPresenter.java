package com.example.wzw.gameapp.presenter;

import com.example.wzw.gameapp.model.net.bean.ResontInfo;
import com.example.wzw.gameapp.ui.activity.MainActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @项目名称 :GameApp
 * @类描述 :
 * @创建人 : wzw
 * @创建时间 : 2018/5/27 17:31
 * @修改人：wzw
 * @修改时间：2018/5/27 17:31
 * @修改备注：
 */

public class MainPresenter extends BasePresenter{

    MainActivity mMainActivity;

    public MainPresenter(MainActivity mainActivity) {
        mMainActivity = mainActivity;
    }

    public void request2(){

        Call<ResontInfo> call = mApi.login(123,"");

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
