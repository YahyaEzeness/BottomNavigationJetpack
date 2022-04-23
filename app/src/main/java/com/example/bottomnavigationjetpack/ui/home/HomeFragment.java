package com.example.bottomnavigationjetpack.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bottomnavigationjetpack.adapter.ChatHeadAdapter;
import com.example.bottomnavigationjetpack.adapter.ChatHeadModel;
import com.example.bottomnavigationjetpack.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeFragment extends Fragment {

    RecyclerView rvChatHead;
    private List<ChatHeadModel> chatHeadModelList = new ArrayList<>();

private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

    binding = FragmentHomeBinding.inflate(inflater, container, false);
    View root = binding.getRoot();
        rvChatHead = binding.recyclerView;
        initChatHeadRecycler();

        return root;
    }

    private void initChatHeadRecycler() {

        ChatHeadAdapter chatHeadAdapter = new ChatHeadAdapter(getActivity());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireActivity(), GridLayoutManager.VERTICAL, false);
        rvChatHead.setLayoutManager(linearLayoutManager);
        rvChatHead.setAdapter(chatHeadAdapter);

        chatHeadModelList = Arrays.asList(
                new ChatHeadModel("@user 1", "https://utagup.com/dev/assect/images/products/thumb/2022/04/15/62595a53bb5a4.jpg"),
                new ChatHeadModel("@user 2", "https://utagup.com/dev/assect/images/products/thumb/2022/04/15/62595a53bb5a4.jpg"),
                new ChatHeadModel("@user 3", "https://utagup.com/dev/assect/images/products/thumb/2022/04/15/62595a53bb5a4.jpg"),
                new ChatHeadModel("@user 4", "https://utagup.com/dev/assect/images/products/thumb/2022/04/15/62595a53bb5a4.jpg"),
                new ChatHeadModel("@user 5", "https://utagup.com/dev/assect/images/products/thumb/2022/04/15/62595a53bb5a4.jpg"),
                new ChatHeadModel("@user 6", "https://utagup.com/dev/assect/images/products/thumb/2022/04/15/62595a53bb5a4.jpg"),
                new ChatHeadModel("@user 7", "https://utagup.com/dev/assect/images/products/thumb/2022/04/15/62595a53bb5a4.jpg"));

        chatHeadAdapter.setArrList(chatHeadModelList);
    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}