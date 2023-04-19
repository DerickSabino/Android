package com.example.meuapp.MODEL;

import java.util.Date;

public class Venda {

    private long id;
    private Produto produtovendido;
    private Date dataDatVenda;
    private String NomeDoCliente;

    public Venda() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Produto getProdutovendido() {
        return produtovendido;
    }

    public void setProdutovendido(Produto produtovendido) {
        this.produtovendido = produtovendido;
    }

    public Date getDataDatVenda() {
        return dataDatVenda;
    }

    public void setDataDatVenda(Date dataDatVenda) {
        this.dataDatVenda = dataDatVenda;
    }

    public String getNomeDoCliente() {
        return NomeDoCliente;
    }

    public void setNomeDoCliente(String nomeDoCliente) {
        NomeDoCliente = nomeDoCliente;
    }

    @Override
    public String toString() {
        return "Venda{" +
                "id=" + id +
                ", produtovendido=" + produtovendido.toString() +
                ", dataDatVenda=" + dataDatVenda +
                ", NomeDoCliente='" + NomeDoCliente + '\'' +
                '}';
    }
}
