package com.example.bookx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.bookx.Model.Post;
import com.example.bookx.R;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends AppCompatActivity {

    TextView title_tv;
    Button account_btn;
    Button preferences_btn;
    Button upload_btn;
    public static List<Post> posts = new ArrayList<>();
    private ListView lvPosts ;
    private ListAdapter postAdapter ;

    Button temp_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        title_tv = (TextView) findViewById(R.id.title_tv);
        account_btn = (Button) findViewById(R.id.account_btn);
        preferences_btn = (Button) findViewById(R.id.preferences_btn);
        upload_btn = (Button) findViewById(R.id.upload_btn);

        temp_btn = findViewById(R.id.tempBtn);
        temp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChat();
            }
        });

        //when you click account_btn, it will open up account page
        account_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAccountPage();
            }
        });

        //when you click preferences_btn, it will open up preferences page
        preferences_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPreferencesPage();
            }
        });

        //when you click upload_btn, it will open up listing page
        upload_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openListingPage();
            }
        });

        data();
        postAdapter = new listingAdapter(this.getBaseContext(),posts) ;
        lvPosts = (ListView) findViewById(R.id.lvListing) ;
        lvPosts.setAdapter(postAdapter);
        lvPosts.setItemsCanFocus(true);
    }
    public void openAccountPage() {
        Intent intent = new Intent(this, AccountPage.class);
        startActivity(intent);

    }
    public void openPreferencesPage() {
        Intent intent = new Intent(this, PreferencesPage.class);
        startActivity(intent);

    }

    public void openListingPage() {
        Intent intent = new Intent(this, ListingPage.class);
        startActivity(intent);
    }

    public static void data(){
        Post post1 = new Post("book1","seller1","course1",1,"This is book1",false) ;
        Post post2 = new Post("book2","seller2","course2",2,"This is book2",false) ;
        Post post3 = new Post("book3","seller3","course3",3,"This is book3",false) ;
        posts.add(post1) ;
        posts.add(post2) ;
        posts.add(post3) ;
    }

    public void openChat(){
        Intent intent = new Intent(this, ChatMain.class);
        startActivity(intent);
    }

}
