package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {

    private Controller controller;

    // панель с двумя вкладками
    private JTabbedPane tabbedPane = new JTabbedPane();
    // компонент для визуального редактирования html
    private JTextPane htmlTextPane = new JTextPane();
    // компонент для редактирования html в виде текста
    private JEditorPane plainTextPane = new JEditorPane();

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    // инициализирует
    public void init() {
        initGui();
        FrameListener listener = new FrameListener(this);
        // добавляем подписчика (регистрации слушателя)
        addWindowListener(listener);
        setVisible(true);
    }

    // инициализация меню
    public void initMenuBar() {}

    // инициализация панелей редактора
    public void initEditor() {}

    // инициализация графического интерфейса
    public void initGui() {
        initMenuBar();
        initEditor();
        // pack() - устанавливает такой минимальный размер контейнера, который достаточен для отображения всех компонентов
        // должен вызываться после добавления всех элементов, ибо, при расчёте размера окна,
        // он учитывает только ранее добавленные элементы а элементы добавленные позднее в расчёт не идут.
        pack();
    }

    public void exit() {
        controller.exit();
    }
}
