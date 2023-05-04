package com.bookStore.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.bookStore.demo.dao.BookRepository;
import com.bookStore.demo.model.Book;

import jakarta.transaction.Transactional;



@Service
public class BookService
{
	@Autowired
	BookRepository bkRepository;

	public List<Book> getAll()
	{
		List<Book> bkList = bkRepository.findAll();
		return bkList;
	}
	
	public Book save(Book s)
	{
		Book obj = bkRepository.save(s);
		return obj;
	}
	
	public Book update(Book s)
	{
		Book obj=bkRepository.save(s);
		return obj;
	}
	public void delete(int billno)
	{
		bkRepository.deleteById(billno);
	}
	public Book get(int billno)
	{
		Book s=bkRepository.findById(billno).get();
		return s;
	}
	

	public List<Book> sortBooks(String field) {
		return bkRepository.findAll(Sort.by(field));
	}

	public List<Book> paging(int offset, int pageSize) {
		Pageable paging=PageRequest.of(offset,pageSize);
		Page<Book> Data=bkRepository.findAll(paging);
		List<Book>bkList=Data.getContent();
		return bkList;
	}
	
	 public List<Book> pagingAndSorting(int offset,int pageSize,String field)
	 {
		 Pageable paging = PageRequest.of(offset,pageSize).withSort(Sort.by(field));
		 Page<Book> bk=bkRepository.findAll(paging);
		 return bk.getContent();
	 }
	 @Transactional
	 public int deleteByName(String name)
	 {
	 	return bkRepository.deleteByName(name);
	 }
	 public List<Book> fetchAll()
	 {
		 return bkRepository.findAll();
	 }
	 public Book saveAll(Book s)
	 {
		 return bkRepository.save(s);
	 }
	 public List<Book> getData(String name ) {
			return bkRepository.getData(name);
		}
}