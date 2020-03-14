package com.vibhu.rahulapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView webView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (isconnect())
        {
            webView = findViewById(R.id.webView);
            webView.setWebViewClient(new WebViewClient());
            webView.loadUrl("https://technologywikipedia.blogspot.com/?m=1");
            WebSettings webSettings = webView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            webSettings.setBuiltInZoomControls(true);
            webSettings.setSupportZoom(true);
        }
        else
        {
            Intent i = new Intent(MainActivity.this, ActivityB.class);
            startActivity(i);
            finish();
        }
    }

    private boolean isconnect(){
        boolean have_wifi=false;
        boolean have_mobile=false;
        ConnectivityManager cm = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo[] netinfo = cm.getAllNetworkInfo();

        for(NetworkInfo info:netinfo) {
            if (info.getTypeName().equalsIgnoreCase("wifi"))
                if (info.isConnected())
                    have_wifi = true;
            if (info.getTypeName().equalsIgnoreCase("mobile"))
                if (info.isConnected())
                    have_mobile = true;
        }
        return have_mobile||have_wifi;

    }
}

