package sg.edu.rp.c346.id21009632.p05_ndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ShowListActivity extends AppCompatActivity {

    Button btnShow5Stars;
    ListView lvSongs;
    ArrayList<Song> alSong;
    ArrayAdapter<Song> aaSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_list);

        btnShow5Stars = findViewById(R.id.btnShowAll5Stars);
        lvSongs = findViewById(R.id.lvSongs);

        alSong = new ArrayList<Song>();
        aaSong = new ArrayAdapter<Song>(this, android.R.layout.simple_list_item_1, alSong);
        lvSongs.setAdapter(aaSong);

        btnShow5Stars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(ShowListActivity.this);
                alSong.clear();
                alSong.addAll(dbh.getAll5StarSongs());
                aaSong.notifyDataSetChanged();
                Toast.makeText(ShowListActivity.this, "Displaying all 5 star songs!", Toast.LENGTH_LONG).show();
            }
        });

        lvSongs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long identity) {
                Song data = alSong.get(position);
                Intent i = new Intent(ShowListActivity.this, EditDeleteActivity.class);
                i.putExtra("data", data);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        DBHelper dbh = new DBHelper(ShowListActivity.this);
        alSong.clear();
        alSong.addAll(dbh.getAllSongs());
        aaSong.notifyDataSetChanged();
    }
}