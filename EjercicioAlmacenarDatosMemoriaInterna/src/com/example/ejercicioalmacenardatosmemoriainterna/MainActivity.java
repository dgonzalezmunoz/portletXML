package com.example.ejercicioalmacenardatosmemoriainterna;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	
	private EditText et1; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		et1= (EditText)findViewById(R.id.editText1);
		String [] archivos= fileList();
		if(existe(archivos ,"notas.txt")){//pattern decorator
			
			InputStreamReader archivo;
			try {
				archivo = new InputStreamReader(
				        openFileInput("notas.txt"));
				BufferedReader br = new BufferedReader(archivo);
				String linea = br.readLine();
				String todo ="";
				while(linea!=null){
					todo = todo + linea + "\n";
					linea= br.readLine();
				}
				br.close();
				archivo.close();
				et1.setText(todo);
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            

		}
	}

	private boolean existe(String[] archivos, String argbusca) {
		// TODO Auto-generated method stub
		for(int f=0; f<archivos.length; f++){
			if(argbusca.equals(archivos[f]))
				return true;
			
		}
		return false;
	}
	
	public void grabar(View v) {
		try {
			OutputStreamWriter archivo= new OutputStreamWriter(openFileOutput("notas.txt",Activity.MODE_PRIVATE));
			archivo.write(et1.getText().toString());
			archivo.flush();
			archivo.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Toast t=Toast.makeText(this,"Los datos fueron grabados", Toast.LENGTH_SHORT);
        t.show();
        finish();
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
