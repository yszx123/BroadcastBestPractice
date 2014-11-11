package com.android.broadcastbestpractice;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BaseActivity {

	private SharedPreferences pref;

	private SharedPreferences.Editor editor;

	private EditText userEdit;

	private EditText pwdEdit;

	private Button login;

	private CheckBox checkBox;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_layout);
		pref = PreferenceManager.getDefaultSharedPreferences(this);
		userEdit = (EditText) findViewById(R.id.username);
		pwdEdit = (EditText) findViewById(R.id.password);
		login = (Button) findViewById(R.id.login);
		checkBox = (CheckBox) findViewById(R.id.remember_pass);
		boolean isRemember = pref.getBoolean("remember_pwd", false);
		if (isRemember) {
			String userName = pref.getString("userName", "");
			String pwd = pref.getString("pwd", "");
			userEdit.setText(userName);
			pwdEdit.setText(pwd);
			checkBox.setChecked(true);
		}
		login.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String userName = userEdit.getText().toString();
				String pwd = pwdEdit.getText().toString();
				if (userName.equals("admin") && pwd.equals("123456")) {
					editor = pref.edit();
					if (checkBox.isChecked()) {
						editor.putBoolean("remember_pwd", true);
						editor.putString("userName", userName);
						editor.putString("pwd", pwd);

					} else {
						editor.clear();
					}
					editor.commit();
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
