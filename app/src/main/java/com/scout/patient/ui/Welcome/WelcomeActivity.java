package com.scout.patient.ui.Welcome;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.scout.patient.R;
import com.scout.patient.ui.Appointments.AppointmentActivity;
import com.scout.patient.ui.AppointmentBooking.BookAppointmentActivity;
import com.scout.patient.ui.DoctorsActivity.DoctorsActivity;
import com.scout.patient.ui.Hospital.HospitalActivity;
import com.scout.patient.ui.MainActivity;
import com.scout.patient.ui.Notification.NotificationActivity;
import com.scout.patient.ui.Profile.ProfileActivity;
import com.scout.patient.ui.Search.SearchActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class WelcomeActivity extends AppCompatActivity implements Contract.View, View.OnClickListener{
    @BindView(R.id.card_hospital)
    CardView card_hospital;
    @BindView(R.id.card_doctor)
    CardView card_doctor;
    @BindView(R.id.card_book_appointment)
    CardView card_appointment;
    @BindView(R.id.card_appointment)
    CardView card_ambulance;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    Unbinder unbinder;
    WelcomeActivityPresenter presenter;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        unbinder = ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        presenter = new WelcomeActivityPresenter(WelcomeActivity.this);
        card_hospital.setOnClickListener(this);
        card_doctor.setOnClickListener(this);
        card_appointment.setOnClickListener(this);
        card_ambulance.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.card_hospital:
                startActivity(new Intent(this, HospitalActivity.class));
                break;
            case R.id.card_doctor:
                startActivity(new Intent(this, DoctorsActivity.class));
                break;
            case R.id.card_book_appointment:
                startActivity(new Intent(this, BookAppointmentActivity.class));
                break;
            case R.id.card_appointment:
                startActivity(new Intent(this, AppointmentActivity.class));
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.welcome_activity_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_help_chat:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.menu_profile:
                startActivity(new Intent(this, ProfileActivity.class));
                break;
            case R.id.search_bar:
                startActivity(new Intent(this, SearchActivity.class).putExtra("key",getString(R.string.both)));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
