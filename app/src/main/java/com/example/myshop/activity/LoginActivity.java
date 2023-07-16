package com.example.myshop.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myshop.Data.DataUserBaseHelper;
import com.example.myshop.R;
import com.example.myshop.databinding.ActivityLoginBinding;
import com.example.myshop.discountActivity.BerryDiscountActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText eEditusername;
    private EditText eEditpassword;
    private Button eButtonLogin;
    private TextView eRegister;

    private TextView eForget;

    DataUserBaseHelper dataUserBaseHelper;
    ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
        initEvent();


        binding.loginLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=binding.loginAccountNumber.getText().toString();
                String password=binding.loginPassword.getText().toString();
                if(email.equals("")||password.equals("")){
                    Toast.makeText(LoginActivity.this,"未完整填写！",Toast.LENGTH_SHORT).show();
                }else{
                    Boolean checkCredentials= dataUserBaseHelper.checkEmailPassword(email,password);
                    if(checkCredentials==true){
                        Toast.makeText(LoginActivity.this,"登录成功！",Toast.LENGTH_SHORT).show();

                        Intent intent1 = new Intent(LoginActivity.this, MainActivity.class);
                        intent1.putExtra("USERNAME_KEY", email);
                        startActivity(intent1);

                    }else{
                        Toast.makeText(LoginActivity.this,"账号或密码错误！",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        binding.loginRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });


    }

    private void initEvent() {

        eRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toRegisterActivity();
            }
        });

        eForget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toForgetActivity();
            }
        });
    }

    private void toForgetActivity() {
        Intent intent=new Intent(this,ForgetActivity.class);
        startActivity(intent);
    }


    private void toRegisterActivity() {
        Intent intent=new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }

    private void initView() {
        eEditusername=findViewById(R.id.login_account_number);
        eRegister=findViewById(R.id.login_register);
        eButtonLogin=findViewById(R.id.login_login_button);
        eEditpassword=findViewById(R.id.login_password);
        eForget=findViewById(R.id.login_forget);
        dataUserBaseHelper =new DataUserBaseHelper(this);
    }
}