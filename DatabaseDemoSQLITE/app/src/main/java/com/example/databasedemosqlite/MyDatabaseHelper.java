package com.example.databasedemosqlite;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.security.cert.Extension;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="Student.db";
    private static final String TABLE_NAME="student_details";
    private static final int VERSION_NUMBER=1;

    private static final String ID="id";
    private static final String NAME="Name";
    private static final String AGE="Age";
    private static final String GENDER="Gender";
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS"+TABLE_NAME;
    private static final String SELECT_ALL="SELECT * FROM "+TABLE_NAME;

    private static final String CREATE_TABLE="CREATE TABLE "+TABLE_NAME+"("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+NAME+" VARCHAR(255),"+AGE+" INTEGER,"+GENDER+" VARCHAR(15));";

    private Context context;


    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION_NUMBER);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        try{
            Toast.makeText(context, "Oncreate call", Toast.LENGTH_SHORT).show();
            sqLiteDatabase.execSQL(CREATE_TABLE);
        }catch (Exception e){
            Toast.makeText(context, "Exception"+e, Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        try{
            Toast.makeText(context, "Onupgrade is called", Toast.LENGTH_SHORT).show();
            sqLiteDatabase.execSQL(DROP_TABLE);
        }catch (Exception e){
            Toast.makeText(context, "Exception"+e, Toast.LENGTH_SHORT).show();
        }


    }

    //insert Data function

    public long insertData(String name, String age, String gender) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME,name);
        contentValues.put(AGE,age);
        contentValues.put(GENDER,gender);

        long rowId =db.insert(TABLE_NAME,null,contentValues);
        return rowId;

    }

    //Show Data Function

    public Cursor showData(){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor=db.rawQuery(SELECT_ALL,null);

        return cursor;
    }

    // Update Functions

    public boolean upDateData(String id,String name,String age,String gender){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID,id);
        contentValues.put(NAME,name);
        contentValues.put(AGE,age);
        contentValues.put(GENDER,gender);

        db.update(TABLE_NAME,contentValues,ID+" = ?",new String[]{id});
        return true;

    }

    //delete function

    public  int deleteData(String id){

        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,ID+" = ?",new String[]{id});
    }

}
