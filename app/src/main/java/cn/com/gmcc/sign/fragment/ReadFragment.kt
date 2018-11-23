package cn.com.gmcc.sign.fragment

import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import cn.com.gmcc.sign.*
import cn.com.gmcc.sign.db.pojo.MissionEntity

import kotlinx.android.synthetic.main.fragment_read.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class ReadFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_read, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        webView.webViewClient = MyWebViewClient(progressBar)
        webView.webChromeClient = MyWebChromeClient(progressBar)
        val mission = arguments?.getParcelable("mission") as MissionEntity
        webView.loadUrl(mission.url)
    }


}

class MyWebViewClient(val progressBar: ProgressBar) : WebViewClient() {
    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
        view?.loadUrl(request?.url?.toString())
        return true
    }
}

class MyWebChromeClient(val progressBar: ProgressBar) : WebChromeClient() {

    override fun onProgressChanged(view: WebView?, newProgress: Int) {
        super.onProgressChanged(view, newProgress)
        progressBar.progress = newProgress
        progressBar.visibility = if (newProgress < 100) View.VISIBLE else View.GONE
    }
}