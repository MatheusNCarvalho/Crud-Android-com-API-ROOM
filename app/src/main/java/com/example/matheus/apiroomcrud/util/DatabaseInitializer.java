package com.example.matheus.apiroomcrud.util;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.matheus.apiroomcrud.confdatabase.AppDatabase;
import com.example.matheus.apiroomcrud.model.Contato;

import java.util.List;

/**
 * Created by Matheus on 30/11/2017.
 */


public class DatabaseInitializer {
//
//    private static final String TAG = DatabaseInitializer.class.getName();
//
////    public static void populateAsync(@NonNull final AppDatabase db) {
////        PopulateDbAsync task = new PopulateDbAsync(db);
////        task.execute();
////    }
//
//    public static void populateSync(@NonNull final AppDatabase db) {
//        populateWithTestData(db);
//    }
//
//    private static Contato addUser(final AppDatabase db, Contato user) {
//        db.contatoDao().insertAll(user);
//        return user;
//    }
//
//    private static void populateWithTestData(AppDatabase db) {
//        Contato contato = new Contato();
//        contato.setNome("Matheus");
//        contato.setTelefone("22222");
//
//        addUser(db, contato);
//
//        List<Contato> userList = db.contatoDao().getAll();
//        Log.d(DatabaseInitializer.TAG, "Rows Count: " + userList.size());
//    }
//
//    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {
//
//        private final AppDatabase mDb;
//
//        PopulateDbAsync(AppDatabase db) {
//            mDb = db;
//        }
//
//        @Override
//        protected Void doInBackground(final Void... params) {
//            populateWithTestData(mDb);
//            return null;
//        }
//
//    }
}
