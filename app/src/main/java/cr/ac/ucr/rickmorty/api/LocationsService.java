package cr.ac.ucr.rickmorty.api;

import cr.ac.ucr.rickmorty.models.LocationsResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface LocationsService {

    @Headers("Content-Type: application/json")
    @GET("location") // ?page=numero
    Call<LocationsResponse> getLocations(@Query("page") int page);
}
