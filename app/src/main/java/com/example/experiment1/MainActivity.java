package com.example.experiment1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn1,btn2;
    ProgressDialog mydialog;
    LinearLayout login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1=(Button)findViewById(R.id.button1);
        btn2 = (Button)findViewById(R.id.button2);
        btn1.setOnClickListener(new mClick());
        btn2.setOnClickListener(new mClick());
    }

    class mClick implements View.OnClickListener {
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);

        public void onClick(View v) {
            if (v == btn1) {
                //设置对话框的标题
                dialog.setTitle("警告");
              /*  //设置对话框的图标
                dialog.setIcon(R.drawable.warn);*/
                //设置对话框的内容
                dialog.setMessage("弹出了提示对话框");
                //设置对话框“确定”按钮
                dialog.setPositiveButton("确定", new okClick());
                //创建对象框
                dialog.show();
            } else if (v == btn2) {
                login = (LinearLayout) getLayoutInflater().inflate(R.layout.login, null);  //从另外的布局关联组件
                dialog.setTitle("用户登录").setMessage("请输入用户名和密码").setView(login);
                dialog.setPositiveButton("确定", new loginClick());
                dialog.setNegativeButton("退出", new exitClick());
               /* dialog.setIcon(R.drawable.qq);*/
               // dialog.create();
                dialog.show();
            }
        }
        //普通对话框的确定
        class okClick implements DialogInterface.OnClickListener{
            public void onClick(DialogInterface dialog, int which){

            }
        }

        //输入对话框的“确定”按钮
        class loginClick implements DialogInterface.OnClickListener{
           EditText username;
            EditText txt;
            public void onClick(DialogInterface dialog,int which){
                username = (EditText)login.findViewById(R.id.userEdit);
                txt = (EditText)login.findViewById(R.id.pwdEdit);
                //从密码框中取值比较
                if((username.getText().toString()).equals("abc")&& (txt.getText().toString()).equals("123"))
                    Toast.makeText(getApplicationContext(),"登录成功",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(),"用户名或密码错误",Toast.LENGTH_SHORT).show();

            }
        }

        //输入对话框的“退出”按钮事件
        class exitClick implements DialogInterface.OnClickListener{
            public void onClick(DialogInterface dialog,int which){
                MainActivity.this.finish();   //点击退出按钮退出MainActivity
            }
        }
    }
}

