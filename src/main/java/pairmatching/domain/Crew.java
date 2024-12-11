package pairmatching.domain;

import java.util.Objects;

public class Crew implements Comparable<Crew> {
    private final Course course;
    private final String name;

    public Crew(Course course, String name) {
        this.course = course;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Course getCourse() {
        return course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Crew crew = (Crew) o;
        return course == crew.course && Objects.equals(name, crew.name);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(course);
        result = 31 * result + Objects.hashCode(name);
        return result;
    }

    @Override
    public int compareTo(Crew o) {
        return this.name.compareTo(o.name);
    }
}

