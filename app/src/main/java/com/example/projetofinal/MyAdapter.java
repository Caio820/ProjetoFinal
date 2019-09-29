package com.example.projetofinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.projetofinal.model.ListItem;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<ListItem> listItems;
    private Context context;
    // Generated constructor from members
    public MyAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
        ListItem listItem = listItems.get(position);
        holder.textViewBatimento.setText("Batimento: " + listItem.batimento);
        holder.textViewPressao.setText("Pressão: " + listItem.pressao);
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewBatimento;
        public TextView textViewPressao;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewBatimento = itemView.findViewById(R.id.textViewBatimento);
            textViewPressao = itemView.findViewById(R.id.textViewPressao);
        }
    }

}


