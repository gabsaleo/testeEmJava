package com.example.testeemjava.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.testeemjava.Others.AppPet;
import com.example.testeemjava.Infra.LoginServices;
import com.example.testeemjava.Others.MaskEditUtil;
import com.example.testeemjava.R;
import com.example.testeemjava.Infra.RetrofitClient;
import com.example.testeemjava.View.MainActivity;
import com.example.testeemjava.model.Enums.CoatLength;
import com.example.testeemjava.model.Enums.Genre;
import com.example.testeemjava.model.Enums.PetRecommendedTo;
import com.example.testeemjava.model.Enums.PetSize;
import com.example.testeemjava.model.Enums.PetType;
import com.example.testeemjava.model.Animal;
import com.example.testeemjava.model.SpinnerAddPet;
import com.example.testeemjava.model.UserDTO;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddPet extends Fragment {

    String tamanhoText, pelosText, recomendadoText, tipoPetText, generoText;

    boolean txt = false;
    private View view;
    private EditText editRaca, editCorPet, editNamePet, editIdade, editDescricaoPet, editSanguineo,
            editURL;
    List<SpinnerAddPet> result = new ArrayList<>();

    List<String> tamanho = new ArrayList<>();
    List<String> pelos = new ArrayList<>();
    List<String> recomendadoPara = new ArrayList<>();
    List<String> tipoPet = new ArrayList<>();
    List<String> genero = new ArrayList<>();


    private Spinner spinnerPorte,spinnerGenero, spinnerPelagem, spinnerRecomendado, spinnerTipoPet;
    private CheckBox checkPossuiDoenca, checkVacinado;
    private Button botaoSalvarCriarPet;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_add_pet, container, false);
        loadUI();
        getSelectedSpinners();
//        editIdade.addTextChangedListener(MaskEditUtil.mask(editIdade, MaskEditUtil.FORMAT_DATE));

        checkPossuiDoenca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkPossuiDoenca.isChecked()){
                    Toast.makeText(getContext(), "Escolheu o " +checkPossuiDoenca.getText(), Toast.LENGTH_SHORT).show();
                    txt = true;
                    Log.d("foi", "true");

                }else{
                    Toast.makeText(getContext(), "Deselecionado " +checkPossuiDoenca.getText(), Toast.LENGTH_SHORT).show();
                    txt = false;
                    Log.d("foi", "false");
                }


            }
        });

        checkVacinado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkVacinado.isChecked()){
                    Toast.makeText(getContext(), "Escolheu o " +checkVacinado.getText(), Toast.LENGTH_SHORT).show();
                    txt = true;
                    Log.d("foi", "true");
                }else{
                    Toast.makeText(getContext(), "Deselecionado" +checkVacinado.getText(), Toast.LENGTH_SHORT).show();
                    txt = false;
                    Log.d("foi", "false");
                }
            }
        });



        addPet();



        return view;

    }

    private void addPet() {
        botaoSalvarCriarPet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UserDTO userDTO = new UserDTO();
                userDTO.setId(AppPet.getUserDTO().getId());

                Animal pet = new Animal( editNamePet.getText().toString(), editIdade.getText().toString(),
                        editRaca.getText().toString(), editDescricaoPet.getText().toString(),
                        editURL.getText().toString(), PetSize.toEnum(tamanhoText).getId(),
                        PetRecommendedTo.toEnum(recomendadoText).getId(), CoatLength.toEnum(pelosText).getId(),
                        Genre.toEnum(generoText).getId(), PetType.toEnum(tipoPetText).getId(), editCorPet.getText().toString(),
                        editSanguineo.getText().toString(), checkVacinado.isChecked(),
                        checkPossuiDoenca.isChecked(), userDTO);

                Log.d("userDTO", userDTO.toString());
                Log.d("toString", pet.toString());
                Log.d("tamanho", PetSize.toEnum(tamanhoText).getId());
                Log.d("tipo",  PetType.toEnum(tipoPetText).getId());
                Log.d("genre",  Genre.toEnum(generoText).getId());
                Log.d("pelos", CoatLength.toEnum(pelosText).getId());
                Log.d("pegou", AppPet.getUserDTO().getId().toString());

            LoginServices services = new RetrofitClient().getRetrofit();
            Call<Animal> animalCall = services.postPet(pet);
            animalCall.enqueue(new Callback<Animal>() {
                @Override
                public void onResponse(Call<Animal> call, Response<Animal> response) {
                    if (response.code() == 200) {
                        Toast.makeText(getContext(), "Pet cadastrado com sucesso", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getContext(), MainActivity.class );
                    startActivity(intent);
                    return;
                    }

                }

                @Override
                public void onFailure(Call<Animal> call, Throwable t) {
                    Log.d("erro" , t.getMessage());
                }
            });


            }

        });
    }

    private void getSelectedSpinners() {
        spinnerTipoPet.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               tipoPetText = (String) spinnerTipoPet.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerRecomendado.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               recomendadoText = (String) spinnerRecomendado.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinnerPelagem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               pelosText = (String) spinnerPelagem.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinnerGenero.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               generoText = (String) spinnerGenero.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinnerPorte.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               tamanhoText = (String) spinnerPorte.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });






    }


    private void setAdapterArray(List<String> list, Spinner spinner) {
        int layout = android.R.layout.simple_spinner_dropdown_item;
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(),layout,list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
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

        loadSpinners();

    }

    private void loadSpinners() {

        for (PetRecommendedTo value : PetRecommendedTo.values())
            recomendadoPara.add(value.getMsg());

        for (PetType value : PetType.values())
            tipoPet.add(value.getMsg());

        for (PetSize value : PetSize.values())
            tamanho.add(value.getMsg());

        for (Genre value : Genre.values())
            genero.add(value.getMsg());

        for (CoatLength value : CoatLength.values()) {
            pelos.add(value.getMsg());
        }

        spinnerPorte.setAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, tamanho));
        spinnerGenero.setAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, genero));
        spinnerPelagem.setAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, pelos));
        spinnerRecomendado.setAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, recomendadoPara));
        spinnerTipoPet.setAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, tipoPet));
    }

}
