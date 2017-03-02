package hhh.zjh.com.weightgauge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        Bundle bunde=this.getIntent().getExtras();
        String sex=bunde.getString("sex");
        double height=bunde.getDouble("height");
        String sexText="";
        if(sex.equals("M")){
            sexText="男性";
        }else{
            sexText="女性";
        }
        String weight=this.getWeight(sex,height);
        TextView output=(TextView)findViewById(R.id.output);
        output.setText("你是一位"+sexText+"\n你的身高是"+height+"公分\n你的体重是"+weight+"公斤");
    }
    private String format(double num){
        NumberFormat formtter=new DecimalFormat("0.00");
        String s=formtter.format(num);
        return s;
    }
    private String getWeight(String sex,double height){
        String weight="";
        if(sex.equals("M")){
            weight=format((height-80)*0.7);
        }else{
            weight=format((height-70)*0.6);
        }
        return weight;
    }
}
