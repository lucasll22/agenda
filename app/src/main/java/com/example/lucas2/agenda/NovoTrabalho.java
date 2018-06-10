package com.example.lucas2.agenda;

import android.app.DatePickerDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.lucas2.agenda.Principal.Materia;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class NovoTrabalho extends AppCompatActivity {


    Calendar myCalendar = Calendar.getInstance();
    EditText txtData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_trabalho);

        txtData = findViewById(R.id.trabData);
        //Desativando entrada de texto no campo data
        txtData.setInputType(0);

        //Ao pressionar o campo data, uma janela deve aparecer com o calendário default do android
        //Esse elemento se chama DatePicker
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            //No momento que o usuário define uma data e aceita, essa função é executada
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        //Quando o usuário pressiona o campo data, abre o calendário
        txtData.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                // TODO Auto-generated method stub
                if(hasFocus)
                {
                    new DatePickerDialog(NovoTrabalho.this, date, myCalendar
                            .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                            myCalendar.get(Calendar.DAY_OF_MONTH)).show();
                }
            }
        });

        //Se o usuário pressionar uma segunda vez o campo, abre novamente
        //Dois eventos utilizados, o OnClick Não reconheceu o primeiro click no elemento de texto
        txtData.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                new DatePickerDialog(NovoTrabalho.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }


    //Atualiza o campo data com a data selecionada pelo usuario
    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        txtData.setText(sdf.format(myCalendar.getTime()));
    }


    public void adicionarTrabalho(View view) {
        final Materia temp = new Materia();

        EditText descr = findViewById(R.id.matDescr);
        Spinner dia = findViewById(R.id.matSpinner);
        temp.setDescr(descr.getText().toString());
        temp.setDia(dia.getSelectedItemPosition());

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                AppLifeCycle.db.materiaDao().insertAll(temp);
            }
        });


    }
}
