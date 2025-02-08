package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@ToString
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String description;
    private LocalDate dueDate;
    private boolean status;

}
