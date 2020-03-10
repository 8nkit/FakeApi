package mybasic.androidtut.assignmentapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.ResourceBundle;

import mybasic.androidtut.assignmentapp.R;
import mybasic.androidtut.assignmentapp.adapter.CountryAdapter;
import mybasic.androidtut.assignmentapp.model.Info;
import mybasic.androidtut.assignmentapp.model.Result;
import mybasic.androidtut.assignmentapp.service.GetCountryDataService;
import mybasic.androidtut.assignmentapp.service.RetrofitInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private CountryAdapter countryAdapter;
    private RecyclerView recyclerView;
    private ArrayList<Result> results;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getCountries();
    }

    private Object getCountries() {
        GetCountryDataService getCountryDataService= RetrofitInstance.getService();
        Call<Info> call=getCountryDataService.getResult();
    call.enqueue(new Callback<Info>() {
        @Override
        public void onResponse(Call<Info> call, Response<Info> response) {
        Info info=response.body();
        if(info!=null && info.getRestResponse()!=null){
            results=(ArrayList<Result>)info.getRestResponse().getResult();
            for(Result r:results){
                Log.i("testing123 ","************* "+r.getName());


            }
            viewData();

        }
        }

        @Override
        public void onFailure(Call<Info> call, Throwable t) {
            Log.i("testing123 ","************* failedd failed");


        }
    });

    return results;
    }

    private void viewData(){
        recyclerView=(RecyclerView)findViewById(R.id.rv_countries_list);
        countryAdapter=new CountryAdapter(results);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(countryAdapter);

    }

}
