package org.shinhan16200100.simpleshotmobileresult;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 60029511 on 2017-11-04.
 */

public class DBHelper extends SQLiteOpenHelper {

    //DB 이름과 버전 정보를 받음
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context,name,factory,version);
    }

    //DB 새로 생성
    @Override
    public void onCreate(SQLiteDatabase db){

        //테이블 생성
        db.execSQL("CREATE TABLE receipt_table (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "aproveno TEXT, cardno TEXT, aprovedate TEXT, payaccount TEXT, content TEXT, department TEXT);");

    }


    //DB 업그레이드를 위해 버전이 변경될 때 호출되는 함수
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }

    public void insert(String aproveno,String cardno, String aprovedata, String payaccount, String content, String department){
        //읽고 쓰기가 가능하게 DB 열기
        SQLiteDatabase db = getWritableDatabase();

        //DB에 입력한 값으로 행 추가
        db.execSQL("INSERT INTO receipt_table VALUES(null, '" + aproveno + "','" + cardno + "','" + aprovedata + "','" + payaccount + "','" + content + "','" + department + "');");
        db.close();

    }

    public String getResult(){
        //읽기가 가능하게 DB 열기
        SQLiteDatabase db = getReadableDatabase();
        String result = "";

        //DB에 있는 데이터를 쉽게 처리하기 위해 Cursor를 사용하여 테이블에 있는 모든 데이터 출력
        Cursor cursor = db.rawQuery("SELECT * FROM receipt_table",null);
        while(cursor.moveToNext()){
            result += cursor.getString(0)
                    + ":"
                    + cursor.getString(1)
                    + "|"
                    + cursor.getInt(2)
                    + "원 "
                    + cursor.getString(3)
                    + "\n";
        }

        return result;
    }
}
