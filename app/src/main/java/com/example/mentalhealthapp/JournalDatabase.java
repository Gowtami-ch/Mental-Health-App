package com.example.mentalhealthapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class JournalDatabase extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION;

    static {
        DATABASE_VERSION = Integer.parseInt("2");
    }

    private static final String DATABASE_NAME="datadb";
    private static final String DATABASE_TABLE="notestable";
    //column names for database table
    private static final String KEY_ID= "_id";
    private static final String KEY_TITLE= "title";
    private static final String KEY_CONTENT= "content";
    private static final String KEY_DAY="day";
    private static final String KEY_MONTH="month";
    private static final String KEY_YEAR="year";

//    private static final String KEY_DATE= "date";

    JournalDatabase(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        //CREATE TABLE nametame(id INT PRIMARY KEY, title TEXT, content TEXT, date TEXT, time TEXT);
        String query;
        query = new StringBuilder().append("CREATE TABLE ").append(DATABASE_TABLE).append(" (").append(KEY_ID).append(" INTEGER PRIMARY KEY,").append(KEY_TITLE).append(" TEXT, ").append(KEY_CONTENT).append(" TEXT, ").append(KEY_DAY).append(" TEXT, ").append(KEY_MONTH).append(" TEXT, ").append(KEY_YEAR).append(" TEXT").append(") ").toString();
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion>=newVersion)
            return;
        db.execSQL(new StringBuilder().append("DROP TABLE IF EXISTS").append(DATABASE_TABLE).toString());
        onCreate(db);
    }

    public ArrayList<JournalEntry> getJournalEntries(){
        SQLiteDatabase db=this.getReadableDatabase();
        ArrayList<JournalEntry> journalEntries=new ArrayList<>();
        Cursor cursor=db.rawQuery("SELECT * FROM "+DATABASE_TABLE,null);

        if(cursor.moveToFirst()){
            do{
                journalEntries.add(new JournalEntry(cursor.getInt(0),cursor.getString(1),cursor.getString(2),
                        cursor.getInt(3),cursor.getInt(4),cursor.getInt(5)));
            }while(cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return journalEntries;
    }

    public ArrayList<JournalEntry> getFilteredJournalEntries(int day,int month,int year){
        SQLiteDatabase db=this.getReadableDatabase();
        ArrayList<JournalEntry> journalEntries=new ArrayList<>();
        String query="SELECT * FROM " + DATABASE_TABLE + " WHERE " + KEY_DAY + "="+day +
                " AND " + KEY_MONTH + "=" + month + " AND " + KEY_YEAR +"="+year + ";";
        Cursor cursor=db.rawQuery(query,null);

        if(cursor.moveToFirst()){
            do{
                journalEntries.add(new JournalEntry(cursor.getInt(0), cursor.getString(1), cursor.getString(2),
                        cursor.getInt(3), cursor.getInt(4), cursor.getInt(5)));
            }while(cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return journalEntries;
    }

    public void addNewJournal(JournalEntry journal){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();


        cv.put(KEY_TITLE,journal.getTitle());
        cv.put(KEY_CONTENT,journal.getContent());
        cv.put(KEY_DAY,journal.getDay());
        cv.put(KEY_MONTH,journal.getMonth());
        cv.put(KEY_YEAR,journal.getYear());

        db.insert(DATABASE_TABLE,null,cv);
        db.close();
    }

    public boolean updateJournal(JournalEntry journal,int id){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();

        cv.put(KEY_ID,id);
        cv.put(KEY_TITLE,journal.getTitle());
        cv.put(KEY_CONTENT,journal.getContent());
        cv.put(KEY_DAY,journal.getDay());
        cv.put(KEY_MONTH,journal.getMonth());
        cv.put(KEY_YEAR,journal.getYear());

        //Refer Documentation if doesn't work
        int x = db.update(DATABASE_TABLE,cv,"_id=?",new String[]{String.valueOf(id)});
        db.close();
        return x>0;
    }

    public boolean deleteJournal(String content){
        SQLiteDatabase db=this.getWritableDatabase();
//        db.delete(DATABASE_TABLE,"id=" +id,null);
        //TODO WONT WORK BECAUSE ROWID IS NOT INCREMENTING....
        //TODO pressing back(menu button works fine though) does not delete record from journal view if deleted in calendar
        int x = db.delete(DATABASE_TABLE,KEY_CONTENT+"=?",new String[]{content});
        db.close();
        return x>0;
    }

}
