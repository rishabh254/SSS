package com.sss.Activity;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.sss.Activity.MainActivity;
import com.sss.R;
import com.sss.Util.PrefUtils;

import org.json.JSONException;
import org.json.JSONObject;

import network.VolleySingleton;

public class WelcomeActivity extends Activity {
    private VolleySingleton volleySingleton;
    private RequestQueue requestQueue;
    DecelerateInterpolator sDecelerator = new DecelerateInterpolator();
    OvershootInterpolator sOvershooter = new OvershootInterpolator();
    AccelerateInterpolator sAccelerator = new AccelerateInterpolator();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        final Button login = (Button) findViewById(R.id.button_login);
        login.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() ==  MotionEvent.ACTION_DOWN){
                    login.animate().setInterpolator(sDecelerator).
                            scaleX(.8f).scaleY(.8f);
                }else if(event.getAction() ==  MotionEvent.ACTION_UP){
                    login.animate().setInterpolator(sAccelerator).
                            scaleX(1f).scaleY(1f);
                }

                return false;
            }
        });

        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String username = ((MaterialEditText) findViewById(R.id.userName)).getText().toString();
                String password =  ((MaterialEditText) findViewById(R.id.password)).getText().toString();
                //if username and password valid then goto main page
                if (passwordValid(password))
                    validateUsername(username,password);
                else
                    ((TextView)findViewById(R.id.password_error)).setVisibility(View.VISIBLE);
            }
        });
        Button skip_button = (Button) findViewById(R.id.button_skip);
        skip_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle translatedBundle = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.slide_in_left, R.anim.slide_out_left).toBundle();
                startActivity(new Intent(getApplicationContext(), MainActivity.class), translatedBundle);
            }
        });

    }

    private boolean passwordValid(String password){
        return password.length() <=10;
    }

    private void validateUsername(final String username, final String password) {

        volleySingleton = VolleySingleton.getInstance();
        requestQueue = volleySingleton.getRequestQueue();
//        String url = "http://ssspro.byethost5.com/user.php";
//        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                if (response.equals("success")) {
//                    PrefUtils.markWelcomeDone(getApplicationContext());
//                    PrefUtils.markLogInDone(getApplicationContext());
//                    PrefUtils.saveUsername(getApplicationContext(),username);
//                    Bundle translatedBundle = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.slide_in_left, R.anim.slide_out_left).toBundle();
//                    startActivity(new Intent(getApplicationContext(), MainActivity.class), translatedBundle);
//                } else {
//                    Toast.makeText(getApplicationContext(), "Wrong Username and Password", Toast.LENGTH_LONG);
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//               handleVolleyError(error);
//            }
//        }) {
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                Map<String, String> params = new HashMap<String, String>();
//                params.put("username", username);
//                params.put("password", password);
//                return params;
//            }
//        };
//        requestQueue.add(stringRequest);
//
        String url = "http://ssspro.byethost5.com/user.php"+"?"+"username="+username+"&"+"password="+password;
        JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.POST, url, (String) null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                String response1 = null;
                try {
                    response1 = response.getString("login");
                    Toast.makeText(getApplicationContext(),response1,Toast.LENGTH_LONG).show();
                    if (response1.equals("success")) {
                        PrefUtils.markWelcomeDone(getApplicationContext());
                        PrefUtils.markLogInDone(getApplicationContext());
                        PrefUtils.saveUsername(getApplicationContext(), username);
                        Bundle translatedBundle = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.slide_in_left, R.anim.slide_out_left).toBundle();
                        startActivity(new Intent(getApplicationContext(), MainActivity.class), translatedBundle);
                    } else {
                        Toast.makeText(getApplicationContext(), "Wrong Username and Password", Toast.LENGTH_LONG);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                handleVolleyError(error);
            }
        });
        requestQueue.add(jsonRequest);
    }

    private void handleVolleyError(VolleyError error) {

        if (error instanceof TimeoutError || error instanceof NoConnectionError) {
            Toast.makeText(this,R.string.error_timeout,Toast.LENGTH_LONG).show();

        } else if (error instanceof AuthFailureError) {
            Toast.makeText(this,R.string.error_auth_failure,Toast.LENGTH_LONG).show();
            //TODO
        } else if (error instanceof ServerError) {
            Toast.makeText(this,R.string.error_auth_failure,Toast.LENGTH_LONG).show();
            //TODO
        } else if (error instanceof NetworkError) {
            Toast.makeText(this,R.string.error_network,Toast.LENGTH_LONG).show();
            //TODO
        } else if (error instanceof ParseError) {
            Toast.makeText(this,R.string.error_parser,Toast.LENGTH_LONG).show();
            //TODO
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_welcome, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//***Change Here***
        startActivity(intent);
        finish();
        System.exit(0);
    }
}
