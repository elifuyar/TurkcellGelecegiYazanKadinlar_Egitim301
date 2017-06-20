package gelecegiyazanlar.navigationdrawermenu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class UserAdd extends Fragment {


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("UserAdd");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,//Arayüz ile java yı bağlamak için
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.fragment_user_add, container,false);
        return view;
    }

}
