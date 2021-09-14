package com.progtechuc.mad_week1_0706012010005;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import model.User;

public class UserRVAdapter extends RecyclerView.Adapter<UserRVAdapter.UserViewHolder> {

    private ArrayList<User> listUser;

    public UserRVAdapter(ArrayList<User> listUser) {
        this.listUser = listUser;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_user, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.card_nama.setText(String.valueOf(listUser.get(position).getNama()));
        holder.card_umur.setText(String.valueOf(listUser.get(position).getUmur()));
        holder.card_kota.setText(String.valueOf(listUser.get(position).getKota()));

    }

    @Override
    public int getItemCount() {
        return listUser.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {

        private TextView card_nama, card_umur, card_kota;
        private ImageView card_image;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            card_nama = itemView.findViewById(R.id.card_nama);
            card_umur = itemView.findViewById(R.id.card_umur);
            card_kota = itemView.findViewById(R.id.card_kota);
            card_image = itemView.findViewById(R.id.card_image);
        }
    }
}
