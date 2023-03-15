package com.ghb.web.servlet.car;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class ProductDB {
    private static Map<String, Product> products = new LinkedHashMap<>();

    static {
        products.put("1", new Product("1", "Java Web编程"));
        products.put("2", new Product("2", "编译原理"));
        products.put("3", new Product("3", "微信小程序开发"));
        products.put("4", new Product("4", "Web高级开发"));
        products.put("5", new Product("5", "Php编程"));
    }

    public static Collection<Product> getAll() {
        return products.values();
    }

    public static Product getProduct(String id) {
        return products.get(id);
    }

}
