package pl.akademiakodu;

import java.util.ArrayList;
import java.util.List;

public class SimpleQuestionGenerator implements QuestionGenerator {

    //klasa, która implementuje interfejs
    //dzięki temu może być traktowna jako typ SimpleQuestionGenerator
    //ale też jako typ questionGenerator


    //implementowanie tej metody
    @Override
    public List<Question> generateQuestions() {

        List<Question> questionList = new ArrayList<>();

        questionList.add(new Question("Czy Polska leży w Europie?",true));
        questionList.add(new Question("Czy 2+5=8?",false));
        questionList.add(new Question("Czy 2^10=1024?",true));
        questionList.add(new Question("Czy Chopi urodził się w Warszawie?",false));
    return questionList;
    }
}
