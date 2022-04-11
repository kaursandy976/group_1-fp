package com.example.management.Activityies;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.management.Adapters.CaptaAdapters;
import com.example.management.Halper.AppDatabase;
import com.example.management.Halper.Refresh;
import com.example.management.Halper.User;
import com.example.management.Halper.UserDao;
import com.example.management.MainActivity;
import com.example.management.R;
import com.example.management.databinding.ActivityCaptaBinding;

import java.util.ArrayList;
import java.util.List;

public class CaptaActivity extends AppCompatActivity implements Refresh {

    ActivityCaptaBinding binding;

    List<Integer> integerList1 = new ArrayList<>();
    List<Integer> integerList2 = new ArrayList<>();
    List<Integer> integerList3 = new ArrayList<>();

    List<String> stringlist = new ArrayList<>();

    List<String> corectlist1 = new ArrayList<>();
    List<String> corectlist2 = new ArrayList<>();
    List<String> corectlist3 = new ArrayList<>();

    List<String> getadapetelist = new ArrayList<>();
    AlertDialog.Builder builder ;
    AlertDialog.Builder builder1 ;

    int captastatus = 1;
    int verifycaptastatus = 1;

    String name,email,phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCaptaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        name = getIntent().getStringExtra("name");
        email = getIntent().getStringExtra("email");
        phone = getIntent().getStringExtra("phone");


        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "Student").allowMainThreadQueries().build();

        UserDao userDao = db.userDao();

       builder = new AlertDialog.Builder(CaptaActivity.this);
       builder.setMessage("verify");
       builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialogInterface, int i) {
                userDao.insertAll(new User(name,email,phone));
                startActivity(new Intent(getApplicationContext(),AllUsersActivity.class));
                finishAffinity();

           }
       });

        builder1 = new AlertDialog.Builder(CaptaActivity.this);
        builder1.setMessage("Not verify");
        builder1.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
               dialogInterface.dismiss();
               startActivity(new Intent(getApplicationContext(), AllUsersActivity.class));
               finish();

            }
        });




        corectlist1.add("1");
        corectlist1.add("2");
        corectlist1.add("3");

        corectlist2.add("1");
        corectlist2.add("2");
        corectlist2.add("3");
        corectlist2.add("4");
        corectlist2.add("5");
        corectlist2.add("6");


        corectlist3.add("4");
        corectlist3.add("5");
        corectlist3.add("6");
        corectlist3.add("7");
        corectlist3.add("8");
        corectlist3.add("9");



        stringlist.add("1");
        stringlist.add("2");
        stringlist.add("3");
        stringlist.add("4");
        stringlist.add("5");
        stringlist.add("6");
        stringlist.add("7");
        stringlist.add("8");
        stringlist.add("9");

        integerList1.add(R.drawable.light1);
        integerList1.add(R.drawable.light2);
        integerList1.add(R.drawable.light3);
        integerList1.add(R.drawable.light4);
        integerList1.add(R.drawable.light5);
        integerList1.add(R.drawable.light6);
        integerList1.add(R.drawable.light7);
        integerList1.add(R.drawable.light8);
        integerList1.add(R.drawable.light8);


        integerList2.add(R.drawable.tight1);
        integerList2.add(R.drawable.tight2);
        integerList2.add(R.drawable.tight3);
        integerList2.add(R.drawable.tight4);
        integerList2.add(R.drawable.tight5);
        integerList2.add(R.drawable.tight6);
        integerList2.add(R.drawable.tight7);
        integerList2.add(R.drawable.tight8);
        integerList2.add(R.drawable.tight9);


        integerList3.add(R.drawable.light4);
        integerList3.add(R.drawable.light5);
        integerList3.add(R.drawable.light6);
        integerList3.add(R.drawable.light3);
        integerList3.add(R.drawable.light1);
        integerList3.add(R.drawable.light2);
        integerList3.add(R.drawable.light1);
        integerList3.add(R.drawable.light2);
        integerList3.add(R.drawable.light3);


        CaptaAdapters captaAdapters = new CaptaAdapters(CaptaActivity.this,integerList1,CaptaActivity.this,stringlist);
        binding.captarecyclerview.setAdapter(captaAdapters);


        captastatus=2;

        binding.reload.setOnClickListener(v ->{
            if (captastatus==1){
                CaptaAdapters captaAdapters1 = new CaptaAdapters(CaptaActivity.this,integerList1,CaptaActivity.this,stringlist);
                binding.captarecyclerview.setAdapter(captaAdapters1);
                captastatus = 2;
                verifycaptastatus = 1;
            }else if(captastatus==2){
                CaptaAdapters captaAdapters2 = new CaptaAdapters(CaptaActivity.this,integerList2,CaptaActivity.this,stringlist);
                binding.captarecyclerview.setAdapter(captaAdapters2);
                captastatus = 3;
                verifycaptastatus = 2;
            }else if(captastatus==3){
                CaptaAdapters captaAdapters3 = new CaptaAdapters(CaptaActivity.this,integerList3,CaptaActivity.this,stringlist);
                binding.captarecyclerview.setAdapter(captaAdapters3);
                captastatus = 1;
                verifycaptastatus = 3;
            }else {
                CaptaAdapters captaAdapters3 = new CaptaAdapters(CaptaActivity.this,integerList1,CaptaActivity.this,stringlist);
                binding.captarecyclerview.setAdapter(captaAdapters3);
            }
        });


        binding.verify.setOnClickListener(v ->{

            int check_Status = 0;

            if(binding.checkbox.isChecked()){

                if(verifycaptastatus==1){
                    for (int i=0;i<corectlist1.size();i++){
                        for (int j=0;j<getadapetelist.size();j++){
                            if(corectlist1.get(i).equals(getadapetelist.get(j))){
                                check_Status++;
                            }
                        }
                    }
                    if(check_Status == 3 && getadapetelist.size() == 3){
                        builder.show();
                    }else {
                        builder1.show();
                    }
                } else if(verifycaptastatus==2){
                    for (int i=0;i<corectlist2.size();i++){
                        for (int j=0;j<getadapetelist.size();j++){
                            if(corectlist2.get(i).equals(getadapetelist.get(j))){
                                check_Status++;
                            }
                        }
                    }

                    if(check_Status == 6 && getadapetelist.size() == 6){
                        builder.show();
                    }else {
                        builder1.show();
                    }

                } else if(verifycaptastatus==3){
                    for (int i=0;i<corectlist3.size();i++){
                        for (int j=0;j<getadapetelist.size();j++){
                            if(corectlist3.get(i).equals(getadapetelist.get(j))){
                                check_Status++;
                            }
                        }
                    }
                    if(check_Status == 6 && getadapetelist.size() == 6){
                        builder.show();
                    }else {
                        builder1.show();
                    }
                }



            }else {
                Toast.makeText(getApplicationContext(),"Please Select I'm not a robot",Toast.LENGTH_SHORT).show();
            }








        });
    }

    @Override
    public void refresh(List<String > list) {
        getadapetelist.clear();
        for (int i=0;i<list.size();i++){
            getadapetelist.add(list.get(i));
        }
        Log.i("Checkedlist","Good : "+getadapetelist.size());
    }
}