package sidespell.tech.midtermexam.apis;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import org.json.JSONException;
import org.json.JSONObject;

import sidespell.tech.midtermexam.entities.Album;
import sidespell.tech.midtermexam.utils.HttpUtils;

/**
 * Created by raprap on 2/2/2016.
 */
public class AlbumApi {

    public static final String BASE_URL= "http://ws.audioscrobbler.com/2.0";

    public static final String PARAM_QUERY   = "method";
    public static final String PARAM_API_KEY = "appId";
    public static final String PARAM_MODE    = "mode";
    public static final String PARAM_ALBUM    = "album";
    public static final String PARAM_LIMIT    = "limit";

    public static final int SUCCESS_CODE = 200;



    public static final String LAST_FM_CODE   = "cod";
    private static final String LAST_FM_ARTIST      = "artist";
    private static final String LAST_FM_ALBUM_NAME   = "name";


    public static Album getAlbum(Uri uri,@NonNull String requestMethod){

        String json = HttpUtils.getResponse(uri,requestMethod);

        if(TextUtils.isEmpty(json)){
            return null;
        }

        final String name;
        final String artist;

        try{
            JSONObject jsonObject = new JSONObject(json);

            int statusCode = jsonObject.getInt(LAST_FM_CODE);
            if(statusCode == SUCCESS_CODE){
                name = jsonObject.getString(LAST_FM_ALBUM_NAME);
                artist = jsonObject.getString(LAST_FM_ARTIST);

                Album al = new Album()
                        .setAlbumName(name)
                        .setBandName(artist);

                return al;
            }


        }
        catch(JSONException e){
            e.printStackTrace();
            return null;
        }



        return null;
    }

}
