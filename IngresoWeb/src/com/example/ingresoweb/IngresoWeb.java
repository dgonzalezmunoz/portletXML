package com.example.ingresoweb;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

public class IngresoWeb extends Activity {
	
	private WebView wbv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.actividadweb);
		wbv=(WebView)findViewById(R.id.webView1);
		Bundle bundle = getIntent().getExtras();
		wbv.loadUrl("http://" + bundle.getString("direccion"));
		}
	public void finalizar(View view){
		finish();
	}

}
