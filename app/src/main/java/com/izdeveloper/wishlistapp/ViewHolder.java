package com.izdeveloper.wishlistapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;

public class ViewHolder extends RecyclerView.ViewHolder {
    EditText ChangeName, changeDescr;
    Button SaveChanges;
    TextView DefaultName, DefaultDescr;
    ImageView Edit, Remove;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        DefaultName = itemView.findViewById(R.id.txtPlaceHolderItemName);
        DefaultDescr = itemView.findViewById(R.id.txtPlaceHolderDescription);
        Remove = itemView.findViewById(R.id.delete);
        Edit = itemView.findViewById(R.id.edit);

        ChangeName = itemView.findViewById(R.id.fieldChangeName);
        changeDescr = itemView.findViewById(R.id.fieldChangeDescription);

        ChangeName.setVisibility(View.GONE);
        changeDescr.setVisibility(View.GONE);

        SaveChanges = itemView.findViewById(R.id.btnSave);
        SaveChanges.setVisibility(View.GONE);
    }
}
