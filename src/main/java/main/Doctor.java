package main;

import java.util.ArrayList;
import java.util.List;

public class Doctor {
    private String name;
    private String specialty;
    private List<Patient> patientsList;

    public Doctor(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
        this.patientsList = new ArrayList<>();
    }

    public void addPatient(Patient patient) {
        patientsList.add(patient);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public List<Patient> getPatientsList() {
        return patientsList;
    }

    public void setPatientsList(List<Patient> patientsList) {
        this.patientsList = patientsList;
    }

    @Override
    public String toString() {
        return "Doctor [name=" + name + ", patientsList=" + patientsList + ", specialty=" + specialty + "]";
    }

}
