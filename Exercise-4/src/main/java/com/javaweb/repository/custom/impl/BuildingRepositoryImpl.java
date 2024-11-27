package com.javaweb.repository.custom.impl;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.repository.custom.BuildingRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;


@Repository
public class BuildingRepositoryImpl implements BuildingRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    private String join(BuildingSearchRequest buildingSearchRequest) {
        StringBuilder sqlJoin = new StringBuilder("");
        if (buildingSearchRequest.getArea_from() != null || buildingSearchRequest.getArea_to() != null) {
            sqlJoin.append(" inner join rentarea as ra on b.id = ra.building_id ");
        }
        if (buildingSearchRequest.getStaff_id() != null) {
            sqlJoin.append(" inner join assignmentbuilding on assignmentbuilding.id = b.id "
                    + " inner join user on assignmentbuilding.staff_id = user.id ");
        }
        return sqlJoin.toString();
    }

    private String conditionsSpecial(BuildingSearchRequest buildingSearchRequest) {
        StringBuilder conditionsSpecial = new StringBuilder("");
        if (buildingSearchRequest.getArea_from() != null) {
            conditionsSpecial.append(" and ra.value >= " + buildingSearchRequest.getArea_from());
        }
        if (buildingSearchRequest.getArea_to() != null) {
            conditionsSpecial.append(" and ra.value <= " + buildingSearchRequest.getArea_to());
        }
        if (buildingSearchRequest.getRent_price_to() != null) {
            conditionsSpecial.append(" and b.rent_price <= " + buildingSearchRequest.getRent_price_to());
        }
        if (buildingSearchRequest.getRent_price_from() != null) {
            conditionsSpecial.append(" and b.rent_price >= " + buildingSearchRequest.getRent_price_from());
        }
        if (buildingSearchRequest.getStaff_id() != null) {
            conditionsSpecial.append(" and user.id = " + buildingSearchRequest.getStaff_id());
        }
        conditionsSpecial.append(" group by b.id order by b.id asc ");
        return conditionsSpecial.toString();
    }

    private String conditionsNormal(BuildingSearchRequest buildingSearchRequest) {
        StringBuilder conditionsNormal = new StringBuilder();
        Class<?> clazz = buildingSearchRequest.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field item : fields) {
            item.setAccessible(true);
            try {
                if (!item.getName().equals("staff_id") && !item.getName().startsWith("area")
                        && !item.getName().startsWith("rent_Price")) {
                    Object value = item.get(buildingSearchRequest); // Lấy giá trị của thuộc tính từ đối tượng buildingSearchRequest

                    if (value != null && (value instanceof Integer || value instanceof Long)) {
                        conditionsNormal.append(" and b.").append(item.getName()).append(" = ").append(value);
                    } else if (List.class.isAssignableFrom(item.getType())) {
                        List<?> list = (List<?>) item.get(buildingSearchRequest);

                        // Kiểm tra danh sách không rỗng trước khi xử lý
                        if (list != null && !list.isEmpty()) {
                            String valueType = list.stream()
                                    .map(Object::toString) // Chuyển từng phần tử thành chuỗi
                                    .collect(Collectors.joining(",")); // Nối thành chuỗi
                            conditionsNormal.append(" and b.").append(item.getName())
                                    .append(" like '%").append(valueType).append("%' ");
                        }
                    } else if (value != null && !value.toString().trim().isEmpty() && !item.getName().equals("type")) {
                        conditionsNormal.append(" and b.").append(item.getName()).append(" like '%").append(value).append("%' ");
                    }
                }

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return conditionsNormal.toString();
    }

    @Override
    public List<BuildingEntity> findAll(BuildingSearchRequest buildingSearchRequest) {

        // JPQL
        // String sql = "FROM BuildingEntity";
        // Query query = entityManager.createQuery(sql, BuildingEntity.class);
        // return query.getResultList();

        // JPA native
        StringBuilder sqlQuery = new StringBuilder("");
        sqlQuery.append(
                " SELECT b.* FROM building as b ");
        String sqlJoin = join(buildingSearchRequest);
        String conditions = " where 1 = 1 " + conditionsNormal(buildingSearchRequest)
                + conditionsSpecial(buildingSearchRequest);
        sqlQuery.append(sqlJoin).append(conditions);
        String sql = sqlQuery.toString();
        System.out.println("Câu lệnh truy vấn sql: " + sql);
        Query query = entityManager.createNativeQuery(sql, BuildingEntity.class);
        return query.getResultList();
    }
}
