package net.a2ka7.dao;

import net.a2ka7.dao.exception.DaoSystemException;
import net.a2ka7.dao.exception.NoSuchEntityException;
import net.a2ka7.entity.Product;

import java.util.List;

public interface ProductDao {
    /**
     * Never return null!
     * @throws DaoSystemException
     * @throws NoSuchEntityException
     */
    public Product selectById(int id) throws DaoSystemException, NoSuchEntityException;

    public List<Product> selectAll() throws DaoSystemException;
}
