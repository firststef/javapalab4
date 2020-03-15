import java.io.ObjectInputStream;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args){
        Resident[] r = IntStream.rangeClosed(0, 3).mapToObj(i -> new Resident("R" + i) ).toArray(Resident[]::new);
        Hospital[] h = IntStream.rangeClosed(0, 2).mapToObj(i -> new Hospital("H" + i, 2) ).toArray(Hospital[]::new);
        h[0].setCapacity(1);

        List<Resident> residentList = new ArrayList<Resident>(Arrays.asList(r));
        residentList.sort(new Comparator<Resident>() {
            @Override
            public int compare(Resident o1, Resident o2) {
                return o1.getName().compareTo(o2.toString());
            }
        });

        Set<Hospital> hospitalSet = new TreeSet<Hospital>();
        hospitalSet.add(h[2]);
        hospitalSet.add(h[1]);
        hospitalSet.add(h[0]);

        Map<Resident, List<Hospital>> residentPreferences = new HashMap<>();
        residentPreferences.put(r[0], Arrays.asList(h[0], h[1], h[2]));
        residentPreferences.put(r[1], Arrays.asList(h[0], h[1], h[2]));
        residentPreferences.put(r[2], Arrays.asList(h[0], h[1]));
        residentPreferences.put(r[3], Arrays.asList(h[0], h[2]));

        Map<Hospital, List<Resident>> hospitalPreferences = new HashMap<>();
        hospitalPreferences.put(h[0], Arrays.asList(r[3], r[0], r[1], r[2]));
        hospitalPreferences.put(h[1], Arrays.asList(r[0], r[2], r[1]));
        hospitalPreferences.put(h[2], Arrays.asList(r[0], r[1], r[3]));

        System.out.println(residentPreferences);
        System.out.println(hospitalPreferences);

        residentList.stream().filter(res -> residentPreferences.get(res).containsAll(Arrays.asList(h[0], h[2]))).forEach(System.out::println);
        hospitalSet.stream().filter(hos -> hospitalPreferences.get(hos).get(0).equals(r[0])).forEach(System.out::println);
    }
}
