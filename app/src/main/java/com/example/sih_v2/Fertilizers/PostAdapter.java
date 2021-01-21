package com.example.sih_v2.Fertilizers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sih_v2.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class PostAdapter extends FirebaseRecyclerAdapter<post,PostAdapter.PastViewHolder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    //Context context;
    public PostAdapter(@NonNull FirebaseRecyclerOptions<post> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull PastViewHolder holder, int position, @NonNull post model) {

        holder.fName.setText(model.getName());
        holder.fNumber.setText(model.getNumber());
        holder.fCategory.setText(model.getCategory());
        Picasso.get().load(model.getURL()).into(holder.fImage, new Callback() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError(Exception e) {
                //Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
//Toast.makeText(PostAdapter.this,"Select District "+model.getState(),Toast.LENGTH_SHORT).show();

    }

    @NonNull
    @Override
    public PastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.msg_fertilizer, parent, false);

        return new PastViewHolder(view);
    }

    class PastViewHolder extends RecyclerView.ViewHolder{
        TextView fName,fNumber,fCategory;
        ImageView fImage;

        public PastViewHolder(@NonNull View itemView) {
            super(itemView);
            fName = itemView.findViewById(R.id.fName);
            fNumber = itemView.findViewById(R.id.fNumber);
            fCategory = itemView.findViewById(R.id.fCategory);
            fImage = itemView.findViewById(R.id.fImage);

        }
    }
}

