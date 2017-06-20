package gelecegiyazanlar.gykegitimodev;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Giris extends Activity {

    ListView listemiz;
    final List<Kisi> kisiler = new ArrayList<Kisi>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris);


        kisiler.add(new Kisi("Elif", "UYAR", "22", true));
        kisiler.add(new Kisi("Zeynep", "KABA", "15", true));
        kisiler.add(new Kisi("Ahmet", "YILMAZ", "25", false));
        kisiler.add(new Kisi("Fevzi", "CAKMAK", "10", false));

        listemiz = (ListView)findViewById(R.id.listView_kullanicilar);

        //Oluşturduğumuz custom Adapter ı tanımladık ve kisileri adaptore ekledik
        CustomAdapter adaptorumuz = new CustomAdapter(this, kisiler);

        //Listview e oluşturduğumuz adapter ı set ettik
        listemiz.setAdapter(adaptorumuz);

        //ListView e tıklandığı zaman olacaklar
        listemiz.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),
                        listemiz.getAdapter().getItem(position).toString(), Toast.LENGTH_LONG).show();

                String kucukYas = "http://www.okyanusyayincilik.com/";
                String buyukYas = "https://www.sondakika.com/";

                if (Integer.parseInt(kisiler.get(position).getYas()) > 18 ) //Yas 18 den buyukse
                {
                    Intent i = new Intent(getApplicationContext(), webView.class);
                    i.putExtra("gonder",buyukYas);
                    startActivity(i);
                }
                else //Yas 18 den küçükse
                {
                    Intent i = new Intent(getApplicationContext(), webView.class); //İntent ile webView in olduğu class a geçiyoruz.
                    i.putExtra("gonder",kucukYas); //putExtra metodu ile kucukYas Stiringini diğer class a yolluyoruz.
                    startActivity(i); //Aktivity i başlatıyoruz
                }
            }
        });

    }
}
