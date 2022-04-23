package com.example.bottomnavigationjetpack.ui.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bottomnavigationjetpack.R;
import com.example.bottomnavigationjetpack.databinding.FragmentHomeBinding;
import com.example.bottomnavigationjetpack.databinding.FragmentHomeDetailsBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeDetailsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private  int id;
    private String txt;

    private FragmentHomeDetailsBinding binding;

    public HomeDetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeDetailsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeDetailsFragment newInstance(String param1, String param2) {
        HomeDetailsFragment fragment = new HomeDetailsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getArguments() != null) {
            id = getArguments().getInt("id");
            txt = getArguments().getString("txt");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeDetailsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        if(getArguments() != null) {
            id = getArguments().getInt("id");
            txt = getArguments().getString("user");
        }

        binding.txtTitle.setText("User : " + txt);
        return root;
    }

}