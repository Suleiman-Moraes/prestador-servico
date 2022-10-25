package br.com.moraes.prestadorservico.api.interfaces;

import java.util.List;

import br.com.moraes.prestadorservico.api.dto.filter.OrderDTO;

public interface IFilterBasic {
    Integer getSize();

    Integer getPage();

    List<OrderDTO> getOrders();
}
