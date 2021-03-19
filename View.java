package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;
import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.*;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.javarush.task.task32.task3209.MenuHelper.*;



public class View extends JFrame implements ActionListener {

    private Controller controller;

    // панель с двумя вкладками
    private JTabbedPane tabbedPane = new JTabbedPane();
    // компонент для визуального редактирования html
    private JTextPane htmlTextPane = new JTextPane();
    // компонент для редактирования html в виде текста
    private JEditorPane plainTextPane = new JEditorPane();

    // управляет списком UndoableEdits,
    // предоставляя возможность отменить или повторить соответствующие изменения
    private UndoManager undoManager = new UndoManager();
    // следит за правками, которые можно отменить или вернуть
    private UndoListener undoListener = new UndoListener(undoManager);

    public UndoListener getUndoListener() {
        return undoListener;
    }

    public View() {
        // Определение внешнего вида (look and fill):
        // Look and fill можно задать двумя различными способами:
        // указав полное имя класса для look and fill или создав экземпляр LookAndFeel и передав его setLookAndFeel.
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            ExceptionHandler.log(e);
        }
    }

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
    public void initMenuBar() {
        // новый объект типа JMenuBar (это и будет наша панель меню)
        JMenuBar menuBar = new JMenuBar();
        // инициализируем меню в следующем порядке:
        // Файл, Редактировать, Стиль, Выравнивание, Цвет, Шрифт и Помощь.
        initFileMenu(this, menuBar);
        initEditMenu(this, menuBar);
        initStyleMenu(this, menuBar);
        initAlignMenu(this, menuBar);
        initColorMenu(this, menuBar);
        initFontMenu(this, menuBar);
        initHelpMenu(this, menuBar);
        // добавил в верхнюю часть панели контента текущего фрейма нашу панель меню
        getContentPane().add(menuBar, BorderLayout.NORTH);
    }

    // инициализация панелей редактора
    public void initEditor() {
        // установил значение "text/html" в качестве типа контента для компонента htmlTextPane
        htmlTextPane.setContentType("text/html");
        // создал новый локальный компонент JScrollPane на базе htmlTextPane
        JScrollPane paneHTML = new JScrollPane(htmlTextPane);
        // добавил вкладку в панель tabbedPane с именем "HTML" и компонентом из предыдущего пункта
        tabbedPane.add("HTML", paneHTML);
        // создал новый локальный компонент JScrollPane на базе plainTextPane
        JScrollPane panePlain = new JScrollPane(plainTextPane);
        // добавил вкладку в панель tabbedPane с именем "Текст" и компонентом из предыдущего пункта.
        tabbedPane.add("Текст", panePlain);
        // установил предпочтительный размер панели tabbedPane
        tabbedPane.setPreferredSize(new Dimension());
        // добавил объект класса TabbedPaneChangeListener и устанавил его в качестве слушателя изменений в tabbedPane
        tabbedPane.addChangeListener(new TabbedPaneChangeListener(this));
        // добавил по центру панели контента текущего фрейма нашу панель с вкладками
        getContentPane().add(tabbedPane, BorderLayout.CENTER);
    }

    // инициализация графического интерфейса
    public void initGui() {
        initMenuBar();
        initEditor();
        // pack() - устанавливает такой минимальный размер контейнера, который достаточен для отображения всех компонентов
        // должен вызываться после добавления всех элементов, ибо, при расчёте размера окна,
        // он учитывает только ранее добавленные элементы а элементы добавленные позднее в расчёт не идут.
        pack();
    }

    // отменяет последнее действие
    public void undo() {
        try {
            undoManager.undo();
        } catch (CannotUndoException e) {
            ExceptionHandler.log(e);
        }
    }

    // возвращает ранее отмененное действие
    public void redo() {
        try {
            undoManager.redo();
        } catch (CannotRedoException e) {
            ExceptionHandler.log(e);
        }
    }

    // можем ли мы отменить действие
    public boolean canUndo() {
        return undoManager.canUndo();
    }

    // можем ли мы вернуть отмененное действие
    public boolean canRedo() {
        return undoManager.canRedo();
    }

    //  Он должен возвращать true, если выбрана вкладка, отображающая html в панели вкладок (подсказка: ее индекс 0).
    public boolean isHtmlTabSelected() {
        return tabbedPane.getSelectedIndex() == 0;
    }

    // сбрасывает все правки в менеджере undoManager
    public void resetUndo() {
        undoManager.discardAllEdits();
    }

    public void exit() {
        controller.exit();
    }

    public void selectedTabChanged() {
    }
}
