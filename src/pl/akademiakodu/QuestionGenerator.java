package pl.akademiakodu;

import java.util.List;


//interfejs
public interface QuestionGenerator {


    //metoda, która ma zwracać nam listę pytań
    //w 'jakiś' sposób
    //ale w jaki to nie wiemy


    List<Question> generateQuestions();

    //tworzymy interfejs, żeby w sytuacji kiedy pytania pobieramy z innej bazy
    //lub z innego pliku można było podmienić tylko jedną linijkę a nie cały kod

}
