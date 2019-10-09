package com.example.testeemjava.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.testeemjava.R;

public class AddPet extends Fragment {
    private View view;
    private EditText editRaca, editCorPet, editNamePet, editIdade, editDescricaoPet, editSanguineo,
            editURL;
    private Spinner spinnerPorte,spinnerGenero, spinnerPelagem, spinnerRecomendado, spinnerTipoPet;
    private CheckBox checkPossuiDoenca, checkVacinado;
    private Button botaoSalvarCriarPet;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_add_pet, container, false);
        loadUI();

        checkPossuiDoenca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Escolheu o " +checkPossuiDoenca.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        checkVacinado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Escolheu o " + checkVacinado.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        return view;

    }

    public void loadUI(){
        editRaca = view.findViewById(R.id.editRaca);
        editCorPet = view.findViewById(R.id.editCorPet);
        editNamePet = view.findViewById(R.id.editNamePet);
        editIdade = view.findViewById(R.id.editIdade);
        editDescricaoPet = view.findViewById(R.id.editDescricaoPet);
        editSanguineo = view.findViewById(R.id.editSanguineo);
        editURL = view.findViewById(R.id.editURL);

        spinnerPorte=view.findViewById(R.id.spinnerPorte);
        spinnerGenero = view.findViewById(R.id.spinnerGenero);
        spinnerPelagem = view.findViewById(R.id.spinnerPelagem);
        spinnerRecomendado = view.findViewById(R.id.spinnerRecomendado);
        spinnerTipoPet = view.findViewById(R.id.spinnerTipoPet);

        checkPossuiDoenca = view.findViewById(R.id. checkPossuiDoenca);
        checkVacinado = view.findViewById(R.id.checkVacinado);

        botaoSalvarCriarPet = view.findViewById(R.id.botaoSalvarCriarPet);

    }

}
