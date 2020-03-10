package mybasic.androidtut.assignmentapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import mybasic.androidtut.assignmentapp.R;
import mybasic.androidtut.assignmentapp.model.Result;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {
    private ArrayList<Result> countriesList;
    public CountryAdapter(ArrayList<Result> countriesList){
        this.countriesList=countriesList;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from((parent.getContext()));
        View view=layoutInflater.inflate(R.layout.row_country,parent,false);
        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        holder.countryNameTextView.setText(countriesList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return countriesList.size();
    }

    class CountryViewHolder extends RecyclerView.ViewHolder{
        TextView countryNameTextView;

        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);
            countryNameTextView=itemView.findViewById(R.id.tv_country_name);

        }
    }

}
