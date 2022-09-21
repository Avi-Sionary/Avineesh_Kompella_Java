package com.example.utilityapi.controller;

import com.example.utilityapi.models.Account;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ArrayList;

@RestController
public class AccountController {

    private List<Account> accountList;

    private static int idCounter = 1;

    public AccountController() {
        accountList = new ArrayList<>();

        accountList.add(new Account("Robert Williams", "TexasAM_44", idCounter++));
        accountList.add(new Account("Danny Ainge", "BYU_44", idCounter++));
        accountList.add(new Account("Brian Scalabrine", "USC_44", idCounter++));
    }

    @RequestMapping(value = "/account", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Account createAccount(@RequestBody Account account) {

        for (Account a : accountList) {
            if (a.getUsername().equals(account.getUsername())) {
                throw new IllegalArgumentException("Error - account already exists.");
            }
        }

        int counter = 0;
        String password = account.getPassword();

        for (int i = 0; i < password.length(); i++) {
            if (!(password.charAt(i) == ' ') && !(password.charAt(i) == '_')) {
                counter += 1;
            }
        }

        if (counter > 10) {
            throw new IllegalArgumentException("Error - password must be 10 characters or less.");
        }

        account.setId(idCounter++);
        accountList.add(account);

        return account;
    }
}
