package com.example.sih_v2.YTvideo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sih_v2.R;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {

    List<YouTubeVideo> youTubeVideoList;

    public VideoAdapter() {
    }

    public VideoAdapter(List<YouTubeVideo> youTubeVideoList) {
        this.youTubeVideoList = youTubeVideoList;
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_video,parent,false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        holder.videoWeb.loadData(youTubeVideoList.get(position).getVideoUrl(),"text/html","utf-8");
        //holder.videoWeb.loadData(youTubeVideoList.get(position).getVideoAddress(),"text/html","utf-8");
    }




    @Override
    public int getItemCount() {
        return youTubeVideoList.size();
    }

    //subclass VideoViewHolder
    public class VideoViewHolder extends RecyclerView.ViewHolder{
        WebView videoWeb;
        //TextView videoAddress;
        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);
            videoWeb = (WebView) itemView.findViewById(R.id.webVideoView);
            // videoAddress = itemView.findViewById(R.id.videoAddress);
            videoWeb.getSettings().setJavaScriptEnabled(true);
            videoWeb.setWebChromeClient(new WebChromeClient(){
            });
            //videoWeb.loadUrl("https://youtu.be/vdbP_3o73qI");
        }
    }//end of VideoViewHolder
}