package by.darozhka.ReslivTelegramBot.service.dto;

import com.google.common.base.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class GuideDto extends BeanDto {
    @NotBlank(message = "City must contain name")
    @Size(min = 1, max = 20, message = "City name size must be between 1 and 20.")
    private String city;
    @NotBlank(message = "City info must contain information")
    @Size(min = 1, max = 2000, message = "Information length must be between 1 and 2000.")
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
        GuideDto guideDto = (GuideDto) o;
        return Objects.equal(city, guideDto.city) &&
                Objects.equal(cityInfo, guideDto.cityInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), city, cityInfo);
    }
}
