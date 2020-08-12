package asks.dev.englishguessinggame;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DictionaryDatabase extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "dictionary.db";
    private static final int DATABASE_VERSION = 1;

    public DictionaryDatabase(Context context) {
        super(context,DATABASE_NAME,null, DATABASE_VERSION);
    }
}