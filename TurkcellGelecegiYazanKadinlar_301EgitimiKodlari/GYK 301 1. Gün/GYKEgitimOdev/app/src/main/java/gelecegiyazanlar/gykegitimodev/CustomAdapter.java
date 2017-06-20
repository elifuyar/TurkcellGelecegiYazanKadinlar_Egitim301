package gelecegiyazanlar.gykegitimodev;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by User on 11.6.2017.
 */

public class CustomAdapter extends BaseAdapter {

    private LayoutInflater mInflate; //Arayüz ile adapter ı birleştimek için
    private List<Kisi> mKisiListesi; //Gelen kişileri listede tutmak için


    //mInflater ı activity sınıf ile bağlayıp activity sınıfının metoslarını kullanabiliriz.
    public CustomAdapter(Activity activity, List<Kisi> kisiler) {
        mInflate = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mKisiListesi = kisiler;
    }


    //Liste içindeki satır sayısını döndürür.
    @Override
    public int getCount() {
        return mKisiListesi.size();
    }

    //Object değer döndürür. Pozisyondaki nesneyi döndürür.
    @Override
    public Object getItem(int position) {
        return mKisiListesi.get(position);
    }

    //Long deger döndürür. Pozisyondaki satırın idsini döndürür.
    @Override
    public long getItemId(int position) {
        return position;
    }

    //Pzisyndaki nesneler döndürür. Mesela textview ' i
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //View i oluşturduğumuz layoout dosyası ile bağladık
        convertView = mInflate.inflate(R.layout.line_layout, null);

        TextView textViewAd = (TextView) convertView.findViewById(R.id.textView_ad);
        TextView textViewSoyad = (TextView) convertView.findViewById(R.id.textView_soyad);
        TextView textViewYas = (TextView) convertView.findViewById(R.id.textView_yas);
        ImageView imageView = (ImageView)convertView.findViewById(R.id.imageView_resim);

        Kisi kisi = mKisiListesi.get(position); //Kisi listesinin pozisyonunu getir

        textViewAd.setText(kisi.getIsim());
        textViewSoyad.setText(kisi.getSoyisim());
        textViewYas.setText(kisi.getYas());

        if (kisi.isKadinMi() == true)//Eğer kisilerden dönen kadın ise kadın resmi gelecek
        {
            imageView.setImageResource(R.drawable.kadin_simge); //Resmi imageView e ekledik
        }
        else
        {
            imageView.setImageResource(R.drawable.erkek_simge);
        }
        return convertView;
    }
}
