package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo1Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }

}

//Минимальные требования:
//
//        1. Сделать страницу со списком задач.
//  2. Добавить форму создания задачи.
//        3. Добавить кнопки «Редактировать» и «Удалить».
//        4. Реализовать изменение статуса.
//  5. Добавить фильтр: все / активные / выполненные.
//  6. Хранить данные пока локально — в памяти или localStorage.
