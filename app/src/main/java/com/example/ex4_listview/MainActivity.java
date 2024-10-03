package com.example.ex4_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView show_textView;
    private ListView mainListView;
    private ArrayList<String> dataSource;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        show_textView = (TextView) findViewById(R.id.show_textView);
        mainListView = (ListView) findViewById(R.id.mainListView);

        dataSource = new ArrayList<String>();
        dataSource.add("Monday");
        dataSource.add("Tuesday");
        dataSource.add("Wednesday");
        dataSource.add("Thursday");
        dataSource.add("Friday");
        dataSource.add("Saturday");
        dataSource.add("Sunday");

        arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_item, dataSource);

        mainListView.setAdapter(arrayAdapter);

        OnItemClickHandler itemClickListener = new OnItemClickHandler();
        mainListView.setOnItemClickListener(itemClickListener);

    }

    public class OnItemClickHandler implements AdapterView.OnItemClickListener{
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            show_textView.setText(dataSource.get((int)id));
        }
    }
}