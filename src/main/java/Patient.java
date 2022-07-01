public class Patient {
    private String name;
    private int age;
    private String specialtyNeeded;

    public Patient(String name, int age, String specialtyNeeded) {
        this.name = name;
        this.age = age;
        this.specialtyNeeded = specialtyNeeded;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSpecialtyNeeded() {
        return specialtyNeeded;
    }

    public void setSpecialtyNeeded(String specialtyNeeded) {
        this.specialtyNeeded = specialtyNeeded;
    }

    @Override
    public String toString() {
        return "Patient [age=" + age + ", name=" + name + ", specialtyNeeded=" + specialtyNeeded + "]";
    }

    

}
