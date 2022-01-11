package pt.ua.nextweather.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import pt.ua.nextweather.R;


public class SecondFragment extends Fragment {

    String str = "";
    TextView tv;

    public SecondFragment(String s) {
        str = s;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_second, container, false);
        tv = (TextView) view.findViewById(R.id.tvSecondFragment);
        tv.setText(str);

        // Inflate the layout for this fragment
        return view;
    }

    public void setText(String s) {
        tv.setText(s);
    }
}