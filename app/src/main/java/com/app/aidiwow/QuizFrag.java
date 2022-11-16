package com.app.aidiwow;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class QuizFrag extends Fragment {


    private TextView questions, questionNum;
    private Button btnOption1,btnOption2,btnOption3,btnOption4;
    private ArrayList<QuizModal> quizModalArrayList;
    Random random;
    int currentScore = 0, questionNumber = 0, currentPos;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quiz,container,false);

        questions = view.findViewById(R.id.idQuestions);
        questionNum = view.findViewById(R.id.idQuestionNum);
        btnOption1 = view.findViewById(R.id.idOption1);
        btnOption2 = view.findViewById(R.id.idOption2);
        btnOption3 = view.findViewById(R.id.idOption3);
        btnOption4 = view.findViewById(R.id.idOption4);
        quizModalArrayList = new ArrayList<QuizModal>();
        random = new Random();

        getQuizQuestion(quizModalArrayList);
        currentPos=random.nextInt(quizModalArrayList.size());
        setDataToViews(currentPos);

        btnOption1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(btnOption1.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionNumber++;
                currentPos=random.nextInt(quizModalArrayList.size());
                setDataToViews(currentPos);
            }
        });
        btnOption2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(btnOption2.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionNumber++;
                currentPos=random.nextInt(quizModalArrayList.size());
                setDataToViews(currentPos);
            }
        });

        btnOption3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(btnOption3.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionNumber++;
                currentPos=random.nextInt(quizModalArrayList.size());
                setDataToViews(currentPos);
            }
        });

        btnOption4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(btnOption4.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionNumber++;
                currentPos=random.nextInt(quizModalArrayList.size());
                setDataToViews(currentPos);
            }
        });

        return view;
    }
    private void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(getActivity());
        View bottomSheetView = LayoutInflater.from(getActivity().getApplicationContext()).inflate(R.layout.score_bottom_sheet,(LinearLayout)getView().findViewById(R.id.ScoreBS));
        TextView score = bottomSheetView.findViewById(R.id.idScore);
        Button restartQuiz = bottomSheetView.findViewById(R.id.idRestart);
        score.setText("Your Score is\n"+currentScore+"/10");
        restartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentPos = random.nextInt(quizModalArrayList.size());
                setDataToViews(currentPos);
                questionNumber=0;
                currentScore=0;
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }

    private void setDataToViews(int currentPos){
        questionNum.setText("Question #"+questionNumber+"/10");
        if(questionNumber == 10){
            showBottomSheet();
        }
        else {
            questions.setText(quizModalArrayList.get(currentPos).getQuestion());
            btnOption1.setText(quizModalArrayList.get(currentPos).getOption1());
            btnOption2.setText(quizModalArrayList.get(currentPos).getOption2());
            btnOption3.setText(quizModalArrayList.get(currentPos).getOption3());
            btnOption4.setText(quizModalArrayList.get(currentPos).getOption4());
        }
    }
    private void getQuizQuestion(ArrayList<QuizModal> quizModalArrayList) {
        quizModalArrayList.add(new QuizModal("May tuhod ba ang jos?","YES","NO","Maybe","All of the above","All of the above"));
        quizModalArrayList.add(new QuizModal("Am I under the water?","YES","NO","Maybe","All of the above","All of the above"));
        quizModalArrayList.add(new QuizModal("Totoo ba jonas?","YES","NO","Maybe","All of the above","All of the above"));
        quizModalArrayList.add(new QuizModal("Bakit ba ikaw ang nasa isip ko at di na mawala wala pa? Kahit na alam ko na ang puso mo ay may mahal na ngang iba~","YES","NO","Maybe","All of the above","All of the above"));
        quizModalArrayList.add(new QuizModal("Ang alin?","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.","Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.","Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.","All of the above","All of the above"));
    }


}