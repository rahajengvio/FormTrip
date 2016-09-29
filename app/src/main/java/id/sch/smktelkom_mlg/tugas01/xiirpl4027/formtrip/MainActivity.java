package id.sch.smktelkom_mlg.tugas01.xiirpl4027.formtrip;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText eNama, tgl, bln;
    Button b;
    TextView h;
    Spinner t;

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

        if (isValid()) {
            h.setText("Pemesanan atas nama " + nama +
                    "\nAkan melakukan perjalanan " +
                    " pada tanggal " + tanggal + " bulan " + bulan
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
        } else {
            eNama.setError(null);
        }

        if (tanggal.isEmpty()) {
            tgl.setError("Tanggal belum diisi");
        } else if (tanggal.length() != 2) {
            tgl.setError("Format tangal tidak sesuai");
        } else {
            tgl.setError(null);
        }
        if (bulan.isEmpty()) {
            bln.setError("Bulan belum diisi");
        } else if (bulan.length() != 2) {
            bln.setError("Format bulan tidak sesuai");
        } else {
            bln.setError(null);
        }
        return false;
    }
});
        }