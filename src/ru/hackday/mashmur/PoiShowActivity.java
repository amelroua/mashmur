package ru.hackday.mashmur;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import ru.hackday.mashmur.media.MediaPlayerDemo;
import ru.hackday.mashmur.media.MediaPlayerDemo_Audio;

public class PoiShowActivity extends Activity {

    Poi mPoi;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.poi_item);
        mPoi = getIntent().getExtras().getParcelable("poi");
        TextView name = (TextView) findViewById(R.id.name);
        name.setText(mPoi.getName());
        TextView desc = (TextView) findViewById(R.id.desc);
        desc.setText(mPoi.getDescription());
        Button playButton = (Button) findViewById(R.id.play);
        playButton.setVisibility(View.VISIBLE);
        playButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent =
                        new Intent(PoiShowActivity.this.getApplication(),
                                MediaPlayerDemo_Audio.class);
                //todo set uri for audio
                intent.putExtra(MediaPlayerDemo.EXTRA_AUDIO_URI, mPoi.audioUrl);
                startActivity(intent);
            }
        }

        );
    }
}