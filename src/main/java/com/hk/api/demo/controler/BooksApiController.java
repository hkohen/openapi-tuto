package com.hk.api.demo.controler;

import com.hk.api.demo.bo.Book;
import com.hk.api.demo.dto.BookDto;
import com.hk.api.demo.service.BookSevice;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-11-08T12:13:40.940160900+01:00[Europe/Paris]")
@Controller
@RequestMapping("${openapi.book.base-path:}")
public class BooksApiController implements BooksApi {

    private final NativeWebRequest request;
    @Autowired
    private BookSevice bookservice;

    @org.springframework.beans.factory.annotation.Autowired
    public BooksApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<BookDto> booksCreatePost(@ApiParam(value = "") @Valid @RequestBody(required = false) BookDto bookDto) {
    Book book =bookservice.insertBook(bookDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(bookDto);
    }

    @Override
    public ResponseEntity<BookDto> booksGetIdGet(@ApiParam(value = "",required=true) @PathVariable("id") Integer id) {
        BookDto reponse=new BookDto();
        Optional<Book> b= bookservice.getBook(id.longValue());
        if (b.isPresent()){

            reponse.setDescription(b.get().getDescription());
            reponse.setTitle(b.get().getTitle());
            reponse.setType(b.get().getType());
        }
        return ResponseEntity.ok(reponse);
    }
@Override
    public ResponseEntity<List<Object>> booksGetallGet() {
List<Book> bookList =bookservice.getAllbooks();
List<Object> listreponse=new ArrayList<Object>();
for (Book b : bookList) {
  BookDto d =new BookDto();
  d.setType(b.getType());
  d.setTitle(b.getTitle());
  d.setDescription(b.getDescription());
  listreponse.add(d);
}
return ResponseEntity.ok(listreponse);
}
    }
