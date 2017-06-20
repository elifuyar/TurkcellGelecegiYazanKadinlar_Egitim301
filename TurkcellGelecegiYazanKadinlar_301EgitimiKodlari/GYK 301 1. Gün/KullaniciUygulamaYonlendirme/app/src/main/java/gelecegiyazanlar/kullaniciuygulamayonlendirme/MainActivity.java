package gelecegiyazanlar.kullaniciuygulamayonlendirme;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String uygulama_ismi = getResources().getString(R.string.new_name);

        TextView uygulamaAd = (TextView)findViewById(R.id.textView_uygulamaAdi);
        Button mailButton = (Button)findViewById(R.id.send_mail);
        Button smsButton = (Button)findViewById(R.id.send_sms);

        uygulamaAd.setText(uygulama_ismi);

        mailButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND); //
                intent.setType("text/html");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "uyarrelif@gmail.com" }); //Hangi mail adresine masej atmak istediğimiz bu kısma yazıyoruz
                intent.putExtra(Intent.EXTRA_SUBJECT, "Android"); //Mail konusunu yazdığımız kısım
                intent.putExtra(Intent.EXTRA_TEXT, "Kod dosyalarina nasil ulasabiliriz?"); //Mailin içeriğini bu kısıma yazıyoruz.
                startActivity(Intent.createChooser(intent, "Send Email"));//createChooser metodu sayesinde çağırdığımız intent
                //için bu intenti açabilecek uygulamalar ekranda belirecektir.
            }
        });

        smsButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                String smsNumber = "05387940043"; //Bir stringe mesaj göndereceğimiz numarayı alıyoruz.
                String smsText = "Merhaba naber?"; // Başka bir string de mesajın içeriğini yazıyoruz.
                //Bu kısımda intent ile birlikte başka bir uygulama çalıştıracağımızı işletim sistemine haber veriyoruz.
                Uri uri = Uri.parse("smsto:" + smsNumber); //Bu uygulamanın bir sms uygulaması olduğunu belirtiyoruz.
                Intent intent = new Intent(Intent.ACTION_SENDTO, uri); //İntent ile uri yi birleştiriyoruz .
                //Yani yeni bir uygulama açacağımızı ve bu uygulamanın bir mesaj uygulaması oldugunu söylüyoruz.
                intent.putExtra("sms_body", smsText); //Sms içeriğini de sms_body etiketi ile gönderiyoruz. id  gibi düşünebiliriz.
                startActivity(intent);// Oluşturduğumuz intenti başlatıyoruz.


            }
        });
    }
}
