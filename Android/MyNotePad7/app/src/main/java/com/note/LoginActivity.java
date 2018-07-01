 package com.note;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.os.Build;

public class LoginActivity extends Activity {
	EditText usernameEdit;
	EditText pwdEdit;
	CheckBox rememberPwdCheck;
	Button loginBtn;
	ProgressBar progressBar;
	SharedPreferences pref;
	Handler handler;
	static final int STOP=0x111;
	static final int CONTINUE=0x112;
	static final int MAX=100;
	int progress;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		init();
		setListeners();

	}

	private void setListeners() {
		// TODO Auto-generated method stub
		loginBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String username=usernameEdit.getText().toString();
				String pwd=pwdEdit.getText().toString();
				if((!username.equals("admin"))||(!pwd.equals("admin"))){
			       Toast.makeText(LoginActivity.this, "用户名或密码不正确", Toast.LENGTH_LONG).show();
		}
		else{
			Editor editor=pref.edit();
			if(rememberPwdCheck.isChecked()){
				editor.putString("USERNAME", username);
				editor.putString("PWD", pwd);
				editor.putBoolean("REMBERPWD", true);
				editor.commit();
			}
			else{
				editor.putBoolean("REMBERPWD", false);
				editor.commit();
			}
			usernameEdit.setEnabled(false);
			pwdEdit.setEnabled(false);
			loginBtn.setEnabled(false);
			progressBar.setVisibility(View.VISIBLE);
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try{
						for(int i=0;i<5;i++){
							progress=(i+1)*20;
							Thread.sleep(1000);
							if(i==4){
								Message msg=new Message();
								msg.what=STOP;
								handler.sendMessage(msg);
								break;
							}
							else{
								Message msg=new Message();
								msg.what=CONTINUE;
								handler.sendMessage(msg);
							}
						}
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				}
			}).start();
		}
			}
		});
	}

	private void init() {
		// TODO Auto-generated method stub
		initViews();
		initHandler();
		
	}

	private void initHandler() {
		// TODO Auto-generated method stub
		handler=new Handler(){@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			switch(msg.what){
			case CONTINUE:
				if(!Thread.currentThread().isInterrupted()){
					progressBar.setProgress(progress);
				}
				break;
			case STOP:
				Intent intent=new Intent();
				intent.setClass(LoginActivity.this, MainShow.class);
				startActivity(intent);
				finish();
				break;
				default:
					break;
			}
			super.handleMessage(msg);
		}
		};
	}

	private void initViews() {
		// TODO Auto-generated method stub
		usernameEdit=(EditText) findViewById(R.id.edit_username);
		pwdEdit=(EditText) findViewById(R.id.edit_pwd);
		rememberPwdCheck=(CheckBox) findViewById(R.id.check_rememberPwd);
		loginBtn=(Button) findViewById(R.id.btn_login);
		progressBar=(ProgressBar) findViewById(R.id.progressbar);
		pref=getSharedPreferences("userinfo", Context.MODE_PRIVATE);
		usernameEdit.setText(pref.getString("USERNAME",""));
		if(pref.getBoolean("REMBERPWD",false)){
			pwdEdit.setText(pref.getString("PWD", ""));
		}
		else{
			pwdEdit.setText("");
		}
		rememberPwdCheck.setChecked(pref.getBoolean("REMBERPWD", false));
		progress=0;
		progressBar.setProgress(progress);
		progressBar.setMax(MAX);
	}

	
	

}
