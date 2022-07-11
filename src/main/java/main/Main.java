package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Welcome to our Hospital! Enter the Hospital name:");
            String hospitalName = scanner.nextLine();
            while (hospitalName.isBlank()) {
                System.out.println("Please enter a non-empty name for the hospital:");
                hospitalName = scanner.nextLine();
            }
            Hospital hospital = new Hospital(hospitalName);
            createDoctorsList(scanner, hospital);
            createPatientsList(scanner, hospital);

            System.out.println(hospital);
        }

    }

    // loop for user defined number of
    // patients and stores them in the
    // doctors patient lists
    private static void createPatientsList(Scanner scanner, Hospital hospital) {

        int numPatients;
        System.out.println("How many patients are at your hospital?");
        String sampleString = scanner.nextLine();
        numPatients = getInput(sampleString);
        if (numPatients <= 0) {
            System.out.println("Invalid input. Your hospital needs at least 1 patient. Try again.");
            createPatientsList(scanner, hospital);
        } else {
            for (int i = 0; i < numPatients; i++) {
                String patientName = "";
                String specialtyNeeded = "";

                patientName = getPatientName(scanner);

                specialtyNeeded = getSpecialty(scanner);
                Patient patient = new Patient(patientName, specialtyNeeded);
                hospital.assignPatientToDoctor(patient, specialtyNeeded);
            }
        }
    }

    // loop for user defined number of
    // doctors and stores them in the
    // hospital
    private static void createDoctorsList(Scanner scanner, Hospital hospital) {

        int numDoctors;
        System.out.println("How many doctors work at your hospital?");
        String sampleString = scanner.nextLine();
        numDoctors = getInput(sampleString);
        if (numDoctors <= 0) {
            System.out.println("Invalid input. Your hospital needs at least 1 doctor. Try again.");
            createDoctorsList(scanner, hospital);
        } else {
            for (int i = 0; i < numDoctors; i++) {
                String doctorName = "";
                String specialty = "";

                doctorName = getDoctorName(scanner);
                specialty = getSpecialty(scanner);
                Doctor doctor = new Doctor(doctorName, specialty);
                hospital.addDoctor(doctor);
            }
        }

    }

    private static String getDoctorName(Scanner scanner) {
        String doctorName = "";
        System.out.println("Enter the doctors name:");
        doctorName = scanner.nextLine();
        while (doctorName.isBlank()) {
            System.out.println("Please enter a non-empty name for the doctor:");
            doctorName = scanner.nextLine();
        }

        return doctorName;
    }

    private static String getPatientName(Scanner scanner) {
        String patientName = "";
        System.out.println("Enter the patient name:");
        patientName = scanner.nextLine();
        while (patientName.isBlank()) {
            System.out.println("Please enter a non-empty name for the patient:");
            patientName = scanner.nextLine();
        }
        return patientName;
    }

    // get doctor specialty or specialty needed by patient
    private static String getSpecialty(Scanner scanner) {

        String specialty = "";
        System.out.println("Pick a specialty:");
        String[] specialties = new String[] { "1. Family Medicine", "2. Internal Medicine", "3. Dermatology",
                "4. Emergency Medicine" };
        for (String string : specialties) {
            System.out.println(string);
        }
        String sampleString = scanner.nextLine();
        int input = getInput(sampleString);
        switch (input) {
            case 1:
                specialty = "Family Medicine";
                break;
            case 2:
                specialty = "Internal Medicine";
                break;
            case 3:
                specialty = "Dermatology";
                break;
            case 4:
                specialty = "Emergency Medicine";
                break;

            default:
                System.out.println("Invalid input. Pick a specialty out of the following please.");
                specialty = getSpecialty(scanner);

        }

        return specialty;
    }

    // get input as integer return -1 if invalid
    private static int getInput(String sampleString) {
        try {
            return Integer.parseInt(sampleString);
        } catch (Exception e) {

            return -1;
        }
    }
}