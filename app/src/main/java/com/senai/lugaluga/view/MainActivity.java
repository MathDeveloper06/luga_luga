package com.senai.lugaluga.view;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.senai.lugaluga.R;
import com.senai.lugaluga.model.Produto;

public class MainActivity extends AppCompatActivity {

    private ListView listCidade;

    private String[] cidades = {
            "São Carlos", "Araraquara", "Ibaté",
            "Ribeirão Bonito", "Dourado", "Descalvado",
            "Porto Ferreira", "Santa Rita do Passa Quatro",
            "Tambaú", "Pirassununga", "Ribeirão Preto",
            "Jaboticabal", "Franca", "São Paulo", "Itapiratina",
            "Brotas", "Jaú", "Bauru", "Rio Claro", "Rio de Janeiro"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        listCidade = findViewById(R.id.listaNomes);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                cidades
        );

        listCidade.setAdapter(adapter);

        listCidade.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemSelecionado = listCidade.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), itemSelecionado, Toast.LENGTH_LONG).show();
            }
        });

    }
}