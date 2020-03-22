package by.darozhka.ReslivTelegramBot.service.dto;

import com.google.common.base.Objects;

public abstract class BeanDto {
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BeanDto beanDto = (BeanDto) o;
        return id == beanDto.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
