package com.senai.lugaluga.view;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.senai.lugaluga.R;
import com.senai.lugaluga.model.Produto;

public class ProdutoActivity extends AppCompatActivity {

    private Produto produto;

    private TextView nomeProduto, qtdProduto, precoProduto, descProduto;

    private Button btnAlugar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_produto);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        nomeProduto = findViewById(R.id.tv_nome);
        qtdProduto = findViewById(R.id.tv_qntd);
        precoProduto = findViewById(R.id.tv_preco);
        descProduto = findViewById(R.id.tv_descricao);

        btnAlugar = findViewById(R.id.tv_btn);

        produto = getIntent().getExtras().getParcelable("produto");

        if (produto.getDisponibilidade().equals("Indisponível")){
            btnAlugar.setEnabled(false);
            btnAlugar.setText("Indisponível");
        }

        nomeProduto.setText(produto.getNome());
        precoProduto.setText(String.valueOf(produto.getPreco()));
        descProduto.setText(produto.getDescricao());

        btnAlugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ProdutoActivity.this);
                builder.setMessage("Deseja realmente alugar este produto?");
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Concluido", Toast.LENGTH_SHORT).show();
                        btnAlugar.setText("Solicitado");
                        btnAlugar.setEnabled(false);
                        btnAlugar.setBackgroundColor(getColor(R.color.yellow));
                    }
                });

                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

    }
}