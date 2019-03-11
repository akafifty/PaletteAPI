package papi.iso.com.paletteapi;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txt1, txt2, txt3, txt4, txt5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.uno);

        crearPalette(bitmap);

    }

    private void init() {
        this.txt1 = findViewById(R.id.txt1);
        this.txt2 = findViewById(R.id.txt2);
        this.txt3 = findViewById(R.id.txt3);
        this.txt4 = findViewById(R.id.txt4);
        this.txt5 = findViewById(R.id.txt5);
    }

    private void crearPalette(Bitmap bitmap) {

        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(@Nullable Palette palette) {

                Palette.Swatch vibrant = palette.getVibrantSwatch();

                if(vibrant!=null){
                    txt1.setBackgroundColor(vibrant.getRgb());
                    txt1.setTextColor(vibrant.getTitleTextColor());
                    txt1.setText("Vibrant");
                }

                Palette.Swatch muted = palette.getMutedSwatch();

                if(muted!=null){
                    txt2.setBackgroundColor(muted.getRgb());
                    txt2.setTextColor(muted.getTitleTextColor());
                    txt2.setText("Muted");
                }

                Palette.Swatch dominant = palette.getDominantSwatch();

                if(dominant!=null){
                    txt3.setBackgroundColor(dominant.getRgb());
                    txt3.setTextColor(dominant.getTitleTextColor());
                    txt3.setText("Dominant");
                }

                Palette.Swatch darkMuted = palette.getDarkMutedSwatch();

                if(darkMuted!=null){
                    txt4.setBackgroundColor(darkMuted.getRgb());
                    txt4.setTextColor(darkMuted.getTitleTextColor());
                    txt4.setText("Dark Muted");
                }

                Palette.Swatch darkVibrant = palette.getDarkVibrantSwatch();

                if(darkVibrant!=null){
                    txt5.setBackgroundColor(darkVibrant.getRgb());
                    txt5.setTextColor(darkVibrant.getTitleTextColor());
                    txt5.setText("Dark Vibrant");
                }

            }
        });



    }




}
