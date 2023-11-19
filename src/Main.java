import library_management.Author;
import library_management.AuthorCrudOperations;
import library_management.BookCrudOperations;
import library_management.Book;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        AuthorCrudOperations authorCrudOperations = new AuthorCrudOperations();
        BookCrudOperations bookCrudOperations = new BookCrudOperations();

        //Insérer un nouvel auteur
        Author newAuthor = new Author("auth67", "James Blue", "M");
        Author savedAuthor = authorCrudOperations.save(newAuthor);
        LOGGER.info("Author saved successfully"+savedAuthor.toString());

        //Insérer une liste d'auteurs


        //Afficher la liste de tous les auteurs
        List<Author> authors = authorCrudOperations.findAll();
        LOGGER.info("List of all authors: "+authors.toString());

        //Insérer une nouveau livre
        /*Book newBook = new Book("bk4", "Satan était un ange", 100, "other", Date.valueOf("2012-05-23"), "available", "auth1");
        Book savedBook = bookCrudOperations.save(newBook);
        LOGGER.info("Book saved successfully: "+savedBook.toString());*/

        //Afficher la liste de tous les livres
        /*List<Book> books = bookCrudOperations.findAll();
        LOGGER.info("List of all books: "+books.toString());*/
    }
}
