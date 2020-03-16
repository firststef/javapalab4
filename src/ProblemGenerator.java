import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import com.github.javafaker.Faker;

public class ProblemGenerator {
    public Problem generate(){
        Faker faker = new Faker();

        List<Resident> residentList = IntStream.rangeClosed(0, getInt(10)).mapToObj(i -> new Resident(faker.name().fullName()) ).collect(Collectors.toList());
        List<Hospital> hospitalList = IntStream.rangeClosed(0, 3).mapToObj(i -> new Hospital(faker.medical().hospitalName(), getInt(4)) ).collect(Collectors.toList());

        Map<Resident, List<Hospital>> residentPreferences = new HashMap<>();
        Map<Hospital, List<Resident>> hospitalPreferences = new HashMap<>();

        for (Resident r : residentList){
            for (Hospital h : hospitalList){
                if (!residentPreferences.containsKey(r) || getInt( 9) % 2 == 0) {
                    ArrayList<Hospital> lstH = new ArrayList<>(Arrays.asList(h));
                    ArrayList<Resident> lstR = new ArrayList<>(Arrays.asList(r));

                    if (residentPreferences.containsKey(r)){
                        ArrayList<Hospital> rl = (ArrayList<Hospital>) residentPreferences.get(r);
                        rl.add(h);
                        residentPreferences.put(r, rl);
                    }
                    else {
                        residentPreferences.put(r, lstH);
                    }

                    if (hospitalPreferences.containsKey(h))
                    {
                        ArrayList<Resident> rl = (ArrayList<Resident>) hospitalPreferences.get(h);
                        rl.add(r);
                        hospitalPreferences.put(h, rl);
                    }
                    else{
                        hospitalPreferences.put(h, lstR);
                    }
                }
            }
        }

        for (Resident r : residentList){
            Collections.shuffle(residentPreferences.get(r));
        }

        for (Hospital h : hospitalList){
            Collections.shuffle(hospitalPreferences.get(h));
        }

        return new Problem(residentList, hospitalList, residentPreferences, hospitalPreferences);
    }

    public BonusProblem generateBonus(){
        Problem p = generate();

        Map<Hospital, List<List<Resident>>> hospitalPreferences2 = new HashMap<>();
        for (Hospital h : p.getHospitalList()) {
            List<List<Resident>> nestedList = new ArrayList<>();
            for (Resident r : p.getHospitalPreferences().get(h)) {
                if (nestedList.isEmpty() || getInt(2) == 2){
                    nestedList.add(new ArrayList<Resident>(Arrays.asList(r)));
                }
                else{
                    nestedList.get(nestedList.size() - 1).add(r);
                }
            }
            hospitalPreferences2.put(h, nestedList);
        }

        return new BonusProblem(p.getResidentList(), p.getHospitalList(), p.getResidentPreferences(), hospitalPreferences2);
    }

    public int getInt(int maxInt){
        return (int) (Math.random() * 100001 % maxInt + 1);
    }
}
