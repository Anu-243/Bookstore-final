package com.bookStore.demo.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bookStore.demo.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer>
{
	@Modifying
	@Query("delete  from Book s where s.name=?1" )
	public int deleteByName(String name);
	
	@Query("select s from Book s where s.name=:name")
	public List<Book> get(String name);
	
	@Query(value="select * from Book s where s.name=?1",nativeQuery=true)
	public List<Book> getData(String name);
}