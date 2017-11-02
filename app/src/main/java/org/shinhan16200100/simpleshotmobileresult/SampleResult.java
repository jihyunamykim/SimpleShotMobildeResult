package org.shinhan16200100.simpleshotmobileresult;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SampleResult extends AppCompatActivity {

    TextView seethesample ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_result);

        Intent intent =getIntent();
        String sampleresult = intent.getStringExtra("SAMPLERESULT");
        seethesample =(TextView)findViewById(R.id.seethesample);
        seethesample.setText(sampleresult);
    }
}
