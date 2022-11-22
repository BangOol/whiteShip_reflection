package com.example.reflectiondemo;

import com.Book;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        Class<Book> bookClass = Book.class;
        Book book = new Book();
        Arrays.stream(bookClass.getDeclaredFields()).forEach(f ->{
            f.setAccessible(true);
            try {
                System.out.printf("%s %s\n", f, f.get(book));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });

    }

    // 모든 필드에 접근이 가능한 상황.
    public static void main2(String[] args) throws ClassNotFoundException{
        Class<Book> bookClass = Book.class;
        Book book = new Book();
        Arrays.stream(bookClass.getDeclaredFields()).forEach(f ->{
            try {
                System.out.printf("%s %s\n", f, f.get(book));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }
}
