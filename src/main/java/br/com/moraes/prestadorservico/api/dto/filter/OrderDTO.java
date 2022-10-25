package br.com.moraes.prestadorservico.api.dto.filter;

import java.io.Serializable;

import org.springframework.data.domain.Sort.Direction;

import br.com.moraes.prestadorservico.api.interfaces.IOrderEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDTO implements Serializable {

    private IOrderEnum orderEnum;

    @Builder.Default
    private Direction direction = Direction.DESC;
}
