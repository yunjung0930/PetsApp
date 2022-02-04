package kr.co.pets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView1, textView2;
    CheckBox chkAgree;
    RadioGroup rGroup;
    RadioButton rdoDog, rdoCat, rdoRabbit;
    Button btnOK;
    ImageView imagePet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);
        setTitle("반려동물 사진 보기");

        // 위젯을 변수에 대입
        textView1 = findViewById(R.id.textViewSta);
        textView2 = findViewById(R.id.textViewCho);

        chkAgree = findViewById(R.id.checkbox);

        rGroup = findViewById(R.id.Rgroup);
        rdoDog = findViewById(R.id.RdoDog);
        rdoCat = findViewById(R.id.RdoCat);
        rdoRabbit = findViewById(R.id.RdoRabbit);

        btnOK = findViewById(R.id.buttonOK);
        imagePet = findViewById(R.id.imageView);

        chkAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                //체크되면 위젯이 모두 보이도록 설정
                if(chkAgree.isChecked() == true) {
                    textView2.setVisibility(View.VISIBLE);
                    rGroup.setVisibility(View.VISIBLE);
                    btnOK.setVisibility(View.VISIBLE);
                    imagePet.setVisibility(View.VISIBLE);
                } else {
                    textView2.setVisibility(View.INVISIBLE);
                    rGroup.setVisibility(View.INVISIBLE);
                    btnOK.setVisibility(View.INVISIBLE);
                    imagePet.setVisibility(View.INVISIBLE);
                }
            }
        });

        // 선택완료 버튼을 클릭하면
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (rGroup.getCheckedRadioButtonId()) {
                    case R.id.RdoDog:
                        imagePet.setImageResource(R.drawable.dog3);
                        break;
                    case R.id.RdoCat:
                        imagePet.setImageResource(R.drawable.cat1);
                        break;
                    case R.id.RdoRabbit:
                        imagePet.setImageResource(R.drawable.rabbit2);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "동물을 먼저 선택하세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}