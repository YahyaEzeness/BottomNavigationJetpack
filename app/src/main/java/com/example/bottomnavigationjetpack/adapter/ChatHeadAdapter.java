package com.example.bottomnavigationjetpack.adapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.navigation.Navigator;
import androidx.navigation.fragment.FragmentNavigator;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bottomnavigationjetpack.R;

import java.util.ArrayList;
import java.util.List;

public class ChatHeadAdapter extends RecyclerView.Adapter<ChatHeadAdapter.ChatHeadHolder> {

    private Activity activity;
    private List<ChatHeadModel> arrList = new ArrayList<>();

    public ChatHeadAdapter(@NonNull Activity activity) {
        this.activity = activity;
    }

    @NonNull
    @Override
    public ChatHeadHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.item_chat_head, parent, false);

        return new ChatHeadHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatHeadHolder holder, int position) {
        ChatHeadModel arrItem = arrList.get(position);

        holder.txtTitle.setText(arrItem.getTitle());

        holder.itemView.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putInt("id", position);
            bundle.putString("user", arrItem.getTitle());

            Navigation.findNavController(v).navigate(R.id.action_home_to_details, bundle);
        });
    }

    @Override
    public int getItemCount() {
        return arrList.size();
    }

    public List<ChatHeadModel> getArrList() {
        return arrList;
    }

    public void setArrList(List<ChatHeadModel> list) {
        arrList.addAll(list);
        notifyDataSetChanged();
    }

    class ChatHeadHolder extends RecyclerView.ViewHolder {

        TextView txtTitle;

        public ChatHeadHolder(View itemView) {
            super(itemView);

            txtTitle = itemView.findViewById(R.id.txtTitle);
        }
    }
}
