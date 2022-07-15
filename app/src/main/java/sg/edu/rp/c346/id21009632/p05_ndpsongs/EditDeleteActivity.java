package sg.edu.rp.c346.id21009632.p05_ndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class EditDeleteActivity extends AppCompatActivity {

    EditText etSongID, etSongTitle, etSinger, etYear;
    RadioGroup rgStars;
    Button btnUpdate, btnDelete, btnCancel;
    Song data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_delete);

        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        btnCancel = findViewById(R.id.btnCancel);
        etSongID = findViewById(R.id.etSongID);
        etSongTitle = findViewById(R.id.etSongTitle);
        etSinger = findViewById(R.id.etSingers);
        etYear = findViewById(R.id.etYear);
        rgStars = findViewById(R.id.rgStars);

        Intent i = getIntent();
        data = (Song) i.getSerializableExtra("data");

        etSongID.setText(data.get_id() + "");
        etSongTitle.setText(data.getTitle());
        etSinger.setText(data.getSingers());
        etYear.setText(data.getYear() + "");
        rgStars.check(data.getStar());

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(EditDeleteActivity.this);
                data.setSongTitle(etSongTitle.getText().toString());
                data.setSingers(etSinger.getText().toString());
                data.setYear(Integer.parseInt(etYear.getText().toString()));
                data.setStars(rgStars.getCheckedRadioButtonId());

                dbh.updateSong(data);
                dbh.close();

                Intent i = new Intent(EditDeleteActivity.this, ShowListActivity.class);
                startActivity(i);
                Toast.makeText(EditDeleteActivity.this, etSongTitle.getText() + " has been updated successfully!", Toast.LENGTH_LONG).show();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(EditDeleteActivity.this);
                dbh.deleteSong(data.get_id());

                Intent i = new Intent(EditDeleteActivity.this, ShowListActivity.class);
                startActivity(i);
                Toast.makeText(EditDeleteActivity.this, etSongTitle.getText() + " has been deleted", Toast.LENGTH_LONG).show();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(EditDeleteActivity.this, ShowListActivity.class);
                startActivity(i);
            }
        });
    }
}