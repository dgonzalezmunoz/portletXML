package com.example.holamundo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
	
	private String[] paises = { "Argentina", "Chile", "Paraguay", "Bolivia",
			"Peru", "Ecuador", "Brasil", "Colombia", "Venezuela", "Uruguay" };
	private String[] habitantes = { "40000000", "17000000", "6500000",
			"10000000", "30000000", "14000000", "183000000", "44000000",
			"29000000", "3500000" };
	private TextView tv1;
	private ListView lv;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv1 =(TextView)findViewById(R.id.textView1);
		lv= (ListView)findViewById(R.id.listView1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,paises);
        lv.setAdapter(adapter);
	
	
	lv.setOnItemClickListener(new OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View v, int posicion, long id) {
            tv1.setText("Población de "+ lv.getItemAtPosition(posicion) + " es "+ habitantes[posicion]);
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
