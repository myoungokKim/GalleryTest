package kr.hs.emirim.cheese0414.gallerytest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Gallery gallery;
    ImageView imgMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gallery=(Gallery)findViewById(R.id.gallery_1);
        imgMain=(ImageView)findViewById(R.id.imgv_main);
        MyGalleryAdapter adapter=new MyGalleryAdapter(this);
        gallery.setAdapter(adapter);
    }

    public class MyGalleryAdapter extends BaseAdapter {
        Context context;
        int[] posterIDs={R.drawable.movie1, R.drawable.movie2, R.drawable.movie3,
                        R.drawable.movie4, R.drawable.movie5, R.drawable.movie6,
                        R.drawable.movie7, R.drawable.movie8, R.drawable.movie9,
                        R.drawable.movie10};

        public MyGalleryAdapter(Context context) {
            this.context=context;
        }

        @Override
        public int getCount() {
            return posterIDs.length;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imgV=new ImageView(context);
            imgV.setLayoutParams(new Gallery.LayoutParams(100, 150));
            imgV.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imgV.setPadding(-1, -1, -1, -1);
            imgV.setImageResource(posterIDs[position]);
            final int pos=position;
            imgV.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    imgMain.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    imgMain.setImageResource(posterIDs[pos]);
                    return false;
                }
            });
            return imgV;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }
    }
}
