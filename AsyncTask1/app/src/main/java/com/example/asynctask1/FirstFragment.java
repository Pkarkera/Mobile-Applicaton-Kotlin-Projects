package com.example.asynctask1;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.asynctask1.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        Log.i("FIRSTFRAGMENT", "In OnCreateView");
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Log.i("FIRSTFRAGMENT", "In OnCreateView");

        AsyncTaskImageDownloader imgDownloader = new AsyncTaskImageDownloader(this.getActivity());
        imgDownloader.execute("https://picsum.photos/280");
        // https://en.wikipedia.org/wiki/PNG#/media/File:PNG_transparency_demonstration_1.png

        LongOperation lop = new LongOperation();
        lop.execute("Hello");
        try {
            Integer myResult = lop.get();
        }
        catch(Exception e){
            e.printStackTrace();
        }

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}