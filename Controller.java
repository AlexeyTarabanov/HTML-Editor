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
