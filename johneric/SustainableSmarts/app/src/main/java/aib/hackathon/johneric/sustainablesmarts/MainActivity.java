package aib.hackathon.johneric.sustainablesmarts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import aib.hackathon.johneric.sustainablesmarts.R;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {


    private Button goQuiz;
    private Button aboutUs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goQuiz = (Button) findViewById(R.id.quizBtn);
        aboutUs = (Button) findViewById(R.id.aboutBtn);

        goQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent quiz_act = new Intent(MainActivity.this, QuizActivity.class);
                startActivity(quiz_act);
            }
        });

        aboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent about_act = new Intent(MainActivity.this, AboutUs.class);
                startActivity(about_act);
            }
        });
    }


}
