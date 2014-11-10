package com.android.broadcastbestpractice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BaseActivity {

	private EditText userEdit;

	private EditText pwdEdit;

	private Button login;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_layout);
		userEdit = (EditText) findViewById(R.id.username);
		pwdEdit = (EditText) findViewById(R.id.password);
		login = (Button) findViewById(R.id.login);
		login.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String userName = userEdit.getText().toString();
				String pwd = pwdEdit.getText().toString();
				if (userName.equals("admin") && pwd.equals("123456")) {
					Intent intent = new Intent(LoginActivity.this,
							MainActivity.class);
					startActivity(intent);
					finish();
				} else {
					Toast.makeText(LoginActivity.this, "用户名或密码不正确.",
							Toast.LENGTH_SHORT).show();
				}
			}
		});
	}
}
