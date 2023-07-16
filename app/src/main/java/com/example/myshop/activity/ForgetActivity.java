package com.example.myshop.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.myshop.Data.DataUserBaseHelper;
import com.example.myshop.R;
import com.example.myshop.databinding.ActivityForgetBinding;
import com.example.myshop.databinding.ActivityLoginBinding;

public class ForgetActivity extends AppCompatActivity {


    DataUserBaseHelper dataUserBaseHelper;
    ActivityForgetBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityForgetBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        dataUserBaseHelper =new DataUserBaseHelper(this);
        binding.forgetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=binding.forgetAdminnumber.getText().toString();
                String password=binding.forgetAdminpassword.getText().toString();
                if(email.equals("")||password.equals("")){
                    Toast.makeText(ForgetActivity.this,"未完整填写！",Toast.LENGTH_SHORT).show();
                }else{
                    Boolean checkCredentials= dataUserBaseHelper.checkadmin(email,password);
                    if(checkCredentials==true){
                        Toast.makeText(ForgetActivity.this,"验证成功！",Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(ForgetActivity.this, ResetpasswordActivity.class);
                        intent1.putExtra("USERNAME_KEY", email);
                        startActivity(intent1);
                    }else{
                        Toast.makeText(ForgetActivity.this,"账号或密码错误！",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}