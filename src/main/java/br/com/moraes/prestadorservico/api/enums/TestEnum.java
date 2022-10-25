package br.com.moraes.prestadorservico.api.enums;

import br.com.moraes.prestadorservico.api.interfaces.IOrderEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TestEnum implements IOrderEnum {

    ID("id");

    private String name;

    @Override
    public String getValue() {
        return this.toString();
    }
}
