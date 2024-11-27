package com.javaweb.utils;

import java.util.Map;

public class MapUtils {
    public static <T> T getObject(Map<String, Object> params, String key, Class<T> tclass) {
        Object obj = params.get(key);
        if (obj != null) {
            String objStr = obj.toString();
            if (!objStr.isEmpty()) {
                try {
                    if (tclass == Integer.class) {
                        obj = Integer.valueOf(objStr);
                    } else if (tclass == Long.class) {
                        obj = Long.valueOf(objStr);
                    } else if (tclass == Double.class) {
                        obj = Double.valueOf(objStr);
                    } else if (tclass == Float.class) {
                        obj = Float.valueOf(objStr);
                    } else if (tclass == Boolean.class) {
                        obj = Boolean.valueOf(objStr);
                    } else if (tclass == String.class) {
                        obj = objStr;
                    } else {
                        // Xử lý cho các kiểu dữ liệu khác hoặc ném ngoại lệ
                        throw new IllegalArgumentException("Unsupported type: " + tclass);
                    }
                } catch (NumberFormatException e) {
                    // Xử lý ngoại lệ chuyển đổi số
                    obj = null;
                }
            } else {
                obj = null;
            }
        }
        return tclass.cast(obj);
    }
}
