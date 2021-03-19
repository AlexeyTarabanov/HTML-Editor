package com.javarush.task.task32.task3209;

import javax.swing.text.html.HTMLDocument;
import java.io.File;

/**
 HTML Editor

 Шаг 1.
 1. Создал классы Controller и View.
 2. В классе Controller:
  - добавил поля View view (отвечающие за представление), HTMLDocument document (модель)
    и File currentFile (будет отвечать за файл, который сейчас открыт в нашем редакторе (текущий файл))
  - добавил конструктор с полем View
  - добавил метод main()
 3. Класс View:
  - наследуется от JFrame и реализовывает интерфейс ActionListener
  - имплементировал метод actionPerformed()
  - добавил поле Controller controller, а также сеттер и геттер к нему.

 Шаг 2.
 1. В классы Controller и View добавил методы init(), пока без реализаций
 2. В классе Controller, в методе main:
  - создал объект представления (объект класса View)
  - создал контроллер (объект класса Controller)
  - установил у представления контроллер (view.setController(controller))
  - инициализировал представление (init)
  - инициализировал контроллер (init)
 3. В классе Controller:
  - создал и реализовал метод exit()
 4. В классе:
  - оздал и реализовал метод exit()

 Шаг 3.
 1. В классе View:
  добавил поля:
  - JTabbedPane tabbedPane - панель с двумя вкладками
  - JTextPane htmlTextPane - компонент для визуального редактирования html. Он будет размещен на первой вкладке.
  - JEditorPane plainTextPane - компонент для редактирования html в виде текста, он будет отображать код html (теги и их содержимое)
 2. Создал пакет listeners, в него добавил класс FrameListener.
  Унаследовал его от WindowAdapter
 3. В классе FrameListener:
  - добавил поле View view
  - добавил конструктор с полем View

  Шаг 4.
  1. В классе View:
  объявил методы:
   - initMenuBar() - инициализация меню
   - initEditor() - инициализация панелей редактора
  2. Объявил и реализовал метод initGui() - инициализация графического интерфейса
  3. Реализовал метод init()

 Шаг 5.
 1. В пакете listeners:
  - объявил класс TabbedPaneChangeListener реализующий интерфейс ChangeListener
 2. В классе View:
  - добавил метод selectedTabChanged()
 3. В классе TabbedPaneChangeListener:
  - добавил поле View view и конструктор с этим полем
  - реализовал метод stateChanged()
 4. Создал класс ExceptionHandler, в нем создал и реализовал метод log(Exception e)

 Шаг 6.
 1. В классе View реализовал метод initEditor()

 Шаг 7.
 1. Создал класс MenuHelper
 (вспомогательный класс для инициализации и настройки меню)
 2. Объявил и реализовал методы:
  - addMenuItem(JMenu parent, String text, ActionListener actionListener)
  - addMenuItem(JMenu parent, Action action)
  - addMenuItem(JMenu parent, String text, Action action)
 3. Создал методы:
  - initHelpMenu(View view, JMenuBar menuBar) - инициализация меню помощи
  - initFontMenu(View view, JMenuBar menuBar) - инициализация меню выбора шрифта
  - initColorMenu(View view, JMenuBar menuBar) - инициализация меню выбора цвета
  - initAlignMenu(View view, JMenuBar menuBar) - инициализация меню выравнивания
  - initStyleMenu(View view, JMenuBar menuBar) - инициализация меню выбора стиля текста
  - initEditMenu(View view, JMenuBar menuBar) - инициализация меню редактирования текста
  - initFileMenu(View view, JMenuBar menuBar) - инициализация меню Файл

 Шаг 8.
 1. Создал пакет actions,
    в нем создал заглушки для следующих классов:
  - класс отмены действия - UndoAction.
  - класс возврата действия - RedoAction
  - класс StrikeThroughAction - отвечает за стиль текста "Зачеркнутый"
  - класс SubscriptAction - отвечает за стиль текста "Подстрочный знак"
  - класс SuperscriptAction - отвечает за стиль "Надстрочный знак"
 2. В пакете listeners, создал заглушки для следующих классов:
  - класс UndoMenuListener
  - класс TextEditMenuListener

 Шаг 9.
 1. В классе View
  - реализовал метод initMenuBar()
  - создал конструктор, который устанавливает внешний вид и поведение (look and feel) нашего приложения такими же,
  как это определено в системе

 Шаг 10.
 1. В классе UndoMenuListener
  - реализовал метод menuSelected(), который делает доступными или не доступными пункты меню undoMenuItem и redoMenuItem
 2. В классе View создал заглушки для следующих методов
  - canUndo() - можем ли мы отменить действие
  - canRedo() - можем повторить

 Шаг 11.
 1. В классе View:
  - добавил поле UndoManager undoManager и проинициализировал его
  - добавил поле UndoListener undoListener и проинициализировал его. Добавил геттер
  Добавил и реализовал методы:
  - void undo() - отменяет последнее действие
  - void redo() - возвращает ранее отмененное действие
  - void resetUndo() - сбрасывает все правки в менеджере undoManager
  Реализовал методы:
  - canUndo() и canRedo()
 2. В пакете listeners:
  - создал класс UndoListener реализующий интерфейс UndoableEditListener
  (класс будет следить за правками, которые можно отменить или вернуть)
 3. В классе UndoListener:
  - добавил поле UndoManager undoManager и конструктор с этим полем
  - реализовал метод undoableEditHappened(UndoableEditEvent e)

 Шаг 12.
 1. В классе RedoAction:
  - реализовал метод actionPerformed(ActionEvent actionEvent)
 2. В классе UndoAction:
  - реализовал метод actionPerformed(ActionEvent e)
 3. Реализовал классы SubscriptAction и SuperscriptAction

 Шаг 13.
 1. В пакете listeners:
  - реализовал класс TextEditMenuListener
 2. В классе View:
  - добавил метод boolean isHtmlTabSelected()

 Шаг 14.
 1.

 */

public class Controller {

    // представление
    private View view;
    // модель
    private HTMLDocument document;
    // текущий файл
    private File currentFile;

    public Controller(View view) {
        this.view = view;
    }

    // инициализирует
    public void init() {}

    public void exit() {
        // exit - используется для завершения программы.
        // Этот метод на вход принимает значение типа int.
        // Обычно это 0, что говорит о том, что программа завершается без ошибок.
        // Любое другое значение говорит о том, что программа завершилась с ошибкой
        System.exit(0);
    }

    public static void main(String[] args) {

        View view = new View();
        Controller controller = new Controller(view);

        view.setController(controller);
        view.init();
        controller.init();
    }
}
