package com.markp.gotravel

import android.content.Context
import android.content.DialogInterface
import android.graphics.Bitmap
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AlertDialog
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var webView: WebView
    lateinit var progressBar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        webView = findViewById(R.id.webView)
//        progressBar = findViewById(R.id.progressBar)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigatin_view)
        val navController = findNavController(R.id.nav_fragment)
        bottomNavigationView.setupWithNavController(navController)
//        webView.webViewClient = WebViewClient()
//        webView.settings.javaScriptEnabled = true
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
}
