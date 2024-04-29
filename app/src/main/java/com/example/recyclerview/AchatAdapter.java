
package com.example.recyclerview;



import static java.security.AccessController.getContext;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import java.util.ArrayList;

public class AchatAdapter extends RecyclerView.Adapter<AchatAdapter.ViewHolder> {

    private ArrayList<Achat> achats;
    private Context context;

    public AchatAdapter(Context context, ArrayList<Achat> achats) {
        this.context = context;
        this.achats = achats;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_layout, parent, false);
        return new ViewHolder(view);
    }


    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Achat achat = achats.get(position);


        holder.quantityTextView.setText(achat.getQte());
        holder.itemTextView.setText(achat.getItem());


        holder.editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText) ((Activity) context).findViewById(R.id.ajouter_item);
                EditText editText2 = (EditText) ((Activity) context).findViewById(R.id.ajouter_quantite);
                String newItem = editText.getText().toString().trim();
                String newQte = editText2.getText().toString().trim();
                editItem(position, newItem, newQte);

                editText.setText("");
                editText2.setText("");
            }
        });

        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                deleteItem(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return achats.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView quantityTextView;
        TextView itemTextView;
        ImageButton editButton;
        ImageButton deleteButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            quantityTextView = itemView.findViewById(R.id.quantityTextView);
            itemTextView = itemView.findViewById(R.id.itemTextView);
            editButton = itemView.findViewById(R.id.editButton);
            deleteButton = itemView.findViewById(R.id.deleteButton);
        }
    }

    private void editItem(int position, String newItem, String newQte) {

        Achat achat = achats.get(position);


        achat.setItem(newItem);
        achat.setQte(newQte);


        notifyItemChanged(position);
    }

    private void deleteItem(int position) {
        achats.remove(position);
        notifyItemRemoved(position);
    }

}

