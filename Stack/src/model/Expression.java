package model;

import java.util.*;

import javax.swing.JOptionPane;

public class Expression {

    public static double evaluateExpression(String expression) {
        Stack<Double> operandStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (Character.isDigit(ch)) {
                StringBuilder numStr = new StringBuilder();
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    numStr.append(expression.charAt(i));
                    i++;
                }
                i--;
                operandStack.push(Double.parseDouble(numStr.toString()));
            } else if (ch == '(') {
                operatorStack.push(ch);
            } else if (ch == ')') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    performOperation(operandStack, operatorStack);
                }
                operatorStack.pop();
            } else if (isOperator(ch)) {
                while (!operatorStack.isEmpty() && operatorPrecedence(operatorStack.peek()) >= operatorPrecedence(ch)) {
                    performOperation(operandStack, operatorStack);
                }
                operatorStack.push(ch);
            } else if (Character.isLetter(ch)) {
                StringBuilder funcName = new StringBuilder();
                while (i < expression.length() && Character.isLetter(expression.charAt(i))) {
                    funcName.append(expression.charAt(i));
                    i++;
                }
                i--;
                if (funcName.toString().equals("sin")) {
                    operatorStack.push('s'); 
                }
            }
        }

        while (!operatorStack.isEmpty()) {
            performOperation(operandStack, operatorStack);
        }

        return operandStack.pop();
    }

    public static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    public static int operatorPrecedence(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0;
    }

    public static void performOperation(Stack<Double> operandStack, Stack<Character> operatorStack) {
        char op = operatorStack.pop();
        if (op == 's') {
            double operand = operandStack.pop();
            operandStack.push(Math.sin(Math.toRadians(operand)));
        } else {
            double rightOperand = operandStack.pop();
            double leftOperand = operandStack.pop();
            switch (op) {
                case '+':
                    operandStack.push(leftOperand + rightOperand);
                    break;
                case '-':
                    operandStack.push(leftOperand - rightOperand);
                    break;
                case '*':
                    operandStack.push(leftOperand * rightOperand);
                    break;
                case '/':
                    operandStack.push(leftOperand / rightOperand);
                    break;
            }
        }
    }
    
    public static void main(String[] args) {
        String text = JOptionPane.showInputDialog(null, "Ingrese la expresión matemática: ");

        double result = evaluateExpression(text);
        JOptionPane.showMessageDialog(null, "Resultado: " + result);
    }
}