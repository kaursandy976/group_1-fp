package com.example.management.Activityies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.TelephonyManager;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.management.Adapters.UsersAdapter;
import com.example.management.Halper.AppDatabase;
import com.example.management.Halper.ShowDataTablet;
import com.example.management.Halper.User;
import com.example.management.Halper.UserDao;
import com.example.management.R;
import com.example.management.databinding.ActivityAllUsersBinding;

import java.util.List;
import java.util.Objects;

public class AllUsersActivity extends AppCompatActivity implements ShowDataTablet {

    ActivityAllUsersBinding binding;
    LinearLayout detilslayout;
    boolean tabstatus = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAllUsersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if(isTablet(getApplicationContext())){
            tabstatus = true;
        }else {
            tabstatus = false;
        }



        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "Student").allowMainThreadQueries().build();

        UserDao userDao = db.userDao();
        List<User> userList = userDao.getAll();
        UsersAdapter usersAdapter =  new UsersAdapter(AllUsersActivity.this,userList,AllUsersActivity.this,tabstatus);
        binding.userrecyclerview.setAdapter(usersAdapter);

        binding.adduser.setOnClickListener(v ->{
            startActivity(new Intent(getApplicationContext(),RegisterActivity.class));
            finish();
        });
    }

    boolean doubleBackToExitPressedOnce;

    @Override
    public void onBackPressed() {

        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            finish();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Press back again to exit", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(() -> doubleBackToExitPressedOnce = false, 2000);

    }

    public  boolean isTablet(Context mContext){
        return (mContext.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_LARGE;
    }

    @Override
    public void refresh(String name, String email, String number) {
        binding.tabname.setText(name);
        binding.tabemail.setText(email);
        binding.tabphone.setText(number);

    }
}