package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Achat> listAchats;
    private RecyclerView recyclerView;
    private AchatAdapter adapter;

    private EditText editText;
    private EditText editText2;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listAchats = new ArrayList<>();

        listAchats.add(new Achat(" Farine", "10 kg"));
        listAchats.add(new Achat(" Huile", "10 L"));
        listAchats.add(new Achat(" Tomates", "4 kg"));
        listAchats.add(new Achat(" Levures", "10 "));
        listAchats.add(new Achat(" Eeu", "10 L"));
        listAchats.add(new Achat(" Extrait de vanille", "1 "));
        listAchats.add(new Achat(" poivre noir", "100 g"));
        listAchats.add(new Achat(" lives noires", "200 g"));

        recyclerView = findViewById(R.id.recyclerView);
        adapter = new AchatAdapter(this, listAchats);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        editText = findViewById(R.id.ajouter_item);
        editText2 = findViewById(R.id.ajouter_quantite);
        button = findViewById(R.id.ajouter_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addItemToList(editText.getText().toString(),editText2.getText().toString());
            }
        });
    }

    public void addItemToList(String item ,String qtn) {

        Achat achat = new Achat(item, qtn);
        listAchats.add(achat);
        adapter.notifyDataSetChanged();
    }


}


