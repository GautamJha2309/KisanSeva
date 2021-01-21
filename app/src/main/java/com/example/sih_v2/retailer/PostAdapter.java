package com.example.sih_v2.retailer;


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
        holder.bind(model);
        //Toast.makeText(PostAdapter.this,"Select District "+model.getState(),Toast.LENGTH_SHORT).show();

    }

    @NonNull
    @Override
    public PastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.msg, parent, false);

        return new PastViewHolder(view);
    }

    class PastViewHolder extends RecyclerView.ViewHolder{
        private TextView personName;
        private TextView agencyName;
        private TextView contact;
        private TextView address;
        private TextView dId;
        private TextView dist;
        private TextView state;

        public PastViewHolder(@NonNull View itemView) {
            super(itemView);
            //address = itemView.findViewById(R.id.address);
            agencyName = itemView.findViewById(R.id.agency_text_view);
            contact = itemView.findViewById(R.id.contact_number_text_view);
            dId = itemView.findViewById(R.id.dealer_id_text_view);
            dist = itemView.findViewById(R.id.district_text_view);
            personName = itemView.findViewById(R.id.person_name_text_view);
            state = itemView.findViewById(R.id.state_text_view);

        }

        void bind(@NonNull post model){
            //address.setText(model.getAddress());
            agencyName.setText(model.getAgency_name());
            contact.setText(model.getContact());
            dId.setText(model.getDealer_ID()+"");
            dist.setText(model.getDistrict());
            personName.setText(model.getPerson_Name());
            state.setText(model.getState());
        }
    }
}