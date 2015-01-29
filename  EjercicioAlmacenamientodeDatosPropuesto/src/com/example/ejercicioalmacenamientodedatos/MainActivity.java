package com.example.ejercicioalmacenamientodedatos;

import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
	
	private EditText et1;
	private TextView tv2,tv3;
	private int num1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv2=(TextView)findViewById(R.id.textView2);
		tv3=(TextView)findViewById(R.id.textView3);
		et1=(EditText)findViewById(R.id.editText1);
		SharedPreferences prefe =getSharedPreferences("datos",Context.MODE_PRIVATE);
		int pt=prefe.getInt("puntuacion",0);
		tv2.setText(String.valueOf(pt));
		num1 =(int) (Math.random()*50);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void ejecutar(View view){
		String valors=et1.getText().toString();
		int valor = Integer.parseInt(valors);
		if(valor<num1){
			tv3.setText("Has puesto un valor mas pequeño");
		}
		else
			if(valor>num1){
				tv3.setText("Has puesto un valor mas grande");
			}
			else{
				tv3.setText("Correcto");
				
				SharedPreferences preferences=getSharedPreferences("datos", Context.MODE_PRIVATE);
				Editor editor = preferences.edit();
				int pnt=Integer.parseInt( tv2.getText().toString() )+1;
				editor.putInt("puntuacion",pnt);
				editor.commit();
				finish();
			}
		
		
			
		
		
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
