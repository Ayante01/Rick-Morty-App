package cr.ac.ucr.rickmorty.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import cr.ac.ucr.rickmorty.R;
import cr.ac.ucr.rickmorty.models.Locations;

public class LocationsAdapter extends RecyclerView.Adapter<LocationsAdapter.ViewHolder>{

    private Context context;
    private ArrayList<Locations> locations;

    public LocationsAdapter(Context context, ArrayList<Locations> locations) {
        this.context = context;
        this.locations = locations;
    }

    public LocationsAdapter(Context context) {
        this.context = context;
        this.locations = new ArrayList<>();
    }

    @NonNull
    @Override
    public LocationsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_locations, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LocationsAdapter.ViewHolder holder, int position) {

        Locations location = locations.get(position);

        holder.tvName.setText(location.getName());
        holder.tvType.setText(location.getType());
        holder.tvDimension.setText(location.getDimension());
    }

    @Override
    public int getItemCount() {
        return locations != null ? locations.size() : 0;
    }

    public void addLocations(ArrayList<Locations> locations) {
        this.locations.addAll(locations);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private CardView cvLocationCard;

        private final TextView tvName;
        private final TextView tvType;
        private final TextView tvDimension;


        public ViewHolder(@NonNull View view) {
            super(view);

            cvLocationCard = view.findViewById(R.id.cv_location_card);

            tvName = view.findViewById(R.id.tv_name);
            tvType = view.findViewById(R.id.tv_type);
            tvDimension = view.findViewById(R.id.tv_dimension);
        }
    }
}