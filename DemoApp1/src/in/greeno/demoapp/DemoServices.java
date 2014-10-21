package in.greeno.demoapp;

import android.app.IntentService;
import android.content.Intent;

public class DemoServices extends IntentService {

	//--------------Broad casting---------------
			public static final String ACTION_MyIntentService = "com.greeno.demoapp.MainActivity.RESPONSE";
			 public static final String ACTION_MyUpdate = "com.greeno.demoapp.MainActivity.UPDATE";
			 public static final String EXTRA_KEY_IN = "EXTRA_IN";
			 public static final String EXTRA_KEY_OUT = "EXTRA_OUT";
			 public static final String EXTRA_KEY_UPDATE = "EXTRA_UPDATE";
			 String msgFromActivity;
			 String extraOut;
			//-----------------------------
	public DemoServices(String name) {
		super("DemoServices");
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		// TODO Auto-generated method stub
		//get input//--------------Broad casting---------------
		  msgFromActivity = intent.getStringExtra(EXTRA_KEY_IN);
		  extraOut = "Hello: " +  msgFromActivity;
		//-----------------------------
		  for(int i = 0; i <=10; i++){
			   try {
			    Thread.sleep(1000);
			   } catch (InterruptedException e) {
			    // TODO Auto-generated catch block
			    e.printStackTrace();
			   }
			   
			   //send update 
			   Intent intentUpdate = new Intent();
			   intentUpdate.setAction(ACTION_MyUpdate);
			   intentUpdate.addCategory(Intent.CATEGORY_DEFAULT);
			   intentUpdate.putExtra(EXTRA_KEY_UPDATE, i);
			   sendBroadcast(intentUpdate);
			  }
			  
			  //return result
			  Intent intentResponse = new Intent();
			  intentResponse.setAction(ACTION_MyIntentService);
			  intentResponse.addCategory(Intent.CATEGORY_DEFAULT);
			  intentResponse.putExtra(EXTRA_KEY_OUT, extraOut);
			  sendBroadcast(intentResponse);
			 }
}
