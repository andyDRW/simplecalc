package com.example.andy.simplecalc;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Stack;

/**
 * Created by andy on 21.07.15.
 */
public class ReversePolishNotation {
        private String mInputDefinition;
        private ArrayList <String> mReverseDefenition;
        //mAnswer - computing result
        private float mAnswer;
        //stores input definition in array
        private char[] mDefinitionArray;
        private HashMap<Character, Integer> mOperations;
        //mError == true if input string isn't correct
        private boolean mError;
        //creates Reverse Polish Notation object from input string
        public ReversePolishNotation(String input){
                mError =false;
                mAnswer =0;
                mInputDefinition = new String(input);
                mDefinitionArray = mInputDefinition.toCharArray();
                mOperations =new HashMap<Character,Integer>();
                mOperations.put('(', 2);
                mOperations.put('*', 1);
                mOperations.put('/', 1);
                mOperations.put('+', 0);
                mOperations.put('-', 0);
        }

        //changes to reverse definition
        public void toReverseDefinition(){
                StringBuilder currentNumber= new StringBuilder("");
                boolean whereDigit=false;
                boolean negative=false;
                Stack stack= new Stack();
                mReverseDefenition = new ArrayList <String>();
                try{
                        for(char currentChar: mDefinitionArray) {
                                if (Character.isDigit(currentChar) || (currentChar == '.')) {
                                   currentNumber.append(currentChar);
                                    whereDigit = true;
                                }
                                else {
                                        if ((currentChar == '-') && (!whereDigit)) {
                                        negative = true;
                                        }
                                        else {
                                                if (currentNumber.length() > 0) {
                                                        if (negative) {
                                                                mReverseDefenition.add("-" + currentNumber.toString());
                                                                negative = false;
                                                        }
                                                        else {
                                                                mReverseDefenition.add(currentNumber.toString());
                                                        }
                                                        currentNumber.setLength(0);
                                                }
                                                if (currentChar == '(') {
                                                        stack.push(currentChar);
                                                }
                                                else {
                                                        if (currentChar == ')') {
                                                            while (stack.peek() != '(') {
                                                                mReverseDefenition.add(stack.pop().toString());
                                                            }
                                                            stack.pop();
                                                        }
                                                        else {
                                                                if (stack.size() == 0) {
                                                                        stack.push(currentChar);
                                                                }
                                                                else {
                                                                        if (mOperations.get(stack.peek()).compareTo(mOperations.get(currentChar)) <= 0) {
                                                                                mReverseDefenition.add(stack.pop().toString());
                                                                                stack.push(currentChar);
                                                                        }
                                                                        else {
                                                                                stack.push(currentChar);
                                                                        }
                                                                }
                                                        }
                                                        whereDigit = false;
                                                }
                                        }
                                }
                        }
                }
                catch(EmptyStackException e){
                       mError =true;
                }
                if(currentNumber.length()>0) {
                        if(negative) {
                                mReverseDefenition.add("-" + currentNumber.toString());
                                negative=false;
                        }
                        else {
                               mReverseDefenition.add(currentNumber.toString());
                               currentNumber.setLength(0);
                        }
                }
                while (stack.size()>0){
                        mReverseDefenition.add(stack.pop().toString());
                }

        }
        //getting last computed result
        public float getAnswer(){
                return mAnswer;
        }

        public boolean isError(){
            return mError;
        }
        //computing and return result

        public float Calc(){
                Stack stack= new Stack();
                float firstOperand, secondOperand;
                float operand;
                String num= mReverseDefenition.get(0);
                boolean wasOperation=false;
                for(String element: mReverseDefenition){
                        try{
                                operand=(float)Double.parseDouble(element);
                                stack.push(operand);
                        }
                        catch(NumberFormatException nfe){
                                try {
                                        secondOperand=(float)stack.pop();
                                        firstOperand = (float) stack.pop();
                                        switch (element) {
                                        case "-":
                                                mAnswer = firstOperand - secondOperand;
                                        break;
                                        case "+":
                                                mAnswer = firstOperand + secondOperand;
                                        break;
                                        case "*":
                                                mAnswer = firstOperand * secondOperand;
                                        break;
                                        case "/":
                                                mAnswer = firstOperand / secondOperand;
                                        break;
                                        }
                                        stack.push(mAnswer);
                                }
                                catch (EmptyStackException ex) {
                                        mError =true;
                                        mAnswer =Float.NaN;
                                }
                        }
                        wasOperation=true;
                }
                if(!wasOperation){
                        mAnswer =(float)Double.parseDouble(num);
                }
                return mAnswer;
        }
}
