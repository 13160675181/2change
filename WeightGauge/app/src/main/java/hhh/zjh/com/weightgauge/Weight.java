package hhh.zjh.com.weightgauge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.content.Intent;

public class Weight extends AppCompatActivity {
    public static String sex="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button star=(Button)findViewById(R.id.start_button);
        star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                EditText st=(EditText)findViewById(R.id.hight_input);
                double height=Double.parseDouble(st.getText().toString());
                RadioGroup sexx=(RadioGroup)findViewById(R.id.radioGroup);
                sexx.setOnCheckedChangeListener(new OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup arg0, int checkedId) {
                        if(checkedId==R.id.male){
                            sex="M";
                        }
                        else{
                            sex="F";
                        }
                    }
                });
                Intent intent=new Intent();
                intent.setClass(Weight.this,Result.class);
                Bundle bundle=new Bundle();
                bundle.putDouble("height",height);
                bundle.putString("sex",sex);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
