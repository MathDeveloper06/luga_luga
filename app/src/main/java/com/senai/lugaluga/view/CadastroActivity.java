package com.senai.lugaluga.view;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputLayout;
import com.senai.lugaluga.R;

import java.lang.reflect.Array;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CadastroActivity extends AppCompatActivity {

    private Spinner spinnerUf;
    private TextInputLayout inputEmail, input_cpf, input_cep, input_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cadastro);

        inputEmail = findViewById(R.id.input_email);
        input_cpf = findViewById(R.id.input_cpf);
        input_cep = findViewById(R.id.input_cep);
        input_data = findViewById(R.id.input_data);

        inputEmail.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Pattern pattern;
                Matcher matcher;
                String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
                pattern = Pattern.compile(EMAIL_PATTERN);
                CharSequence cs = (CharSequence) s;
                matcher = pattern.matcher(cs);
                if (!(matcher.matches() == true)) {
                    inputEmail.setError("Invalid email");
                } else {
                    inputEmail.setError("");
                }
            }
        });

        input_cpf.getEditText().addTextChangedListener(new TextWatcher() {

            private static final String maskCNPJ = "##.###.###/####-##";
            private static final String maskCPF = "###.###.###-##";
            boolean isUpdating;
            String old = "";
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String str = s.toString().replaceAll("[^0-9]*", "");
                String mask;
                String defaultMask = maskCPF;
                if (str.length() > 11){
                    defaultMask = maskCNPJ;
                }
                switch (str.length()) {
                    case 11:
                        mask = maskCPF;
                        break;
                    case 14:
                        mask = maskCNPJ;
                        break;

                    default:
                        mask = defaultMask;
                        break;
                }

                String mascara = "";
                if (isUpdating) {
                    old = str;
                    isUpdating = false;
                    return;
                }
                int i = 0;
                for (char m : mask.toCharArray()) {
                    if ((m != '#' && str.length() > old.length()) || (m != '#' && str.length() < old.length() && str.length() != i)) {
                        mascara += m;
                        continue;
                    }

                    try {
                        mascara += str.charAt(i);
                    } catch (Exception e) {
                        break;
                    }
                    i++;
                }
                isUpdating = true;
                input_cpf.getEditText().setText(mascara);
                input_cpf.getEditText().setSelection(mascara.length());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        input_cep.getEditText().addTextChangedListener(new TextWatcher() {

            private static final String maskCEP = "#####-###";
            boolean isUpdating;
            String old = "";

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String str = s.toString().replaceAll("[^0-9]*", "");
                String mask;
                String defaultMask = maskCEP;
                switch (str.length()) {
                    case 8:
                        mask = maskCEP;

                    default:
                        mask = defaultMask;
                        break;
                }

                String mascara = "";
                if (isUpdating) {
                    old = str;
                    isUpdating = false;
                    return;
                }
                int i = 0;
                for (char m : mask.toCharArray()) {
                    if ((m != '#' && str.length() > old.length()) || (m != '#' && str.length() < old.length() && str.length() != i)) {
                        mascara += m;
                        continue;
                    }

                    try {
                        mascara += str.charAt(i);
                    } catch (Exception e) {
                        break;
                    }
                    i++;
                }
                isUpdating = true;
                input_cep.getEditText().setText(mascara);
                input_cep.getEditText().setSelection(mascara.length());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        input_data.getEditText().addTextChangedListener(new TextWatcher() {
            private static final String maskData = "##/##/####";
            boolean isUpdating;
            String old = "";
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String str = s.toString().replaceAll("[^0-9]*", "");
                String mask;
                String defaultMask = maskData;
                switch (str.length()) {
                    case 8:
                        mask = maskData;

                    default:
                        mask = defaultMask;
                        break;
                }

                String mascara = "";
                if (isUpdating) {
                    old = str;
                    isUpdating = false;
                    return;
                }
                int i = 0;
                for (char m : mask.toCharArray()) {
                    if ((m != '#' && str.length() > old.length()) || (m != '#' && str.length() < old.length() && str.length() != i)) {
                        mascara += m;
                        continue;
                    }

                    try {
                        mascara += str.charAt(i);
                    } catch (Exception e) {
                        break;
                    }
                    i++;
                }
                isUpdating = true;
                input_data.getEditText().setText(mascara);
                input_data.getEditText().setSelection(mascara.length());
            }
        });

        spinnerUf = (Spinner) findViewById((R.id.spinner_uf));

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.uf_cadastro,
                android.R.layout.simple_spinner_item
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerUf.setAdapter(adapter);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        myToolbar.setTitle("Cadastro");
        setSupportActionBar(myToolbar);
        }
    }
