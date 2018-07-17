package pl.akademiakodu;

public enum AnswerEnum {

    TAK(true), tak(true),
    NIE(false), nie(false),
    no(false), yes(true);
    //odwołanie siędo metody poprzez metodę name();


    private boolean isCorrect;
    //automatycznie Enum ma name
    //dodatkowe atrybuty trzeba dorzucić

    AnswerEnum(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public static void main(String[] args) {

        //valueof zwraca nm zmienną typu AnswerEnum, na której możemy wywołać dodatkowe metody

        System.out.println(AnswerEnum.valueOf("nie").isCorrect());
        System.out.println(AnswerEnum.valueOf("yes").isCorrect());
        System.out.println(AnswerEnum.valueOf("NIE").isCorrect());
       // System.out.println(AnswerEnum.valueOf("dsa").isCorrect());
        // jak nie ma to zwraca wyjątek
        // IllegalArgumentException
    }
}
