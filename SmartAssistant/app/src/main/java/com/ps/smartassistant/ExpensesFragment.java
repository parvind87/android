package com.ps.smartassistant;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ExpensesFragment extends Fragment {
    TextView expenseTv;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.expensesfragment,null);
        expenseTv = v.findViewById(R.id.expensesview);
        expenseTv.setText("This is Expense View");

        return v;
    }
}
