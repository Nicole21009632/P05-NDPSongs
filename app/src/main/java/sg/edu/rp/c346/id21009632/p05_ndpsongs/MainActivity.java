package sg.edu.rp.c346.id21009632.p05_ndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnInsert, btnShowList;
    EditText etSongTitle, etSinger, etYear;
    RadioGroup rgStars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsert = findViewById(R.id.btnInsert);
        btnShowList = findViewById(R.id.btnShowList);
        etSongTitle = findViewById(R.id.etSongTitle);
        etSinger = findViewById(R.id.etSingers);
        etYear = findViewById(R.id.etYear);
        rgStars = findViewById(R.id.rgStars);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String songTitle = etSongTitle.getText().toString();
                String singer = etSinger.getText().toString();
                int year = Integer.parseInt(etYear.getText().toString());
                int stars = rgStars.getCheckedRadioButtonId();

                DBHelper dbh = new DBHelper(MainActivity.this);
                long inserted_id = dbh.insertSong(songTitle, singer, year, stars);

                if (inserted_id != -1) {
                    Toast.makeText(MainActivity.this, "Added " + songTitle + " to the song list successfully!", Toast.LENGTH_LONG).show();

                    etSongTitle.setText("");
                    etSinger.setText("");
                    etYear.setText("");
                    rgStars.clearCheck();
                }
            }
        });

        btnShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ShowListActivity.class);
                startActivity(i);
            }
        });
    }
}