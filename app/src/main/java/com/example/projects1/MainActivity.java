package com.example.projects1;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn_clean,btn_plus,btn_subtract,btn_multiply,btn_divide,btn_point,btn_equal;//各个操作按钮
    Button btn_1,btn_2,btn_3,btn_4,btn_5,btn_6,btn_7,btn_8,btn_9,btn_0;//各个数字按钮
    int[] number_id = new int[]{R.id.btn_0,R.id.btn_1,R.id.btn_2,R.id.btn_3,R.id.btn_4,R.id.btn_5,R.id.btn_6,R.id.btn_7,R.id.btn_8,R.id.btn_9};//数字按钮id
    private Button[] buttons = new Button[10];
    TextView tv,edit ;//显示框
    private String opt = "+";//操作符
    private double n1 = 0.0, n2 = 0.0;//两个操作数
    String str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    /**
     * 初始化,通过ID获取各个按钮
     * 并且绑定监听器
     */
    public void init(){
        tv = this.findViewById(R.id.tv);
        edit = this.findViewById(R.id.edit);
        btn_clean = this.findViewById(R.id.btn_clean);
        btn_clean.setOnClickListener(this.lisenter);

        btn_plus = this.findViewById(R.id.btn_plus);
        btn_plus.setOnClickListener(this.lisenter);

        btn_subtract = this.findViewById(R.id.btn_subtract);
        btn_subtract.setOnClickListener(this.lisenter);

        btn_multiply = this.findViewById(R.id.btn_multiply);
        btn_multiply.setOnClickListener(this.lisenter);

        btn_divide = this.findViewById(R.id.btn_divide);
        btn_divide.setOnClickListener(this.lisenter);

        btn_point = this.findViewById(R.id.btn_point);
        btn_point.setOnClickListener(this.lisenter);

        btn_equal = this.findViewById(R.id.btn_equal);
        btn_equal.setOnClickListener(this.lisenter);

        for(int i=0;i<number_id.length;i++){
            buttons[i] =(Button)this.findViewById(number_id[i]);
            buttons[i].setOnClickListener(this.lisenter);
        };

    }

    /**
     * 按钮的监听器
     */
    private View.OnClickListener lisenter = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int id = view.getId();//获取id
            Button button = (Button)view.findViewById(id);//获取该按钮
            String current = button.getText().toString();//获取该按钮的字符串
            switch (id){
                //数字类型按钮，在编辑框后添加数字并将编辑框内容拷贝到算术框中
                case R.id.btn_0:
                    str = edit.getText().toString();
                    edit.setText(str+0);
                    tv.setText(edit.getText().toString());
                    break;
                case R.id.btn_1:
                    str = edit.getText().toString();
                    edit.setText(str+1);
                    tv.setText(edit.getText().toString());
                    break;
                case R.id.btn_2:
                    str = edit.getText().toString();
                    edit.setText(str+2);
                    tv.setText(edit.getText().toString());
                    break;
                case R.id.btn_3:
                    str = edit.getText().toString();
                    edit.setText(str+3);
                    tv.setText(edit.getText().toString());
                    break;
                case R.id.btn_4:
                    str = edit.getText().toString();
                    edit.setText(str+4);
                    tv.setText(edit.getText().toString());
                    break;
                case R.id.btn_5:
                    str = edit.getText().toString();
                    edit.setText(str+5);
                    tv.setText(edit.getText().toString());
                    break;
                case R.id.btn_6:
                    str = edit.getText().toString();
                    edit.setText(str+6);
                    tv.setText(edit.getText().toString());
                    break;
                case R.id.btn_7:
                    str = edit.getText().toString();
                    edit.setText(str+7);
                    tv.setText(edit.getText().toString());
                    break;
                case R.id.btn_8:
                    str = edit.getText().toString();
                    edit.setText(str+8);
                    tv.setText(edit.getText().toString());
                    break;
                case R.id.btn_9:
                    str = edit.getText().toString();
                    edit.setText(str+9);
                    tv.setText(edit.getText().toString());
                    break;
                case R.id.btn_point:
                     str = edit.getText().toString();
                    if(str.indexOf(".") != -1) //判断字符串中是否已经包含了小数点，如果有就什么也不做
                    {

                    }
                    else //如果没有小数点
                    {
                        if(str.equals("0"))//如果开始为0，
                            edit.setText(("0" + "."));
                        else if(str.equals(""))//如果初时显示为空，就什么也不做
                        {

                        }
                        else
                            edit.setText(str + ".");
                    }
                    break;
                case R.id.btn_plus:
                    //首先获取编辑框的数字将其置入为n1
                    str = edit.getText().toString();
                    n1 = Double.parseDouble(str);
                    //清空编辑框
                    edit.setText("");
                    opt = "+";
                    //在算式框中加入新的算式
                    tv.setText(n1 + opt);
                    break;
                case R.id.btn_multiply:
                    str = edit.getText().toString();
                    n1 = Double.parseDouble(str);
                    edit.setText("");
                    opt = "*";
                    tv.setText(n1 + opt);
                    break;
                case R.id.btn_divide:
                    str = edit.getText().toString();
                    n1 = Double.parseDouble(str);
                    edit.setText("");
                    opt = "/";
                    tv.setText(n1 + opt);
                    break;
                case R.id.btn_subtract:
                    str = edit.getText().toString();
                    n1 = Double.parseDouble(str);
                    edit.setText("");
                    opt = "-";
                    tv.setText(n1 + opt);
                    break;
                case R.id.btn_clean:
                    tv.setText("");
                    edit.setText("");
                    break;
                case R.id.btn_equal:
                    if(opt=="+"){
                        str = edit.getText().toString();
                        n2 = Double.parseDouble(str);
                        tv.setText(n1 + opt + n2 + "=");
                        edit.setText((n1 + n2) + "");
                    }
                    else if(opt=="-"){
                        str = edit.getText().toString();
                        n2 = Double.parseDouble(str);
                        tv.setText(n1 + opt + n2 + "=");
                        edit.setText((n1 - n2) + "");
                    }
                    else if(opt=="*"){
                        str = edit.getText().toString();
                        n2 = Double.parseDouble(str);
                        tv.setText(n1 + opt + n2 + "=");
                        edit.setText((n1 * n2) + "");
                    }
                    else if(opt=="/"){
                        str = edit.getText().toString();
                        n2 = Double.parseDouble(str);
                        if(n2 == 0){
                            edit.setText("");
                            tv.setText("除数不能为0");
                            break;
                        }else{
                            tv.setText(n1 + opt + n2 + "=");
                            edit.setText((n1 / n2) + "");
                        }
                    }
            }
        }
    };

}
