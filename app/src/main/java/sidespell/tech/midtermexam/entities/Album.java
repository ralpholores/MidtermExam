package sidespell.tech.midtermexam.entities;

/**
 * Created by raprap on 2/2/2016.
 */
public class Album {

    private String mAlbumName;
    private String mBandName;
    private int mAlbumImage;


    public Album(){


    }

    public Album(String name, String bandName, int albumImg)
    {
        mAlbumImage = albumImg;
        mBandName = bandName;
        mAlbumName = name;
    }

    public String getAlbumName() {
        return mAlbumName;
    }

    public Album setAlbumName(String AlbumName) {
        mAlbumName = AlbumName;
        return this;
    }

    public String getBandName() {
        return mBandName;
    }

    public Album setBandName(String BandName) {
        mBandName = BandName;
        return this;
    }

    public int getAlbumImage() {
        return mAlbumImage;
    }

    public Album setAlbumImage(int AlbumImage) {
        mAlbumImage = AlbumImage;
        return this;
    }
}
