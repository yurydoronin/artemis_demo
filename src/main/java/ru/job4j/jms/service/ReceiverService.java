package ru.job4j.jms.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 * Class ReceiverService.
 *
 * @author Yury Doronin (doronin.ltd@gmail.com)
 * @version 1.0
 * @since 21.07.2020
 */
@Service
public class ReceiverService {

    private static final Logger LOG = LoggerFactory.getLogger(ReceiverService.class);

    @JmsListener(destination = "${jms.queue.destination}")
    public void receiveMessage(String msg) {
        LOG.info(String.format("Received message: %s", msg));
    }
}
