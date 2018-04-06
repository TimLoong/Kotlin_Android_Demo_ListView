package blog.feihu.android.kotlin.demo1.net

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitManager {

    companion object {
        private var okhttpClient: OkHttpClient? = null
        private var gson: Gson? = null

        init {
            okhttpClient = OkHttpClient.Builder().build()
            gson = GsonBuilder().serializeNulls().create()
        }

        /**
         * 获取Retrofit实例
         */
        fun getInstance(url: String): Retrofit? {

            var retrofit = Retrofit.Builder()
                    .baseUrl(url)
                    .client(okhttpClient)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            return retrofit
        }


        /**
         * 对象转字符串
         */
        fun <T> getRequestBody(obj: T): RequestBody? {

            val data = gson!!.toJson(obj)

            return RequestBody.create(okhttp3.MediaType.parse("application/json;charset=utf-8"), data)
        }

        /**
         * 发送请求
         */
        fun <T> req(observable: Observable<T>, callback: HttpCallBack<T>) {

            observable?.subscribeOn(Schedulers.io())
                    ?.observeOn(AndroidSchedulers.mainThread())
                    ?.subscribe(
                            { t: T ->
                                callback.onSuccessful(t)
                            },
                            { t: Throwable? ->
                                callback.onFailed("-1", t.toString())
                            }
                    )
        }


    }


}