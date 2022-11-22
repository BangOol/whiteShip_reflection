package com.example.refactoring;

import java.lang.reflect.Modifier;
import java.util.Arrays;

public class App {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<Book> bookClass = Book.class;

        Book book = new Book();
        Class<? extends Book> aClass = book.getClass();
//        Class<?> aClass1 = Class.forName("com.example.refactoring");
        Arrays.stream(bookClass.getDeclaredFields()).forEach(f -> {
            try {
                f.setAccessible(true); // 해당 코드가 있어야 값까지 접근 가능. (reflection으로 접근 지시자 무시 가능)
                System.out.printf("%s %s",f, f.get(book));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });
        Arrays.stream(bookClass.getFields()).forEach(System.out::println);

        Arrays.stream(bookClass.getMethods()).forEach(System.out::println);
        Arrays.stream(bookClass.getConstructors()).forEach(System.out::println);
        Class<? super MoBook> superclass = MoBook.class.getSuperclass();
        System.out.println(superclass);

        Arrays.stream(MoBook.class.getInterfaces()).forEach(System.out::println);
        Arrays.stream(Book.class.getFields()).forEach(f ->{
            int modifiers = f.getModifiers();
            System.out.println(Modifier.isPrivate(modifiers));
            System.out.println(Modifier.isPublic(modifiers));
            f.getDeclaredAnnotations();
        });


    }
}
