package menu;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import settings.*;

import java.util.List;
import java.util.ArrayList;

public class MenuBank {
    public static InlineKeyboardMarkup keyboardBanks(long chatId) {
        Setting userSetting = SetToJson.settings.get(chatId);
        Banks selectedBank = userSetting.getSelectedBank();
        List<List<InlineKeyboardButton>> keyboardMenuBanks = new ArrayList<>();
        List<InlineKeyboardButton> keyboardMSetRow1 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardMSetRow2 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardMSetRow3 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardMSetRow4 = new ArrayList<>();
        InlineKeyboardButton buttonPrivat = InlineKeyboardButton.builder()
                .text(Banks.PRIVAT.getBankNameEN() + getButtonStatus(Banks.PRIVAT, selectedBank))
                .callbackData(Banks.PRIVAT.getBankNameEN())
                .build();
        InlineKeyboardButton buttonNBU = InlineKeyboardButton.builder()
                .text(Banks.NBU.getBankNameEN() + getButtonStatus(Banks.NBU, selectedBank))
                .callbackData(Banks.NBU.getBankNameEN())
                .build();
        InlineKeyboardButton buttonMonobank = InlineKeyboardButton.builder()
                .text(Banks.MONO.getBankNameEN() + getButtonStatus(Banks.MONO, selectedBank))
                .callbackData(Banks.MONO.getBankNameEN())
                .build();
        InlineKeyboardButton buttonHome = InlineKeyboardButton.builder()
                .text(Buttons.BACK_TO_START.getName())
                .callbackData(Buttons.BACK_TO_START.getNameEN())
                .build();
        InlineKeyboardButton buttonBack = InlineKeyboardButton.builder()
                .text(Buttons.BACK_TO_SETTINGS.getName())
                .callbackData(Buttons.BACK_TO_SETTINGS.getNameEN())
                .build();
        keyboardMSetRow1.add(buttonPrivat);
        keyboardMSetRow2.add(buttonNBU);
        keyboardMSetRow3.add(buttonMonobank);
        keyboardMSetRow4.add(buttonHome);
        keyboardMSetRow4.add(buttonBack);
        keyboardMenuBanks.add(keyboardMSetRow1);
        keyboardMenuBanks.add(keyboardMSetRow2);
        keyboardMenuBanks.add(keyboardMSetRow3);
        keyboardMenuBanks.add(keyboardMSetRow4);

        return InlineKeyboardMarkup.builder().keyboard(keyboardMenuBanks).build();
    }

    private static java.lang.String getButtonStatus(Banks current, Banks selected) {
        if (current == selected) {
            return "✅";
        }
        return "";
    }
}
