package com.danta.sidqi.projectptsxi;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class RealmHelper {

    Realm realm;

    public RealmHelper(Realm realm){
        this.realm = realm;
    }

    public static void save(final Model model){
        Realm.getDefaultInstance().executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                if (realm != null){
                    Log.e("saved", "Database was created");
                    realm.copyToRealm(model);
                } else {
                    Log.e("Eror", "Database not exist");
                }
            }
        });
    }
    public static Model getModel(final String string){
        return Realm.getDefaultInstance().where(Model.class).equalTo("original_title", string).findFirst();
    }
    public List<Model> getAllModel(){
        RealmResults<Model> model = Realm.getDefaultInstance().where(Model.class).findAll();
        return model;
    }
    public void delete(final String string){
        RealmResults<Model> model = realm.where(Model.class).equalTo("original_title", string).findAll();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                model.deleteFromRealm(0);
            }
        });
    }
}
