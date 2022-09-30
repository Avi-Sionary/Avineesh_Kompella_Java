package com.company.Summative_1.controllers;

import com.company.Summative_1.models.Quote;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

@RestController
public class QuoteController {

    // As an API user, I would like to request a quote from a list of at least 10 quotes.
    // Quotes must be served at random.

    private List<Quote> randomQuotes;

    public QuoteController() {
        randomQuotes = new ArrayList<>();

        randomQuotes.add(new Quote(1, "My Mom", "Get lost"));
        randomQuotes.add(new Quote(2, "Walt Disney", "If you can dream it you can do it."));
        randomQuotes.add(new Quote(3, "Mario", "It's-a-me, Mario!"));
        randomQuotes.add(new Quote(4, "Jotaro Kujo", "Yare yare daze."));
        randomQuotes.add(new Quote(5, "Giorno Giovanna", "I, Giorno Giovanna, have a dream."));
        randomQuotes.add(new Quote(6, "SpongeBob SquarePants", "I'm ready!"));
        randomQuotes.add(new Quote(7, "Son Goku", "My name's Goku, and I'm from Earth!"));
        randomQuotes.add(new Quote(8, "Ice Cube", "If y'all don't like how I'm living, well, " +
                "[EXPLICIT]"));
        randomQuotes.add(new Quote(9, "Batman", "I am vengeance. I am the night. I am Batman!"));
        randomQuotes.add(new Quote(10, "My friend Henry", "YOU CAN'T FOOL ME, PACO!"));
    }

    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Quote getQuote() {

        Random randomGen = new Random(); // Set up for random answer
        int randomIndex = randomGen.nextInt(randomQuotes.size()); // In btwn range of 0, 10 exclusive

        return randomQuotes.get(randomIndex);
    }

}
