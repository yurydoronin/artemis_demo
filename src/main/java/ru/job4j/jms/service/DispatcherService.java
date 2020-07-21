package ru.job4j.jms.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 * Class DispatcherService.
 *
 * @author Yury Doronin (doronin.ltd@gmail.com)
 * @version 1.0
 * @since 21.07.2020
 */
@Service
@RequiredArgsConstructor
public class DispatcherService {

    private final JmsTemplate jmsTemplate;

    @Value("${jms.queue.destination}")
    String jmsQueue;

    public void sendMessage(String msg) {
        this.jmsTemplate.convertAndSend(this.jmsQueue, msg);
    }
}
