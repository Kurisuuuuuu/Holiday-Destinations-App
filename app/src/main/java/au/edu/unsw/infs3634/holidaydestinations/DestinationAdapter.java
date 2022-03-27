package au.edu.unsw.infs3634.holidaydestinations;

import android.content.ReceiverCallNotAllowedException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class DestinationAdapter extends RecyclerView.Adapter<DestinationAdapter.DestinationViewHolder> {

    // Declared variables
    private List<Destination> mDestinations, mDestinationsFiltered;
    private RecyclerViewListener mListener;
    public static Destination currentDestination;

    // Constructor method
    public DestinationAdapter(List<Destination> destinations, RecyclerViewListener listener) {

        this.mDestinations = destinations;
        mDestinationsFiltered = destinations;
        mListener = listener;
    }

    // Method that filters RecyclerView based on inputted text from OnQueryTextSubmit and OnQueryTextChange
    public Filter getFilter() {

        return new Filter() {

            // Method that filters the RecyclerView based on inputted text and returns a filtered list
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                // For when text is empty
                String charString = charSequence.toString();
                if (charString.isEmpty()) {

                    mDestinationsFiltered = mDestinations;
                }
                else {

                    // Cycles through the list of destinations. If one matches the text, it is added to the filtered list
                    ArrayList<Destination> filteredList = new ArrayList<>();
                    for (Destination destination : mDestinations) {

                        if (destination.getName().toLowerCase(Locale.ROOT).contains(charString.toLowerCase(Locale.ROOT))) {

                            filteredList.add(destination);
                        }
                    }

                    mDestinationsFiltered = filteredList;
                }

                // Filtered list is returned
                FilterResults filterResults = new FilterResults();
                filterResults.values = mDestinationsFiltered;
                notifyDataSetChanged();
                return filterResults;
            }

            // Filtered list results are published
            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

                mDestinationsFiltered = (ArrayList<Destination>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    // ClickListener interface
    public interface RecyclerViewListener {

        void onClick(View view, String name);
    }

    // Creates a new ViewHolder
    @NonNull
    @Override
    public DestinationAdapter.DestinationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
        return new DestinationViewHolder(view, mListener);
    }

    // Updates RecyclerView contents based on the position
    @Override
    public void onBindViewHolder(@NonNull DestinationAdapter.DestinationViewHolder holder, int position) {

        Destination destination = mDestinationsFiltered.get(position);
        holder.mName.setText(destination.getName());
        holder.mLocation.setText(destination.getLocation());
        holder.mRating.setText("Rating: " + destination.getRating());
        holder.mTimeZone.setText(destination.getTimeZone());
        holder.itemView.setTag(destination.getName());

        DetailActivity.setImage(holder.ivPhoto, destination);
    }

    // Gets and changes the items on the RecyclerView
    @Override
    public int getItemCount() {

        return mDestinationsFiltered.size();
    }

    // DestinationViewHolder class
    class DestinationViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        // Declared variables
        private TextView mName, mLocation, mRating, mTimeZone;
        private ImageView ivPhoto;
        public RecyclerViewListener mListener;

        // Variables are set based on item id
        public DestinationViewHolder(@NonNull View itemView, RecyclerViewListener listener) {

            super(itemView);
            mListener = listener;
            itemView.setOnClickListener(this);
            mName = itemView.findViewById(R.id.tvName);
            mLocation = itemView.findViewById(R.id.tvLocation);
            mRating = itemView.findViewById(R.id.tvRating);
            mTimeZone = itemView.findViewById(R.id.tvTimeZone);
            ivPhoto = itemView.findViewById(R.id.ivPhoto);
        }

        // When a view is clicked, gets the tag of the item
        @Override
        public void onClick(View view) {

            mListener.onClick(view, (String) view.getTag());
        }
    }

    // Method that sorts RecyclerView items based on what option was selected in MainActivity's OnOptionsItemSelected()
    public void sort(final int sortMethod) {

        if (mDestinationsFiltered.size() > 0) {

            Collections.sort(mDestinationsFiltered, new Comparator<Destination>() {

                // Compares items together to order them
                @Override
                public int compare(Destination o1, Destination o2) {

                    // When Sort by Name is selected, the names of the destinations are compared
                    if (sortMethod == 1) {

                        System.out.println("sorting name");
                        int returnValue = o1.getName().compareTo(o2.getName());
                        System.out.println(returnValue);
                        return returnValue;
                    }
                    // When Sort by Rating is selected, the ratings of the destinations are compared
                    else if (sortMethod == 2) {

                        System.out.println("sorting rating");
                        int returnValue = Double.valueOf(o2.getRating()).compareTo(Double.valueOf(o1.getRating()));
                        System.out.println(returnValue);
                        return returnValue;
                    }

                    return o1.getName().compareTo(o2.getName());
                }
            });
        }
    }
}
