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
				 * ACTION_UP比ACTION_MOVE动作更合适一点.
				 * 因为move在移动过程中会多次触发事件,会造成过多的误操作.
				 * UP是手指离开屏幕的时候才触发事件.
				 * 或许还有更好动作监听?
				 */
				case MotionEvent.ACTION_UP:
//					break;
//				case MotionEvent.ACTION_MOVE:
					if (sv.getScrollY()<=0){
						Log.i("Main", "移动到顶部了!!");
						Toast.makeText(MainActivity.this,"移动到顶部了!!" , 100).show();
					}
					
					/**
					 * getHeight()一屏的高度
					 * getMeasuredHeight() 整个ScrollView的高度
					 * getScrollY() 滚动条现在的坐标Y点, 在顶部等于0,在底部等于getMeasuredHeight()减去一屏高度的差.
					 */
					if (sv.getChildAt(0).getMeasuredHeight()<=sv.getHeight()+sv.getScrollY()){
						Log.i("Main","移动到底部了!!");
						Toast.makeText(MainActivity.this,"移动到底部了!!" , 100).show();
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
