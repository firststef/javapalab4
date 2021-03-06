import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Hospital implements Comparable<Hospital>, Serializable {
    private String name;
    private int capacity;

    List<Resident> residents = new ArrayList<>();

    public Hospital(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        Hospital hospital = (Hospital) o;
        return Objects.equals(name, hospital.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Hospital h2){
        return Integer.compare(hashCode(), h2.hashCode());
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Resident> getResidents() {
        return residents;
    }

    public void setResidents(List<Resident> residents) {
        this.residents = residents;
    }

    public void addResident(Resident r){
        residents.add(r);
    }

    public void removeResident(Resident r){
        residents.remove(r);
    }

    public boolean isFree(){
        return capacity - residents.size() != 0;
    }
}
