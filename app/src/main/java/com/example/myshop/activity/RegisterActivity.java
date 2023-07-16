package com.example.myshop.activity;

import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myshop.Data.DataUserBaseHelper;
import com.example.myshop.R;
import com.example.myshop.databinding.ActivityRegisterBinding;


public class RegisterActivity extends BaseActivity {
    private EditText eRegisterusername;
    private EditText eRegisterpassword;
    private EditText eRegisterrepassword;
    private Button eRegisterbutton;

    DataUserBaseHelper dataUserBaseHelper;
    ActivityRegisterBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
        setupToolBar();


        binding.registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=binding.registerUsername.getText().toString();
                String password=binding.registerPassword.getText().toString();
                String confirmPassword=binding.registerPasswordAgain.getText().toString();
                if(email.equals("")||password.equals("")||confirmPassword.equals("")){
                    Toast.makeText(RegisterActivity.this,"未完整填写！",Toast.LENGTH_SHORT).show();
                }else {
                    if(password.equals(confirmPassword)){
                        Boolean checkUserEmail= dataUserBaseHelper.checkEmail(email);
                        if(checkUserEmail==false){
                            Boolean insert= dataUserBaseHelper.insertData(email,password);
                            if(insert==true){
                                Toast.makeText(RegisterActivity.this,"注册成功！",Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(getApplicationContext(), LoginActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(RegisterActivity.this,"注册失败！",Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(RegisterActivity.this,"用户已经注册！",Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(RegisterActivity.this,"两次输入密码不一致！",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }



    protected void setupToolBar() {
        Toolbar toolbar=findViewById(R.id.id_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }


    private void initView() {
        eRegisterusername=findViewById(R.id.register_username);
        eRegisterpassword=findViewById(R.id.register_password);
        eRegisterrepassword=findViewById(R.id.register_password_again);
        eRegisterbutton=findViewById(R.id.register_button);
        dataUserBaseHelper =new DataUserBaseHelper(this);
    }
}