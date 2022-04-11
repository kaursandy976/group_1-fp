package com.example.management.Activityies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.management.Halper.User;
import com.example.management.R;
import com.example.management.databinding.ActivityUserDetailsActivituBinding;

public class UserDetailsActivitu extends AppCompatActivity {

    public static User model;
    ActivityUserDetailsActivituBinding binding;
    int status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserDetailsActivituBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        status = getIntent().getIntExtra("status",0);
        if(status==1){
            binding.userimage.setImageResource(R.drawable.user1);
        }else if(status ==2){
            binding.userimage.setImageResource(R.drawable.user2);
        } else if(status == 3){
            binding.userimage.setImageResource(R.drawable.user3);
        }else if(status ==4){
            binding.userimage.setImageResource(R.drawable.user4);
        } else if(status==5){
            binding.userimage.setImageResource(R.drawable.user5);
        }else if(status==6){
            binding.userimage.setImageResource(R.drawable.user6);
        }else if(status==7){
            binding.userimage.setImageResource(R.drawable.user7);
        }else if(status==8){
            binding.userimage.setImageResource(R.drawable.user8);
        }else if(status==9){
            binding.userimage.setImageResource(R.drawable.user9);
        }else if(status==10){
            binding.userimage.setImageResource(R.drawable.user10);
        }

        binding.name.setText(model.getName());
        binding.email.setText(model.getEmail());
        binding.phone.setText(model.getPhone());
    }
}