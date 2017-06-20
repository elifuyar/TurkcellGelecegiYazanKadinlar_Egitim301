package gelecegiyazanlar.videoviewkullanimi;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private int position = 0;
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView = (VideoView) findViewById(R.id.video_view); //VideoVİew i tanımladık
        Uri adres = Uri.parse("android.resource://" + getPackageName()
                + "/"
                + R.raw.turkcellvideo); //VideoView in adresini yani videonun nerede olduğunu belirtiyoruz

        videoView.setVideoURI(adres); //Belittiğimiz adresi yani videonun urlisini videoVİew e yolluyoruz
       // videoView.start(); //Videoyu başlatıyoruz


        //videoView.requestFocus();

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            public void onPrepared(MediaPlayer mediaPlayer) {
                videoView.seekTo(position);
                if (position == 0) {
                    videoView.start();
                } else {
                    videoView.pause();
                }
            }
        });

    }
}
