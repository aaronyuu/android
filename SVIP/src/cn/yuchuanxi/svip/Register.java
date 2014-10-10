package cn.yuchuanxi.svip;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager.OnActivityResultListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Register extends Activity {
	
	private Button register;
	private ToggleButton agree;
	private String result;
	private TextView textViewResult;
	private EditText username;
	private EditText password;
	private String sPassword;
	private EditText password_confirm;
	private String sPasswordConfirm;
	private RadioGroup sex;
	private String sSex;
	private CheckBox cb1;
	private CheckBox cb2;
	private CheckBox cb3;
	private CheckBox cb4;
//	int x;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		
		register=(Button) findViewById(R.id.button_register);
		agree=(ToggleButton) findViewById(R.id.toggleButton1);
		textViewResult=(TextView) findViewById(R.id.textView_result);
		username=(EditText) findViewById(R.id.editText_username);
		password=(EditText) findViewById(R.id.editText_password);
		sPassword=password.getText().toString();
		password_confirm=(EditText) findViewById(R.id.editText_password_confirm);
		sPasswordConfirm=password_confirm.getText().toString();
		sex=(RadioGroup) findViewById(R.id.radioGroup_sex);
		
		cb1=(CheckBox) findViewById(R.id.checkBox1);
		cb2=(CheckBox) findViewById(R.id.checkBox2);
		cb3=(CheckBox) findViewById(R.id.checkBox3);
		cb4=(CheckBox) findViewById(R.id.checkBox4);
		
//		 x=sex.getCheckedRadioButtonId();
//		Integer xx=x; 
//		 Log.i("tag", xx.toString());
////		Toast.makeText(this, x, 5000).show();

		
		//���ע�ᰴť
		register.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				switch (sex.getCheckedRadioButtonId()){
				case R.id.radio_male:
					sSex="��";
					break;
				default:
					sSex="Ů";
					break;
				}
					
//					 Log.i("tag", xx.toString());
//					 Toast.makeText(Register.this, xx.toString(), 5000).show();
//				
				if (username.getText().length()>0&&password.getText().length()>0){
					if (password.getText().toString().equals(password_confirm.getText().toString())){
//						Toast.makeText(Register.this, x, 5000).show();
						Intent intent=new Intent(Register.this, RegisterConfirm.class);
						intent.putExtra("username", "�û�����:"+username.getText());  
						intent.putExtra("password", "������:"+password.getText()); 

						intent.putExtra("sex", "�Ա���:"+sSex); 
						startActivityForResult(intent, 1);
					}else{
						Toast.makeText(Register.this, "������������벻ƥ��"+password.getText().toString()+","+password_confirm.getText().toString(), 5000).show();
					}
				}else{
					Toast.makeText(Register.this, "�û������벻��Ϊ��", 5000).show();
				}
			}
		});
		
		agree.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
	}
	
	/*
	 * 
	 */
	
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	// TODO Auto-generated method stub
	super.onActivityResult(requestCode, resultCode, data);
	result=data.getStringExtra("data");
	textViewResult.setText(result);
}



@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Register other = (Register) obj;
	if (password == null) {
		if (other.password != null)
			return false;
	} else if (!password.equals(other.password))
		return false;
	return true;
}
	
}