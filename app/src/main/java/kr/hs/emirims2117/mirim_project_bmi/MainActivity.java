package kr.hs.emirims2117.mirim_project_bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.UiAutomation;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editname, editweight,edithight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editname = findViewById(R.id.edit_name);
        editweight = findViewById(R.id.edit_weight);
        edithight = findViewById(R.id.edit_hight);
        Button btnResult = findViewById(R.id.btn_result);
        btnResult.setOnClickListener(btnResultListener);


    }

    View.OnClickListener btnResultListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
            intent.putExtra("name", editname.getText().toString());
            intent.putExtra("weight", editweight.getText().toString());
            intent.putExtra("height", edithight.getText().toString());
            startActivity(intent);
        }
    };




}