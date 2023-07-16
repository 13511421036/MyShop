package com.example.myshop.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.myshop.Data.DataUserBaseHelper;
import com.example.myshop.R;
import com.example.myshop.databinding.ActivityForgetBinding;
import com.example.myshop.databinding.ActivityResetpasswordBinding;

public class ResetpasswordActivity extends AppCompatActivity {
    String username;
    DataUserBaseHelper dataUserBaseHelper;
    ActivityResetpasswordBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityResetpasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = getIntent();
        username = intent.getStringExtra("USERNAME_KEY");

        dataUserBaseHelper =new DataUserBaseHelper(this);

        binding.resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=binding.resetNumber.getText().toString();
                String password=binding.resetPassword.getText().toString();
                String confirmpassword=binding.resetConfirmpassword.getText().toString();
                if(email.equals("")||password.equals("")){
                    Toast.makeText(ResetpasswordActivity.this,"未完整填写！",Toast.LENGTH_SHORT).show();
                }else{
                    if(password.equals(confirmpassword)){
                        dataUserBaseHelper.delete(email);
                        dataUserBaseHelper.insertData(email,password);
                        Toast.makeText(ResetpasswordActivity.this,"重置成功！",Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(ResetpasswordActivity.this, LoginActivity.class);
                        startActivity(intent1);
                        finish();
                    }else{
                        Toast.makeText(ResetpasswordActivity.this,"两次输入密码不一致！",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });



    }
}