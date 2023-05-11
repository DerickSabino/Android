package com.example.meuapp.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.meuapp.ListaDoProduto;
import com.example.meuapp.MODEL.Produto;
import com.example.meuapp.R;

import java.util.List;

public class  AdapterListaProdutos extends BaseAdapter {

    private Context context;
    private List<Produto> produtoList;

    public AdapterListaProdutos(Context context, List<Produto> produtoList) {
        this.context = context;
        this.produtoList = produtoList;
    }

    @Override
    public int getCount() {
        if (produtoList == null) {
            return 0;
        }
        return produtoList.size();
    }


    @Override
    public Object getItem (int posicao) {
        return this.produtoList.get(posicao) ;
    }

    @Override
    public long getItemId (int posicao) {
        return posicao;
    }

    public void removerProduto (int posicao) {
        this.produtoList.remove(posicao);
        notifyDataSetChanged();
    }

    @Override
    public View getView (int posicao, View view, ViewGroup viewgroup) {

        View v = View.inflate(this.context, R.layout.layout_produto, null );
        TextView tvNomeProduto = (TextView) v.findViewById(R.id.tvNomeProduto);
        TextView tvPrecoProduto = (TextView) v.findViewById(R.id.tvPrecoProduto);
        TextView tvEstoqueProduto = (TextView) v.findViewById(R.id.tvEstoqueProduto);

        tvNomeProduto.setText(this.produtoList.get(posicao).getNome());
        tvPrecoProduto.setText(String.valueOf(this.produtoList.get(posicao).getPreco()));
        tvEstoqueProduto.setText(String.valueOf(this.produtoList.get(posicao).getQuantidadeEmEstoque()));


        return v;
    }
}
