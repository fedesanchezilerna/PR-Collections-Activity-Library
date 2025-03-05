package library;

import java.util.Objects;

public class Writer {
    private String name;
    private String dateBirth;
    private String countryOfBirth;

    public Writer(String name, String dateBirth, String countryOfBirth) {
        this.name = name;
        this.dateBirth = dateBirth;
        this.countryOfBirth = countryOfBirth;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDateBirth() { return dateBirth; }
    public void setDateBirth(String dateBirth) { this.dateBirth = dateBirth; }

    public String getCountryOfBirth() { return countryOfBirth; }
    public void setCountryOfBirth(String countryOfBirth) { this.countryOfBirth = countryOfBirth; }

    @Override
    public String toString() {
        return String.format("%-20s %-12s %-15s", name, dateBirth, countryOfBirth);
    }

    /**
     * Writers are equals if they have same <strong>name, dateOfBirth and countryBirth</strong>
     *
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, dateBirth, countryOfBirth);
    }

    /**
     * Writers are equals if they have same <strong>name, dateOfBirth and countryBirth</strong>
     *
     * @param obj       writer to be compared
     * @return          true if writer is equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Writer writer = (Writer) obj;
        return name.equals(writer.name) && dateBirth.equals(writer.dateBirth) &&
               countryOfBirth.equals(writer.countryOfBirth);
    }
}
