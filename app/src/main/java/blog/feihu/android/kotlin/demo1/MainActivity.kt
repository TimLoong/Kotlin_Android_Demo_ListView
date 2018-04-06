package blog.feihu.android.kotlin.demo1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.view.View
import android.widget.AdapterView
import blog.feihu.android.kotlin.demo1.adapter.BannerAdapter
import blog.feihu.android.kotlin.demo1.bean.resp.BannerResp
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity(), MainView {


    var presenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "欢迎访问 Tim飞虎 的博客 https://feihu.blog", Snackbar.LENGTH_INDEFINITE)
                    .setAction("访问博客", View.OnClickListener {
                        val uri = Uri.parse("https://feihu.blog")
                        startActivity(Intent(Intent.ACTION_VIEW, uri))
                    }).show()
        }
        //发出请求
        presenter.getBanner()
    }


    override fun changeProgress(state: Boolean) {
        if (state) {
            Snackbar.make(list, "开始请求", Snackbar.LENGTH_SHORT).show()
        } else {
            Snackbar.make(list, "结束请求", Snackbar.LENGTH_SHORT).show()
        }
    }

    override fun bannerResult(result: Boolean, msg: String, bannerResp: BannerResp?) {
        if (result && null != bannerResp) {
            if (bannerResp.code == 200) {
                if (bannerResp.data != null && bannerResp.data.list != null) {
                    list.adapter = BannerAdapter(bannerResp.data.list)
                    //Item点击事件
                    list.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
                        Snackbar.make(list, "选中了Banner ${position + 1},标题为 " + bannerResp.data.list[position].title, Snackbar.LENGTH_SHORT).show()
                    }
                } else {
                    Snackbar.make(list, "暂无数据", Snackbar.LENGTH_SHORT).show()
                }
            } else {
                Snackbar.make(list, bannerResp.msg, Snackbar.LENGTH_SHORT).show()
            }
        } else if (!result) {
            if (!TextUtils.isEmpty(msg)) {
                Snackbar.make(list, msg, Snackbar.LENGTH_SHORT).show()
            } else {
                showReqFail()
            }
        }
    }

    /**
     * 展示请求失败
     */
    private fun showReqFail() {
        Snackbar.make(list, "获取失败", Snackbar.LENGTH_SHORT).show()
    }


}
