package cr.ac.ucr.rickmorty.api;

import cr.ac.ucr.rickmorty.models.Character;
import cr.ac.ucr.rickmorty.models.CharacterResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CharacterService {

    @Headers("Content-Type: application/json")
    @GET("character") // ?page=numero
    Call<CharacterResponse> getCharacters(@Query("page") int page);

    @Headers("Content-Type: application/json")
    @GET("character/{id}")
    Call<Character> getCharacter(@Path("id") int id);
}
