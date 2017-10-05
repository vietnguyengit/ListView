package com.example.viet.listview_assign06;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BookAdapter mBookAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Calling the Adapter to display ListView data */
        mBookAdapter = new BookAdapter();
        ListView listNote = (ListView) findViewById(R.id.listView);
        listNote.setAdapter(mBookAdapter);
        /* Creating new Books */
        Book android = new Book("Android Programming for Beginners", 5, R.drawable.android);
        Book elon = new Book("Elon Musk - How the billionaire CEO of SpaceX and Tesla is shaping our future", 4, R.drawable.elon);
        Book intel = new Book("SuperIntelligence - Paths, Dangers, Strategies", 5, R.drawable.intel);
        Book neural = new Book("Make Your Own Neural Network", 4, R.drawable.neural);
        Book thinking = new Book("Thinking fast and slow", 5, R.drawable.thinking);
        Book ai = new Book("Artificial Intelligence - A Modern Approach", 5, R.drawable.ai);
        Book hour = new Book("4-Hour Work Week", 4, R.drawable.hour);
        Book java = new Book("Absolute Java", 5, R.drawable.java);
        Book python = new Book("Deep Learning with Python", 3, R.drawable.python);
        Book science = new Book("100 Most Important Science Ideas", 3, R.drawable.science);
        /* Array of Books */
        Book[] books = {android, elon, intel, neural, thinking, ai, hour, java, python, science};
        /* Add the books ListView's data */
        for (int i = 0; i < books.length; i++)
        {
            createNewBook(books[i]);
        }
    }

    public void createNewBook(Book n) {
        mBookAdapter.addBook(n);
    }

    public class BookAdapter extends BaseAdapter {
        List<Book> bookList = new ArrayList<>();

        @Override
        public int getCount() {
            return bookList.size();
        }

        @Override
        public Book getItem(int whichItem) {
            return bookList.get(whichItem);
        }

        @Override
        public long getItemId(int whichItem) {
            return whichItem;
        }

        @Override
        public View getView(int whichItem, View view, ViewGroup viewGroup) {
            /* Check if view has been inflated */
            if (view == null) {
                /* Create a LayoutInflater */
                LayoutInflater intflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                /* Using the listitem.xml */
                view = intflater.inflate(R.layout.listitem, viewGroup, false);
            }

            /*List item's elements*/
            TextView txtTitle = view.findViewById(R.id.txtTitle);
            TextView txtRating = view.findViewById(R.id.txtDescription);
            ImageView ivCover = view.findViewById(R.id.imageViewCover);

            Book tempBook = bookList.get(whichItem);
            txtTitle.setText(tempBook.getTitle());
            txtRating.setText(tempBook.getRating());
            ivCover.setImageResource(tempBook.getImage());

            return view;
        }
        public void addBook(Book n) {
            bookList.add(n);
            /* Tell the Adapter that data in cityList has changed */
            notifyDataSetChanged();
        }
    }
}
