package com.javaweb.repository;

import com.javaweb.entity.RentAreaEntity;
import com.javaweb.repository.custom.RentAreaRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentAreaRepository extends JpaRepository<RentAreaEntity, Long>, RentAreaRepositoryCustom {
}
