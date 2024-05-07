package com.senai.lugaluga.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.senai.lugaluga.R;
import com.senai.lugaluga.RecyclerItemClickListener;
import com.senai.lugaluga.model.Produto;
import com.senai.lugaluga.view.adapter.AdapterProduto;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdapterProduto adapterProduto;
    private List<Produto> produtoList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.listaProdutos);

        CriarListaProdutos();

        adapterProduto = new AdapterProduto(produtoList);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterProduto);

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent intent = new Intent(MainActivity.this, ProdutoActivity.class);
                        intent.putExtra("produto", produtoList.get(position));
                        startActivity(intent);
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        Toast.makeText(getApplicationContext(), produtoList.get(position).getDisponibilidade(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    }
                }));
    }

    public void CriarListaProdutos(){

        Produto produto;

        produto = new Produto("Iphone 13", "Iphone 13 64gb", 200.00, "Disponível", "Muito bom");

        produtoList.add(produto);

        produto = new Produto("Fone", "Bluetooth", 150.00, "Disponível", "Muito bom");

        produtoList.add(produto);

        produto = new Produto("Notebook", "Nvidia, Intel CORE I7", 7500.00, "Disponível", "Muito bom");

        produtoList.add(produto);

        produto = new Produto("Bola Society", "Bola Society da copa do mundo", 50.00, "Indisponível", "Muito bom");

        produtoList.add(produto);

        produto = new Produto("Xbox One", "500gb", 2500.00, "Disponível", "Muito bom");

        produtoList.add(produto);

        produto = new Produto("Samsung S20 FE", "250gb", 1900.00, "Disponível", "Muito bom");

        produtoList.add(produto);

        produto = new Produto("Samsung Smart Oled", "8k", 10000.00, "Disponível", "Muito bom");

        produtoList.add(produto);

        produto = new Produto("Furadeira", "Bivolt", 120.00, "Disponível", "Muito bom");

        produtoList.add(produto);

        produto = new Produto("Chuteira", "Chuteira Society", 250.00, "Disponível", "Muito bom");

        produtoList.add(produto);

        produto = new Produto("JBL", "Caixa de som prova d'água", 350.00, "Disponível", "Muito bom");

        produtoList.add(produto);

    }

}