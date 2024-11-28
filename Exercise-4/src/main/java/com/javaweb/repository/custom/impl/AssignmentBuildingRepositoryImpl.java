package com.javaweb.repository.custom.impl;

import com.javaweb.entity.AssignmentBuildingEntity;
import com.javaweb.repository.custom.AssignmentBuildingRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.util.List;

@Repository
public class AssignmentBuildingRepositoryImpl implements AssignmentBuildingRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void deleteByBuildingId(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Building ID cannot be null.");
        }

        // Sử dụng câu truy vấn native SQL để xóa dữ liệu
        String sql = "DELETE FROM assignmentbuilding WHERE building_id = ?";

        // Thực thi câu truy vấn với tham số
        entityManager.createNativeQuery(sql)
                .setParameter(1, id)  // Thay thế tham số :buildingId
                .executeUpdate();  // Thực thi câu truy vấn
    }

    @Override
    public List<AssignmentBuildingEntity> findByBuildingId(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Building ID cannot be null.");
        }

        String sql = "SELECT * FROM assignmentbuilding WHERE building_id = ?";

        List<AssignmentBuildingEntity> res = entityManager.createNativeQuery(sql, AssignmentBuildingEntity.class)
                .setParameter(1, id)
                .getResultList();
        return res;
    }
}
