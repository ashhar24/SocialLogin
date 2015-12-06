package com.defoliate.sociallogin;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.defoliate.sociallogin.google.SignInFragment;
import com.facebook.appevents.AppEventsLogger;

/*
 * Created by defoliate on 29-11-2015.
 */
public class MainActivity extends FragmentActivity
{
    @Override
    protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SignInFragment googlesigninfragment = new SignInFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frame_googlelogin, googlesigninfragment);
        fragmentTransaction.commit();
    }

    @Override
    protected void onResume ()
    {
        super.onResume();
        // Logs 'install' and 'app activate' App Events.
        AppEventsLogger.activateApp(this);
    }

    @Override
    protected void onPause ()
    {
        super.onPause();
        // Logs 'app deactivate' App Event.
        AppEventsLogger.deactivateApp(this);
    }
}
