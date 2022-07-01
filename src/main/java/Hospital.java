import java.util.ArrayList;
import java.util.List;

public class Hospital {
    private List<Doctor> doctorsList;
    private String name;
    public Hospital(String name){
        this.doctorsList=new ArrayList<>();
        this.name=name;
    }

    public void addDoctor(Doctor doctor){
        doctorsList.add(doctor);
    }

    @Override
    public String toString() {
        return "Hospital [doctorsList=" + doctorsList + ", name=" + name + "]";
    }

    


}
