package pairmatching.domain;

import java.util.Collections;
import java.util.List;

public class Pair {

    private final List<Crew> crews;

    public Pair(List<Crew> crews) {
        this.crews = crews;
        Collections.sort(crews);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Pair pair = (Pair) o;
        return crews.equals(pair.crews);
    }

    @Override
    public int hashCode() {
        return crews.hashCode();
    }
}
