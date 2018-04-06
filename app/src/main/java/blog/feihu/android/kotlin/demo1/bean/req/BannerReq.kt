package blog.feihu.android.kotlin.demo1.bean.req

data class BannerReq(
        val type:Int,
        val page:Int,
        val countPerPage:Int,
        val time:Long,
        val token:String)
