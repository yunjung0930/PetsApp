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
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
/*
    수정
    1) '좋아하는 안드로이드 버전은 어떤건가요?'
    2) 체크박스를 스위치로 변경
    3) 선택 완료 대신, 라디오 버튼을 선택할 때마다 즉시 해당 이미지가 나오도록 변경
    4) 버튼 2개 끝부분에 추가
        - 종료 -> 응용 프로그램 종료
        - 처음으로 -> 초기화되고 처음 화면으로
 */
public class MainActivity extends AppCompatActivity {

    TextView textView1, textView2;
    Switch switchAgree;
    RadioGroup rGroup;
    RadioButton[] radioArray = new RadioButton[3];
    Button btnQuit, btnReturn;
    ImageView imageAndroid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);
        setTitle("안드로이드 사진 보기");

        // 위젯을 변수에 대입
        textView1 = findViewById(R.id.textViewSta);
        textView2 = findViewById(R.id.textViewCho);

        switchAgree = findViewById(R.id.switchAgree);

        rGroup = findViewById(R.id.Rgroup);
        radioArray[0] = findViewById(R.id.Rdo10);
        radioArray[1] = findViewById(R.id.Rdo11);
        radioArray[2] = findViewById(R.id.Rdo12);

        btnQuit = findViewById(R.id.BtnQuit);
        btnReturn = findViewById(R.id.BtnReturn);

        imageAndroid = findViewById(R.id.imageView);

        // switch가 체크되면
        switchAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                // 체크되면 모두 보이도록 설정
                if(switchAgree.isChecked() == true) {
                    textView2.setVisibility(View.VISIBLE);
                    rGroup.setVisibility(View.VISIBLE);
                    imageAndroid.setVisibility(View.VISIBLE);
                    btnQuit.setVisibility(View.VISIBLE);
                    btnReturn.setVisibility(View.VISIBLE);
                } else {
                    textView2.setVisibility(View.INVISIBLE);
                    rGroup.setVisibility(View.INVISIBLE);
                    imageAndroid.setVisibility(View.INVISIBLE);
                    btnQuit.setVisibility(View.INVISIBLE);
                    btnReturn.setVisibility(View.INVISIBLE);
                }
            }
        });

        // 라디오 버튼을 클릭하면, 이미지 뷰를 변경시킴 -> 배열로 처리함
        final int[] draw = {R.drawable.q10, R.drawable.r11, R.drawable.s12};

        for (int i=0; i < radioArray.length; i++) {
            final int index;
            index = i;
            radioArray[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    imageAndroid.setImageResource(draw[index]);
                }
            });
        }

        // 종료 버튼 클릭
        btnQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        // 처음으로 버튼 클릭
       btnQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView2.setVisibility(View.INVISIBLE);
                rGroup.setVisibility(View.INVISIBLE);
                imageAndroid.setVisibility(View.INVISIBLE);
                btnQuit.setVisibility(View.INVISIBLE);
                btnReturn.setVisibility(View.INVISIBLE);

                rGroup.clearCheck();
                switchAgree.setChecked(false);
            }
        });


    }
}