package com.scout.patient.Models;

import java.io.Serializable;
import java.util.ArrayList;

public class ModelIntent implements Serializable {
    ModelBookAppointment bookAppointmentData;
    ModelDoctorInfo doctorProfileInfo;
    ArrayList<ModelRequestId> listOfDoctors;
    Boolean isIntentFromHospital;

    public ModelIntent(ModelBookAppointment bookAppointmentData, ModelDoctorInfo doctorProfileInfo, ArrayList<ModelRequestId> listOfDoctors, Boolean isIntentFromHospital) {
        this.bookAppointmentData = bookAppointmentData;
        this.doctorProfileInfo = doctorProfileInfo;
        this.listOfDoctors = listOfDoctors;
        this.isIntentFromHospital = isIntentFromHospital;
    }

    public ModelBookAppointment getBookAppointmentData() {
        return bookAppointmentData;
    }

    public void setBookAppointmentData(ModelBookAppointment bookAppointmentData) {
        this.bookAppointmentData = bookAppointmentData;
    }

    public ModelDoctorInfo getDoctorProfileInfo() {
        return doctorProfileInfo;
    }

    public void setDoctorProfileInfo(ModelDoctorInfo doctorProfileInfo) {
        this.doctorProfileInfo = doctorProfileInfo;
    }

    public ArrayList<ModelRequestId> getListOfDoctors() {
        return listOfDoctors;
    }

    public void setListOfDoctors(ArrayList<ModelRequestId> listOfDoctors) {
        this.listOfDoctors = listOfDoctors;
    }

    public Boolean isIntentFromHospital() {
        return isIntentFromHospital;
    }

    public void setIntentFromHospital(Boolean intentFromHospital) {
        isIntentFromHospital = intentFromHospital;
    }
}
