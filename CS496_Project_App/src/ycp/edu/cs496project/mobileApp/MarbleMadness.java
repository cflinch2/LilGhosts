package ycp.edu.cs496project.mobileApp;

import java.util.ArrayList;

import ycp.edu.cs496project.mobileApp.graphics.Panel;
import ycp.edu.cs496project.mobileApp.model.User;
import android.os.Bundle;
import android.view.Window;
import android.app.Activity;
import android.content.Intent;

public class MarbleMadness extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        ArrayList<String> str_arr = new ArrayList<String>();

		Intent userInfoIntent = getIntent();

		//get user info from the mainactivity
		str_arr = userInfoIntent.getStringArrayListExtra(LoginActivity.USER_INFO_MESSAGE);
        
        User user = new User(str_arr.get(0), str_arr.get(1));
        user.setUserScore(Integer.valueOf(str_arr.get(2)));
        
        setContentView(new Panel(this, user));
	}

}
