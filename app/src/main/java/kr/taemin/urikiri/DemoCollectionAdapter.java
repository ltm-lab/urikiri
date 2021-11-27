package kr.taemin.urikiri;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class DemoCollectionAdapter extends FragmentStateAdapter {

    public int mCount;

    public int getRealPosition(int position){return position % mCount;}

    public DemoCollectionAdapter(FragmentActivity fa, int Count) {

        super(fa);
        mCount = Count;
    }



    @NonNull
    @Override
    public Fragment createFragment(int position) {

        int dex= getRealPosition(position);

        if(dex ==0){
            return new fragment1();
        }

        else{
            return new fragment2();
        }




    }

    @Override
    public int getItemCount() {
        return 100;
    }


}

