package com.izdeveloper.wishlistapp;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

public class Adapter extends RecyclerView.Adapter<ViewHolder> {
    ArrayList<Article> listOfItems;
    private Context context;
    private int i;
    String descr, name;
    Article editedItem;

    public Adapter(Context context, ArrayList<Article> listOfItems) {
        this.context = context;
        this.listOfItems = listOfItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.display_user, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        name = listOfItems.get(position).getItemName();
        descr = listOfItems.get(position).getItemDescription();

        holder.DefaultDescr.setText(listOfItems.get(position).getItemDescription());

        holder.DefaultName.setText(name);
        holder.changeDescr.setText(descr);
        holder.ChangeName.setText(name);

        holder.Remove.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                i = holder.getAdapterPosition();
                listOfItems.remove(i);

                notifyItemRemoved(i);
                notifyDataSetChanged();
            }
        });


        holder.Edit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                holder.Edit.setVisibility(View.VISIBLE);
                holder.ChangeName.setVisibility(View.VISIBLE);
                holder.changeDescr.setVisibility(View.VISIBLE);
                holder.SaveChanges.setVisibility(View.VISIBLE);

                holder.SaveChanges.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view2) {
                        String changedName = holder.ChangeName.getText().toString();
                        String changedDescr = holder.changeDescr.getText().toString();

                        editedItem = new Article(changedName, changedDescr);
                        listOfItems.set(position, editedItem);

                        notifyDataSetChanged();

                        holder.ChangeName.setVisibility(View.GONE);
                        holder.changeDescr.setVisibility(View.GONE);

                        holder.SaveChanges.setVisibility(View.GONE);
                    }
                });
            }
        });
    }
    @Override
    public int getItemCount() {
        return listOfItems.size();
    }
}
