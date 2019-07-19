package android.festafimdeano.data;

import android.content.Context;
import android.content.SharedPreferences;

public class SecurityPreferences {
    private SharedPreferences mSharedPreferences;

    public  SecurityPreferences(Context mContext){
        //Define o nome dao nosso mSharedPreferences
        this.mSharedPreferences = mContext.getSharedPreferences("FestafimAno", Context.MODE_PRIVATE);
    }

    public void storePreferences(String key, String value){
        //Adiciona uma nova chave
        this.mSharedPreferences.edit().putString(key, value).apply();
    }

    public String getStorePreferences(String key){
        //Procura pela chave key, caso não encotre devolve um valor padrao "".
        return this.mSharedPreferences.getString(key, "");
    }
}
