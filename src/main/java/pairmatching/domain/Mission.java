package pairmatching.domain;

public class Mission {
    private final String name;

    public Mission(String name) {
        this.name = name;
    }

    public boolean isEqualName(String missionName) {
        return this.name.equals(missionName);
    }
}
