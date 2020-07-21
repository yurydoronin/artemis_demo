package ru.job4j.jms.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.job4j.jms.service.DispatcherService;

/**
 * Class MessageController.
 *
 * @author Yury Doronin (doronin.ltd@gmail.com)
 * @version 1.0
 * @since 21.07.2020
 */
@RestController
@RequestMapping(path = "/jms")
@RequiredArgsConstructor
public class MessageController {

    private final DispatcherService dispatcher;

    @PostMapping(path = "/send")
    public ResponseEntity<String> send(@RequestBody String msg) {
        this.dispatcher.sendMessage(msg);
        return new ResponseEntity<>(String.format("Message sent: %s", msg), HttpStatus.OK);
    }

}
