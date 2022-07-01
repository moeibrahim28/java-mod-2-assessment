package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Hospital {
    private Map<String, List<Doctor>> specialtyToDoctors;
    private String name;

    public Hospital(String name) {
        this.specialtyToDoctors = new HashMap<>();
        this.name = name;
    }

    public void addDoctor(Doctor doctor) { // add doctor to hospital and map that stores specialties and the doctors
                                           // with that specialty
        // if specialty of this doctor exists then add the doctor to that list
        if (specialtyToDoctors.containsKey(doctor.getSpecialty())) {
            List<Doctor> withSpecialty = specialtyToDoctors.get(doctor.getSpecialty());
            withSpecialty.add(doctor);
        } else { // specialty doesnt exist diddo
            List<Doctor> doctorsListForSpecialtyMap = new ArrayList<>();
            doctorsListForSpecialtyMap.add(doctor);
            // adding new specialty to map
            specialtyToDoctors.put(doctor.getSpecialty(), doctorsListForSpecialtyMap);
        }

    }

    @Override
    public String toString() {
        return "Hospital [name=" + name + ", specialtyToDoctors=" + specialtyToDoctors + "]";
    }

    public void assignPatientToDoctor(Patient patient, String specialty) { // assign patient to first doctor in listr of
                                                                           // doctors
        boolean doctorWithSpecialtyFound = this.specialtyToDoctors.containsKey(specialty);
        if (doctorWithSpecialtyFound) {
            System.out.println("The following doctors have that specialty:");
            List<Doctor> doctorList = specialtyToDoctors.get(specialty);
            System.out.println(doctorList);

            // randomly assign to any doctor with that specialty
            int doctorListSize = doctorList.size();
            Random random = new Random(doctorListSize + 1);
            int randomIndex = random.nextInt(doctorListSize + 1);
            Doctor doctor = doctorList.get(randomIndex); //
            doctor.addPatient(patient);

        }

        else {
            System.out.println("No doctors at this hospital have that specialty");
        }

    }

}
