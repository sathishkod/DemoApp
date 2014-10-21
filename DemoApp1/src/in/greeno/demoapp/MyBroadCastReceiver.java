package in.greeno.demoapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyBroadCastReceiver extends BroadcastReceiver {

	MainActivity mainActivity = new MainActivity();
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		String result = intent.getStringExtra(DemoServices.EXTRA_KEY_OUT);
		   mainActivity.textResult.setText(result);
	}

}
