package com.company.Summative_1.controllers;

import com.company.Summative_1.models.Answer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

@RestController
public class Magic8Controller {

    // As an API user, I would like to request Magic 8 Ball responses from a list of at least 6 different responses.
    // Magic 8 Ball answers must be served up at random.

    // The students are not being asked to provide Entity/Model validations or validation responses in this summative.
    // This means that it is possible to submit the Magic 8 Ball POST request without a question, and a response will
    // still be returned.

    private List<Answer> magicList;

    public Magic8Controller() {
        magicList = new ArrayList<>();

        magicList.add(new Answer(1, "", "I don't know man"));
        magicList.add(new Answer(2, "", "It is certain."));
        magicList.add(new Answer(3, "", "It is decidedly so."));
        magicList.add(new Answer(4, "", "Without a doubt."));
        magicList.add(new Answer(5, "", "Yes, definitely."));
        magicList.add(new Answer(6, "", "You  may rely on it."));
        magicList.add(new Answer(7, "", "Reply hazy, try again."));
        magicList.add(new Answer(8, "", "Ask again later."));
        magicList.add(new Answer(9, "", "Better not tell you now."));
        magicList.add(new Answer(10, "", "Cannot predict now."));
        magicList.add(new Answer(11, "", "Concentrate and ask again."));
        magicList.add(new Answer(12, "", "Nah"));
        magicList.add(new Answer(13, "", "Very doubtful."));
        magicList.add(new Answer(14, "", "Don't bet on it."));
        magicList.add(new Answer(15, "", "My reply is no."));
        magicList.add(new Answer(16, "", "Outlook not so good."));

        // https://en.wikipedia.org/wiki/Magic_8_Ball#Possible_answers
    }
    @RequestMapping(value = "/magic", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Answer getMagic8(@RequestBody Answer magic8) {

        Random randomGen = new Random(); // Set up for random answer
        int randomIndex = randomGen.nextInt(magicList.size()); // In btwn range of 0, 16 exclusive

        Answer magicQandA = new Answer();
        magicQandA.setId(magicList.size()); // The answer will be appended to the list, so make its index the last
        magicQandA.setQuestion(magic8.getQuestion());

        String answer = magicList.get(randomIndex).getAnswer();

        magicQandA.setAnswer(answer);

        magicList.add(magicQandA);

        return magicQandA;
    }
}
