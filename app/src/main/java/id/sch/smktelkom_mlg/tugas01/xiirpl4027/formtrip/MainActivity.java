package id.sch.smktelkom_mlg.tugas01.xiirpl4027.formtrip;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText eNama, tgl, bln;
    Button b;
    RadioButton rOT, rP;
    TextView h;
    Spinner t;
    CheckBox sa, tu, ti, em;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eNama = (EditText) findViewById(R.id.editText);

        b = (Button) findViewById(R.id.button);

        h = (TextView) findViewById(R.id.textViewH);

        t = (Spinner) findViewById(R.id.spinner);

        tgl = (EditText) findViewById(R.id.editText2);
        bln = (EditText) findViewById(R.id.editText3);

        rOT = (RadioButton) findViewById(R.id.radioButton);
        rP = (RadioButton) findViewById(R.id.radioButton2);

        sa = (CheckBox) findViewById(R.id.checkBox);
        tu = (CheckBox) findViewById(R.id.checkBox2);
        ti = (CheckBox) findViewById(R.id.checkBox3);
        em = (CheckBox) findViewById(R.id.checkBox4);

        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                doProcess();
            }
        });
    }


    private void doProcess() {
        String nama = eNama.getText().toString();
        String tanggal = tgl.getText().toString();
        String bulan = bln.getText().toString();
        String trip = t.getSelectedItem().toString();

        String hasil = null;

        String has = "";
        int startlen = has.length();
        if (sa.isChecked()) has += sa.getText() + "\n";
        if (tu.isChecked()) has += tu.getText() + "\n";
        if (ti.isChecked()) has += ti.getText() + "\n";
        if (em.isChecked()) has += em.getText() + "\n";

        if (has.length() == startlen) has += "Tidak ada pada Pilihan";
        if (rOT.isChecked()) {
            hasil = rOT.getText().toString();
        } else if (rP.isChecked()) {
            hasil = rP.getText().toString();
        }

        if (isValid()) {
            h.setText("Pemesanan atas nama " + nama +
                    "\nAkan melakukan perjalanan " + hasil + " " + trip +
                    " pada tanggal " + tanggal + " bulan " + bulan
                    + "\n\nExtra : \n" + has
            );
        }
    }

    private boolean isValid() {
        boolean valid = true;
        String nama = eNama.getText().toString();
        String tanggal = tgl.getText().toString();
        String bulan = bln.getText().toString();


        if (nama.isEmpty()) {
            eNama.setError("Nama belum diisi");
            valid = false;
        } else {
            eNama.setError(null);
        }

        if (tanggal.isEmpty()) {
            tgl.setError("Tanggal belum diisi");
            valid = false;
        } else if (tanggal.length() != 2) {
            tgl.setError("Format tangal tidak sesuai");
            valid = false;
        } else {
            tgl.setError(null);
        }
        if (bulan.isEmpty()) {
            bln.setError("Bulan belum diisi");
            valid = false;
        } else if (bulan.length() != 2) {
            bln.setError("Format bulan tidak sesuai");
            valid = false;
        } else {
            bln.setError(null);
        }
        return valid;
    }
}