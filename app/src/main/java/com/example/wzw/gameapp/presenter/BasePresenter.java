package com.example.wzw.gameapp.presenter;

import com.example.wzw.gameapp.request.ResponselnfoAPi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @项目名称 :GameApp
 * @类描述 : 数据库网络公共方法
 * @创建人 : wzw
 * @创建时间 : 2018/5/28 21:15
 * @修改人：wzw
 * @修改时间：2018/5/28 21:15
 * @修改备注：
 */

public class BasePresenter {

    protected   ResponselnfoAPi mApi = null;

    public BasePresenter( ) {
        
        if (mApi==null){
            Retrofit retrofit = new Retrofit.Builder().baseUrl("")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            mApi = retrofit.create(ResponselnfoAPi.class);

        }
        

    }
}
