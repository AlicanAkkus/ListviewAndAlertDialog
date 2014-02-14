package com.example.sertifikasinavlistviewkullanimi;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
	ListView systemList;
	AlertDialog.Builder alertSystem;
	private final int systemIcon[] = { R.drawable.linux_icon,
			R.drawable.ubuntuicon, R.drawable.mint_icon,
			R.drawable.windows_icon, R.drawable.mac_icon,
			R.drawable.android_icon, R.drawable.apple_icon,
			R.drawable.wpf_icon, R.drawable.wpf_icon };
	private final String systemArray[] = { "LINUX", "UBUNTU", "MINT",
			"WINDOWS", "MAC", "ANDROID", "IOS", "WINDOWS PHONE", "BLACBERRY OS" };

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		systemList = (ListView) findViewById(R.id.listSystem);

		final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_2, android.R.id.text1,
				systemArray);

		systemList.setAdapter(adapter);

		systemList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(final AdapterView<?> adapterView,
					final View view, final int position, final long id) {
				// TODO Auto-generated method stub
				alertSystem = new AlertDialog.Builder(MainActivity.this);

				alertSystem.setTitle("Seçilen System Türü : ");
				alertSystem.setIcon(systemIcon[position]);
				alertSystem.setMessage(systemArray[position]);
				alertSystem.setCancelable(true);
				alertSystem.setPositiveButton("Tamam :)",
						new OnClickListener() {

							@Override
							public void onClick(final DialogInterface dialog,
									final int which) {
								// TODO Auto-generated method stub
								dialog.dismiss();
							}
						});
				alertSystem.create().show();
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(final Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
