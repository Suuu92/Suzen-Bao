import java.util.ArrayList;
import java.util.Objects;

public class Planet {
    private int orbitTime;
    private ArrayList<Moon> moons;
    private String designation;

    public Planet(int orbitTime, String designation) {
        this.orbitTime = orbitTime;
        this.designation = designation;
    }

    public Planet() {
        this.orbitTime = 248;
        designation = "dwarf";
    }

    public int getOrbitTime() {
        return orbitTime;
    }

    public void setOrbitTime(int orbitTime) {
        this.orbitTime = orbitTime;
    }

    public ArrayList<Moon> getMoons() {
        return moons;
    }

    public void setMoons(ArrayList<Moon> moons) {
        this.moons = moons;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Planet) {
            Planet other = (Planet) obj;
            if (this.designation.equals(other.designation)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "orbitTime=" + orbitTime +
                ", designation='" + designation + '\'' +
                '}';
    }
}

