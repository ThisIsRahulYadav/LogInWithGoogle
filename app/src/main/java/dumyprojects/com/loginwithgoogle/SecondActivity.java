package dumyprojects.com.loginwithgoogle;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecondActivity extends AppCompatActivity {
Button button;
FirebaseAuth mAuth;
FirebaseAuth.AuthStateListener mAuthListener;

        @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    button =(Button) findViewById(R.id.logOut);
    mAuth = FirebaseAuth.getInstance();

mAuthListener= new FirebaseAuth.AuthStateListener() {
    @Override
    public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
        if(firebaseAuth.getCurrentUser() ==null){
            startActivity(new Intent(SecondActivity.this,MainActivity.class));
        }
    }
};
    button.setOnClickListener(new View.OnClickListener() {
          @Override
        public void onClick(View v) {
            mAuth.signOut();


                 /* try {
                      PackageInfo info = getPackageManager().getPackageInfo(
                              "dumyprojects.com.loginwithgoogle",
                              PackageManager.GET_SIGNATURES);
                      for (Signature signature : info.signatures) {
                          MessageDigest md = MessageDigest.getInstance("SHA");
                          md.update(signature.toByteArray());
                          Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
                      }
                  } catch (PackageManager.NameNotFoundException e) {

                  } catch (NoSuchAlgorithmException e) {

                  }*/
        }
    });
    }
}
