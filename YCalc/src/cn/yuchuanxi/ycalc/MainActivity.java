package cn.yuchuanxi.ycalc;

import android.R.string;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.math.*;

public class MainActivity extends Activity implements OnClickListener {

	Button bt_0; // ���ְ�ť
	Button bt_1; // ���ְ�ť
	Button bt_2; // ���ְ�ť
	Button bt_3; // ���ְ�ť
	Button bt_4; // ���ְ�ť
	Button bt_5; // ���ְ�ť
	Button bt_6; // ���ְ�ť
	Button bt_7; // ���ְ�ť
	Button bt_8; // ���ְ�ť
	Button bt_9; // ���ְ�ť
	Button bt_dot; // С���㰴ť
	Button bt_clear;
	Button bt_del;
	Button bt_plus; // �Ӻ�
	Button bt_minus; // ����
	Button bt_multiply; // �˺�
	Button bt_divide;// ����
	Button bt_equle; // �Ⱥ�
	EditText et_input; // ��ʾ��
	Boolean isGetResult = false;
	String str;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		silihua();
	}

	/**
	 * ʵ�����ؼ�
	 */
	private void silihua() {
		// TODO Auto-generated method stub
		bt_0 = (Button) findViewById(R.id.bt_0);
		bt_1 = (Button) findViewById(R.id.bt_1);
		bt_2 = (Button) findViewById(R.id.bt_2);
		bt_3 = (Button) findViewById(R.id.bt_3);
		bt_4 = (Button) findViewById(R.id.bt_4);
		bt_5 = (Button) findViewById(R.id.bt_5);
		bt_6 = (Button) findViewById(R.id.bt_6);
		bt_7 = (Button) findViewById(R.id.bt_7);
		bt_8 = (Button) findViewById(R.id.bt_8);
		bt_9 = (Button) findViewById(R.id.bt_9);
		bt_dot = (Button) findViewById(R.id.bt_dot);
		bt_clear = (Button) findViewById(R.id.bt_clear);
		bt_del = (Button) findViewById(R.id.bt_del);
		bt_divide = (Button) findViewById(R.id.bt_divide);
		bt_multiply = (Button) findViewById(R.id.bt_multiply);
		bt_plus = (Button) findViewById(R.id.bt_plus);
		bt_minus = (Button) findViewById(R.id.bt_minus);
		bt_equle = (Button) findViewById(R.id.bt_equle);

		et_input = (EditText) findViewById(R.id.et_input);

		bt_0.setOnClickListener(this);
		bt_1.setOnClickListener(this);
		bt_2.setOnClickListener(this);
		bt_3.setOnClickListener(this);
		bt_4.setOnClickListener(this);
		bt_5.setOnClickListener(this);
		bt_6.setOnClickListener(this);
		bt_7.setOnClickListener(this);
		bt_8.setOnClickListener(this);
		bt_9.setOnClickListener(this);
		bt_dot.setOnClickListener(this);
		bt_clear.setOnClickListener(this);
		bt_del.setOnClickListener(this);
		bt_divide.setOnClickListener(this);
		bt_multiply.setOnClickListener(this);
		bt_plus.setOnClickListener(this);
		bt_minus.setOnClickListener(this);
		bt_equle.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		str = et_input.getText().toString();
		switch (v.getId()) {
		case R.id.bt_0:
		case R.id.bt_1:
		case R.id.bt_2:
		case R.id.bt_3:
		case R.id.bt_4:
		case R.id.bt_5:
		case R.id.bt_6:
		case R.id.bt_7:
		case R.id.bt_8:
		case R.id.bt_9:
		case R.id.bt_dot:
			if (isGetResult) {
				isGetResult = false;
				str = "";
				et_input.setText(str);
			}
			et_input.setText(str + ((Button) v).getText() + "");
			break;
		case R.id.bt_clear:
			et_input.setText("");
			break;
		case R.id.bt_del:

			if (str != null && !str.equals("")) {
				et_input.setText(str.substring(0, str.length() - 1));
			}
			break;
		case R.id.bt_plus:
		case R.id.bt_minus:
		case R.id.bt_multiply:
		case R.id.bt_divide:
			if (isGetResult) {
				isGetResult = false;
			}
			et_input.setText(str + " " + ((Button) v).getText() + " ");

			break;
		case R.id.bt_equle:
			getResult();
			// Toast.makeText(MainActivity.this,"�����ǵȺ�", 5000).show();
			break;
		default:
			break;
		}

	}

	private void getResult() {
		// TODO Auto-generated method stub
		double result=0; // ������
		String exp = et_input.getText().toString();
		if (exp == null || exp.equals("")) {
			return;
		}
		if (!exp.contains(" ")) {
			return;
		}
		String s1 = exp.substring(0, exp.indexOf(" "));
//		String ops = exp.substring(exp.indexOf(" ") + 1, exp.indexOf(" ") + 2);
		char op = exp.charAt(exp.indexOf(" ")+1);
//		op='/';
		//Toast.makeText(MainActivity.this,"/"+exp.charAt(exp.indexOf(" ")+2)+"/", 5000).show();
		String s2 = exp.substring(exp.indexOf(" ") + 3);
		//Toast.makeText(MainActivity.this,( s1+"/")+(op+"/")+(s2+"/"), 5000).show();
		if (!s1.equals("") && !s2.equals("")) {
			double d1 = Double.parseDouble(s1);
			double d2 = Double.parseDouble(s2);

		//	Toast.makeText(MainActivity.this,( d1+"")+(op+"")+(d2+""), 5000).show();
			switch (op) {
			case '+':
				result = d1 + d2;
				break;
			case '-':
				result = d1 - d2;
				break;
			case '*':
				result = d1 * d2;
				break;
			case '/':
				if (d2 == 0) {
					result = 0;
				} else {
					result = d1 / d2;
				}

				break;
			default:
				break;
			}
			
			//String.valueOf(result);
			//��������һ�¾Ͳ������1.2*3=3.5999999999������ֵĶ�����.
			//et_input.setText(String.valueOf(Double.valueOf(String.format("%.16f",result))));
			et_input.setText((float)result+"");
					isGetResult=true;
		}
	}
}