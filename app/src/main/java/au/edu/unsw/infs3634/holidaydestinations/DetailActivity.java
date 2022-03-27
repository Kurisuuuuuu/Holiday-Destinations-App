package au.edu.unsw.infs3634.holidaydestinations;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class DetailActivity extends AppCompatActivity {

    // Declared variables
    private TextView mName, mLocation, mRating, mTimeZone, mDescription;
    private Button mSearch, mMap;
    private ImageView mPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Creates a back button
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        // Returns the selected view's name that was passed by the last intent
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        // Finds the destination that corresponds with the passed name
        Destination destination = Destination.findDestination(name);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setTitle("Detail Activity");

        // Declares variables by item id
        mName = findViewById(R.id.name);
        mLocation = findViewById(R.id.location);
        mRating = findViewById(R.id.rating);
        mTimeZone = findViewById(R.id.timeZone);
        mDescription = findViewById(R.id.description);
        mPhoto = findViewById(R.id.photo);

        // Sets Textview item text based on the destination's details
        mName.setText(destination.getName());
        mLocation.setText(destination.getLocation());
        mRating.setText(destination.getRating());
        mTimeZone.setText(destination.getTimeZone());
        mDescription.setText(destination.getDescription());

        // Declares button variables
        mSearch = findViewById(R.id.searchButton);
        mMap = findViewById(R.id.mapButton);

        // When Search button is selected, open the provided URL
        mSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent searchIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=" + destination.getName().toLowerCase(Locale.ROOT)));
                startActivity(searchIntent);
            }
        });

        // When Maps button is selected, open the provided URL
        mMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/" + destination.getUrl()));
                startActivity(mapIntent);
            }
        });

        // Image setting method
        setImage(mPhoto, destination);
    }

    // When Back button is selected, exit the activity
    public boolean onOptionsItemSelected(MenuItem item){
        finish();
        return true;
    }

    // I couldn't find a way to dynamically set the image, so I made a method with a switch statement
    public static void setImage (ImageView photo, Destination destination) {

        switch (destination.getName()) {

            case "Shibuya Crossing":
                photo.setImageResource(R.drawable.shibuya);
                break;
            case "Kabuchiko":
                photo.setImageResource(R.drawable.kabuchiko);
                break;
            case "Akihabara":
                photo.setImageResource(R.drawable.akihabara);
                break;
            case "Mount Fuji":
                photo.setImageResource(R.drawable.fuji);
                break;
            case "Hiroshima Peace Memorial":
                photo.setImageResource(R.drawable.hiroshima);
                break;
            case "Tsushima Island":
                photo.setImageResource(R.drawable.tsushima);
                break;
            case "Dotonbori":
                photo.setImageResource(R.drawable.dotonbori);
                break;
            case "Osaka Castle":
                photo.setImageResource(R.drawable.castle);
                break;
            case "Kinkaku-ji":
                photo.setImageResource(R.drawable.kinkakuji);
                break;
            case "Tokyo Tower":
                photo.setImageResource(R.drawable.tower);
                break;
            case "Shuri Castle":
                photo.setImageResource(R.drawable.shuri);
                break;
        }
    }
}
