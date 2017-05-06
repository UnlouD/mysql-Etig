package app.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "country", schema = "project")

@NamedQueries({
        @NamedQuery(name = "CountryDaoImpl.getAll", query = "SELECT c from Country c"),
        @NamedQuery(name = "CountryDaoImpl.find", query = "SELECT c from Country c WHERE c.id = :id")
})
public class Country {
    private int id;
    private String name;
    private Collection<Region> regions;

    public Country() {
    }

    public Country(int id) {
        this.id = id;
    }

    public Country(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        if (id != country.id) return false;
        if (name != null ? !name.equals(country.name) : country.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "country")
    public Collection<Region> getRegions() {
        return regions;
    }

    public void setRegions(Collection<Region> regions) {
        this.regions = regions;
    }

    @Override
    public String toString() {
        return name;
    }
}
