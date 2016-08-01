package com.example.admin.simplelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private EditText mEditText;
    private String[] names;
    private List<String> data;
    private listAdapter mlistAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.a_main_list);

        names  = new String[]{"Chris", "Aldo", "Mike", "Libu", "Karles","Pedro","Bart","Bort","Kyle",
                "El Brayan", "La Britanny", "El wero", "Dona Pelos","Pirrrurris","Fat joe"};

        data = new ArrayList<String>(Arrays.asList(names));

        //arrayAdapter = new ArrayAdapter<String>(this,android.R.layout_textview_item1, data);
        mlistAdapter = new listAdapter(this,R.layout.list_item,R.id.a_textview_item, data);

        mListView.setAdapter(mlistAdapter);

    }

    public void addItem(View view) {

        mEditText = (EditText) findViewById(R.id.a_main_et);
        String text = mEditText.getText().toString();
        data.add(text);
        mlistAdapter.notifyDataSetChanged();
        Toast.makeText(view.getContext(),"Item added succesfully",Toast.LENGTH_SHORT).show();
        mEditText.setText("");
    }
}
