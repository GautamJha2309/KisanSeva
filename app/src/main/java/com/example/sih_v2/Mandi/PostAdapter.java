package com.example.sih_v2.Mandi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sih_v2.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;


public class PostAdapter extends FirebaseRecyclerAdapter<post,PostAdapter.PastViewHolder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public PostAdapter(@NonNull FirebaseRecyclerOptions<post> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull PastViewHolder holder, int position, @NonNull post model) {
        holder.min_price.setText(model.getMin_price());
        holder.commodity.setText(model.getCommodity());
        holder.max_price.setText(model.getMax_price());
        holder.modal_price.setText(model.getModal_price());
        holder.district.setText(model.getDistrict());
        holder.market.setText(model.getMarket());
        holder.state.setText(model.getState());

        //Toast.makeText(PostAdapter.this,"Select District "+model.getState(),Toast.LENGTH_SHORT).show();

    }

    @NonNull
    @Override
    public PastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.msg_mandi, parent, false);

        return new PastViewHolder(view);
    }

    class PastViewHolder extends RecyclerView.ViewHolder{
        TextView min_price,max_price,modal_price,district,state,commodity,market;

        public PastViewHolder(@NonNull View itemView) {
            super(itemView);
            min_price = itemView.findViewById(R.id.min_price);
            commodity = itemView.findViewById(R.id.commodity);
            max_price = itemView.findViewById(R.id.max_price);
            modal_price = itemView.findViewById(R.id.modal_price);
            district = itemView.findViewById(R.id.district);
            market = itemView.findViewById(R.id.market);
            state = itemView.findViewById(R.id.state);

        }
    }
}




