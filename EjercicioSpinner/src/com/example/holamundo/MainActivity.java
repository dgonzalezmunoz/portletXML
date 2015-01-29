package com.example.holamundo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
	
	private EditText et1,et2;
	private TextView tv3;
	private Spinner sp;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		et1=(EditText)findViewById(R.id.editText1);
        et2=(EditText)findViewById(R.id.editText2);
        tv3=(TextView)findViewById(R.id.tv3);
        sp=(Spinner)findViewById(R.id.spinner1);
        String[] opciones={"sumar", "restar", "multiplicar" , "dividir"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,opciones);
        sp.setAdapter(adapter);
	}
	public void operar(View view){
		String valor1 = et1.getText().toString();
		String valor2 = et2.getText().toString();
		int int1 = Integer.parseInt(valor1); 
		int int2 = Integer.parseInt(valor2);
		String resu ="";
		String selec=sp.getSelectedItem().toString();
		if(selec.equals("sumar")){
			int suma = int1+int2;
			resu = String.valueOf(suma);
		}
		else
			if(selec.equals("restar")){			
				int resta =int1-int2;
				resu =String.valueOf(resta);
			}
			else
				if(selec.equals("multiplicar")){
					int multiplicacion=int1*int2;
					resu = String.valueOf(multiplicacion);
				}
				else
					if(selec.equals("dividir")){
						double dividir=(double)int1/int2;
						resu =String.valueOf(dividir);
					}
		        
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
