package com.example.knu2017.realm_test.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.knu2017.realm_test.Model.TestModel;
import com.example.knu2017.realm_test.R;

import java.util.List;

/**
 * Created by KNU2017 on 2018-01-06.
 */

class RealmViewHolder extends RecyclerView.ViewHolder {

    TextView nameText, uuidText, ageText;

    public RealmViewHolder(View itemView) {
        super(itemView);
        nameText = (TextView) itemView.findViewById(R.id.tvName);
        uuidText = (TextView) itemView.findViewById(R.id.tvUUID);
        ageText = (TextView) itemView.findViewById(R.id.tvAge);
    }
}

public class RealmAdapter extends RecyclerView.Adapter<RealmViewHolder> {

    Context context;
    List<TestModel> modelList;

    public RealmAdapter(Context context, List<TestModel> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @Override
    public RealmViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.list_item, parent, false);
        RealmViewHolder realmViewHolder = new RealmViewHolder(view);
        return realmViewHolder;
    }

    @Override
    public void onBindViewHolder(RealmViewHolder holder, int position) {
        holder.ageText.setText(modelList.get(position).getAge());
        holder.nameText.setText(modelList.get(position).getName());
        holder.uuidText.setText(modelList.get(position).getUserUUID());

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }
}
