package com.example.rosemberg.sine.classes;

/**
 * Created by yurid on 31/10/2016.
 */
public class Sine {
    private  String codPosto;
    private  String Nome;
    private String entidadeConveniada;
    private String uf;

    public Sine(String codPosto, String nome, String entidadeConveniada, String uf) {
        setCodPosto(codPosto);
        setNome(nome);
        setEntidadeConveniada(entidadeConveniada);
        setUf(uf);
    }

    public String getCodPosto() {
        return codPosto;
    }

    public void setCodPosto(String codPosto) {
        this.codPosto = codPosto;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getEntidadeConveniada() {
        return entidadeConveniada;
    }

    public void setEntidadeConveniada(String entidadeConveniada) {
        this.entidadeConveniada = entidadeConveniada;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public String toString() {
       return  "Codigo do Posto: " + this.getCodPosto() +
                "\n Nome: " + this.getNome() +
                "\n Entidade conveniada: " + this.getEntidadeConveniada() +
               "\n UF: " + this.getUf();
    }


}
