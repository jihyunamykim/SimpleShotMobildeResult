package org.shinhan16200100.simpleshotmobileresult;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SaveCardNumber extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_card_number);

        final DBHelperCard dbHelpercard = new DBHelperCard(getApplicationContext(), "card_table.db",null,1);

        //
        final EditText setcardnumber   = (EditText)findViewById(R.id.setcardnumber);

        //DB에 데이터 추가
        Button insertcardnumber = (Button)findViewById(R.id.insertcardnumber);

        insertcardnumber.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String st_setcardnumber  = setcardnumber.getText().toString();

                //입력항목 체크
                if(TextUtils.isEmpty(st_setcardnumber)){
                    Toast.makeText(getApplicationContext(), "카드번호를 입력하세요",Toast.LENGTH_SHORT).show();
                }
                //dbHelper로 저장
                dbHelpercard.insert(st_setcardnumber);

                Intent intent = new Intent( getApplicationContext(), FirstMenu.class);// 다음 넘어갈 클래스 지정
                startActivity(intent);//다음 화면으로 넘어간다
            }
        });

    }
}
