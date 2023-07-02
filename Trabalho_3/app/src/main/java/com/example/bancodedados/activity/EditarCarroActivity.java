package com.example.bancodedados.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.bancodedados.R;
import com.example.bancodedados.data.Carro;
import com.example.bancodedados.data.CarroDAO;

public class EditarCarroActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtNome;
    private EditText edtMarca;
    private EditText edtMotor;
    private ImageView imagem;
    private Button btnProcessar;
    private Button btnCancelar;
    private Carro carro;
    private CarroDAO carroDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_produto);

        edtNome = findViewById(R.id.edt_nome);
        edtMarca = findViewById(R.id.edt_marca);
        edtMotor = findViewById(R.id.edt_motor);
        btnProcessar = findViewById(R.id.btnProcessar);
        btnCancelar = findViewById(R.id.btnCancelar);
        btnProcessar.setOnClickListener(this);
        btnCancelar.setOnClickListener(this);

        carroDAO = CarroDAO.getInstance(this);

        carro = (Carro) getIntent().getSerializableExtra("carro");

        if (carro != null){
            edtNome.setText(carro.getNome());
            edtMarca.setText(String.valueOf(carro.getMarca()));
            edtMotor.setText(String.valueOf(carro.getMotor()));
        }

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnProcessar){
            String nome = edtNome.getText().toString();
            String marca = edtMarca.getText().toString();
            String motor = edtMotor.getText().toString();
            String msg;

            if (carro == null) {
                Carro carro = new Carro(nome, marca, motor);
                carroDAO.save(carro);
                msg = "Carro veio gravado com ID = " + carro.getId();

            } else {
                carro.setNome(nome);
                carro.setMarca(marca);
                carro.setMotor(motor);
                carroDAO.update(carro);
                msg = "Carro veio atualizado com ID = " + carro.getId();
            }

            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
            setResult(RESULT_OK);
            finish();
        }
        else if (view.getId() == R.id.btnCancelar){
            setResult(RESULT_CANCELED);
            finish();
        }
    }
}