package telkomsel.myshoppingmall;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Multimatics on 20/07/2016.
 */
public class ImagePagerAdapter extends FragmentPagerAdapter {
    private ArrayList<String> listImages;
    public ImagePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public ArrayList<String> getListImages() {
        return listImages;
    }

    public void setListImages(ArrayList<String> listImages) {
        this.listImages = listImages;
    }

    @Override
    public Fragment getItem(int position) {
        ImageFragment imageFragment = new ImageFragment();
        imageFragment.setImageUrl(getListImages().get(position));
        return imageFragment;
    }

    @Override
    public int getCount() {
        return getListImages().size();
    }
}
