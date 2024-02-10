package com.Matazor.quizApp.Model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
private String title;
@ManyToMany
   private List<Question> questions;

}