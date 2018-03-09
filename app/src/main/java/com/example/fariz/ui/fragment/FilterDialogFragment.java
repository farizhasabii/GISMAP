package com.example.fariz.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;

import com.example.fariz.ui.R;

public class FilterDialogFragment extends DialogFragment implements View.OnClickListener {

    private Button button;
    private RadioButton button1,button2;

    private String rbCaseHome, rbCaseOther;

    private OnOptionDialogListener onOptionDialogListener;


    public void setOnOptionDialogListener(OnOptionDialogListener onOptionDialogListener) {
        this.onOptionDialogListener = onOptionDialogListener;
    }

    public FilterDialogFragment() {
        // Required empty public constructor
    }
    public static FilterDialogFragment newInstance(String param1, String param2) {
        FilterDialogFragment fragment = new FilterDialogFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_filter_dialog, container, false);

        button=(Button) view.findViewById(R.id.button);
        button1 = (RadioButton) view.findViewById(R.id.button1);
        button2 = (RadioButton) view.findViewById(R.id.button2);

        button.setOnClickListener(this);
        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button:
                if (button1.isChecked()){
                    rbCaseHome = button1.getText().toString().trim();
                    onOptionDialogListener.onOptionSelect(rbCaseHome);
                    dismiss();
                }else if (button2.isChecked()){
                    rbCaseOther = button2.getText().toString().trim();
                    onOptionDialogListener.onOptionSelect(rbCaseOther);
                    dismiss();
                }
                break;
        }
    }

    public interface OnOptionDialogListener{

        void onOptionSelect(String caseOption);
    }


}
