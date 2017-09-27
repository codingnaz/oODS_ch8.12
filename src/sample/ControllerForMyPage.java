package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.Scanner;

public class ControllerForMyPage {
    @FXML
    public Label quizOutput;
    @FXML
    public Label quizNumber;
    @FXML
    public TextField answerInput;
    @FXML
    public Button submit;
    @FXML
    public Label answerOutput;
    int score=0;
    int quizCount=0;
    String[] eList = new String[119];
    int elementNumber;

/*public void setup() throws FileNotFoundException {
    Scanner inputFile = new Scanner(new FileReader("periodic.txt.txt"));
    int lineCount = 0;


    while (inputFile.hasNext()) {
        //String element = inputFile.next();
        eList[lineCount] = inputFile.next();

        lineCount++;
    }
    answerOutput.setVisible(true);
    quizOutput.setVisible(true);
    quizCount=quizCount+1;
    int elementNumber= (int)(Math.random() * 118 + 1);
    quizNumber.setText(" Quiz Number: "+ (quizCount));
    quizOutput.setText("Which Element has periodic number "+ elementNumber+ "?");
    if(answerInput.getText().equals(returnElement(elementNumber))){
        score=score+1;

    }
    if(!answerInput.getText().equals(returnElement(elementNumber))){
        answerOutput.setText("Right answer was "+ returnElement(elementNumber));
        answerOutput.setTextFill(Color.RED);
        answerOutput.setVisible(true);

    }
    if (quizCount<11){
        answerOutput.setText("Your Score is "+ score+" out of 10");
        answerOutput.setTextFill(Color.GREEN);
        answerOutput.setVisible(true);
        score=0;
        quizCount=0;

    }



}*/
    public void startQuiz() throws FileNotFoundException {
        quizNumber.setVisible(true);


        quizOutput.setVisible(true);
        quizCount=quizCount+1;
        System.out.print(quizCount);
        System.out.println(" Score "+score);

        elementNumber= (int)(Math.random() * 118 );
        quizNumber.setText(" Quiz Number: "+ (quizCount));
        if(quizCount==1){
            answerOutput.setVisible(true);
        }
        if(quizCount>1){
            answerOutput.setVisible(false);
        }
        quizOutput.setText("Which Element has periodic number "+ elementNumber+ "?");
    }


    public void quizG() throws FileNotFoundException {


        if(answerInput.getText().equals(returnElement(elementNumber))){
            score=score+1;
            answerOutput.setVisible(false);

        }
        /*if(!answerInput.getText().equals(returnElement(elementNumber))){
            answerOutput.setText("Right answer was "+ returnElement(elementNumber));
            answerOutput.setTextFill(Color.RED);
            answerOutput.setVisible(true);

        }*/

        if (quizCount>9){
            answerOutput.setText("Your Score is "+ score+" out of 10");
            answerOutput.setTextFill(Color.GREEN);
            answerOutput.setVisible(true);
            score=0;
            quizCount=0;

        }

    startQuiz();

    }
    public String returnElement(int x) throws FileNotFoundException {
    try{
        Scanner inputFile = new Scanner(new File("periodic.txt.txt"));
        int lineCount = 0;


        while (inputFile.hasNext()) {
            //String element = inputFile.next();
            eList[lineCount] = inputFile.nextLine();

            lineCount++;

        }
    }catch (FileNotFoundException e){
        System.out.println("file not found");
    }

        return eList[x];



    }
}
