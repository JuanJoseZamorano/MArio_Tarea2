package zamoranogarcia.juanjose.mario_tarea2;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.Locale;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Locale;

///**
// * A simple {@link Fragment} subclass.
// * Use the {@link Configuracion_Fragment#newInstance} factory method to
// * create an instance of this fragment.
// */
public class Configuracion_Fragment extends Fragment {
    private Switch switchLanguage;
//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;

    public Configuracion_Fragment() {
        // Required empty public constructor
    }

//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment Configuracion_Fragment.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static Configuracion_Fragment newInstance(String param1, String param2) {
//        Configuracion_Fragment fragment = new Configuracion_Fragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_configuracion_, container, false);
        // Inicializa el Switch
        switchLanguage = view.findViewById(R.id.switch_language);


        // Obtén el estado actual del idioma
        SharedPreferences sharedPreferences = requireActivity().getSharedPreferences("AppSettings", Context.MODE_PRIVATE);
        boolean isEnglish = sharedPreferences.getBoolean("isEnglish", false);
        switchLanguage.setChecked(isEnglish);

        // Maneja el cambio de idioma
        switchLanguage.setOnCheckedChangeListener((buttonView, isChecked) -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            if (isChecked) {
                editor.putBoolean("isEnglish", true);
                setLocale("en");
            } else {
                editor.putBoolean("isEnglish", false);
                setLocale("es");
            }
            editor.apply();
            Toast.makeText(requireContext(), "Idioma cambiado", Toast.LENGTH_SHORT).show();
            requireActivity().recreate(); // Reinicia la actividad para aplicar los cambios
        });

        return view;

    }
    private void setLocale(String languageCode) {
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        requireActivity().getResources().updateConfiguration(config, requireActivity().getResources().getDisplayMetrics());
    }
}

