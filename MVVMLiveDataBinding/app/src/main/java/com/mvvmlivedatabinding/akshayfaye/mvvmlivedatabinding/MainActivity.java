package com.mvvmlivedatabinding.akshayfaye.mvvmlivedatabinding;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.arch.lifecycle.Observer;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.mvvmlivedatabinding.akshayfaye.mvvmlivedatabinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        LoginViewModel loginViewModel = new LoginViewModel();
        binding.setLoginViewModel(loginViewModel);

        loginViewModel.getUser().observe(this, new Observer() {
            @Override
            public void onChanged(@Nullable User user) {
                if (user.getEmail().length() > 0 || user.getPassword().length() > 0)
                    Toast.makeText(getApplicationContext(), "email : " + user.getEmail() + " password " + user.getPassword(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

