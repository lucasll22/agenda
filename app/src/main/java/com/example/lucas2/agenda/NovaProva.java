package com.example.lucas2.agenda;

import android.app.DatePickerDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;

import com.example.lucas2.agenda.Principal.Materia;
import com.example.lucas2.agenda.Principal.Prova;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class NovaProva extends AppCompatActivity {

    //Um calendário deve ser aberto para a definição da data
    Calendar myCalendar = Calendar.getInstance();
    EditText txtData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_prova);

        txtData = findViewById(R.id.provaData);
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
                    new DatePickerDialog(NovaProva.this, date, myCalendar
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

                    new DatePickerDialog(NovaProva.this, date, myCalendar
                            .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                            myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        //Temposrário, aquele picker da hora............
        TimePicker tp = findViewById(R.id.provaHorario);
        tp.setIs24HourView(true);


    }
    //Atualiza o campo data com a data selecionada pelo usuario
    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        txtData.setText(sdf.format(myCalendar.getTime()));
    }



    public void adicionarProva(View view) {
        final Prova temp = new Prova();
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        EditText descr = findViewById(R.id.provaDescr);
        EditText provaData = findViewById(R.id.provaData);
        try {
            Date data = sdf.parse(provaData.getText().toString());
            TimePicker hora = findViewById(R.id.provaHorario);
            temp.setData(data);
            temp.setHorarioInicio(new Time(hora.getCurrentHour(), hora.getCurrentMinute(), 0));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        temp.setDescr(descr.getText().toString());

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                AppLifeCycle.db.provaDao().insertAll(temp);
            }
        });


    }
}
