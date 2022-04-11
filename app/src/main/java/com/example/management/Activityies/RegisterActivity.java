package com.example.management.Activityies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.management.R;
import com.example.management.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {

    ActivityRegisterBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                String name = binding.name.getText().toString();
                String email = binding.email.getText().toString();
                String phone = binding.phone.getText().toString();

                if(!name.isEmpty()){
                    if(!email.isEmpty()){
                        if(email.matches(emailPattern)){
                            if(!phone.isEmpty()){
                                    registerUser(name,email,phone);
                            }else {
                                binding.phone.setError("Please Enter Phone Number");
                                binding.phone.requestFocus();
                            }
                        }else {
                            binding.email.setError("Please Enter Valid Email");
                            binding.email.requestFocus();
                        }
                    }else {
                        binding.email.setError("Please Enter Email");
                        binding.email.requestFocus();
                    }
                }else {
                    binding.name.setError("Please Enter Name");
                    binding.name.requestFocus();
                }
            }
        });
    }

    private void registerUser(String name, String email, String phone) {
        Intent intent = new Intent(getApplicationContext(),CaptaActivity.class);
        intent.putExtra("name",name);
        intent.putExtra("email",email);
        intent.putExtra("phone",phone);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void CaptchaActivity(View view) {
        startActivity(new Intent(getApplicationContext(),CaptaActivity.class));
    }
}