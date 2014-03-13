package in.greeno.demoapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyBroadcastReceiverUpdate extends BroadcastReceiver {

	
	MainActivity mainActivity = new MainActivity();
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		int update = intent.getIntExtra(DemoServices.EXTRA_KEY_UPDATE, 0);
		   mainActivity.progressBar.setProgress(update);
	}

}
//test command