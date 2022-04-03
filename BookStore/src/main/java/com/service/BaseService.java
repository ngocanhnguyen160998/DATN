package com.service;

import com.dto.WarehouseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
public class BaseService {
    @Autowired
    private EntityManagerFactory emf;
    @Autowired
    private ModelMapper modelMapper;

    public Stream<WarehouseDTO> findWarehouseDTO() {
        EntityManager entityManager = emf.createEntityManager();
        List<WarehouseDTO> lst = new ArrayList<>();
        Query query = entityManager
                .createQuery("SELECT w.id, w.amount, p.name, w.note FROM  Warehouse w, Product p"
                        + " WHERE w.productId = p.id");
//        List<WarehouseDTO> tmp = query.getResultList();
//        for (WarehouseDTO obj : tmp) {
//            WarehouseDTO warehouseDTO = new WarehouseDTO();
//            warehouseDTO.setId(obj.getId());
//            warehouseDTO.setProductName(obj.getProductName());
//            warehouseDTO.setAmount(obj.getAmount());
//            warehouseDTO.setNote(obj.getNote());
//            lst.add(warehouseDTO);
//        }
        return query.getResultStream();
    }
}
