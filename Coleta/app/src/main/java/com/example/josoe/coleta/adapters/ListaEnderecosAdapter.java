package com.example.josoe.coleta.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.josoe.coleta.R;

public class ListaEnderecosAdapter extends RecyclerView.Adapter<ListaEnderecosAdapter.EnderecosViewHolder> {
    int numberOfItems;
    String[] texto;
    String[] ceps;


    public ListaEnderecosAdapter(String[] nomes, String[] ceps) {
        texto = nomes;
        this.ceps = ceps;
        numberOfItems = texto.length;
    }


    @Override
    public EnderecosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutItemId = R.layout.endereco_list_item;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        boolean shoudAttachImmediately = false;
        View itemView = layoutInflater.inflate(layoutItemId, parent, shoudAttachImmediately);
        EnderecosViewHolder viewHolder = new EnderecosViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(EnderecosViewHolder holder, int position) {
        holder.bind(texto[position], ceps[position]);
    }

    @Override
    public int getItemCount() {
        return numberOfItems;
    }

    public class EnderecosViewHolder extends RecyclerView.ViewHolder {
        TextView enderecoTextView;
        TextView cepTextView;

        public EnderecosViewHolder(View itemView) {
            super(itemView);
            enderecoTextView = itemView.findViewById(R.id.tv_item_endereco_texto);
            cepTextView = itemView.findViewById(R.id.tv_item_cep);
        }

        public void bind(String texto, String cep) {
            enderecoTextView.setText(texto);
            cepTextView.setText(cep);
        }
    }
}
