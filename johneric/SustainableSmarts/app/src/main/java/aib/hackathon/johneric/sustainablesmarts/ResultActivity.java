package aib.hackathon.johneric.sustainablesmarts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import aib.hackathon.johneric.sustainablesmarts.R;

public class ResultActivity extends AppCompatActivity {

    private TextView result;
    private Button home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        result = (TextView) findViewById(R.id.resultView);
        home = (Button) findViewById(R.id.resHomeButton);

        String res = getIntent().getStringExtra("result").toString();

        result.setText(res);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent main_act = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(main_act);
            }
        });
    }
}
