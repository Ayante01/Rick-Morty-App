package cr.ac.ucr.rickmorty.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.ArrayList;

import cr.ac.ucr.rickmorty.R;
import cr.ac.ucr.rickmorty.adapters.LocationsAdapter;
import cr.ac.ucr.rickmorty.api.LocationsService;
import cr.ac.ucr.rickmorty.api.RetrofitBuilder;
import cr.ac.ucr.rickmorty.models.Locations;
import cr.ac.ucr.rickmorty.models.LocationsResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LocationsFragment extends Fragment {

    private final String TAG = "LocationsFragment";
    private AppCompatActivity activity;
    private ArrayList<Locations> locations;
    private LocationsAdapter locationsAdapter;

    boolean canLoad = true;
    int limit = 0;
    int page = 1;
    private ProgressBar pbLoading;
    private RecyclerView rvLocations;

    public LocationsFragment() {
        // Required empty public constructor
    }

    public static LocationsFragment newInstance() {
        LocationsFragment fragment = new LocationsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        locations = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_locations, container, false);

        pbLoading = view.findViewById(R.id.pb_loading);

        rvLocations = view.findViewById(R.id.rv_locations);

        //ArrayList -------> Adapter <-------- RV

        locationsAdapter = new LocationsAdapter(activity);

        rvLocations.setAdapter(locationsAdapter);
        rvLocations.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);

        rvLocations.setLayoutManager(linearLayoutManager);

        locationsAdapter.addLocations(locations);

        setupRVScrollListener(rvLocations, linearLayoutManager);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getLocaionsInfo(page);
    }

    private void getLocaionsInfo(int page) {

        canLoad = false;

        LocationsService locationsService = RetrofitBuilder.createService(LocationsService.class);

        Call<LocationsResponse> response = locationsService.getLocations(page);

        response.enqueue(new Callback<LocationsResponse>() {

            @Override
            public void onResponse(@NonNull Call<LocationsResponse> call, @NonNull Response<LocationsResponse> response) {
                if (response.isSuccessful()) {

                    LocationsResponse locationsResponse = response.body();

                    ArrayList<Locations> locations = locationsResponse.getResults();
                    locationsAdapter.addLocations(locations);

                    showCharacters(true);

                } else {
                    Log.e(TAG, "onError: " + response.errorBody());
                }
                canLoad = true;
            }

            @Override
            public void onFailure(@NonNull Call<LocationsResponse> call, @NonNull Throwable t) {
                canLoad = true;
                throw new RuntimeException(t);
            }
        });
    }

    private void setupRVScrollListener(RecyclerView recyclerView, LinearLayoutManager linearLayoutManager) {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (dy > 0) {
                    int totalItems = linearLayoutManager.getItemCount();

                    int pastItems = linearLayoutManager.findFirstVisibleItemPosition();

                    int visibleItems = linearLayoutManager.getChildCount();

                    if (canLoad) {
                        if ((pastItems + visibleItems) >= totalItems) {
                            page++;

                            pbLoading.setVisibility(View.VISIBLE);

                            getLocaionsInfo(page);
                        }
                    }
                }
            }
        });
    }

    private void showCharacters(boolean setVisible) {
        rvLocations.setVisibility(setVisible ? View.VISIBLE : View.GONE);
        pbLoading.setVisibility(!setVisible ? View.VISIBLE : View.GONE);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = (AppCompatActivity) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        activity = null;
    }
}