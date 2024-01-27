package fr.emse.ai.search.bottle;

public class Bottles {
    public final int bottle1;
    public final int bottle2;

    public Bottles(int bottle1, int bottle2) {
        this.bottle1 = bottle1;
        this.bottle2 = bottle2;
    }

    public int HValue() {
        return Math.abs((bottle1 + bottle2) - 2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bottles)) return false;
        Bottles bottles = (Bottles) o;
        return bottle1 == bottles.bottle1 && bottle2 == bottles.bottle2;
    }

    @Override
    public int hashCode() {
        return 31 * bottle1 + bottle2;
    }

    @Override
    public String toString() {
        return "(" + bottle1 + ", " + bottle2 + ")";
    }
}
