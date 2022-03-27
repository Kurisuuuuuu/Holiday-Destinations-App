package au.edu.unsw.infs3634.holidaydestinations;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

  // Declared variables
  private RecyclerView mRecyclerView;
  private DestinationAdapter mAdapter;
  private List<Destination> destinations = new ArrayList<>();
  private RecyclerView.LayoutManager mLayoutManager;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    setTitle("Main Activity");

    // Setting variables to be used in the code
    mRecyclerView = findViewById(R.id.rvList);
    mLayoutManager = new LinearLayoutManager(getApplicationContext());
    mRecyclerView.setLayoutManager(mLayoutManager);

    // Method that activates when a view is clicked, thus launching DetailActivity
    DestinationAdapter.RecyclerViewListener listener = new DestinationAdapter.RecyclerViewListener() {
      @Override
      public void onClick(View view, String name) {

        // Launches DetailActivity;
        launchDetailActivity(name);
      }
    };

    // Declaring the adapter instance, and feeding it the destinations data
    mAdapter = new DestinationAdapter(Destination.getDestinations(), listener);

    // Setting the RecyclerView adapter
    mRecyclerView.setAdapter(mAdapter);
  }

  // Method that creates the menu when the user opens the app
  @Override
  public boolean onCreateOptionsMenu(Menu menu) {

    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.menu_main, menu);
    SearchView searchView = (SearchView) menu.findItem(R.id.app_bar_search).getActionView();
    searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

      // Method that activates when the query text is submitted
      @Override
      public boolean onQueryTextSubmit(String s) {

        // The inputted string is fed into the filter method
        mAdapter.getFilter().filter(s);
        mAdapter.notifyDataSetChanged();
        return false;
      }

      // Function that activates when the query text is changed
      @Override
      public boolean onQueryTextChange(String s) {

        // The inputted string is fed into the filter method
        mAdapter.getFilter().filter(s);
        mAdapter.notifyDataSetChanged();
        return true;
      }
    });

    return true;
  }

  // Returns the menu item selected by the user
  @Override
  public boolean onOptionsItemSelected(MenuItem item) {

    // Method for determining the sort functionality based on menu item selected
    switch (item.getItemId()) {

      // If item selected is Sort Name, feed 1 into sort method
      case R.id.sortName:

        mAdapter.sort(1);
        mAdapter.notifyDataSetChanged();
        return true;

      // If item selected is Sort Name, feed 2 into sort method
      case R.id.sortRating:

        mAdapter.sort(2);
        mAdapter.notifyDataSetChanged();
        return true;

      default:

        return super.onOptionsItemSelected(item);
    }
  }

  // Method that launches DetailActivity
  private void launchDetailActivity (String name) {

    // Intent launches DetailActivity
    Intent intent = new Intent(MainActivity.this, DetailActivity.class);

    // Sends the name of the selected item onto DetailActivity
    intent.putExtra("name", name);

    startActivity(intent);
  }
}