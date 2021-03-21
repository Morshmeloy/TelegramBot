import javassist.CodeConverter;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.BotApiMethod;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.CallbackQuery;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

import javax.xml.crypto.Data;
import java.lang.invoke.SwitchPoint;
import java.time.MonthDay;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Bot extends TelegramLongPollingBot {
    public static void main(String[] args) {

        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new Bot());
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }

    Calendar c = Calendar.getInstance();
    Integer dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
    Integer nextDayOfWeek = dayOfWeek - 1;

    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        if (update.getMessage() != null && update.getMessage().hasText()) {
            switch (update.getMessage().getText()) {
                case "Расписание на завтра": {
                    SendMsg(message, "Кому требуеться рассписание");
                    switch (update.getMessage().getText()) {
                        case "Пупсик": {
                            switch (dayOfWeek) {
                                case 7: {
                                    SendMsg(message, "2");
                                    break;
                                }
                                default:
                                    SendMsg(message, "3");
                            }
                            break;
                        }
                    }

                    break;
                }
                case "Расписание на сегодня": {
                    SendMsg(message, "4");
                    break;
                }
            }

        }
    }

    public void SendMsg(Message message, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(text);
        try {

            /* SetButtons(sendMessage);*/
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    /*public BotApiMethod processCallbackQuery(CallbackQuery buttonQuery){
            final long chatId=buttonQuery.getMessage().getChatId();
            final int iserId=buttonQuery.getFrom().getId();
            BotApiMethod<?> callBackAnswer=mainMenuService.getMainMessage(chatId,"Воспользуйтесь главным меню");
            if(buttonQuery.getData().equals("Расписание на завтра")){
                callBackAnswer =new SendMessage(chatId,"");
            }
    }*/
   /* private InlineKeyboardMarkup getInLineMessageButtons() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        InlineKeyboardButton ButtonLessonsToday = new InlineKeyboardButton().setText("Расписание на сегодня");
        InlineKeyboardButton ButtonLessonsTomorrow = new InlineKeyboardButton().setText("Расписание на завтра");
        InlineKeyboardButton ButtonForPersonDad = new InlineKeyboardButton().setText("Папочка");
        InlineKeyboardButton ButtonForPersonPups = new InlineKeyboardButton().setText("Пупсик");
        InlineKeyboardButton ButtonForPersonDen = new InlineKeyboardButton().setText("Дэн");
        InlineKeyboardButton ButtonForChat = new InlineKeyboardButton().setText("Поболтаем?");
        InlineKeyboardButton ButtonForLessonsForYourDay = new InlineKeyboardButton().setText("Расписание на любой день");
        InlineKeyboardButton ButtonForLost = new InlineKeyboardButton().setText("Прогулы");

        ButtonLessonsToday.setCallbackData("Расписание на завтра");
        ButtonLessonsTomorrow.setCallbackData("Расписание на завтра");
        ButtonForPersonDad.setCallbackData("Папочка");
        ButtonForPersonPups.setCallbackData("Пупсик");
        ButtonForPersonDen.setCallbackData("Дэн");
        ButtonForChat.setCallbackData("Поболтаем?");
        ButtonForLessonsForYourDay.setCallbackData("Расписание на любой день");
        ButtonForLost.setCallbackData("Прогулы");

        List<InlineKeyboardButton> keyboardButtonsRow = new ArrayList<>();
        keyboardButtonsRow.add(ButtonLessonsToday);
        keyboardButtonsRow.add(ButtonLessonsTomorrow);

        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
        keyboardButtonsRow1.add(ButtonForLessonsForYourDay);

        List<InlineKeyboardButton>keyboardButtonsRow2=new ArrayList<>();
        keyboardButtonsRow2.add(ButtonForChat);

        List<InlineKeyboardButton>keyboardButtonsRow3=new ArrayList<>();
        keyboardButtonsRow3.add(ButtonForLost);

        List<InlineKeyboardButton>keyboardButtonsRow4=new ArrayList<>();
        keyboardButtonsRow4.add(ButtonForPersonDad);
        keyboardButtonsRow4.add(ButtonForPersonPups);
        keyboardButtonsRow4.add(ButtonForPersonDen);

        List<List<InlineKeyboardButton>>rowlist=new ArrayList<>();
        rowlist.add(keyboardButtonsRow);
        rowlist.add(keyboardButtonsRow1);
        rowlist.add(keyboardButtonsRow2);
        rowlist.add(keyboardButtonsRow2);
        rowlist.add(keyboardButtonsRow3);
        rowlist.add(keyboardButtonsRow4);

        inlineKeyboardMarkup.setKeyboard(rowlist);
        return inlineKeyboardMarkup;

    }*/


   public void SetButtons(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);

        replyKeyboardMarkup.setOneTimeKeyboard(false);
        List<KeyboardRow> keyboardRowList = new ArrayList<>();

        KeyboardRow keyboardFirstRow = new KeyboardRow();
        keyboardFirstRow.add(new KeyboardButton("Расписание на завтра"));
        keyboardFirstRow.add(new KeyboardButton("Расписание на сегодня"));

        KeyboardRow keyboardSecondRow = new KeyboardRow();
        keyboardSecondRow.add(new KeyboardButton("Количество прогулов"));
        keyboardSecondRow.add(new KeyboardButton("Рассписание на любой день"));

        KeyboardRow keyboardThirdRow = new KeyboardRow();
        keyboardThirdRow.add(new KeyboardButton("Поболтаем ?"));

        KeyboardRow keyboardFourRow = new KeyboardRow();
        keyboardFourRow.add(new KeyboardButton("Пупсик"));
        keyboardFourRow.add(new KeyboardButton("Папочка"));

        keyboardRowList.add(keyboardFirstRow);
        keyboardRowList.add(keyboardSecondRow);
        keyboardRowList.add(keyboardThirdRow);
        keyboardRowList.add(keyboardFourRow);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);

    }


    @Override
    public String getBotUsername() {
        return "Franchezko_Bot";
    }

    @Override
    public String getBotToken() {
        return "1609845253:AAEWJ48yaAwF5n8PLrSXt0BipuTypeyG6PQ";
    }
}
