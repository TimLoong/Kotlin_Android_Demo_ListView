package blog.feihu.android.kotlin.demo1.net

import blog.feihu.android.kotlin.demo1.bean.resp.BannerResp
import io.reactivex.Observable
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.POST

interface APIService {
    @POST("/public/bannerList")
    fun getBanner(@Body  body: RequestBody):Observable<BannerResp>
}