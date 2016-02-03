package sidespell.tech.midtermexam.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import sidespell.tech.midtermexam.R;
import sidespell.tech.midtermexam.entities.Album;

/**
 * Created by raprap on 2/2/2016.
 */
public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>{

    private Context mContext;
    private int mLayoutId;
    private ArrayList<Album> mAlbums;



    public AlbumAdapter(Context context, int layoutId,ArrayList<Album> album) {

        mContext = context;
        mLayoutId = layoutId;
        mAlbums = album;

    }

    @Override
    public AlbumViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(mContext).inflate(mLayoutId, parent, false);
        return new AlbumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AlbumViewHolder holder, int position)
    {
        Album album = mAlbums.get(position);

        if (album != null) {
            if (holder.imgAlbum != null) {
                holder.imgAlbum.setImageResource(album.getAlbumImage());
            }
            if (holder.tvBandName != null) {
                holder.tvBandName.setText(album.getBandName());
            }
            if (holder.tvAlbumName != null) {
                holder.tvAlbumName.setText(album.getAlbumName());
            }
        }


    }

    @Override
    public int getItemCount(){
        return mAlbums.size();
    }



  static class AlbumViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public CardView cardView;
        public ImageView imgAlbum;
        public TextView tvBandName;
        public TextView tvAlbumName;

        public AlbumViewHolder(View view) {
            super(view);
            cardView = (CardView) view.findViewById(R.id.cardView);
            imgAlbum = (ImageView) view.findViewById(R.id.imgAlbum);
            tvBandName = (TextView) view.findViewById(R.id.tvBandName);
            tvAlbumName = (TextView) view.findViewById(R.id.tvAlbumName);

            // once an item view (list item or grid item) is clicked
            view.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {

        }


    }
}
