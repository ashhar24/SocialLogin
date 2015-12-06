package com.defoliate.sociallogin.facebook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.defoliate.sociallogin.R;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

/*
 * Created by defoliate on 29-11-2015.
 */
public class SignInFragment extends Fragment
{
    private LoginButton loginButton;
    private CallbackManager callbackManager;

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        //return inflater.inflate(R.layout.fragment_facebook_signin, container, false);
        View view = inflater.inflate(R.layout.fragment_facebook_signin, container, false);

        loginButton = (LoginButton) view.findViewById(R.id.fb_login_button);
        loginButton.setReadPermissions("user_friends");
        // If using in a fragment
        loginButton.setFragment(this);
        // Other app specific specialization

        // Callback registration
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>()
        {
            @Override
            public void onSuccess (LoginResult loginResult)
            {
                // App code
            }

            @Override
            public void onCancel ()
            {
                // App code
            }

            @Override
            public void onError (FacebookException exception)
            {
                // App code
            }
        });

        return view;
    }

    @Override
    public void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getActivity().getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
