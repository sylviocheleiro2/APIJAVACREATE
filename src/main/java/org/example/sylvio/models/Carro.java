package org.example.sylvio.models;

public class Carro
{
 long Id;
 String nome;
 String data;
 String fabricante;
    public Carro(String nome, String data, String fabricante) {
        this.nome = nome;
        this.data = data;
        this.fabricante = fabricante;
    }
    public Carro(long id, String nome, String data, String fabricante) {
        this(nome, data, fabricante);
        this.Id = id;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        this.Id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }
}
