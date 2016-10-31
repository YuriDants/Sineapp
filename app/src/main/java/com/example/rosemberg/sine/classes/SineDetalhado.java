package com.example.rosemberg.sine.classes;

public class SineDetalhado {
    private String codPosto;
    private String nome;
    private String entidadeConveniada;
    private String endereco;
    private String bairro;
    private String cep;
    private String telefone;
    private String municipio;
    private String uf;
    private String lat;
    private String longi;


    public SineDetalhado(String codPosto, String nome, String entidadeConveniada, String endereco, String bairro, String cep, String telefone, String municipio, String uf, String lat, String longi){
        setCodPosto(codPosto);
        setNome(nome);
        setEntidadeConveniada(entidadeConveniada);
        setEndereco(endereco);
        setBairro(bairro);
        setCep(cep);
        setTelefone(telefone);
        setMunicipio(municipio);
        setUf(uf);
        setLat(lat);
        setLongi(longi);
    }

    public String getCodPosto() {
        return codPosto;
    }
    public void setCodPosto(String codPosto) {
        this.codPosto = codPosto;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEntidadeConveniada() {
        return entidadeConveniada;
    }
    public void setEntidadeConveniada(String entidadeConveniada) {
        this.entidadeConveniada = entidadeConveniada;
    }

    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getMunicipio() {
        return municipio;
    }
    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getUf() {
        return uf;
    }
    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getLat() {
        return lat;
    }
    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLongi() {
        return longi;
    }
    public void setLongi(String longi) {
        this.longi = longi;
    }

    @Override
    public String toString() {
        return  "Codigo do Posto: " + this.getCodPosto() +
                "\n Nome: " + this.getNome() +
                "\n Entidade conveniada: " + this.getEntidadeConveniada() +
                "\n Endereço: " + this.getEndereco() +
                "\n Bairro" + this.getBairro() +
                "\n Cep: " + this.getCep() +
                "\n Telefone: " + this.getTelefone() +
                "\n Município: " + this.getMunicipio() +
                "\n UF: " + this.getUf() +
                "\n Latitude: " + this.getLat() +
                "\n Longitude: " + this.getLongi();
    }
}
