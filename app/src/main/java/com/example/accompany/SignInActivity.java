package com.example.accompany;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import org.json.JSONException;
import org.json.JSONObject;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "SignInActivity";
    private static final int RC_SIGN_IN = 9001;
    private GoogleSignInClient mGoogleSignInClient;
    private TextView mStatusTextView;
    private User _user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        // Views
        mStatusTextView = findViewById(R.id.status);

        // button listeners
        findViewById(R.id.sign_in_button).setOnClickListener(this);
        findViewById(R.id.sign_out_button).setOnClickListener(this);
        findViewById(R.id.disconnect_button).setOnClickListener(this);

        // [start configure_signin]
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        // [end]

        // [start build_client]
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        // [end]

        // [start customize_button]
        SignInButton signInButton = findViewById(R.id.sign_in_button);
        signInButton.setSize(SignInButton.SIZE_STANDARD);
        signInButton.setColorScheme(SignInButton.COLOR_LIGHT);
        // [end]
    }

    @Override
    public void onStart(){
        super.onStart();

        // [start on start sign in]
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        updateUI(account);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        // result returned from launching the intent form google sign in client
        if(requestCode == RC_SIGN_IN){
            // the task returned from this call is always completed, no need to attach a listener
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask){
        try{
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            updateUI(account);
        }catch(ApiException e){
            Log.w(TAG, "signInResult:failed code=" + e.getStatusCode());
            updateUI(null);
        }
    }

    private void signIn(){
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    private void signOut(){
        mGoogleSignInClient.signOut().addOnCompleteListener(this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                updateUI(null);
            }
        });
    }

    private void revokeAccess(){
        mGoogleSignInClient.revokeAccess().addOnCompleteListener(this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                updateUI(null);
            }
        });
    }

    private void updateUI(@Nullable GoogleSignInAccount account){
        if(account != null){
            mStatusTextView.setText(getString(R.string.signed_in_fmt, account.getDisplayName()));
            findViewById(R.id.sign_in_button).setVisibility(View.GONE);
            findViewById(R.id.sign_out_and_disconnect).setVisibility(View.VISIBLE);

            getAccompanyUser(account.getId());

        }else{
            mStatusTextView.setText(R.string.sign_out);

            findViewById(R.id.sign_in_button).setVisibility(View.VISIBLE);
            findViewById(R.id.sign_out_and_disconnect).setVisibility(View.GONE);
        }
    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.sign_in_button:
                signIn();
                break;

            case R.id.sign_out_button:
                signOut();
                break;

            case R.id.disconnect_button:
                revokeAccess();
                break;
        }
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

    private void getAccompanyUser(String id){

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
                            startActivity(new Intent(SignInActivity.this, ConcessionListView.class).putExtra("User", _user));
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
}
