import javafx.util.Pair;
import java.util.*;

public class GaleShapleyAlgorithm implements Algorithm {
    public List<Pair<Hospital, Resident>> solve(Problem p) {
        List<Resident> residents = p.getResidentList();
        List<Hospital> hospitals = p.getHospitalList();
        Map<Resident, List<Hospital>> residentPreferences = p.getResidentPreferences();
        Map<Hospital, List<Resident>> hospitalPreferences = p.getHospitalPreferences();

        List<Pair<Hospital, Resident>> matchings = new ArrayList<>();

        while(residents.stream().anyMatch(r -> r.getHospital() == null)) {
            searchForRejected:
            for (Resident r : residents) {
                if (r.getHospital() == null) {
                    boolean foundMatch = false;

                    for (Hospital h : residentPreferences.get(r)) {
                        List<Resident> currentResidents = h.getResidents();
                        List<Resident> preferences = hospitalPreferences.get(h);

                        if (!preferences.contains(r))
                            continue;

                        if (h.isFree()) {
                            h.addResident(r);
                            r.setHospital(h);
                            foundMatch = true;
                            break;
                        } else {
                            currentResidents.sort(Comparator.comparingInt(preferences::indexOf));
                            Resident other = currentResidents.get(currentResidents.size() - 1);
                            if (preferences.indexOf(other) > preferences.indexOf(r)) {
                                h.removeResident(other);
                                residents.get(residents.indexOf(other)).setHospital(null);
                                h.addResident(r);
                                r.setHospital(h);
                                continue searchForRejected;
                            }

                        }
                    }

                    if (!foundMatch) {
                        throw new InvalidProblemException("Resident can not find a place");
                    }
                }
            }
        }

        for (Resident r : residents) {
            matchings.add(new Pair<>(r.getHospital(), r));
        }

        return matchings;
    }

    public List<Pair<Hospital, Resident>> solveBonus(BonusProblem p) {
        List<Resident> residents = p.getResidentList();
        List<Hospital> hospitals = p.getHospitalList();
        Map<Resident, List<Hospital>> residentPreferences = p.getResidentPreferences();
        Map<Hospital, List<List<Resident>>> hospitalPreferences = p.getHospitalPreferences();

        List<Pair<Hospital, Resident>> matchings = new ArrayList<>();

        while(residents.stream().anyMatch(r -> r.getHospital() == null)) {
            searchForRejected:
            for (Resident r : residents) {
                if (r.getHospital() == null) {
                    boolean foundMatch = false;

                    for (Hospital h : residentPreferences.get(r)) {
                        List<Resident> currentResidents = h.getResidents();
                        List<List<Resident>> prefs = hospitalPreferences.get(h);
                        List<Resident> linearPrefs = new ArrayList<>();
                        prefs.forEach(linearPrefs::addAll);

                        if (!linearPrefs.contains(r))
                            continue;

                        if (h.isFree()) {
                            h.addResident(r);
                            r.setHospital(h);
                            foundMatch = true;
                            break;
                        } else {
                            currentResidents.sort(Comparator.comparingInt(linearPrefs::indexOf));
                            Resident other = currentResidents.get(currentResidents.size() - 1);
                            if (linearPrefs.indexOf(other) > linearPrefs.indexOf(r)) {
                                h.removeResident(other);
                                residents.get(residents.indexOf(other)).setHospital(null);
                                h.addResident(r);
                                r.setHospital(h);
                                continue searchForRejected;
                            }

                        }
                    }

                    if (!foundMatch) {
                        throw new InvalidProblemException("Resident can not find a place");
                    }
                }
            }
        }

        for (Resident r : residents) {
            matchings.add(new Pair<>(r.getHospital(), r));
        }

        return matchings;
    }
}
