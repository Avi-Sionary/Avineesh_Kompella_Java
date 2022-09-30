package com.company.Summative_1.controllers;

import com.company.Summative_1.models.Word;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

@RestController
public class WordController {

    // As an API user, I would like issue definition requests from a list of at least 10 words and their corresponding
    // definitions. Words and definitions must be served up at random.

    private List<Word> randomWords;

    public WordController() {
        randomWords = new ArrayList<>();

        randomWords.add(new Word(1, "Hardboot", "a horse-racing enthusiast"));
        randomWords.add(new Word(2, "Lull", "to put to sleep or rest by soothing means"));
        randomWords.add(new Word(3, "Cringe", "to feel very embarrassed or awkward; react with " +
                "discomfort"));
        randomWords.add(new Word(4, "Stupid", "lacking ordinary quickness and keenness of mind"));
        randomWords.add(new Word(5, "Elementary", "pertaining to or dealing with elements, rudiments, " +
                "or first principles"));
        randomWords.add(new Word(6, "Antagonize", "to make hostile or unfriendly; make an enemy or " +
                "antagonist of"));
        randomWords.add(new Word(7, "Instigator", "a person or thing that provokes or incites an " +
                "action or course"));
        randomWords.add(new Word(8, "Provoke", "to stir up, arouse, or call forth (feelings, desires, " +
                "or activity)"));
        randomWords.add(new Word(9, "Shiny", "bright or glossy in apperance"));
        randomWords.add(new Word(10, "Teeth", "collection of hard bodies or processes usually " +
                "attached in a row to each jaw, serving for the prehension and mastication of food, as weapons of " +
                "attack or defense, etc., and in mammals typically composed chiefly of dentin surrounding a sensitive " +
                "pulp and covered on the crown with enamel"));

        // Definitions from Dictionary.com
    }

    @RequestMapping(value = "/word", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Word getWord() {

        Random randomGen = new Random(); // Set up for random answer
        int randomIndex = randomGen.nextInt(randomWords.size()); // In btwn range of 0, 10 exclusive

        return randomWords.get(randomIndex);
    }

}
