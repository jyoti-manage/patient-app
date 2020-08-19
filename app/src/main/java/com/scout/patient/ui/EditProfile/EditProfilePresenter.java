package com.scout.patient.ui.EditProfile;

import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.scout.patient.Models.ModelPatientInfo;
import com.scout.patient.Repository.Prefs.SharedPref;

public class EditProfilePresenter implements Contract.Presenter {
    Contract.View view;
    Contract.Model model;
    private StorageTask mUploadTask;
    StorageReference mStorageRef;

    public EditProfilePresenter(Contract.View view) {
        this.view = view;
        model = new Model(EditProfilePresenter.this);
    }

    @Override
    public int getBloodGrpPosition(String bloodGroup) {
        switch (bloodGroup){
            case "A+" :
                return 1;
            case "A-" :
                return 2;
            case "B+" :
                return 3;
            case "B-" :
                return 4;
            case "O+" :
                return 5;
            case "O-" :
                return 6;
            case "AB+" :
                return 7;
            case "AB-" :
                return 8;
        }
        return 0;
    }

    @Override
    public void updateProfileData(ModelPatientInfo patientInfo) {
        model.updateProfileData(patientInfo);
    }

    @Override
    public void showToast(String s) {
        view.showToast(s);
    }

    @Override
    public void saveProfilePic(EditProfileActivity editProfileActivity, Uri mImageUri, String fileName) {
        if (mUploadTask != null && mUploadTask.isInProgress())
            view.showToast("Profile Update is in Progress");
        else {
            mStorageRef = FirebaseStorage.getInstance().getReference(FirebaseAuth.getInstance().getUid()+"/Hospital ProfilePic");
            StorageReference fileReference = mStorageRef.child(fileName);

            mUploadTask = fileReference.putFile(mImageUri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                            fileReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                    String url = uri.toString();
                                    model.updateProfilePic(editProfileActivity,url);
                                }
                            });
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            view.showToast(e.getMessage());
                        }
                    });
        }
    }
}
