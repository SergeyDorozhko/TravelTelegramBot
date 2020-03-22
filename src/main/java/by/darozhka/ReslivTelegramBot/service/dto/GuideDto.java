package by.darozhka.ReslivTelegramBot.service.dto;

import com.google.common.base.Objects;

public class GuideDto extends BeanDto {
    private String city;
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
