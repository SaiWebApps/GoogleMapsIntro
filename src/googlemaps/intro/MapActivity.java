package googlemaps.intro;

import googlemaps.services.MapService;
import android.app.Activity;
import android.os.Bundle;

/**
 * Displays a Google Map and a toast with the user's current location.
 * @author Sairam Krishnan (sbkrishn)
 */
public class MapActivity extends Activity {
	private MapService mapService;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);
	}

	/**
	 * When this method is invoked, we set up all of the views and initialize
	 * the MapService's resources. As such, the MapService will register listeners,
	 * which will then handle events themselves later on. For example, the MapService
	 * registers listeners for LocationClient; these listeners will handle displaying
	 * the user's current location.
	 */
	@Override
	public void onResume() {
		super.onResume();
		mapService = new MapService(this);
	}
	
	/**
	 * Release all resources when this app loses focus (even if it
	 * is partially visible).
	 */
	@Override
	public void onPause() {
		mapService.releaseResources();
		super.onPause();
	}
}