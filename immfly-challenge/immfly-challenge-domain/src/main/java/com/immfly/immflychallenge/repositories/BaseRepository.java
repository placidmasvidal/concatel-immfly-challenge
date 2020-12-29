package com.immfly.immflychallenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
public interface BaseRepository<T, I extends Serializable> extends JpaRepository<T, I> {
    T saveAndRefresh(T t);
    List<T> saveAndRefreshList(List<T> entities);
}
