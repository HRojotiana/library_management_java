import library_management.model.Author;
import library_management.model.Book;
import library_management.model.Subscriber;
import library_management.repository.AuthorCrudOperations;
import library_management.repository.BookCrudOperations;
import library_management.repository.SubscriberCrudOperations;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        AuthorCrudOperations authorCrudOperations = new AuthorCrudOperations();
        BookCrudOperations bookCrudOperations = new BookCrudOperations();
        SubscriberCrudOperations subscriberCrudOperations = new SubscriberCrudOperations();

        //Insérer un nouvel auteur
        Author newAuthor = new Author("auth67", "James Blue", "M");
        Author savedAuthor = authorCrudOperations.save(newAuthor);
        LOGGER.info("Author saved successfully"+savedAuthor.toString());

        //Insérer une liste d'auteurs
        Author author1 = new Author("auth89","Sylvia Johns", "F" );
        Author author2 = new Author("auth100","Jimy Clarckson", "M" );
        List<Author> authorList = new ArrayList<>();
        authorList.add(author1);
        authorList.add(author2);
        List<Author> savedAuthorList = authorCrudOperations.saveAll(authorList);
        LOGGER.info("List of the saved authors successfully: "+savedAuthorList.toString());

        //Supprimer un auteur
        Author deletedAuthor = authorCrudOperations.delete(author1);
        LOGGER.info("Author deleted successfully: "+deletedAuthor.toString());

        //Afficher la liste de tous les auteurs
        List<Author> authors = authorCrudOperations.findAll();
        LOGGER.info("List of all authors: "+authors.toString());

        //Insérer une nouveau livre
        Book newBook = new Book("bk4", "Satan était un ange", 100, "other", Date.valueOf("2012-05-23"), "available", "auth1");
        Book savedBook = bookCrudOperations.save(newBook);
        LOGGER.info("Book saved successfully: "+savedBook.toString());

        //Insérer une liste de livres
        Book book1 = new Book("bk98", "Quelque part", 250, "comedy", Date.valueOf("2014-05-29"),"borrowed", "auth2" );
        Book book2 = new Book("bk100", "Nul part", 150, "romance", Date.valueOf("2004-09-25"),"available", "auth100" );
        List<Book> bookList = new ArrayList<>();
        bookList.add(book1);
        bookList.add(book2);
        List<Book> savedBookList = bookCrudOperations.saveAll(bookList);
        LOGGER.info("List of books saved successfully: "+savedBookList.toString());

        //Supprimer un auteur
        Book deletedBook = bookCrudOperations.delete(book1);
        LOGGER.info("Book deleted successfully: "+deletedBook.toString());

        //Afficher la liste de tous les livres
        List<Book> books = bookCrudOperations.findAll();
        LOGGER.info("List of all books: "+books.toString());

        //Insérer un nouveau visiteur
        Subscriber newSubscriber = new Subscriber("subs12","Marc Antoine", "oopcj",Date.valueOf("2000-03-06") );
        Subscriber savedSubscriber = subscriberCrudOperations.save(newSubscriber);
        LOGGER.info("Subscriber saved successfully: "+savedSubscriber.toString());

        //Insérer une liste de visiteurs
        Subscriber subscriber1 = new Subscriber("subs14","Marie Claire", "dfgh",Date.valueOf("2001-04-07") );
        Subscriber subscriber2 = new Subscriber("subs15","Jane Katherine", "vbncc",Date.valueOf("2002-05-08") );
        List<Subscriber> subscriberList = new ArrayList<>();
        subscriberList.add(subscriber1);
        subscriberList.add(subscriber2);
        List<Subscriber> savedSubscriberList = subscriberCrudOperations.saveAll(subscriberList);
        LOGGER.info("List of subscribers saved successfully: "+savedSubscriberList.toString());

        //Supprimer un visiteur
        Subscriber deletedSubscriber = subscriberCrudOperations.delete(subscriber1);
        LOGGER.info("Subscriber deleted successfully: "+deletedSubscriber.toString());

        //Afficher tous les visiteurs
        List<Subscriber> subscribers = subscriberCrudOperations.findAll();
        LOGGER.info("List of all subscribers: "+subscribers.toString());

    }
}
