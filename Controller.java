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

    public static void main(String[] args) {

    }
}
