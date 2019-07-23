package com.link.component_search.data

import com.link.component_search.data.entity.MenuResult
import com.link.component_search.data.source.http.IHttpDataSource
import com.link.component_search.data.source.local.ILocalDataSource
import com.link.librarycomponent.entity.base.BaseEntity
import com.link.librarymodule.base.mvvm.model.BaseModel
import io.reactivex.Observable

class SearchRepository private constructor(
        private val httpDataSource: IHttpDataSource,
        private val localDataSource: ILocalDataSource
) :
        BaseModel(), ILocalDataSource, IHttpDataSource {


    companion object {

        @Volatile
        private var instance: SearchRepository? = null

        fun getInstance(httpDataSource: IHttpDataSource, localDataSource: ILocalDataSource) =
                instance ?: synchronized(this) {
                    instance ?: SearchRepository(httpDataSource, localDataSource).also {
                        instance = it
                    }
                }
    }


    /**
     * 获取本地分类数据
     */
    override fun getCatalogData(): Observable<String> {
        return localDataSource.getCatalogData()
    }

    override fun search(menu: String, pn: Int, rn: Int): Observable<BaseEntity<MenuResult>> {
        return httpDataSource.search(menu, pn, rn)
    }

    override fun index(cid: String, pn: Int, rn: Int): Observable<BaseEntity<MenuResult>> {
        return httpDataSource.index(cid, pn, rn)
    }
}