package mybasic.androidtut.assignmentapp.service;

import mybasic.androidtut.assignmentapp.model.Info;
import retrofit2.Call;
import retrofit2.http.GET;

public interface GetCountryDataService {


    @GET("8nkit/RESTapi/db")
    Call<Info> getResult();


}
