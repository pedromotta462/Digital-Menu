package com.example.menu.food;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "foods")
@Entity(name = "foods")
//com essas notações abaixo o lomboc(uma das dependencias) cria automaticamente em runtime os boilerplates para:
@Getter   //getters
@NoArgsConstructor //construtor sem argumentos
@AllArgsConstructor // construtor com todos os argumentos
@EqualsAndHashCode(of = "id") // indica o id como representação unica na food
public class Food {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //importante usar UUID em aplicações em produção por questões de segurança
    private Long id;
    private String title;
    private String image;
    private Integer price;

    public Food(FoodRequestDTO data){
        this.title = data.title();
        this.image = data.image();
        this.price = data.price();
    }
}
