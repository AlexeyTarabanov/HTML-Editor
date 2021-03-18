package com.javarush.task.task32.task3209;

import javax.swing.*;
import java.awt.event.ActionListener;

// вспомогательный класс для инициализации и настройки меню
public class MenuHelper {

    public static JMenuItem addMenuItem(JMenu parent, String text, ActionListener actionListener) {
        // parent - меню в которое мы добавляем пункт,
        // text - текст добавляемого пункта,
        // actionListener - слушатель действий добавляемого пункта меню.

        // создал новый пункт меню JMenuItem
        JMenuItem textJMenu = new JMenuItem(text);
        // установил этому пункту слушателя действий
        textJMenu.addActionListener(actionListener);
        // в parent добавил созданный пункт меню
        parent.add(textJMenu);

        return textJMenu;
    }

    public static JMenuItem addMenuItem(JMenu parent, Action action) {
        // parent - меню в которое мы добавляем пункт,
        // action - действие, которое необходимо выполнить при выборе пункта меню

        JMenuItem actionJMenu = new JMenuItem(action);
        parent.add(actionJMenu);

        return actionJMenu;
    }

    public static JMenuItem addMenuItem(JMenu parent, String text, Action action) {
        JMenuItem jMenu = addMenuItem(parent, action);
        jMenu.setText(text);
        parent.add(jMenu);

        return jMenu;
    }

    // инициализация меню помощи
    public static void initHelpMenu(View view, JMenuBar menuBar) {}

    // инициализация меню выбора шрифта
    public static void initFontMenu(View view, JMenuBar menuBar) {}

    // инициализация меню выбора цвета
    public static void initColorMenu(View view, JMenuBar menuBar) {}

    // инициализация меню выравнивания
    public static void initAlignMenu(View view, JMenuBar menuBar) {}

    // инициализация меню выбора стиля текста
    public static void initStyleMenu(View view, JMenuBar menuBar) {}

    // инициализация меню редактирования текста
    public static void initEditMenu(View view, JMenuBar menuBar) {}

    // инициализация меню Файл
    public static void initFileMenu(View view, JMenuBar menuBar) {}
}
