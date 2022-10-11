package org.example.jsonl_ist_from_postman;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.awt.print.Book;
import java.util.List;

@Setter
@Getter
@ToString
public class Books {

    List<OneBook> books;
    int totalPrice;
}
