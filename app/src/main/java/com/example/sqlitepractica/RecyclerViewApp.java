package com.example.sqlitepractica;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewApp extends RecyclerView.Adapter<RecyclerViewApp.ViewHolder> {

    private List<Coche> elements;

    public RecyclerViewApp(List<Coche> elements) {
        this.elements = elements;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewElement = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder, parent, false);
        return new ViewHolder(viewElement);
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        holder.getTxtElement().setText(elements.get(position).getMatricula());
        holder.getTxtElement2().setText(elements.get(position).getNombre());

    }

    @Override
    public int getItemCount() {
        return elements.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtElement;
        private TextView txtElement2;

        public ViewHolder(View itemView) {
            super(itemView);
            txtElement = itemView.findViewById(R.id.textView);
            txtElement2 = itemView.findViewById(R.id.textView2);
        }
        public TextView getTxtElement() {
            return txtElement;
        }
        public TextView getTxtElement2() {
            return txtElement2;
        }
    }


    }

