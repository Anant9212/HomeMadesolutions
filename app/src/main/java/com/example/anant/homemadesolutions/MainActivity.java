package com.example.anant.homemadesolutions;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

import static android.net.Uri.*;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
     WebView web;
     boolean exit=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Home Made solutions");
        toolbar.setSubtitle("gharelu nuskhe");

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(this);

        web=(WebView)findViewById(R.id.webview);
        web.loadUrl("https://www.youtube.com/channel/UCLEKScK-KhlSC7Nq8UBAa6w");
        web.getSettings().setJavaScriptEnabled(true);
        web.setWebViewClient(new WebViewClient());


    }

    @SuppressLint("ShowToast")
    public void onBackPressed() {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if(web.canGoBack())
            {
                web.goBack();
            }
            else
            {
                if (exit)
                {
                    finish();
                }
               else {
                    Toast.makeText(MainActivity.this,"Press again to exit",Toast.LENGTH_SHORT).show();
                }
                Timer timer=new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        exit=false;
                    }
                },2000);
                exit=true;
            }

        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.facebook) {
            Intent i = new Intent();
            i.setAction(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://www.facebook.com/Homemadesolutions.gharelunuskhe/"));
            startActivity(i);
        } else if (id == R.id.google) {
            Intent i = new Intent();
            i.setAction(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://plus.google.com/+HomeMadesolutionsgharelunuskhe"));
            startActivity(i);

        } else if (id == R.id.about) {
            Intent i = new Intent();
            i.setAction(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://www.youtube.com/channel/UCLEKScK-KhlSC7Nq8UBAa6w/about"));
            startActivity(i);

        } else if (id == R.id.channel) {
            Intent i = new Intent();
            i.setAction(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://www.youtube.com/channel/UCLEKScK-KhlSC7Nq8UBAa6w/channels"));
            startActivity(i);

        } else if (id == R.id.community) {
            Intent i = new Intent();
            i.setAction(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://www.youtube.com/channel/UCLEKScK-KhlSC7Nq8UBAa6w/community"));
            startActivity(i);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
