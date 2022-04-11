package com.example.management.Adapters;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.management.Activityies.UserDetailsActivitu;
import com.example.management.Halper.ShowDataTablet;
import com.example.management.Halper.User;
import com.example.management.R;
import com.example.management.databinding.UsersItemsBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UsersDataHolder> {
   UsersItemsBinding binding;
   Activity activity;
   List<User> userList;
   ShowDataTablet refesh;
   boolean tabstatus;
   List<Integer> knowimage = new ArrayList<>();

    public UsersAdapter(Activity activity, List<User> userList,ShowDataTablet refesh,boolean tabstatus) {
        this.activity = activity;
        this.userList = userList;
        this.refesh = refesh;
        this.tabstatus = tabstatus;
    }

    @NonNull
    @Override
    public UsersDataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       binding = UsersItemsBinding.inflate(activity.getLayoutInflater(),parent,false);
        return new UsersDataHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull UsersDataHolder holder, int position) {

         int min = 1;
         int max = 5;
         int random = new Random().nextInt((max - min) + 1) + min;
         knowimage.add(random);

        User user = userList.get(position);
        binding.name.setText(user.getName());
        binding.email.setText(user.getEmail());
        binding.number.setText(user.getPhone());

        if(tabstatus){

        }else {
            if(random==1){
                binding.userimage.setImageResource(R.drawable.user1);
            }else if(random ==2){
                binding.userimage.setImageResource(R.drawable.user2);
            } else if(random == 3){
                binding.userimage.setImageResource(R.drawable.user3);
            }else if(random ==4){
                binding.userimage.setImageResource(R.drawable.user4);
            } else if(random==5){
                binding.userimage.setImageResource(R.drawable.user5);
            }else if(random==6){
                binding.userimage.setImageResource(R.drawable.user6);
            }else if(random==7){
                binding.userimage.setImageResource(R.drawable.user7);
            }else if(random==8){
                binding.userimage.setImageResource(R.drawable.user8);
            }else if(random==9){
                binding.userimage.setImageResource(R.drawable.user9);
            }else if(random==10){
                binding.userimage.setImageResource(R.drawable.user10);
            }
            ImageView move = new ImageView(activity);
        }



        holder.itemView.setOnClickListener(v ->{
            if(tabstatus){
                refesh.refresh(user.getName(),user.getEmail(),user.getPhone());
            }else {
                Intent intent = new Intent(holder.itemView.getContext(), UserDetailsActivitu.class);
                intent.putExtra("status",knowimage.get(position));
                UserDetailsActivitu.model = user;
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                holder.itemView.getContext().startActivity(intent);
            }

        });

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }


    public class UsersDataHolder extends RecyclerView.ViewHolder {

        public UsersDataHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
