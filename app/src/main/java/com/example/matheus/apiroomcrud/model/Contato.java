package com.example.matheus.apiroomcrud.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.example.matheus.apiroomcrud.util.DateConverter;

import java.util.Date;

/**
 * Created by Matheus on 29/11/2017.
 */

@Entity(tableName = "contatos")
public class Contato {

    @PrimaryKey(autoGenerate = true)
    private Integer uid;

    @ColumnInfo(name = "nome")
    private String nome;

    @ColumnInfo(name = "telefones")
    private String telefone;


    private String info;

    @ColumnInfo(name = "data-cricao")
    @TypeConverters(DateConverter.class)
    private Date dataCriacao = new Date();

    @ColumnInfo(name = "data-alteracao")
    @TypeConverters(DateConverter.class)
    private  Date dataAlteração;


    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataAlteração() {
        return dataAlteração;
    }

    public void setDataAlteração(Date dataAlteração) {
        this.dataAlteração = dataAlteração;
    }

    @Override
    public String toString() {
        return "Nome: "+nome + " \n"+
                "Telefone: "+ telefone+ "\n"+
                "Informação: "+info+"\n"+
                "Data Criacao: " + DataConvertida(dataCriacao)+"\n"+
                "Data Alteração:" + DataConvertida(dataAlteração);
    }

    public String DataConvertida(Date data){
        String dataStri = "";
        
        if(data != null){
            String mes = String.valueOf(data.getMonth());
            String dia = String.valueOf(data.getDay());
            String ano = String.valueOf(data.getYear());

            dataStri =  dia + "/"+mes + "/"+ano;
            
        }
      

        return dataStri;
    }
}
