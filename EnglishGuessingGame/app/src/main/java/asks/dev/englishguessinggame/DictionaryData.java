package asks.dev.englishguessinggame;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.ResultSet;

public class DictionaryData {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DictionaryData instance;
    Cursor cursor = null;
    ResultSet rs;

    private DictionaryData(Context context){
        this.openHelper = new DictionaryDatabase(context);
    }

    public static DictionaryData getInstance(Context context){
        if(instance==null){
            instance = new DictionaryData(context);
        }
        return instance;
    }

    public void open(){
        this.database = openHelper.getWritableDatabase();
    }

    public void close(){
        this.database.close();
    }

    public String getWord(int id){
        cursor = database.rawQuery("select word from vocabulary where id = "+id,new String[]{});
        StringBuffer buffer = new StringBuffer();
        while(cursor.moveToNext()){
            String word = cursor.getString(0);
            buffer.append(""+word);
        }

        return buffer.toString();
    }

    public String getSynonym(int id){
        cursor = database.rawQuery("select synonym from vocabulary where id = "+id,new String[]{});
        StringBuffer buffer = new StringBuffer();
        while(cursor.moveToNext()){
            String synonym = cursor.getString(0);
            buffer.append(""+synonym);
        }

        return buffer.toString();
    }
}
