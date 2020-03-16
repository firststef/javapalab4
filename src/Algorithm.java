import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public interface Algorithm {
    public List<Pair<Hospital, Resident>> solve(Problem p);
    public List<Pair<Hospital, Resident>> solveBonus(BonusProblem p);
}
