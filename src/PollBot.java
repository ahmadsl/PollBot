import org.telegram.telegrambots.TelegramApiException;
import org.telegram.telegrambots.api.methods.groupadministration.GetChatAdministrators;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Microsoft on 18/08/2016.
 */
public class PollBot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        System.out.println(update.getMessage().toString());
        try {
            System.out.println(getChatAdministrators(new GetChatAdministrators().setChatId("-1001080879425")));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        SendMessage test=new SendMessage().setChatId(update.getMessage().getChatId().toString()).setText(update.getMessage().getText());
        InlineKeyboardMarkup inlineKeyboardMarkup=new InlineKeyboardMarkup();
        List<InlineKeyboardButton> inlineKeyboardButtons=new ArrayList<>();
        List<List<InlineKeyboardButton>> listList=new ArrayList<>();
        inlineKeyboardButtons.add(new InlineKeyboardButton().setText("like").setCallbackData("1"));
        inlineKeyboardButtons.add(new InlineKeyboardButton().setText("disLike").setCallbackData("2"));
        listList.add(inlineKeyboardButtons);
        inlineKeyboardMarkup.setKeyboard(listList);
        test.setReplyMarkup(inlineKeyboardMarkup);
        test.enableMarkdown(true);
        try {
            sendMessage(test);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


    @Override
    public String getBotUsername() {
        return null;
    }

    @Override
    public String getBotToken() {
        return "";
    }
}
