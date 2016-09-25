package net.a2ka7.dao.impl;

import net.a2ka7.dao.ProductDao;
import net.a2ka7.dao.exception.DaoSystemException;
import net.a2ka7.dao.exception.NoSuchEntityException;
import net.a2ka7.entity.Product;
import org.omg.CORBA.ExceptionList;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ProductMockDao implements ProductDao {
    private final Map<Integer, Product> memory = new ConcurrentHashMap<>();

    public ProductMockDao() {
        this.memory.put(1, new Product(1, "Casserole", 240));
        this.memory.put(2, new Product(2, "Tuna", 450));
        this.memory.put(3, new Product(3, "Cheese", 310));
        this.memory.put(4, new Product(4, "Lollipop", 50));
    }

    public Product selectById(int id) throws DaoSystemException, NoSuchEntityException {
        if (!memory.containsKey(id)){
            throw new NoSuchEntityException("No product for id = " + id + " ");
        }
        return memory.get(id);
    }

    public List<Product> selectAll() throws DaoSystemException {
        return new ArrayList<>(memory.values());
    }
}
