package pl.akademiakodu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class Main extends JFrame implements ActionListener {

    //ma zawierać pytanie
    //ma zawierać 2 przyciski tak i nie

    private JButton buttonYes;
    private JButton buttonNo;
    private JLabel labelQuestion;



    //zmienna, która jest typu interfejsowego
    //co oznacza że musi to tej zmiennej przekazać klasę
    //która będzie implementowała interfejs Question Generator
    //mówimy ogólnie o typie, ale nie mówi konkretnie oe klasie
    //podajemy kategorię, do której będzie należała klasa
    private QuestionGenerator questionGenerator;
    private int currentQuestion;
    private int numberOfPoints =0;


    //lista pytań
    private List<Question> questionsList = new ArrayList<>();

    public void setQuestionGenerator(QuestionGenerator questionGenerator) {
        //ustawiamy zmienną z 21 linijki na tą, która jest podana w argumencie metody
        this.questionGenerator = questionGenerator;
        //tutaj zakładamy, że już mamy obiekt jakiejś klasy
        //na etapie pisania kodu nie wiemy kompletnie jaka to będzie klasa
        //tylko wiemy, że musi implementować interfejs QuestionGenerator
        //wypełniamy listę pytaniami, które są generowane za pomocą metody generateQuestions
        questionsList=questionGenerator.generateQuestions();
    }






    public Main() {
        super("Milionerzy");   //ustawia tytuł okna
        createDefaultComponents();
        //this wskazuje na obiekt, w którym jest
        //na rzecz którego w tym momencie wołany jest konstruktor
        //Listener ma być obiekt Main, czyli okno
        add(labelQuestion); //dodajemy do framr naszą label
        add(buttonYes); //dodajemy do frame przycisk Tak
        add(buttonNo); // -||-                       Nie
        setLayout((new GridLayout(3,1))); //układ naszego okna, 3 w pionie, 1 w poziomie


    }

    private void createDefaultComponents() {
        setSize(500,500);           //ustawia wielkość okna
        setDefaultCloseOperation(1);//sprawia, że działa przylcisk exit
        setVisible(true);           //widoczność okna



        setQuestionGenerator( new FileGenerator());


        //ustawiamy konkretną klasę, która będzie generować nam pytania
        //za pomocą new NazwaKlasy możemy podmienić nasz generator za pomocą 1 linijki kodu!


        buttonYes= new JButton("Tak");
        buttonNo= new JButton("Nie");
        labelQuestion=new JLabel(questionsList.get(0).getContent(),0);

        buttonYes.addActionListener(this);
        buttonNo.addActionListener(this);
    }

    public static void main(String[] args) {
	// write your code here

        //odpalenie okna w wątku
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //stworzeniee nowej zmiennej typu Main = nowego okna
                Main main = new Main();
                //konstruktor tworzy nowy obiekt, dlatego jesteśmy w obiekcie Main
            }
        });



    }

    //ta metoda jest wywołana gdy klikniemy na przycisk, albo Tak, albo Nie
    @Override
    public void actionPerformed(ActionEvent e) {

        if (currentQuestion <questionsList.size()){
            JButton clickedButton = (JButton) e.getSource();
            Question currentQuestion = questionsList.get(this.currentQuestion);
            if (clickedButton==buttonYes
                    && currentQuestion.isCorrect()
                    ) {
                numberOfPoints++;
            }
            if (clickedButton==buttonNo
                    && !currentQuestion.isCorrect()
                    ) {
                numberOfPoints++;
            }

        }

        if(questionsList.size()>currentQuestion+1) {
            labelQuestion.setText(questionsList.get(++currentQuestion).getContent());
        } else {
            JOptionPane.showMessageDialog(this,"Koniec quizu zdobyłeś "+numberOfPoints+" punktów");
            buttonNo.setEnabled(false);
            buttonYes.setEnabled(false);
        }
        System.out.println("Kliknięto mnie!");

    }
}
