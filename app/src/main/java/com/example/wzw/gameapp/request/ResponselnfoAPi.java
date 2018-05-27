package com.example.wzw.gameapp.request;

import com.example.wzw.gameapp.bean.ResontInfo;
import com.example.wzw.gameapp.utils.Constant;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @项目名称 :GameApp
 * @类描述 :
 * @创建人 : wzw
 * @创建时间 : 2018/5/27 19:32
 * @修改人：wzw
 * @修改时间：2018/5/27 19:32
 * @修改备注：
 */

public interface ResponselnfoAPi {
    @GET(Constant.LOGIN)
    Call<ResontInfo>login(@Query("name") int name,@Query("pass") String pass);

}
