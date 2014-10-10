package cn.yuchuanxi.svip;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class RegisterConfirm extends Activity {
	private Button button_return;
	private TextView tv;
	private String getResult;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register_confirm);
		button_return=(Button)findViewById(R.id.button_return);
		tv=(TextView) findViewById(R.id.textView_info);
		
		Intent i=this.getIntent();
		getResult=i.getExtras().getString("username");
		getResult=getResult+"\n"+i.getExtras().getString("password");
		getResult=getResult+"\n"+i.getExtras().getString("sex");
		tv.setText(getResult);
		
		button_return.setOnClickListener(new OnClickListener() {
		
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent data=new Intent();
				data.putExtra("data", "¹§Ï²Äã,×¢²á³É¹¦!!!");
				setResult(1, data);
				finish();
			}
		});
		
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		tv.setText(data.getStringExtra("info"));
	}
}
