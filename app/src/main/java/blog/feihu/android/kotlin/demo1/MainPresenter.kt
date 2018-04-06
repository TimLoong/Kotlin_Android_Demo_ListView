package blog.feihu.android.kotlin.demo1

import blog.feihu.android.kotlin.demo1.bean.resp.BannerResp
import blog.feihu.android.kotlin.demo1.net.HttpCallBack

/**
 * 主页P
 * @author Tim飞虎
 */
class MainPresenter constructor(var view: MainView) {

    /**
     * 获取Banner
     */
    fun getBanner() {
        if (null != view) {
            view.changeProgress(true)
        }

        MainModel().getBanner(object : HttpCallBack<BannerResp> {
            override fun onSuccessful(t: BannerResp) {
                if (null != view) {
                    view.changeProgress()
                    view.bannerResult(true, "", t)
                }
            }

            override fun onFailed(errorCode: String, errorMsg: String) {
                if (null != view) {
                    view.changeProgress()
                    view.bannerResult(false, errorMsg)
                }
            }
        })
    }
}