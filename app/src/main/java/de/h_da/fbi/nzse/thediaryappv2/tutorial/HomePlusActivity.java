package de.h_da.fbi.nzse.thediaryappv2.tutorial;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

import de.h_da.fbi.nzse.thediaryapp.R;

class HomePlusActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_home_plus);
        Objects.requireNonNull(getSupportActionBar()).hide();

         //Button navigates to the next slide

        ImageButton imgBtnNext = findViewById(R.id.btnNext);
        imgBtnNext.setOnClickListener(view -> startActivity(new Intent(this, HomeAchievementActivity.class)));


         //Button navigates back to the last slide

        TextView txtBtnBack = findViewById(R.id.txtBtnBackwards);
        txtBtnBack.setOnClickListener(view -> startActivity(new Intent(this, Activity.class)));
    }

}