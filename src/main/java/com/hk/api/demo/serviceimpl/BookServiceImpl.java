package com.hk.api.demo.serviceimpl;

import com.hk.api.demo.bo.Book;
import com.hk.api.demo.dao.BookDao;
import com.hk.api.demo.dto.BookDto;
import com.hk.api.demo.service.BookSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookSevice{

    @Autowired
   private BookDao bookdao;

    @Override
    public Book insertBook(BookDto b) {
        Book c= new Book();
        c.setType(b.getType());
        c.setTitle(b.getTitle());
        c.setDescription(b.getDescription());


        return bookdao.save(c);
    }
    @Override
    public Optional<Book> getBook(Long id) {
        return bookdao.findById(id);
    }



    @Override
    public List<Book> getAllbooks() {
        return  bookdao.findAll().stream().peek( m -> m.setType(m.getType().toUpperCase())).sorted().collect(Collectors.toList());
    }

    @Override
    public List<String> getAllbookstypes() {
        return  bookdao.findAll().stream().map( m -> m.getType()).distinct().collect(Collectors.toList());
    }
    @Override
    public List<Book> getbooksbytype(String type) {
        return  bookdao.findAll().stream().filter(m->type.equals(m.getType())).sorted().collect(Collectors.toList());
    }


    @Override
    public void deleteBook(Long id) {
       bookdao.deleteById(id);

    }

    @Override
    public Book modifyBook(Book b) {
/*       Book c=bookdao.getById(b.getId());
       c.setDescription(b.getDescription());
       c.setTitle(b.getTitle());
       c.setType(b.getType());
       return bookdao.save(c);*/
        return null;

    }

    @Override
    public List<Book> getAllBookStartingBy(String s) {
        return bookdao.findAll().stream().filter(m->m.getType().startsWith(s)).sorted().collect(Collectors.toList());
    }

    @Override
    public long getNombreBook() {
        return bookdao.findAll().stream().count();
    }
}
