package in.greeno.demoapp;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	TextView textResult;
	 public ProgressBar progressBar;
	 
	 private MyBroadCastReceiver myBroadcastReceiver;
	 private MyBroadcastReceiverUpdate myBroadcastReceiver_Update;
	 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d("Demo_MainActivity","Activity created");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.progress_bar_view);
		  textResult = (TextView)findViewById(R.id.result);
		  progressBar = (ProgressBar)findViewById(R.id.progressbar);

		  //prepare MyParcelable passing to intentMyIntentService
		  String msgToIntentService = "Android-er";

		  //Start MyIntentService
		  Intent intentMyIntentService = new Intent(this, DemoServices.class);
		  intentMyIntentService.putExtra(DemoServices.EXTRA_KEY_IN, msgToIntentService);
		  startService(intentMyIntentService);
		  
		  myBroadcastReceiver = new MyBroadCastReceiver();
		  myBroadcastReceiver_Update = new MyBroadcastReceiverUpdate();
		  
		  //register BroadcastReceiver
		  IntentFilter intentFilter = new IntentFilter(DemoServices.ACTION_MyIntentService);
		  intentFilter.addCategory(Intent.CATEGORY_DEFAULT);
		  registerReceiver(myBroadcastReceiver, intentFilter);
		  
		  IntentFilter intentFilter_update = new IntentFilter(DemoServices.ACTION_MyUpdate);
		  intentFilter_update.addCategory(Intent.CATEGORY_DEFAULT);
		  registerReceiver(myBroadcastReceiver_Update, intentFilter_update);
		 }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	@Override
	public void onDestroy(){
		 super.onDestroy();
		  //un-register BroadcastReceiver
		  unregisterReceiver(myBroadcastReceiver);
		  unregisterReceiver(myBroadcastReceiver_Update);
	}

}

