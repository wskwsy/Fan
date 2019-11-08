package com.link.fan.data.repository.source.net

import com.link.component_shopping.data.entity.EntityResult
import com.link.component_shopping.data.entity.GoodsEntity
import com.link.component_shopping.data.entity.SecondsEntity
import com.link.fan.data.bean.BaseEntity
import com.link.fan.data.bean.MenuResult
import com.link.librarymodule.constant.Constant
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Headers

/**
 * copyright:TS
 * author:wujia
 * create:2019-11-05-18:52
 * email:wujia0916@thundersoft.com
 * description:  定义网络数据源的操作
 */
interface RetrofitHttpService {

    /**
     * 获取首页的轮播图.
     */
    @Headers("${Constant.URL_TYPE}:${Constant.MOCK}")
    @GET("mock/5dc147a511f6e545761fac9a/fan/home/banner")
    fun homeBanner(): Observable<BaseEntity<MenuResult>>

    /**
     * 获取首页的今日推荐.
     */
    @Headers("${Constant.URL_TYPE}:${Constant.MOCK}")
    @GET("mock/5dc147a511f6e545761fac9a/fan/home/today")
    fun today(): Observable<BaseEntity<MenuResult>>

    /**
     * 获取首页的最新菜谱.
     */
    @Headers("${Constant.URL_TYPE}:${Constant.MOCK}")
    @GET("mock/5dc147a511f6e545761fac9a/fan/home/last_menu")
    fun lastMenu(): Observable<BaseEntity<MenuResult>>

    /**
     * 获取首页的菜谱列表.
     */
    @Headers("${Constant.URL_TYPE}:${Constant.MOCK}")
    @GET("mock/5dc147a511f6e545761fac9a/fan/home")
    fun home(): Observable<BaseEntity<MenuResult>>

    /**
     * 获取商城的活动的数据
     */
    @Headers("${Constant.URL_TYPE}:${Constant.MOCK}")
    @GET("mock/5dc147a511f6e545761fac9a/fan/mall/newGoods")
    fun getGoods(): Observable<BaseEntity<EntityResult<List<GoodsEntity>>>>


    /**
     * 获取商城的活动的数据
     */
    @Headers("${Constant.URL_TYPE}:${Constant.MOCK}")
    @GET("mock/5dc147a511f6e545761fac9a/fan/mall/newSeconds")
    fun getSeconds(): Observable<BaseEntity<EntityResult<List<SecondsEntity>>>>

}