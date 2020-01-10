package com.example.accompany;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    private GoogleSignInClient mGoogleSignInClient;
    private static int RC_SIGN_IN = 100;
    private User _user;
    private CallbackManager fbCallbackManager;
    private LoginButton fbLoginButton;
    private String _gId;
    private String _fbId;
    private boolean _isLoggedInGoogle = false;
    private boolean _isLoggedInFb = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.fullyInitialize();
        setContentView(R.layout.activity_login);

        SignInButton signInButton = findViewById(R.id.sign_in_button);
        signInButton.setSize(SignInButton.SIZE_STANDARD);
        fbLoginButton = findViewById(R.id.fb_login_button);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().requestProfile().build();
        fbCallbackManager = CallbackManager.Factory.create();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        // register the onclick listener
        findViewById(R.id.sign_in_button).setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v){

               switch (v.getId()){
                   case R.id.sign_in_button:
                       signIn();
                       break;
               }
           }
        });

        LoginManager.getInstance().registerCallback(fbCallbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        // need to get the accompany user by the fb ID
                        Log.d("INFO", loginResult.toString());
                        String user_id = loginResult.getAccessToken().getUserId();
                        // user id setup, now
                    }

                    @Override
                    public void onCancel() {

                    }

                    @Override
                    public void onError(FacebookException error) {

                    }
                });

    }

    @Override
    protected void onStart()
    {
        super.onStart();

        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);

        _gId = account.getId();
        //_isLoggedInGoogle = true;
        //_isLoggedInFb = isLoggedIntoFacebook();

        GetAccompanyUser(_gId);
    }

    private void GetAccompanyUser(String id){

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://accompanyusersapi.azurewebsites.net/api/users?id=" + id;

        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response) {
                        // display response
                        Log.d("Response", response.toString());
                        try {
                            _user = parseUser(response);
                            startActivity(new Intent(LoginActivity.this, ConcessionListView.class).putExtra("User", _user));
                        }catch(JSONException ex){
                            Log.d("EXCEPTION", ex.getMessage());
                        }
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Error.Response", error.getMessage());
                    }
                }
        );

        queue.add(getRequest);
    }

    private User parseUser(JSONObject json) throws JSONException {

        User user = new User();

            try{

                user.setId(json.getString("Id"));
                user.setFirstName(json.getString("FirstName"));
                user.setLastName(json.getString("LastName"));
                user.setEmail(json.getString("Email"));
                user.setPhoneNumber(json.getString("PhoneNumber"));
                user.setAddress(json.getString("StreetAddress"));
                user.setApartmentNumber(json.getString("ApartmentNumber"));
                user.setCity(json.getString("City"));
                user.setState(json.getString("State"));
                user.setZip(json.getString("Zip"));
                user.setIsEnrolled(json.getBoolean("IsEnrolled"));

            }
            catch (JSONException ex){
                throw new JSONException("Error parsing the User object");
            }

            return user;
    }

    private void signIn(){
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
        //GetAccompanyUser(_gId);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        fbCallbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    private boolean isLoggedIntoFacebook(){

        return AccessToken.getCurrentAccessToken() != null && !AccessToken.getCurrentAccessToken().isExpired();
    }
}
