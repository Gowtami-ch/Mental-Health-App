package com.example.mentalhealthapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class QuizDatabase extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION;

    static {
        DATABASE_VERSION = Integer.parseInt("2");
    }

    private static final String DATABASE_NAME="quiz_db";
    private static final String DATABASE_TABLE="quiz_details_table";
    //column names for database table
    private static final String KEY_ID= "_id";
    private static final String KEY_TOTAL_SCORE = "total_score";
    private static final String KEY_C1 = "c1";
    private static final String KEY_C2 = "c2";
    private static final String KEY_C3= "c3";
    private static final String KEY_C4= "c4";
    private static final String KEY_C5= "c5";
    private static final String KEY_C6= "c6";
    private static final String KEY_C7= "c7";
    private static final String KEY_C8= "c8";
    private static final String KEY_DATE_HASH = "date_hash";

//    private static final String KEY_DATE= "date";

    QuizDatabase(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        //CREATE TABLE nametame(id INT PRIMARY KEY, title TEXT, content TEXT, date TEXT, time TEXT);
        String query;
        query = "CREATE TABLE "+DATABASE_TABLE+ " (" + KEY_ID + " INTEGER PRIMARY KEY " +
                        "AUTOINCREMENT, " + KEY_TOTAL_SCORE + " INTEGER, " +
                        KEY_C1 + " INTEGER, "+KEY_C2 + " INTEGER, "+KEY_C3 + " INTEGER, "+KEY_C4 + " INTEGER, "+
                        KEY_C5 + " INTEGER, "+KEY_C6 + " INTEGER, "+KEY_C7 + " INTEGER, "+KEY_C8 + " INTEGER, "+KEY_DATE_HASH + " INTEGER)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion>=newVersion)
            return;
        db.execSQL(new StringBuilder().append("DROP TABLE IF EXISTS").append(DATABASE_TABLE).toString());
        onCreate(db);
    }

    public ArrayList<QuizDetails> getQuizEntries(){
        SQLiteDatabase db=this.getReadableDatabase();
        ArrayList<QuizDetails> quizEntries=new ArrayList<>();
        Cursor cursor=db.rawQuery("SELECT * FROM "+DATABASE_TABLE,null);
        if(cursor.moveToFirst()){
            do{
                int []arr={cursor.getInt(2),cursor.getInt(3),
                        cursor.getInt(4),cursor.getInt(5),cursor.getInt(6),cursor.getInt(7),
                        cursor.getInt(8),cursor.getInt(9)};
                quizEntries.add(new QuizDetails(cursor.getInt(1),arr,cursor.getInt(10)));
            }while(cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return quizEntries;
    }

    public ArrayList<QuizDetails> getFilteredQuizEntries(int hash1,int hash2){
        SQLiteDatabase db=this.getReadableDatabase();
        ArrayList<QuizDetails> quizEntries=new ArrayList<>();
        String query="SELECT * FROM " + DATABASE_TABLE + " WHERE " + KEY_DATE_HASH + ">="+hash1 +
                " AND " + KEY_DATE_HASH + "<=" + hash2 + ";";
        Cursor cursor=db.rawQuery(query,null);

        if(cursor.moveToFirst()){

        }

        cursor.close();
        db.close();
        return quizEntries;
    }

    public void addNewQuiz(QuizDetails quiz){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();

        cv.put(KEY_TOTAL_SCORE,quiz.getQuizScoreTotal());
        cv.put(KEY_C1,quiz.getCategoryScores()[0]);
        cv.put(KEY_C2,quiz.getCategoryScores()[1]);
        cv.put(KEY_C3,quiz.getCategoryScores()[2]);
        cv.put(KEY_C4,quiz.getCategoryScores()[3]);
        cv.put(KEY_C5,quiz.getCategoryScores()[4]);
        cv.put(KEY_C6,quiz.getCategoryScores()[5]);
        cv.put(KEY_C7,quiz.getCategoryScores()[6]);
        cv.put(KEY_C8,quiz.getCategoryScores()[7]);
        cv.put(KEY_DATE_HASH,quiz.getQuizDateHash());

        db.insert(DATABASE_TABLE,null,cv);
        db.close();
    }

    public boolean updateQuiz(QuizDetails quiz,int id){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();

        //Refer Documentation if doesn't work
        int x = db.update(DATABASE_TABLE,cv,"_id=?",new String[]{String.valueOf(id)});
        db.close();
        return x>0;
    }

    public boolean deleteQuiz(String content){
        SQLiteDatabase db=this.getWritableDatabase();
//        db.delete(DATABASE_TABLE,"id=" +id,null);
        int x = db.delete(DATABASE_TABLE, KEY_C1 +"=?",new String[]{content});
        db.close();
        return x>0;
    }

}
