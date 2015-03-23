package com.sss;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.sss.Util.Author;
import com.sss.Util.Book;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import network.VolleySingleton;

import static com.sss.Keys.EndpointBooks.KEY_BOOKS;
import static com.sss.Keys.EndpointBooks.KEY_DATE;
import static com.sss.Keys.EndpointBooks.KEY_DESCRIPTION;
import static com.sss.Keys.EndpointBooks.KEY_EDITION;
import static com.sss.Keys.EndpointBooks.KEY_ISBN;
import static com.sss.Keys.EndpointBooks.KEY_LANGUAGE;
import static com.sss.Keys.EndpointBooks.KEY_LENGTH;
import static com.sss.Keys.EndpointBooks.KEY_NAME;
import static com.sss.Keys.EndpointBooks.KEY_RATINGS;
import static com.sss.Keys.EndpointBooks.KEY_SSS;
import static com.sss.Keys.EndpointBooks.KEY_SUBJECT;
import static com.sss.Keys.EndpointBooks.KEY_SYMBOL;

;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentEbookAll#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentEbookPopular extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // TODO: Rename and change types of parameters
    private static String mParam1;
    VolleySingleton volleySingleton;
    RequestQueue requestQueue;
    TextView textVolleyError;
    AdapterBookAll adapterBookAll;
    private String mParam2;
    private RecyclerView booksAll;
    private List<Book> listBooks = new ArrayList<>();
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public FragmentEbookPopular() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentEbookAll.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentEbookAll newInstance(String param1, String param2) {
        FragmentEbookAll fragment = new FragmentEbookAll();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        mParam1 = param1;
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        Log.d("Test", "starting Parsing");
        sendJSONRequest();
        Log.d("Test", "starting Parsing");

    }

    public void sendJSONRequest() {
        volleySingleton = VolleySingleton.getInstance();
        requestQueue = volleySingleton.getRequestQueue();
        String url = "http://10.0.3.3/bookDetailsByRatings.php?subject=";
        JsonObjectRequest request = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                listBooks = parseJSONResponse(response);
                adapterBookAll.setListBooks(listBooks);
                Log.d("Test", "adding list books  Parsing");

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                handleVolleyError(error);
            }
        });

        requestQueue.add(request);
    }


    private ArrayList<Book> parseJSONResponse(JSONObject response) {
        Log.e("response test", "working");
        ArrayList<Book> listBooks = new ArrayList<>();
        if (response != null && response.length() > 0) {
            try {
                JSONArray arrayBooks = response.getJSONArray(KEY_BOOKS);
                Log.d("arraySize", "SIZE" + arrayBooks.length());
                for (int i = 0; i < arrayBooks.length(); i++) {
                    String SSS = Constants.NA;
                    String symbol = Constants.NA;
                    String bookName = Constants.NA;
                    String edition = Constants.NA;
                    String ISBN = Constants.NA;
                    String subject = Constants.NA;
                    String date = Constants.NA;
                    String time = Constants.NA;
                    String language = Constants.NA;
                    String description = Constants.NA;
                    String length = Constants.NA;
                    String imageUrl = Constants.NA;
                    String publisher = Constants.NA;
                    ArrayList<Author> authors = new ArrayList<>();
                    int ratings = -1;

                    JSONObject currentBook = arrayBooks.getJSONObject(i);
                    Book book = new Book();
                    SSS = currentBook.getString(KEY_SSS);
                    bookName = currentBook.getString(KEY_NAME);
                    String dateTime = currentBook.getString(KEY_DATE);
                    String[] date_time = dateTime.split(" ");
                    date = date_time[0];
                    time = date_time[1];
                    ratings = currentBook.getInt(KEY_RATINGS);
                    subject = currentBook.getString(KEY_SUBJECT);
                    edition = currentBook.getString(KEY_EDITION);
                    ISBN = currentBook.getString(KEY_ISBN);
                    symbol = currentBook.getString(KEY_SYMBOL);
                    subject = currentBook.getString(KEY_LANGUAGE);
                    description = currentBook.getString(KEY_DESCRIPTION);
                    length = currentBook.getString(KEY_LENGTH);
                    imageUrl = currentBook.getString("urlThumbnail");
                    ratings = currentBook.getInt("ratings");

//                    if (contains(currentBook, KEY_AUTHORS)) {
//                        JSONArray array = currentBook.getJSONArray("authors");
//                        for (int j = 0; j < array.length(); j++) {
//                            JSONObject object = array.getJSONObject(i);
//                            if (contains(currentBook, KEY_NAME)) {
//                                String authorName = object.getString("name");
//                                Author author = new Author(authorName);
//                                authors.add(author);
//                            }
//                        }
//                    }

                    book.setSSS(SSS);
                    book.setSymbol(symbol);
                    book.setBookName(bookName);
                    book.setEdition(edition);
                    book.setISBN(ISBN);
                    book.setDate(date);
                    book.setSubject(subject);
                    book.setLanguage(language);
                    book.setDescription(description);
                    book.setLength(length);
                    book.setImageUrl(imageUrl);
                    book.setPublisher(publisher);
                    book.setRatings(ratings);
                    //book.setAuthorsList(authors);
                    listBooks.add(book);
                    Log.d("adding", "1233467");
//                    L.t(getActivity(), book + "");
//                    if (!bookName.equals(Constants.NA)) {
//                        listBooks.add(book);
//                    }
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
//                L.t(getActivity(), listBooks.size() + " rows fetched");
        }
        Log.d("Test", "Parsing");
        return listBooks;
    }

    private boolean contains(JSONObject jsonObject, String key) {
        return (jsonObject != null && jsonObject.has(key) && !jsonObject.isNull(key) ? true : false);
    }

    private void handleVolleyError(VolleyError error) {
        textVolleyError.setVisibility(View.VISIBLE);
        if (error instanceof TimeoutError || error instanceof NoConnectionError) {
            textVolleyError.setText(R.string.error_timeout);

        } else if (error instanceof AuthFailureError) {
            textVolleyError.setText(R.string.error_auth_failure);
            //TODO
        } else if (error instanceof ServerError) {
            textVolleyError.setText(R.string.error_auth_failure);
            //TODO
        } else if (error instanceof NetworkError) {
            textVolleyError.setText(R.string.error_network);
            //TODO
        } else if (error instanceof ParseError) {
            textVolleyError.setText(R.string.error_parser);
            //TODO
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_ebook_all, container, false);
        textVolleyError = (TextView) view.findViewById(R.id.textVolleyError);
        booksAll = (RecyclerView) view.findViewById(R.id.booksAll);
        booksAll.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapterBookAll = new AdapterBookAll(getActivity(), listBooks);
        booksAll.setAdapter(adapterBookAll);
        return view;
    }
}
