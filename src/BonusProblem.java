import javafx.util.Pair;
import org.apache.commons.lang3.SerializationUtils;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Bonus problem, see Problem for more
 *
 * Consider the case in which preferences are not necessarily strict. Some consecutive preferences in an element's list may form a tie.
 * For example R1: H1, [H2,H3] means that R1 prefers H1 over H2 and H3, but H2 and H3 have no precedence one over the other.
 */
public class BonusProblem {
    private List<Resident> residentList;
    private List<Hospital> hospitalList;

    private List<Pair<Hospital, Resident>> matchings = new ArrayList<>();
    private Map<Resident, List<Hospital>> residentPreferences = new HashMap<>();
    private Map<Hospital, List<List<Resident>>> hospitalPreferences = new HashMap<>();

    public BonusProblem(List<Resident> residentList, List<Hospital> hospitalList, Map<Resident, List<Hospital>> residentPreferences, Map<Hospital, List<List<Resident>>> hospitalPreferences) {
        this.residentList = residentList;
        this.hospitalList = hospitalList;
        this.residentPreferences = residentPreferences;
        this.hospitalPreferences = hospitalPreferences;
    }

    public BonusProblem(BonusProblem pb){
        this.residentList = pb.residentList.stream().map(SerializationUtils::clone).collect(Collectors.toList());
        this.hospitalList = pb.hospitalList.stream().map(SerializationUtils::clone).collect(Collectors.toList());
        this.residentPreferences = new HashMap<>();
        pb.residentPreferences.forEach((k,v) -> this.residentPreferences.put(k, v));
        this.hospitalPreferences = new HashMap<>();
        pb.hospitalPreferences.forEach((k,v) -> this.hospitalPreferences.put(k, v));
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

    public Map<Hospital, List<List<Resident>>> getHospitalPreferences() {
        return hospitalPreferences;
    }

    public void setHospitalPreferences(Map<Hospital, List<List<Resident>>> hospitalPreferences) {
        this.hospitalPreferences = hospitalPreferences;
    }
}
