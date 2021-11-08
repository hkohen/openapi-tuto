package com.hk.api.demo.bo;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

@Entity
@Table

public class Book implements Comparable<Book>{
  public Book(Long id, String title, String description, String type) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.type = type;
  }

  public Book() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;
  private String description;
  private String type;


  @Override
  public int compareTo(Book o) {
    return this.getType().compareTo(o.getType());
  }

}
