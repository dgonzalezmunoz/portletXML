package com.example.ejercicioarchivotarjetasd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	
	private EditText et1,et2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		et1=(EditText)findViewById(R.id.editText1);
		et2=(EditText)findViewById(R.id.editText2);
	}
	
	public void grabar(View v) {
		String nomarchivo=et1.getText().toString();
		String contenido=et2.getText().toString();
		
		File tarjeta = Environment.getExternalStorageDirectory();
		File file = new File(tarjeta.getAbsolutePath(), nomarchivo);
		try {
			OutputStreamWriter osw= new OutputStreamWriter(new FileOutputStream(file));
			osw.write(contenido);
			osw.flush();
			osw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		    Toast.makeText(this,"Los datos fueron grabados",Toast.LENGTH_SHORT).show(); 
		    et1.setText("");
		    et2.setText("");
	}
	
	public void recuperar(View view){
		String nomarchivo = et1.getText().toString();
		
		File tarjeta = Environment.getExternalStorageDirectory();
		File file = new File(tarjeta.getAbsolutePath(), nomarchivo);
		
		try {
			InputStreamReader archivo = new InputStreamReader( new FileInputStream(file));
			BufferedReader br=new BufferedReader(archivo);
			String linea = br.readLine();
			String todo = "";
		    while(linea!=null){
		    	todo= todo + linea + "\n";
		    	linea =br.readLine();
		    }
		    br.close();
		    archivo.close();
			et2.setText(todo);
		    } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
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
