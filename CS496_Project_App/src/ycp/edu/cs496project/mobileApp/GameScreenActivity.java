package ycp.edu.cs496project.mobileApp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * an activity for playing the game.
 * 
 * @author josh coady
 *
 */
public class GameScreenActivity extends Activity {
	private final static int NUM_COLS = 4;//the number of columns for the game grid
	private final static int NUM_ROWS = 6;//the number of columns for the game grid
	private final static int NUM_SPACES = NUM_COLS * NUM_ROWS;
	
	private GridView gameGrid; //the game grid
	Integer[] imageArray = {R.drawable.sample_0, R.drawable.sample_1, R.drawable.sample_2, R.drawable.sample_3,
							R.drawable.sample_4, R.drawable.sample_5, R.drawable.sample_5, R.drawable.sample_6,
							R.drawable.sample_7, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher,
							R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher,
							R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher,
							R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher};
			
	boolean[] imgNum = {true, true, true, true, true, true, true};
	
	private OnItemClickListener gridClickListener;
	private ImageArrayAdapter<Integer> imageAdapter;
	boolean bool;
	
	ImageButton imgButton; //an image button
	
	Integer[] element = new Integer[NUM_SPACES];
	
	//GameplayController gameplayController = new GameplayController();
	
	public void initializeElementArray()
	{
		for (int i = 0; i < NUM_SPACES; i++)
		{
			element[i] = 0;
		}
	}
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_game_screen);
		
		imageAdapter = new ImageArrayAdapter<Integer>(this, R.layout.list_imagebutton, imageArray);
		
		bool = true;
		
		initializeElementArray();
		
		initGridView(); //initialize the GridView
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game_screen, menu);
		return true;
	}
	
	//method to create an OnClickListener for the ImageButton
	public void createOnImageButtonClick(){
		imgButton.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(bool){
					imgButton.setImageResource(R.drawable.ic_launcher);
					bool = false;
				}else{
					imgButton.setImageResource(R.drawable.sample_4);
					bool = true;
				}
			}
			
		});
	}
	
	
	/**
	 * a method to initialize the gameGrid with parameter, ImageButton Adapter and OnItemClickListener
	 */
	public void initGridView(){
		gameGrid = (GridView)findViewById(R.id.gridView1);
		gameGrid.setNumColumns(NUM_COLS);
		gameGrid.setAdapter(imageAdapter);
		gameGrid.setOnItemClickListener(gridClickListener = new OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> adapterView, View v, int position, long id) {
				// TODO Auto-generated method stub
				ImageView img = (ImageView) v;
				img.setImageResource(R.drawable.ic_launcher);
			}
		});
	}
	
	/**
	 * an implementation of an ArrayAdapter to use ImageView to populate the GridView
	 * instead of the default TextView.
	 * 
	 * @param <T>
	 */
	private class ImageArrayAdapter<T> extends ArrayAdapter<T>{

		/**
		 * constructor
		 * 
		 * @param context
		 * @param resource
		 * @param imageArray
		 */
		public ImageArrayAdapter(Context context, int resource, T[] imageArray) {
			super(context, resource, imageArray);
			
		}
		
		/**
		 * an overwritten implementation of the ArrayAdapter getView() method, to enable the GridView
		 * to be populated with images.
		 */
		public View getView(int position, View convertView, ViewGroup parent)
		{
			ImageView image;
			
			if(convertView == null){
				image = new ImageView(getContext());
				image.setLayoutParams(new GridView.LayoutParams(85, 85));
				image.setScaleType(ImageView.ScaleType.CENTER_CROP);
				image.setPadding(8, 8, 8, 8);
			}else{
				image = (ImageView) convertView;
			}
			
			image.setImageResource(imageArray[position]);
			return image;
		}
		
		/**
		 * Continually handles game mechanics by calling the GameplayController
		 * and updating the "element" array to accurately describe what to display
		 */
		public void onResume()
		{
			//update element array
			//gameplayController.currentTime
			
			//while (gameActive == true)
			{
				for (int i = 0; i < NUM_SPACES; i++)
				{
					ImageView currentSpace = (ImageView) gameGrid.getItemAtPosition(i);
					currentSpace.setImageResource(element[i]);
				}
			}
		}
	}
	
}


