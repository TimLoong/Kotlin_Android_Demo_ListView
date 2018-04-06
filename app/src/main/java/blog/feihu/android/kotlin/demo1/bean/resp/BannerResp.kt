package blog.feihu.android.kotlin.demo1.bean.resp




data class BannerResp(val at:String, val code:Int, val msg:String,var data: BannerData)


data class BannerData(val totalCount:Int, val time:Long, val list:List<Banner>)


data class Banner(val bannerId:Int,
                  val image:String,
                  val link:String,
                  val title:String)



