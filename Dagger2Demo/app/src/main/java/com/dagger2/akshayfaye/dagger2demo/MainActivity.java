package com.dagger2.akshayfaye.dagger2demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    EditText inUsername, inNumber;
    Button btnSave, btnGet;
    private MyComponent myComponent;
    @Inject
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        myComponent = DaggerMyComponent.builder().sharedPrefModule(new SharedPrefModule(this)).build();
        myComponent.inject(this);


    }

    private void initViews() {
        btnGet = findViewById(R.id.btnGet);
        btnSave = findViewById(R.id.btnSave);
        inUsername = findViewById(R.id.inUsername);
        inNumber = findViewById(R.id.inNumber);
        btnSave.setOnClickListener(this);
        btnGet.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btnGet:
                inUsername.setText(sharedPreferences.getString("username", "default"));
                inNumber.setText(sharedPreferences.getString("number", "12345"));
                break;
            case R.id.btnSave:

                String userName = inUsername.getText().toString().trim();
                String number = inNumber.getText().toString().trim();

                if(userName.length() > 0 && number.length() > 0) {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("username", userName);
                    editor.putString("number", number);
                    editor.apply();

                    inUsername.setText("");
                    inNumber.setText("");
                }else{
                    Toast.makeText(this, "Please enter valid username & number", Toast.LENGTH_SHORT).show();
                }
                break;

        }
    }
}

