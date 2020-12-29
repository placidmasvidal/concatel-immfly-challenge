package com.immfly.immflychallenge.repositories;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public class BaseRepositoryImpl<T, I extends Serializable> extends SimpleJpaRepository<T, I> implements BaseRepository<T, I> {

    private final EntityManager entityManager;

    public BaseRepositoryImpl(JpaEntityInformation entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public T saveAndRefresh(T entity) {
        save(entity);
        entityManager.refresh(entity);
        return entity;
    }

    @Override
    @Transactional
    public List<T> saveAndRefreshList(List<T> entities) {
        saveAll(entities);
        return entities;
    }


}
