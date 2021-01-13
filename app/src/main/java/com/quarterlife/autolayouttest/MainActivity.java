package com.quarterlife.autolayouttest;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HideBottom.hideBottomMenu(getWindow()); // 隱藏 Android 下方系統內建虛擬按鍵，並且全螢幕

        loadItem();
    }

    private void loadItem() {
        List<ItemModel> list = new ArrayList();
        int i = 0;
        while (i < 8){
            list.add(new ItemModel("item " + i, R.drawable.example));
            i++;
        }

        System.out.println("DER list.size() = " + list.size());

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new GridLayoutManager(this,4);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        ItemAdapter adapter = new ItemAdapter(list,this);
        recyclerView.setAdapter(adapter);
    }
}