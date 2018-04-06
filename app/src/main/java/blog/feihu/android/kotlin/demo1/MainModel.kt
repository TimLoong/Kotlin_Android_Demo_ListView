package blog.feihu.android.kotlin.demo1

import blog.feihu.android.kotlin.demo1.bean.req.BannerReq
import blog.feihu.android.kotlin.demo1.bean.resp.BannerResp
import blog.feihu.android.kotlin.demo1.net.APIService
import blog.feihu.android.kotlin.demo1.net.HttpCallBack
import blog.feihu.android.kotlin.demo1.net.RetrofitManager
import blog.feihu.android.kotlin.demo1.util.MD5

/**
 * 主页M
 * @author Tim飞虎
 */
class MainModel {
    fun getBanner(callback: HttpCallBack<BannerResp>) {
        val timeMillis = System.currentTimeMillis() / 1000
        val token = MD5.TOMD5("" + timeMillis + "000")
        val req = BannerReq(2, 1, 10, timeMillis, token)

        RetrofitManager.req(
                RetrofitManager.getInstance("https://www.izhongmao.cn/")!!.create(APIService::class.java).getBanner(RetrofitManager.getRequestBody(req)!!),
                callback)

    }
}