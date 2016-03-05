package hw6.notes.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Юлия on 12.02.2016.
 */
@Entity
@Table(name = "NOTES")
public class Notebook {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQUENCE1",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "ID")
    private Long id;

    @Column(name = "VENDOR")
    private String vendor;


    @Column(name = "MODEL")
    private String model;

    @Column(name = "MANUFACTURE_DATE")
    private Date date;

    @Column(name = "PRICE")
    private double price;

    @Column(name = "SERIAL")
    private String serial;

    public Notebook() {
    }

    public Notebook(long id, String vendor, String model, Date date, double price, String serial) {
        this.id = id;
        this.vendor = vendor;
        this.model = model;
        this.date = date;
        this.price = price;
        this.serial = serial;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String name) {
        this.vendor = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Notebook ntb = (Notebook) o;

        if (id != null ? !id.equals(ntb.id) : ntb.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }


    @Override
    public String toString() {
        return "Notebook{" +
                "id=" + id +
                ", vendor='" + vendor + ", model='" + model + ", date='" + date + ", price='" + price + '\'' +
                '}';
    }


}
