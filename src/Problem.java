import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The Hospitals/Residents Problem (HR)
 * An instance of HR involves a set of residents and a set f hospitals, each resident seeking a post at one hospital,
 * and each hospital having a number of available posts (its capacity). Each resident ranks some (acceptable) hospitals in strict order,
 * and each hospital ranks its applicants in strict order. A matching is a set of pairs (resident, hospital) such that
 * each resident is assigned to at most one hospital and the capacities of the hospitals are not exceeded.
 * A matching is stable if there is no pair (r, h) such that r is assigned to h' but r prefers h better than h' and h
 * prefers r better than some of its assigned residents. We consider the problem of creating a stable matching between residents and hospitals.
 */
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
