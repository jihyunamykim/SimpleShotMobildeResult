package org.shinhan16200100.simpleshotmobileresult;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class OcrResult extends AppCompatActivity{

    Spinner mSpinner1;
    String   string_cardno;
    ArrayList<String> mArGeneral;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ocr_result);

        final DBHelper dbHelper = new DBHelper(getApplicationContext(), "receipt_table.db",null,1);
        final DBHelperCard dbHelpercard = new DBHelperCard(getApplicationContext(), "card_table.db",null,1);

        string_cardno ="";
        //

        String[]strTextList ;

        strTextList = dbHelpercard.getResult().split("\n");

        mArGeneral=new ArrayList<String>();

        for(int i=0;i<strTextList.length;i++){
            mArGeneral.add(strTextList[i]);
        }

        ArrayAdapter<String>adapter;

        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,mArGeneral);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mSpinner1= (Spinner)findViewById(R.id.spinner1);

        mSpinner1.setAdapter(adapter);




        //


        final EditText aproveno   = (EditText)findViewById(R.id.aproveno);
        //final EditText cardno     = (EditText)findViewById(R.id.cardno);
        final EditText aprovedate = (EditText)findViewById(R.id.aprovedate);
        final EditText payaccount = (EditText)findViewById(R.id.payaccount);
        final EditText content    = (EditText)findViewById(R.id.content);
        final EditText department = (EditText)findViewById(R.id.department);

        //DB에 데이터 추가
        Button savedata = (Button)findViewById(R.id.savedata);

        AdapterView.OnItemSelectedListener mItemSelectedListener =
                new AdapterView.OnItemSelectedListener(){
                    public void onItemSelected(AdapterView<?> parent,View view,
                                               int position, long id){

                        string_cardno = mArGeneral.get(position);
                    }
                    public void onNothingSelected(AdapterView<?> parent){
                        string_cardno="Nope";
                    }
                };
        //
        mSpinner1.setOnItemSelectedListener(mItemSelectedListener);

        savedata.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String st_aproveno  = aproveno.getText().toString();
                String st_aprovedate  = aprovedate.getText().toString();
                String st_payaccount  = payaccount.getText().toString();
                String st_content  = content.getText().toString();
                String st_department  = department.getText().toString();


                //입력항목 체크
                if(TextUtils.isEmpty(st_aproveno)){
                    Toast.makeText(getApplicationContext(), "승인번호를 입력하세요",Toast.LENGTH_SHORT).show();
                }else if (TextUtils.isEmpty(string_cardno)){
                    Toast.makeText(getApplicationContext(),"카드번호를 선택하세요",Toast.LENGTH_SHORT).show();
                }else if (TextUtils.isEmpty(st_aprovedate)){
                    Toast.makeText(getApplicationContext(),"승인일시를 입력하세요",Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(st_payaccount)){
                    Toast.makeText(getApplicationContext(),"결제 금액을 입력하세요",Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(st_content)){
                    Toast.makeText(getApplicationContext(),"내용을 입력하세요",Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(st_department)){
                    Toast.makeText(getApplicationContext(),"부서를 입력하세요",Toast.LENGTH_SHORT).show();
                }

                //dbHelper로 저장
                dbHelper.insert(st_aproveno,string_cardno,st_aprovedate,st_payaccount,st_content,st_department);

                Intent intent = new Intent( getApplicationContext(), Showlist.class);// 다음 넘어갈 클래스 지정
                startActivity(intent);//다음 화면으로 넘어간다
            }
        });
    }

    public void initSpinner(){

        //String[]strTextList ;

        String[]strTextList ={"1","2","3"};

        //strTextList = dbHelpercard.getResult().split("\n");

        mArGeneral=new ArrayList<String>();

        for(int i=0;i<3;i++){
            mArGeneral.add(strTextList[i]);
        }

        ArrayAdapter<String>adapter;

        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,mArGeneral);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mSpinner1= (Spinner)findViewById(R.id.spinner1);

        mSpinner1.setAdapter(adapter);
    }

}

