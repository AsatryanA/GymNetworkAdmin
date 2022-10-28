package com.example.gym.telegrambot;

import com.example.gym.service.WalletsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Component
@RequiredArgsConstructor
public class BotService {
    private final WalletsService walletsService;
    private static final String START = "/start";
    private static final String ENTER_CODE = "Enter your verification code";
    private static final String THANK_YOU = "Thank you for verifying your wallet";
    private static final String WRONG_CODE = "Please try again";


    public SendMessage botFunction(String message, Long id) {

        boolean verificationCode = walletsService.verification(message);
        if (message.equals(START)) {
            return sendMess(ENTER_CODE, id);
        } else if (verificationCode) {
            return sendMess(THANK_YOU, id);
        } else return sendMess(WRONG_CODE, id);
    }

    public SendMessage sendMess(String message, Long id) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(message);
        sendMessage.setChatId(String.valueOf(id));
        return sendMessage;
    }
}