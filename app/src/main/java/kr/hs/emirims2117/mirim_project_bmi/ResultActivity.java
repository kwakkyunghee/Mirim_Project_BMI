package kr.hs.emirims2117.mirim_project_bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView textComment;
    ImageView imgv;
    double bmi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        textComment = findViewById(R.id.text_result_comment);
        imgv = findViewById(R.id.imgv);
        Button btnHome = findViewById(R.id.home);
        btnHome.setOnClickListener(btnHomeListener);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        double weight = Double.parseDouble(intent.getStringExtra("weight"));
        double height = Double.parseDouble(intent.getStringExtra("height"));
        bmi = weight / Math.pow(height/100, 2);
        String bmiRasult = "";
        if(bmi < 18.5){
            bmiRasult = "저";
            imgv.setImageResource(R.drawable.bmi1);
        } else if(bmi < 24.9){
            bmiRasult = "정상";
            imgv.setImageResource(R.drawable.bmi2);
        }else if(bmi < 29.9){
            bmiRasult = "과";
            imgv.setImageResource(R.drawable.bmi3);
        }else if(bmi < 34){
            bmiRasult = "비만";
            imgv.setImageResource(R.drawable.bmi4);
        }else{
            bmiRasult = "고도비만";
            imgv.setImageResource(R.drawable.bmi5);
        }

        textComment.setText(name + "님의 BMI지수는 " + String.format("%.2f", bmi) + "(㎏/㎡)입니다. 따라서 " +bmiRasult +"체중입니다" );
    }
    View.OnClickListener btnHomeListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            finish();
        }
    };
}