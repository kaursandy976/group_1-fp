package com.example.management.Adapters;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.animsh.animatedcheckbox.AnimatedCheckBox;
import com.example.management.Halper.Refresh;
import com.example.management.R;
import com.example.management.databinding.CaptaItemsBinding;

import java.sql.Ref;
import java.util.ArrayList;
import java.util.List;

public class CaptaAdapters extends RecyclerView.Adapter<CaptaAdapters.CaptaDataHolder> {
   CaptaItemsBinding binding;
   Activity activity;
   List<Integer> integerList;
   List<String> checkedlist = new ArrayList<>();
   Refresh refresh;
   List<String> stringList;

    public CaptaAdapters(Activity activity, List<Integer> integerList, Refresh refresh,List<String> stringList) {
        this.activity = activity;
        this.integerList = integerList;
        this.refresh = refresh;
        this.stringList = stringList;
    }

    @NonNull
    @Override
    public CaptaDataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = CaptaItemsBinding.inflate(activity.getLayoutInflater(),parent,false);
        return new CaptaDataHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull CaptaDataHolder holder, int position) {
            binding.captaimage.setImageResource(integerList.get(position));
            holder.itemView.setOnClickListener(v ->{
                if(holder.animatedCheckBox.isChecked()){
                    checkedlist.remove(stringList.get(position));
                    holder.animatedCheckBox.setVisibility(View.GONE);
                    holder.animatedCheckBox.setChecked(false);
                    refresh.refresh(checkedlist);
                }else {
                    checkedlist.add(stringList.get(position));
                    holder.animatedCheckBox.setVisibility(View.VISIBLE);
                    holder.animatedCheckBox.setChecked(true);
                    refresh.refresh(checkedlist);

                }
            });
    }

    @Override
    public int getItemCount() {
        return integerList.size();
    }

    public class CaptaDataHolder extends RecyclerView.ViewHolder {
        AnimatedCheckBox  animatedCheckBox;
        public CaptaDataHolder(@NonNull View itemView) {
            super(itemView);
            animatedCheckBox = itemView.findViewById(R.id.roboatcheckbox);
        }
    }
}
