package pl.akademiakodu;

//klasa question, która jest odpowiedzialna za przechowywanie konkretnego pytania
//pytanie ma opcję tak, alob nie
public class Question {

    //treść pytania
    private String content;
    //czy TAK jest poprawne
    private boolean isCorrect;

    //konstruktor 2 parametrowy
    public Question(String content, boolean isCorrect) {
        this.content = content;
        this.isCorrect = isCorrect;
    }


    //getter otrzymuje dane
    public String getContent() {
        return content;
    }

    //setter, zmienia treść pytania
    public void setContent(String content) {
        this.content = content;
    }

    //getter dla booleana
    public boolean isCorrect() {
        return isCorrect;
    }

    //setter dla booleana
    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    @Override //podpowiedź dla kompilatora
    public String toString() {
        return "Question{" +
                "content='" + content + '\'' +
                ", isCorrect=" + isCorrect +
                '}';
    }
}
