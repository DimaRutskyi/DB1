package notes.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Rrr on 09.02.2016.
 */

    @Entity
    @Table(name="NOTEBOOKS")
    public class Notebook {
        @Id
        @GeneratedValue
        @Column(name="ID")
        private Long id;

        private Integer serial;
        private String vendor;
        private String model;


        @Temporal(TemporalType.DATE)
        @Column(name = "Manufacture_Date")
        private Date date;
        private Integer price;

        public Notebook() {
        }

        public Notebook(int serial,String vendor,String model,Date date,int price) {

            this.serial=serial;
            this.vendor=vendor;
            this.model=model;
            this.date = date;
            this.price=price;
        }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSerial(Integer serial) {
        this.serial = serial;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public Integer getSerial() {
        return serial;
    }

    public String getVendor() {
        return vendor;
    }

    public String getModel() {
        return model;
    }

    public Date getDate() {
        return date;
    }

    public Integer getPrice() {
        return price;
    }



    @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

        Notebook notebook = (Notebook) o;

            if (id != null ? !id.equals(notebook.id) : notebook.id != null) return false;

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
                ", serial=" + serial +
                ", vendor='" + vendor + '\'' +
                ", model='" + model + '\'' +
                ", date=" + date +
                ", price=" + price +
                '}';
    }

    }

