package com.defoliate.sociallogin;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.defoliate.sociallogin.google.SignInFragment;

/**
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
}
