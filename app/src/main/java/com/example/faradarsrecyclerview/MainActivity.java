package com.example.faradarsrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MyAdapter adapter;
    List<MyFriend> myFriendList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        prepareData();
        showData();
    }

    private void showData() {
        adapter=new MyAdapter(myFriendList);
     //   recyclerView.setLayoutManager(new LinearLayoutManager(
          //       this, LinearLayoutManager.VERTICAL,false));
       recyclerView.setItemAnimator(new DefaultItemAnimator());
      //  recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setLayoutManager(new GridLayoutManager(this , 2));
        recyclerView.setAdapter(adapter);
    }

    private void prepareData() {
        if(myFriendList==null){
            myFriendList=new ArrayList<>();
        }else {
            myFriendList.clear();
        }
        myFriendList.add(new MyFriend("Tannaz", "Kermanshah"));
        myFriendList.add(new MyFriend("Tara", "Tehran"));
        myFriendList.add(new MyFriend("Maryam", "Rasht"));
        myFriendList.add(new MyFriend("Zahra", "Shiraz"));
        myFriendList.add(new MyFriend("Sara", "Isfahan"));
        myFriendList.add(new MyFriend("Elnaz", "Yasuj"));
        myFriendList.add(new MyFriend("Tiana", "Kerman"));
        myFriendList.add(new MyFriend("Mina", "Tehran"));
        myFriendList.add(new MyFriend("Hana", "Lahijan"));
        myFriendList.add(new MyFriend("Mahmoud", "Mashhad"));
        myFriendList.add(new MyFriend("Majid", "Karaj"));
        myFriendList.add(new MyFriend("Mitra", "Bandar"));
        myFriendList.add(new MyFriend("Mona", "Kermanshah"));
        myFriendList.add(new MyFriend("Mandana", "Tehran"));
        myFriendList.add(new MyFriend("Nila", "Rasht"));
        myFriendList.add(new MyFriend("Elham", "Shiraz"));
        myFriendList.add(new MyFriend("Reza", "Isfahan"));
        myFriendList.add(new MyFriend("Ronak", "Yasuj"));
        myFriendList.add(new MyFriend("Nila", "Kerman"));
        myFriendList.add(new MyFriend("Nick", "Tehran"));
        myFriendList.add(new MyFriend("Kian", "Lahijan"));
        myFriendList.add(new MyFriend("Saman", "Mashhad"));
        myFriendList.add(new MyFriend("Parsa", "Karaj"));
        myFriendList.add(new MyFriend("Mohamad", "Bandar"));

    }
}
