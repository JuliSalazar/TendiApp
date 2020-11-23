package com.example.tendi.InicioRegistro;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tendi.R;
import com.example.tendi.generalUser.UserMainActivity;
import com.example.tendi.usuario.Usuario;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;

public class RegistroComprador extends AppCompatActivity {

    private ImageButton backBTN;
    private Button continueBTN;

    private EditText nameEDT;
    private EditText contraEDT;
    private EditText confirmContraEDT;
    private EditText celEDT;
    private EditText naciEDT;
    private EditText identiEDT;
    private Spinner opcID;
    Calendar c = Calendar.getInstance();
    private int año,mes,dia, saño,smes,sdia;

    private static final int CODE = 11;
    private static final int DATE_ID = 0;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_comprador);

        backBTN = findViewById(R.id.backBTN);
        continueBTN = findViewById(R.id.continueBTN);

        nameEDT = findViewById(R.id.nameEDT);
        contraEDT = findViewById(R.id.contraEDT);
        confirmContraEDT = findViewById(R.id.confirmContraEDT);
        celEDT = findViewById(R.id.celEDT);
        naciEDT = findViewById(R.id.naciEDT);
        identiEDT = findViewById(R.id.identiEDT);

        sdia = c.get(Calendar.DAY_OF_MONTH);
        smes = c.get(Calendar.MONTH);
        saño = c.get(Calendar.YEAR);

        opcID = findViewById(R.id.spin1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.opci, android.R.layout.simple_spinner_item);
        opcID.setAdapter(adapter);

        naciEDT.setOnClickListener(
                (v)->{
                    showDialog(DATE_ID);
                }
        );


        continueBTN.setOnClickListener(
                (v)->{

                    Usuario user = new Usuario(identiEDT.getText().toString(), nameEDT.getText().toString(),
                            contraEDT.getText().toString(), celEDT.getText().toString(),false);
                   // Gson gson = new Gson();
                    //String json = gson.toJson(comprador);

                   /* HTTPSWebUtilDomi https = new HTTPSWebUtilDomi();
                    new Thread(
                            ()->{
                                https.PUTrequest(Constants.BASEURL+"Comprador/"+comprador.getCelular()+".json",json);
                            }
                    ).start();*/

                    if(contraEDT.getText().toString().equals(confirmContraEDT.getText().toString())){
                        CollectionReference usersRef = db.collection("Usuarios");
                        usersRef.document(user.getCelular()).set(user);
                        goToUserActivity(user);
                    }else{
                        contraEDT.setText("");
                        confirmContraEDT.setText("");
                        confirmContraEDT.setHint("No coinciden las contraseñas");
                        confirmContraEDT.setHintTextColor(getResources().getColor(R.color.colorError));
                    }
                }
        );

        backBTN.setOnClickListener(
                (v)->{
                    finish();
                }
        );
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if(id == DATE_ID){
            return new DatePickerDialog(this,dateSetListener, saño,smes,sdia);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            año = year;
            mes = month;
            dia = dayOfMonth;
            colocarFecha();
        }
    };

    public void goToUserActivity(Usuario user){
        Intent i = new Intent(this, UserMainActivity.class);
        i.putExtra("myUser", user);
        startActivity(i);
    }

    private void colocarFecha(){
        naciEDT.setText(dia + "/" + (mes+1) + "/" + año);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CODE && resultCode == RESULT_OK) {

        }
    }
}