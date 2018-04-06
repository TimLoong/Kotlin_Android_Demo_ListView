package blog.feihu.android.kotlin.demo1

import blog.feihu.android.kotlin.demo1.bean.resp.BannerResp

/**
 * 主页V
 */
interface MainView {

    /**
     * 更改展示进度
     * @param state  默认不展示进度 true 需要展示进度,false 不需要展示进度
     */
    fun changeProgress(state: Boolean = false)

    /**
     * 获取Banner结果
     * @param result 结果
     * @param msg 当result为false时 需要设置此字符串
     * @param bannerResp 返回数据
     */
    fun bannerResult(result: Boolean, msg: String = "", bannerResp: BannerResp? = null)
}
