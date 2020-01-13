package com.example.qualityquestion.Fragment;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.qualityquestion.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class Tab2 extends Fragment {

    TextView currentuserName,currentuserMail;
    ImageView currentuser_img;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    FirebaseDatabase firebaseDatabase;


    private OnFragmentInteractionListener mListener;

    public Tab2() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_tab2, container, false);
        currentuserName = view.findViewById(R.id.currentuser_name);
        currentuserMail = view.findViewById(R.id.currentuser_mail);
        currentuser_img = view.findViewById(R.id.currentuser_img);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        firebaseDatabase = FirebaseDatabase.getInstance();

        Glide.with(getContext()).load(firebaseUser.getPhotoUrl()).into(currentuser_img);
        currentuserName.setText(firebaseUser.getDisplayName());
        currentuserMail.setText(firebaseUser.getEmail());
        return view;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
