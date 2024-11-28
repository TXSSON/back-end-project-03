package com.javaweb.repository.custom.impl;


import com.javaweb.repository.custom.RentAreaRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Repository
public class RentAreaRepositoryImpl implements RentAreaRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void deleteByBuildingId(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Building ID cannot be null.");
        }

        // Sử dụng câu truy vấn native SQL để xóa dữ liệu
        String sql = "DELETE FROM rentarea WHERE building_id = ?";

        // Thực thi câu truy vấn với tham số
        int result = entityManager.createNativeQuery(sql)
                .setParameter(1, id)  // Thay thế tham số :buildingId
                .executeUpdate();  // Thực thi câu truy vấn

        // Kiểm tra kết quả, nếu không có bản ghi nào bị xóa
        if (result == 0) {
            throw new RuntimeException("No assignments found for the given building ID.");
        }
    }
}
