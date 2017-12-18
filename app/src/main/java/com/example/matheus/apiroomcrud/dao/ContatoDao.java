package com.example.matheus.apiroomcrud.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.matheus.apiroomcrud.model.Contato;

import java.util.List;

/**
 * Created by Matheus on 30/11/2017.
 */

@Dao
public interface ContatoDao {

    @Query("SELECT * FROM contatos")
    List<Contato> getAll();

//    @Query("SELECT * FROM contatos where nome LIKE  :firstName AND last_name LIKE :lastName")
//    Contato findByName(String nome, String lastName);

    @Query("SELECT * FROM contatos where nome LIKE :nome")
    Contato findByName(String nome);

    @Query("SELECT COUNT(*) from contatos")
    int countUsers();

    @Insert
    void insertAll(Contato... conta);

    @Delete
    void delete(Contato user);

    @Update
    void update(Contato contato);


}
