package cn.yuchuanxi.scrollview;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.MonthDisplayHelper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	private String ss;
	TextView tv;
	ScrollView sv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ss=getResources().getString(R.string.contents);
		tv=(TextView) findViewById(R.id.tv);
		sv=(ScrollView) findViewById(R.id.sv);
		tv.setText(ss);
		
		sv.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View arg0, MotionEvent event) {
				// TODO Auto-generated method stub
				switch(event.getAction()){
				/**
				 * ACTION_UP��ACTION_MOVE����������һ��.
				 * ��Ϊmove���ƶ������л��δ����¼�,����ɹ���������.
				 * UP����ָ�뿪��Ļ��ʱ��Ŵ����¼�.
				 * �������и��ö�������?
				 */
				case MotionEvent.ACTION_UP:
//					break;
//				case MotionEvent.ACTION_MOVE:
					if (sv.getScrollY()<=0){
						Log.i("Main", "�ƶ���������!!");
						Toast.makeText(MainActivity.this,"�ƶ���������!!" , 100).show();
					}
					
					/**
					 * getHeight()һ���ĸ߶�
					 * getMeasuredHeight() ����ScrollView�ĸ߶�
					 * getScrollY() ���������ڵ�����Y��, �ڶ�������0,�ڵײ�����getMeasuredHeight()��ȥһ���߶ȵĲ�.
					 */
					if (sv.getChildAt(0).getMeasuredHeight()<=sv.getHeight()+sv.getScrollY()){
						Log.i("Main","�ƶ����ײ���!!");
						Toast.makeText(MainActivity.this,"�ƶ����ײ���!!" , 100).show();
					}
					
					break;
				
				}
				
				return false;
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}