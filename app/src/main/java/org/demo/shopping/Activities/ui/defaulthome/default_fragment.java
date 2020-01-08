package org.demo.shopping.Activities.ui.defaulthome;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import org.demo.shopping.Activities.ui.tools.ToolsViewModel;
import org.demo.shopping.R;

public class default_fragment  extends Fragment {

    private ToolsViewModel toolsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.defaultlayout, container, false);

        return root;
    }
}