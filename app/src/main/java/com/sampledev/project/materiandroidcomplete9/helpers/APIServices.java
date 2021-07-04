package com.sampledev.project.materiandroidcomplete9.helpers;

import com.sampledev.project.materiandroidcomplete9.responsemodel.LoginResponse;
import com.sampledev.project.materiandroidcomplete9.responsemodel.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * created by Irfan Assidiq
 * email : assidiq.irfan@gmail.com
 **/
public interface APIServices {
    @FormUrlEncoded
    @POST("masuk")
    public Call<LoginResponse> userLogin(
                @Field("username") String username,
                @Field("password") String password);

    @FormUrlEncoded
    @POST("register")
    public Call<RegisterResponse> userRegister(
                @Field("username") String username,
                @Field("email") String email,
                @Field("password") String password,
                @Field("point") int point);

    @GET("getallbarang")
    public Call<String> getAllBarang();

    @FormUrlEncoded
    @POST("uploadbarang")
    public Call<String> uploadBarang(
            @Field("namabarang") String namabarang,
            @Field("hargabarang") String hargabarang,
            @Field("stock") int stock);
}
