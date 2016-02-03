package sidespell.tech.midtermexam.fragments;

import android.net.Uri;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import sidespell.tech.midtermexam.BuildConfig;
import sidespell.tech.midtermexam.R;
import sidespell.tech.midtermexam.adapters.AlbumAdapter;
import sidespell.tech.midtermexam.apis.AlbumApi;
import sidespell.tech.midtermexam.entities.Album;

public class MainFragment extends Fragment {
    AlbumAdapter albumAdapter;
    RecyclerView mRecyclerView;
    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

//        TextView mTxtAlbumName = (TextView) view.findViewById(R.id.tvAlbumName);
//        TextView mTxtBandName = (TextView) view.findViewById(R.id.tvBandName);
//        ImageView mAlbumImg = (ImageView) view.findViewById(R.id.imgAlbum);
//         mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerListView);
//        ArrayList<Album> test1 = new ArrayList<Album>();
//        Album test = new Album();
//        test.setAlbumName("allright");
//        test.setBandName("onyok band");
//        test1.add(test);
//        albumAdapter = new AlbumAdapter(getContext().getApplicationContext(),test1);
//        mRecyclerView.setHasFixedSize(true);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        mRecyclerView.setAdapter(albumAdapter);

        // TODO: Find all views here..
        //ProgressBar mPrgBar = (ProgressBar) view.findViewById(R.id.prgBar);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        // TODO: Perform logic operations here..
//        TextView mTxtView = (TextView) view.findViewById(R.id.);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerListView);
        TextView tvEmpty = (TextView) view.findViewById(android.R.id.empty);

        // Use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // Unlike a ListView, a RecyclerView needs a LayoutManager to manage the positioning of its
        // items. You could define your own LayoutManager by extending the RecyclerView.LayoutManager
        // class. However, in most cases, you could simply use one of the predefined LayoutManager
        // subclasses. In our case, since we are to create a ListView, we will be using the
        // LinearLayoutManager.
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(llm);
//
//        AlbumAdapter adapter = new AlbumAdapter(getContext(),R.layout.recycler_list_item,test1);

        // Set the Adapter
//        recyclerView.setAdapter(adapter);
        FetchInfoTask fetchTask = new FetchInfoTask();
        fetchTask.execute("album.search");
    }



    public class FetchInfoTask extends AsyncTask<String, Void , Album> {


        @Override
        protected Album doInBackground(String... params) {

            if(params.length == 0){
                return null;
            }

            String album = params[0];
            Uri builtUri = Uri.parse(AlbumApi.BASE_URL).buildUpon()
                    .appendQueryParameter(AlbumApi.PARAM_QUERY, album)
                    .appendQueryParameter(AlbumApi.PARAM_API_KEY, BuildConfig.MIDTERM_EXAM_API_KEY)
                    .appendQueryParameter(AlbumApi.PARAM_ALBUM, "Hello")
                    .appendQueryParameter(AlbumApi.PARAM_LIMIT, String.valueOf(50))
                    .appendQueryParameter(AlbumApi.PARAM_MODE,"json")
                    .build();

            return AlbumApi.getAlbum(builtUri, "GET");
        }


    }


}
