package com.senai.lugaluga.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Usuario {
    private String nome;
    private int cpf;
    private String data;
    private int cep;
    private String cidade;
    private int num;
    private String bairro;
    private String email;
    private String senha;

    protected Usuario(Parcel in) {
        nome = in.readString();
        cpf = in.readInt();
        data = in.readString();
        cep = in.readInt();
        cidade = in.readString();
        num = in.readInt();
        bairro = in.readString();
        email = in.readString();
        senha = in.readString();
    }

    public static final Parcelable.Creator<Usuario> CREATOR = new Parcelable.Creator<Usuario>() {
        @Override
        public Usuario createFromParcel(Parcel in) {
            return new Usuario(in);
        }

        @Override
        public Usuario[] newArray(int size) {
            return new Usuario[size];
        }
    };

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Usuario(String nome, int cpf, String data, int cep, String cidade, int num, String bairro, String email, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.data = data;
        this.cep = cep;
        this.cidade = cidade;
        this.num = num;
        this.bairro = bairro;
        this.email = email;
        this.senha = senha;
    }


}

