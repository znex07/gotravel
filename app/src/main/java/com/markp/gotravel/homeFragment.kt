package com.markp.gotravel

import android.app.ProgressDialog
import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.ProgressBar
import androidx.fragment.app.Fragment


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [homeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class homeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var webView: WebView
    lateinit var progressBar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        webView = view.findViewById<WebView>(R.id.webView)
        progressBar = view.findViewById<ProgressBar>(R.id.progressBar)
        webView.loadUrl("https://sg.segoviagroup.com")

        webView.webViewClient = object : android.webkit.WebViewClient() {
            override fun onPageFinished(view: WebView, url: String) {
                progressBar.visibility = View.GONE
            }
        }
        webView.settings.javaScriptEnabled = true
//        if (!DetectConnection.checkInternetConnection(this)) {
//            AlertDialog.Builder(this)
//                .setIcon(android.R.drawable.ic_dialog_alert)
//                .setTitle("Internet Connection Alert")
//                .setMessage("Please Check Your Internet Connection")
//                .setPositiveButton(
//                    "Close"
//                ) { dialogInterface, i -> finish() }.show()
//        } else {
//            webView.loadUrl("https://sg.segoviagroup.com")
//        }

    }


    inner class WebViewClient : android.webkit.WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                view.loadUrl(url)
                return false
            }
        }

        fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
            progressBar.visibility = View.VISIBLE
        }
        fun onPageFinished(view: WebView, url: String) {
            onPageFinished(view, url)
            progressBar.visibility = View.GONE
        }
    }


//object DetectConnection {
//    fun checkInternetConnection(context: Context): Boolean {
//        val con_manager =
//            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
//        return (con_manager.activeNetworkInfo != null && con_manager.activeNetworkInfo!!.isAvailable
//                && con_manager.activeNetworkInfo!!.isConnected)
//    }
//}