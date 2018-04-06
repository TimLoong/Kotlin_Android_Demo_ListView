package blog.feihu.android.kotlin.demo1.net

interface HttpCallBack<T> {
    /**
     * 请求成功
     */
    fun onSuccessful(t: T) //成功了就回调这个方法,可以传递任何形式的数据给调用者

    /**
     * 请求失败
     */
    fun onFailed(errorCode: String, errorMsg: String) //失败了就调用这个方法,可以传递错误的请求消息给调用者
}