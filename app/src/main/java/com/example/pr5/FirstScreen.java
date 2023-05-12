package com.example.pr5;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pr5.databinding.FragmentFirstScreenBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FirstScreen#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstScreen extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FirstScreen() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FirstScreen.
     */
    // TODO: Rename and change types and number of parameters
    public static FirstScreen newInstance(String param1, String param2) {
        FirstScreen fragment = new FirstScreen();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentFirstScreenBinding binding = FragmentFirstScreenBinding.inflate(inflater);
        binding.text2.setText(getArguments().getString("text"));
        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("textA", binding.text2.getText().toString());
                bundle.putString("textB", getArguments().getString("textB"));
                Navigation.findNavController(v).navigate(R.id.action_firstScreen_to_mainScreen, bundle);
            }
        });
        return binding.getRoot();
    }
}