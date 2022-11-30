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
        quizModalArrayList.add(new QuizModal("How should you open the airway of an unconscious casualty?","Head tilt and chin lift","Jaw thrust","Head tilt and jaw thrust","Lift the chin","Head tilt and chin lift"));
        quizModalArrayList.add(new QuizModal("How long would you check to see if an unconscious casualty is breathing normally?","No more than 10 seconds","Approximately 10 seconds","Exactly 10 seconds","At least 10 seconds","No more than 10 seconds"));
        quizModalArrayList.add(new QuizModal("Which is the correct ratio of chest compressions to rescue breaths for use in CPR of an adult casualty?","2 compressions : 30 rescue breaths.","5 compressions : 1 rescue breath.","15 compressions : 2 rescue breaths.","30 compressions : 2 rescue breaths.","30 compressions : 2 rescue breaths."));
        quizModalArrayList.add(new QuizModal("You are a lone first aider and have an unconscious non-breathing adult, what should you do first?","Start CPR with 30 chest compressions.","Give five initial rescue breaths.","Call 911/112 requesting AED (defibrillator) and ambulance.","Give two initial rescue breaths.","Call 911/112 requesting AED (defibrillator) and ambulance."));
        quizModalArrayList.add(new QuizModal("What names are given to the three different depths of burns?","Small, medium and large.","First, second and third degree.","Minor, medium and severe.","Superficial, partial thickness, full thickness.","Superficial, partial thickness, full thickness."));
        quizModalArrayList.add(new QuizModal("What is a faint?","A response to fear.","An unexpected collapse.","A brief loss of consciousness.","A sign of flu.","A brief loss of consciousness."));
        quizModalArrayList.add(new QuizModal("What steps would you take to control bleeding from a nosebleed?","Sit casualty down, lean forward and pinch soft part of nose.","Sit casualty down, lean backward and pinch soft part of nose.","Lie casualty down and pinch soft part of nose.","Lie casualty down and pinch top of nose.","Sit casualty down, lean forward and pinch soft part of nose."));
        quizModalArrayList.add(new QuizModal("What is the first thing you should do for severe bleeding?","Put the victim in the recovery position","Direct pressure with clean cloth or hand","cover with a clean cloth","Give oxygen","Direct pressure with clean cloth or hand"));
        quizModalArrayList.add(new QuizModal("What is your FIRST action when examining the condition of a patient?","Check for breathing","Check for insurance","Speak to the victim and shake his shoulders","Check for external injuries.","Speak to the victim and shake his shoulders"));
        quizModalArrayList.add(new QuizModal("What do you do for a small cut?","Wash with soap and water, cover with a sterile bandage","Only cover with a sterile bandage","Clean the wound with cotton wool","None of the above", "Wash with soap and water, cover with a sterile bandage"));
        quizModalArrayList.add(new QuizModal("What is included in the CPR procedure?","Rescue breathing only","Compression of the chest only","Rescue breathing and chest compressions","None of the above","Rescue breathing and chest compressions"));
        quizModalArrayList.add(new QuizModal("What is the best treatment of second degree burn?","Put Aloe vera lotion on it","Water","Put ice on the burn","Put soap on it","Water"));
        quizModalArrayList.add(new QuizModal("How do you check for breathing?","Listen","Look for rising chest", "Feel with the cheek","Look, Listen to and Feel","Look, Listen to and Feel"));
        quizModalArrayList.add(new QuizModal("What do you do when someone breaks an arm?","Scream and run","Put plaster on it","Use an antiseptic wipe","Put the arm in a sling","Put the arm in a sling"));
        quizModalArrayList.add(new QuizModal("What are the symptoms of third-degree burn?","Charred skin, no pain","Charred skin, pain","Blisters and pain","Red and pain","Charred skin, no pain"));
        quizModalArrayList.add(new QuizModal("CPR is an emergency technique that combines artificial ventilation with chest compressions to help people with a cardiac arrest. What does it stand for?","Cardiopulmonary Recovery","Cardiopulmonary Resuscitation","Cardiopulmonary Revival","Cardiopulmonary Resurrection","Cardiopulmonary Resuscitation"));
        quizModalArrayList.add(new QuizModal("Which of the following is not the purposes of first aid?","To prevent further injury","To preserve life","To protect wounded areas","To promote recovery ","To protect wounded areas"));
        quizModalArrayList.add(new QuizModal("What is the first step to do when you sprain the ankle?","Rest with elevated leg","Massage the swollen area","Apply ice","Apply job","Apply ice"));
        quizModalArrayList.add(new QuizModal("When a person faints, which position should you put them to help with recovery?","Sit in a chair","Lay down with elevated legs","Lay flat","Standing position","Lay down with elevated legs"));
        quizModalArrayList.add(new QuizModal("Which of the following should not be applied to a sunburn?","Petroleum jelly","Moisturising lotion","Aloe vera gel","None of the above","Petroleum jelly"));
        quizModalArrayList.add(new QuizModal("What is the best way to check a patient’s circulation?","To check for noises, breathing, or eye movements","To punt the ear","To take the pulse","All of the above","To check for noises, breathing, or eye movements"));
        quizModalArrayList.add(new QuizModal("Who is considered to be the father of modern first aid?","Jerome Caluag","Zian Espiridion","Friedrich Esmarch","None of the above","Friedrich Esmarch"));
        quizModalArrayList.add(new QuizModal("Which one does not belong to the 3P's of first aid","Preserve life","Prevent further injury","Protect the unconscious","Promote recovery","Protect the unconscious"));
        quizModalArrayList.add(new QuizModal("What does the ABCD of first aid stand for?","Airway, Breathing, Circulation, Disability","Airplane, Bromance, Circumcision, Disabled","Accuracy, Body, Casualty , Damage","Armpit, Brain, Calf, Diaphragm","Airway, Breathing, Circulation, Disability"));
    }


}