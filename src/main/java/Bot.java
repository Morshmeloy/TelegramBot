
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

import java.util.ArrayList;
import java.util.Calendar;
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
    Person Person = new Person();

    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();

        if (update.getMessage() != null && update.getMessage().hasText()) {
            switch (update.getMessage().getText()) {
                case "Пупсик": {
                    Person.SetPerson("Пупсик");
                    SendMsg(message, "Вы написали Пупсик");
                    break;
                }
                case "Папочка": {
                    Person.SetPerson("Папочка");
                    SendMsg(message, "Вы написали Папочка");
                    break;
                }
                case "Дэн": {
                    Person.SetPerson("Дэн");
                    SendMsg(message, "Вы написали Дэн");
                    break;
                }
            }


        }
        if (update.getMessage() != null && update.getMessage().hasText() && Person.GetPesrson() != null) {
            switch (Person.GetPesrson()) {
                case "Дэн": {
                    switch (update.getMessage().getText()) {
                        case "Расписание на завтра": {
                            switch (dayOfWeek) {
                                case 1: {SendMsg(message,"-----\n");SendMsg(message,"Лекция Захаров\n");break;}
                                case 2: {SendMsg(message,"-----\n");SendMsg(message,"Лекция Рожкова\n");SendMsg(message,"Химия лекция\n");break;}
                                case 3:{SendMsg(message,"Выходные\n");break;}
                                case 4:{SendMsg(message,"Упражнение захаров\n");SendMsg(message,"Упр Рожкова\n");SendMsg(message,"Химия\n");break;}
                                case 5:{SendMsg(message,"-----\n");SendMsg(message,"------\n");SendMsg(message,"Ин.яз\n");break;}
                                case 6:{SendMsg(message,"Выходные");break;}
                                case 7:{SendMsg(message,"Выходные");break;}
                            }
                            break;
                        }
                        case "Расписание на сегодня": {
                            switch (nextDayOfWeek) {
                                case 1: {SendMsg(message,"-----\n");SendMsg(message,"Лекция Захаров\n");break;}
                                case 2: {SendMsg(message,"-----\n");SendMsg(message,"Лекция Рожкова\n");SendMsg(message,"Химия лекция\n");break;}
                                case 3:{SendMsg(message,"Выходные\n");break;}
                                case 4:{SendMsg(message,"Упражнение захаров\n");SendMsg(message,"Упр Рожкова\n");SendMsg(message,"Химия\n");break;}
                                case 5:{SendMsg(message,"-----\n");SendMsg(message,"------\n");SendMsg(message,"Ин.яз\n");break;}
                                case 6:{SendMsg(message,"Выходные");break;}
                                case 7:{SendMsg(message,"Выходные");break;}
                            }
                            break;
                        }
                        case "Сменить пользователя":{Person.SetPerson(null);SendMsg(message,"Выберите нового пользователя");break;}
                    }
                    break;
                }
                case "Пупсик":
                    {switch (update.getMessage().getText()) {
                    case "Расписание на завтра": {
                        switch (dayOfWeek) {
                            case 1: {SendMsg(message, "ИНО упр. к.1 Биленко\n");SendMsg(message,"ТММ лаб. 1-421 Сорокина\n"+"\n"+"ТММ упр. 1-421 Сорокина\n");SendMsg(message,"Основы геометрич. Моделир-ния лаб. 3-203 Орехов\n");SendMsg(message,"Учебная практика лаб. I 7-115 Васильчук\n");break;}
                            case 2: {SendMsg(message,"Глупышка у тебя выходной");break;}
                            case 3:{SendMsg(message,"ТММ лекц. 1-422 Сорокина\n");SendMsg(message,"Эл/техника лекц. 7-502 Фишер\n");SendMsg(message,"Электрон. Устр-ва МХТ И РТС лекц. 7-502 Мельников\n"+"\n"+"ТФКП И ОПЕР. ИСЧИСЛ. лекц. 7-504 Андриянов\n");break;}
                            case 4:{SendMsg(message,"-------\n"+"\n"+"Материаловедение лаб. II 4-320 Герасимова\n");SendMsg(message,"ТФКП и опер. Исчисл. Упр. 7-406 Андриянов\n");SendMsg(message,"Электрон. Устр-ва мхт и ртс лаб. 3-303 Петровичев\n");SendMsg(message,"Электротехника лаб. 3-212 Фишер\n"+"\n"+"Электротехника упр. 3-410 Фишер\n");break;}
                            case 5:{SendMsg(message,"Основы робототех. И МХТ лекц. 7-502 Романов\n"+"------\n");SendMsg(message,"М/ведение лекц. 4-220 Герасимова\n"+"\n"+"-----");SendMsg(message,"М/ведение лекц. 4-220 Герасимова");SendMsg(message,"-------"+"\n"+"Основы геометрич. Моделир-ния 7-502 Орехов\n");break;}
                            case 6:{SendMsg(message,"Основы робототех. и МХТ лаб. 7-115б Романов\n");SendMsg(message,"Физическая культура к.2\n");SendMsg(message,"------\n"+"\n"+"Русский язык и культура речи упр. 1-203 Логинова\n");break;}
                            case 7:{SendMsg(message,"Глупышка у тебя выходной");break;}
                        }
                        break;
                    }
                    case "Расписание на сегодня": {
                        switch (nextDayOfWeek) {
                            case 1: {SendMsg(message, "ИНО упр. к.1 Биленко\n");SendMsg(message,"ТММ лаб. 1-421 Сорокина\n"+"\n"+"ТММ упр. 1-421 Сорокина\n");SendMsg(message,"Основы геометрич. Моделир-ния лаб. 3-203 Орехов\n");SendMsg(message,"Учебная практика лаб. I 7-115 Васильчук\n");break;}
                            case 2: {SendMsg(message,"Глупышка у тебя выходной");break;}
                            case 3:{SendMsg(message,"ТММ лекц. 1-422 Сорокина\n");SendMsg(message,"Эл/техника лекц. 7-502 Фишер\n");SendMsg(message,"Электрон. Устр-ва МХТ И РТС лекц. 7-502 Мельников\n"+"\n"+"ТФКП И ОПЕР. ИСЧИСЛ. лекц. 7-504 Андриянов\n");break;}
                            case 4:{SendMsg(message,"-------\n"+"\n"+"Материаловедение лаб. II 4-320 Герасимова\n");SendMsg(message,"ТФКП и опер. Исчисл. Упр. 7-406 Андриянов\n");SendMsg(message,"Электрон. Устр-ва мхт и ртс лаб. 3-303 Петровичев\n");SendMsg(message,"Электротехника лаб. 3-212 Фишер\n"+"\n"+"Электротехника упр. 3-410 Фишер\n");break;}
                            case 5:{SendMsg(message,"Основы робототех. И МХТ лекц. 7-502 Романов\n"+"------\n");SendMsg(message,"М/ведение лекц. 4-220 Герасимова\n"+"\n"+"-----");SendMsg(message,"М/ведение лекц. 4-220 Герасимова");SendMsg(message,"-------"+"\n"+"Основы геометрич. Моделир-ния 7-502 Орехов\n");break;}
                            case 6:{SendMsg(message,"Основы робототех. и МХТ лаб. 7-115б Романов\n");SendMsg(message,"Физическая культура к.2\n");SendMsg(message,"------\n"+"\n"+"Русский язык и культура речи упр. 1-203 Логинова\n");break;}
                            case 7:{SendMsg(message,"Глупышка у тебя выходной");break;}
                        }
                        break;
                    }
                        case "Сменить пользователя":{Person.SetPerson(null);SendMsg(message,"Выберите нового пользователя");break;}
                    }
                    break;
                }
                case "Папочка":{
                    switch (update.getMessage().getText()) {
                        case "Расписание на завтра": {
                            switch (dayOfWeek) {
                                case 1: {SendMsg(message, "ФИЗ.-ХИМ. ОСНОВЫ М И НТ лаб. 3-213 Парамонов\n"+"\n"+"ТВ И МС упр. 7-404 Савотин");SendMsg(message,"ТВ И МС 7-404 Савотин\n");SendMsg(message,"ФИЗИЧЕСКАЯ КУЛЬТУРА к.2\n");SendMsg(message,"-----\n"+"\n"+"ФИЗ.-ХИМ. ОСНОВЫ М И НТ упр. 3-416 Ткаченко\n");break;}
                                case 2: {SendMsg(message,"ФИЗ.-ХИМ. ОСНОВЫ МИКРО- И Н/ТЕХНОЛОГИЙ лекц. 3-403 Андреев\n");SendMsg(message,"МАТЕМ. МОДЕЛИР. ТЕХ. ОБЪЕКТОВ лекц. 3-426 Шагаев\n");SendMsg(message,"МЕТРОЛ. И ТИ В ПРОИЗВ. ЭС лекц. 3-403 Адарчин\n"+"\n"+"ОКП лекц. 3-403 Адарчин");break;}
                                case 3:{SendMsg(message,"------\n");SendMsg(message,"ФИЗ. ОСНОВЫ МИКРОЭЛЕКТРОНИКИ лекц. 3-403 Столяров\n");SendMsg(message,"ФИЗИЧЕСКАЯ КУЛЬТУРА к.2\n");SendMsg(message,"СПЕЦГЛАВЫ ЭЛ/ТЕХНИКИ 4-204 Царькова\n");break;}
                                case 4:{SendMsg(message,"Учебная Военная Ебля");break;}
                                case 5:{SendMsg(message,"ИНО упр. 6-405 Журавлева, Тунанова\n");SendMsg(message,"ОКП упр. 3-416 Адарчин\n"+"\n"+"ФИЗ. ОСНОВЫ МИКРОЭЛ. лаб. 3-413 Шагаев");SendMsg(message,"ФИЗ. ОСНОВЫ МИКРОЭЛ. упр. 3-404 Шагаев\n"+"\n"+"---");break;}
                                case 6:{SendMsg(message,"МАТЕМ. МОДЕЛИР. ТЕХ. ОБЪЕКТОВ упр. 3-413 Шагаев\n");SendMsg(message,"СПЕЦГЛАВЫ ЭЛ/ТЕХНИКИ упр. 4-312 Царькова\n"+"\n"+"МЕТРОЛ. И ТИ В ПРОИЗВ. ЭС упр. 3-426 Лыков");SendMsg(message,"МЕТРОЛ. И ТИ В ПРОИЗВ. ЭС лаб. 3-416 Лыков\n" + "\n"+"---");break;}
                                case 7:{SendMsg(message,"Выходняра");break;}
                            }
                            break;
                        }
                        case "Расписание на сегодня": {
                            switch (nextDayOfWeek) {
                                case 1: {SendMsg(message, "ФИЗ.-ХИМ. ОСНОВЫ М И НТ лаб. 3-213 Парамонов\n"+"\n"+"ТВ И МС упр. 7-404 Савотин");SendMsg(message,"ТВ И МС 7-404 Савотин\n");SendMsg(message,"ФИЗИЧЕСКАЯ КУЛЬТУРА к.2\n");SendMsg(message,"-----\n"+"\n"+"ФИЗ.-ХИМ. ОСНОВЫ М И НТ упр. 3-416 Ткаченко\n");break;}
                                case 2: {SendMsg(message,"ФИЗ.-ХИМ. ОСНОВЫ МИКРО- И Н/ТЕХНОЛОГИЙ лекц. 3-403 Андреев\n");SendMsg(message,"МАТЕМ. МОДЕЛИР. ТЕХ. ОБЪЕКТОВ лекц. 3-426 Шагаев\n");SendMsg(message,"МЕТРОЛ. И ТИ В ПРОИЗВ. ЭС лекц. 3-403 Адарчин\n"+"\n"+"ОКП лекц. 3-403 Адарчин");break;}
                                case 3:{SendMsg(message,"------\n");SendMsg(message,"ФИЗ. ОСНОВЫ МИКРОЭЛЕКТРОНИКИ лекц. 3-403 Столяров\n");SendMsg(message,"ФИЗИЧЕСКАЯ КУЛЬТУРА к.2\n");SendMsg(message,"СПЕЦГЛАВЫ ЭЛ/ТЕХНИКИ 4-204 Царькова\n");break;}
                                case 4:{SendMsg(message,"Учебная Военная Ебля");break;}
                                case 5:{SendMsg(message,"ИНО упр. 6-405 Журавлева, Тунанова\n");SendMsg(message,"ОКП упр. 3-416 Адарчин\n"+"\n"+"ФИЗ. ОСНОВЫ МИКРОЭЛ. лаб. 3-413 Шагаев");SendMsg(message,"ФИЗ. ОСНОВЫ МИКРОЭЛ. упр. 3-404 Шагаев\n"+"\n"+"---");break;}
                                case 6:{SendMsg(message,"МАТЕМ. МОДЕЛИР. ТЕХ. ОБЪЕКТОВ упр. 3-413 Шагаев\n");SendMsg(message,"СПЕЦГЛАВЫ ЭЛ/ТЕХНИКИ упр. 4-312 Царькова\n"+"\n"+"МЕТРОЛ. И ТИ В ПРОИЗВ. ЭС упр. 3-426 Лыков");SendMsg(message,"МЕТРОЛ. И ТИ В ПРОИЗВ. ЭС лаб. 3-416 Лыков\n" + "\n"+"---");break;}
                                case 7:{SendMsg(message,"Выходняра");break;}
                            }
                            break;
                        }
                        case "Сменить пользователя":{Person.SetPerson(null);SendMsg(message,"Выберите нового пользователя");break;}
                    }

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
            SetButtons(sendMessage, Person);
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


    public void SetButtons(SendMessage sendMessage, Person Person) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        if (Person.GetPesrson() != null) {
            KeyboardRow keyboardFirstRow = new KeyboardRow();
            keyboardFirstRow.add(new KeyboardButton("Расписание на завтра"));
            keyboardFirstRow.add(new KeyboardButton("Расписание на сегодня"));

            KeyboardRow keyboardSecondRow = new KeyboardRow();
            keyboardSecondRow.add(new KeyboardButton("Сменить пользователя"));
        //    keyboardSecondRow.add(new KeyboardButton("Рассписание на любой день"));

           // KeyboardRow keyboardThirdRow = new KeyboardRow();
     //       keyboardThirdRow.add(new KeyboardButton("Поболтаем ?"));
            keyboardRowList.add(keyboardFirstRow);
            keyboardRowList.add(keyboardSecondRow);
         //   keyboardRowList.add(keyboardThirdRow);
        }
else {
            KeyboardRow keyboardFourRow = new KeyboardRow();
            keyboardFourRow.add(new KeyboardButton("Пупсик"));
            keyboardFourRow.add(new KeyboardButton("Папочка"));
            keyboardFourRow.add(new KeyboardButton("Дэн"));
            keyboardRowList.add(keyboardFourRow);
        }

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

