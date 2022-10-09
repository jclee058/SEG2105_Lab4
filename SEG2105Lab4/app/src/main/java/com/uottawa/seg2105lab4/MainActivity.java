package com.uottawa.seg2105lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.net.Uri;
import android.content.Intent;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnOpenInGoogleMaps(View view){
        EditText teamAddres = findViewById(R.id.teamAddressField);

        //Create a uri from an intent string. Use the result to create an intent
        Uri gmmIntentUri = Uri.parse("http://maps.google.co.in/maps?q="+teamAddres.getText());

        //Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);

        //Make the Intent explicit by setting the Google Maps package
        mapIntent.setPackage("com.google.android.apps.maps");

        //Attempt to start an activity that can handle the Intent
        startActivity(mapIntent);
    }

    public void OnSetAvatarButton(View view){
        //Application context and activity
        Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
        startActivityForResult(intent, 0);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED) return;

        //Getting the avatar image we show to our users
        ImageView avatarImage = (ImageView) findViewById(R.id.avatarImage);

        //Figuring out the correct image
        String drawableName = "@android:drawable/btn_star_big_on";
        switch (data.getIntExtra("imageID", R.id.teamid00)) {
            case R.id.teamid00:
                drawableName = "@drawable/suuny";
                break;
            case R.id.teamid01:
                drawableName = "@drawable/chevrolet_zl1";
                break;
            case R.id.teamid02:
                drawableName = "@android:drawable/btn_star_big_off";
                break;
            case R.id.teamid03:
                drawableName = "@drawable/rainy_day";
                break;
            case R.id.teamid04:
                drawableName = "@android:drawable/ic_input_add";
                break;
            case R.id.teamid05:
                drawableName = "@android:drawable/btn_star_big_on";
                break;
            default:
                drawableName = "@android:drawable/btn_star_big_on";
                break;

        }
        int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
        avatarImage.setImageResource(resID);
    }
}