package com.example.holamundo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
	
	private EditText et1,et2;
	private TextView tv3;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		et1=(EditText)findViewById(R.id.editText1);
        et2=(EditText)findViewById(R.id.editText2);
        tv3=(TextView)findViewById(R.id.textView3);

	}
	public void sumar(View view){
		String valor1 = et1.getText().toString();
		String valor2 = et2.getText().toString();
		int int1 = Integer.parseInt(valor1); 
		int int2 = Integer.parseInt(valor2);
		int suma = int1+int2;
		String resu = String.valueOf(suma);
		tv3.setText(resu);
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
