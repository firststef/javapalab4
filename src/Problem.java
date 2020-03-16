import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem {
    private List<Resident> residentList;
    private List<Hospital> hospitalList;

    private List<Pair<Hospital, Resident>> matchings = new ArrayList<>();
    private Map<Resident, List<Hospital>> residentPreferences = new HashMap<>();
    private Map<Hospital, List<Resident>> hospitalPreferences = new HashMap<>();

    public Problem(List<Resident> residentList, List<Hospital> hospitalList, Map<Resident, List<Hospital>> residentPreferences, Map<Hospital, List<Resident>> hospitalPreferences) {
        this.residentList = residentList;
        this.hospitalList = hospitalList;
        this.residentPreferences = residentPreferences;
        this.hospitalPreferences = hospitalPreferences;
    }

    public List<Resident> getResidentList() {
        return residentList;
    }

    public void setResidentList(List<Resident> residentList) {
        this.residentList = residentList;
    }

    public List<Hospital> getHospitalList() {
        return hospitalList;
    }

    public void setHospitalList(List<Hospital> hospitalList) {
        this.hospitalList = hospitalList;
    }

    public Map<Resident, List<Hospital>> getResidentPreferences() {
        return residentPreferences;
    }

    public void setResidentPreferences(Map<Resident, List<Hospital>> residentPreferences) {
        this.residentPreferences = residentPreferences;
    }

    public Map<Hospital, List<Resident>> getHospitalPreferences() {
        return hospitalPreferences;
    }

    public void setHospitalPreferences(Map<Hospital, List<Resident>> hospitalPreferences) {
        this.hospitalPreferences = hospitalPreferences;
    }
}
