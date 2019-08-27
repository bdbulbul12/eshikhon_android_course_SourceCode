package com.example.databasedemosqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private EditText nameET,ageET,genderET,idET;
    private Button addBtn,showDataBtn,updateBtn,deleteBtn;
    TextView showDataViewTv;

    MyDatabaseHelper myDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        nameET=findViewById(R.id.nameId);
        ageET=findViewById(R.id.ageId);
        genderET=findViewById(R.id.genderId);
        idET=findViewById(R.id.stId);

        addBtn=findViewById(R.id.addDataId);
        showDataBtn=findViewById(R.id.showDataId);
        showDataViewTv=findViewById(R.id.showDataView);
        updateBtn=findViewById(R.id.updateDataId);
        deleteBtn=findViewById(R.id.deleteDataId);


        myDatabaseHelper = new MyDatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase = myDatabaseHelper.getWritableDatabase();


            //========================Insert Data================================

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name=nameET.getText().toString();
                String age = ageET.getText().toString();
                String gender = genderET.getText().toString();


                if(TextUtils.isEmpty(name) || TextUtils.isEmpty(age) || TextUtils.isEmpty(gender)){

                    Toast.makeText(MainActivity.this, "Name , age , gender Reqired", Toast.LENGTH_SHORT).show();
                }else{

                    long rowId =myDatabaseHelper.insertData(name,age,gender);

                    if(rowId==-1){
                        Toast.makeText(MainActivity.this, "Unsuceesfull", Toast.LENGTH_SHORT).show();
                    }else{

                        Toast.makeText(MainActivity.this, "Row "+rowId+ " inserted", Toast.LENGTH_SHORT).show();
                    }
                }



            }
        });

        //=======================Show or View Data =============================

        showDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Cursor cursor = myDatabaseHelper.showData();

                if(cursor.getCount()==0){
                    showDataViewTv.setText("No Data Found !! ");
                }else{

                    StringBuffer stringBuffer = new StringBuffer();

                    while (cursor.moveToNext()){
                        stringBuffer.append("ID : "+cursor.getString(0)+"\n");
                        stringBuffer.append("Name : "+cursor.getString(1)+"\n");
                        stringBuffer.append("Age : "+cursor.getString(2)+"\n");
                        stringBuffer.append("Gender : "+cursor.getString(3)+"\n \n \n");

                    }

                    showDataViewTv.setText(stringBuffer.toString());
                }
            }
        });


        // ===========================Update Data==============================


        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String id = idET.getText().toString();
                String name = nameET.getText().toString();
                String age = ageET.getText().toString();
                String gender = genderET.getText().toString();

                boolean isUpdate = myDatabaseHelper.upDateData(id,name,age,gender);

                if(isUpdate==true){
                    Toast.makeText(MainActivity.this, "Data is updated", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Data is not Updated", Toast.LENGTH_SHORT).show();
                }

            }
        });

        //=============Delete Data=================


        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = idET.getText().toString();

                int value = myDatabaseHelper.deleteData(id);

                if(value>0){
                    Toast.makeText(MainActivity.this, "Data is deleted", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Data is not deleted", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


}
