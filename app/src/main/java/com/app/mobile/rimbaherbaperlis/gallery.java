package com.app.mobile.rimbaherbaperlis;

        import android.os.Bundle;
        import android.util.Log;
        import android.view.MenuItem;
        import android.widget.Toast;

        import com.daimajia.slider.library.Animations.DescriptionAnimation;
        import com.daimajia.slider.library.Indicators.PagerIndicator;
        import com.daimajia.slider.library.SliderLayout;
        import com.daimajia.slider.library.SliderTypes.BaseSliderView;
        import com.daimajia.slider.library.SliderTypes.TextSliderView;
        import com.daimajia.slider.library.Tricks.ViewPagerEx;
        import java.util.HashMap;
        import android.content.Intent;
        import android.net.Uri;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.view.MenuItem;
/**
 * When you want to make your own slider view, you must implements from BaseSliderView and ViewPagerEx class.
 */

public class gallery extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener{

    private SliderLayout imageSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        imageSlider = (SliderLayout)findViewById(R.id.slider);


        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Spesifikasi",R.drawable.pic1);
        file_maps.put("Menu Aplikasi",R.drawable.pic2);
        file_maps.put("Menu Utama",R.drawable.pic3);
        file_maps.put("Log Masuk",R.drawable.pic4);
        file_maps.put("Kemaskini Rekod",R.drawable.pic5);

        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            imageSlider.addSlider(textSliderView);
        }
        imageSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        imageSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        imageSlider.setCustomAnimation(new DescriptionAnimation());
        imageSlider.setDuration(4000);
        imageSlider.addOnPageChangeListener(this);


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            // finish the activity
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onStop() {
        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
        imageSlider.stopAutoCycle();
        super.onStop();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        Toast.makeText(this,slider.getBundle().get("extra") + "",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

    @Override
    public void onPageSelected(int position) {
        Log.e("Slider Demo", "Page Changed: " + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {}
}
