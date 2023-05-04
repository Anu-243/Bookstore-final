package com.bookStore.demo.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookStore.demo.model.Book;
import com.bookStore.demo.service.BookService;


@RestController
public class BookStoreController
{
	@Autowired
	BookService bkService;
	
	@GetMapping(value="/fetch")
	public List<Book> getAll()
	{
		List<Book> bkList = bkService.getAll();
		return bkList;
	}
	
	@PostMapping(value="/save")
	public Book save(@RequestBody Book s)
	{
		return bkService.save(s);
	}
	
	@PutMapping(value="/update")
	public Book update(@RequestBody Book s)
	{
		return bkService.save(s); 
	}
	
	//http://localhost:8080/deleteStudent/1003
	@DeleteMapping(value="/delete/{billno}")
	public void delete(@PathVariable("billno") int billno)
	{
		bkService.delete(billno);
	}
	@GetMapping(value="/get/{billno}")
	public Book get(@PathVariable("billno") int billno)
	{
		return bkService.get(billno);
	}

	@GetMapping("/sort/{field}")
	public List<Book>sortBooks(@PathVariable String field)
	{
		return bkService.sortBooks(field);
	}
	
	@GetMapping("/paging/{offset}/{pageSize}")
	public List<Book> paging(@PathVariable int offset,@PathVariable int pageSize)
	{
		return bkService.paging(offset,pageSize);
	}
	@GetMapping("/pagingandsorting/{offset}/{pageSize}/{field}")
	public List<Book> pagingAndSorting(@PathVariable int offset,@PathVariable int pageSize,@PathVariable String field)
	{
		return bkService.pagingAndSorting(offset,pageSize,field);
	}
	
	@DeleteMapping("/deleteByName1/{name}")
	public String deleteByName(@PathVariable String name)
	{
	int result=bkService.deleteByName(name);
	if(result >0)
		return "Customer record deleted";
	else
		return "Problem occured while deleting";
	}
	
	@GetMapping("/fetchAll")
	   public List<Book> fetchAll()
	   {
		  return  bkService.fetchAll();
	   }  
	@PostMapping("/saveAll")
	   public Book saveAll(@RequestBody Book s)
	   {
	  	 return bkService.saveAll(s);
	   }
	@GetMapping("/getData")
	public List<Book> getData(@RequestParam String name)
	{
		return bkService.getData(name);
	}
}