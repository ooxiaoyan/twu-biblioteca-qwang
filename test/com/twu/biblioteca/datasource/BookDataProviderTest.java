package com.twu.biblioteca.datasource;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

/**
 * Created by 筱湮 on 2018/7/14 0014.
 */
public class BookDataProviderTest {

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private BookDataProvider bookDataProvider;

    private String systemOut() {
        return outContent.toString();
    }

    @Before
    public void setup() {
        bookDataProvider = new BookDataProvider();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void should_print_a_list_of_all_books() {
        bookDataProvider.printBookList();
        String result =
                "----------Here is the Book List----------\n" +
                        "Id        Name                                                        Author                                  YearOfPublication\n" +
                        "1         Head First Java                                             Kathy Sierra,BertBates                  2005 \n" +
                        "2         Pride and Prejudice                                         Jane Austen                             1983 \n" +
                        "3         The Little Prince                                           Antoine de Saint-Exupery                1998 \n" +
                        "4         Harry Potter and the Prisoner of Azkaban                    J. K. Rowling                           2001 \n" +
                        "5         Les Miserables                                              Victor Hugo                             1862 ";
        assertThat(systemOut(),containsString(result));
    }

}
