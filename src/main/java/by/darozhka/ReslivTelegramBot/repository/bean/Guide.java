package by.darozhka.ReslivTelegramBot.repository.bean;

import com.google.common.base.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "guide")
public class Guide extends Bean implements Serializable {
    @Column(name = "city")
    private String city;
    @Column(name = "city_info")
    private String cityInfo;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityInfo() {
        return cityInfo;
    }

    public void setCityInfo(String cityInfo) {
        this.cityInfo = cityInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Guide guide = (Guide) o;
        return Objects.equal(city, guide.city) &&
                Objects.equal(cityInfo, guide.cityInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), city, cityInfo);
    }
}
