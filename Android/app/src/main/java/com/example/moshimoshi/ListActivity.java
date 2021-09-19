package com.example.moshimoshi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private EditText editText;
    private ListView listView;
    private Button button;

    private ListAdapter listAdapter;
    private List<String> texts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        editText = (EditText) findViewById(R.id.editText);
        listView = (ListView) findViewById(R.id.listView);
        button = (Button) findViewById(R.id.button);

        texts = new ArrayList<>();
        listAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, texts);
        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                AlertDialog.Builder adb = new AlertDialog.Builder(ListActivity.this)
                        .setTitle("Usunięcie elementu")
                        .setMessage("Czy chcesz usunąć element o pozycji " + position)
                        .setPositiveButton("Tak", new
                                DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Toast.makeText(getApplicationContext(), "Kliknąłeś tak", Toast.LENGTH_LONG).show();
                                        texts.remove(position);
                                        listView.invalidateViews();
                                    }
                                }).setNegativeButton("Nie", new
                                DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Toast.makeText(getApplicationContext(), "Kliknąłeś nie", Toast.LENGTH_LONG).show();

                                    }
                                });
                adb.show();
            }
        });
    }

    public void addText(View v) {
        listView = (ListView) findViewById(R.id.listView);
        String text = editText.getText().toString();
        if (text.isEmpty()) {
            Toast.makeText(this, R.string.edittext_cant_be_empty,
                    Toast.LENGTH_LONG)
                    .show();
        } else {
            texts.add(text);
            Log.d("tests", texts.toString());
            listView.invalidateViews();
            editText.setText("");
        }
    }
}