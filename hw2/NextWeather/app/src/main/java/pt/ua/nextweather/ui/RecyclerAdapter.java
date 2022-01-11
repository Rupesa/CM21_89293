package pt.ua.nextweather.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import pt.ua.nextweather.R;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private String[] cities;
    private RecyclerViewClickListener listener;

    public RecyclerAdapter(String[] ar, RecyclerViewClickListener lis) {
        cities = ar;
        listener = lis;
        Log.e("hey", ar.length +"");
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView nameText;

        public MyViewHolder(final View view) {
            super(view);
            nameText = view.findViewById(R.id.tvListItem);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onClick(view, getAdapterPosition() );
        }
    }

    @NonNull
    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.MyViewHolder holder, int position) {
        String city = cities[position];
        holder.nameText.setText(city);
    }

    @Override
    public int getItemCount() {
        return cities.length;
    }

    public interface RecyclerViewClickListener {
        void onClick(View v, int position);
    }
}
