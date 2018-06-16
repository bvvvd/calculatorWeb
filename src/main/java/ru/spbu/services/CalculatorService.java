package ru.spbu.services;

import ru.spbu.exception.IllegalExpressionException;

import java.util.*;

public class CalculatorService {

    static class ExpressionParser {
        private static String operators = "+-*/";
        private static String delimiters = "() " + operators;
        public static boolean flag = true;

        private static boolean isDelimiter(String token) {
            if (token.length() != 1) return false;
            for (int i = 0; i < delimiters.length(); i++) {
                if (token.charAt(0) == delimiters.charAt(i)) return true;
            }
            return false;
        }

        private static boolean isOperator(String token) {
            if (token.equals("u-")) return true;
            for (int i = 0; i < operators.length(); i++) {
                if (token.charAt(0) == operators.charAt(i)) return true;
            }
            return false;
        }

        private static boolean isFunction(String token) {
            if (token.equals("sqrt") || token.equals("cube") || token.equals("pow10")) return true;
            return false;
        }

        private static int priority(String token) {
            if (token.equals("(")) return 1;
            if (token.equals("+") || token.equals("-")) return 2;
            if (token.equals("*") || token.equals("/")) return 3;
            return 4;
        }

        public static List<String> parse(String infix) throws IllegalExpressionException {
            List<String> postfix = new ArrayList<>();
            Deque<String> stack = new ArrayDeque<>();
            StringTokenizer tokenizer = new StringTokenizer(infix, delimiters, true);
            String prev = "";
            String curr = "";
            while (tokenizer.hasMoreTokens()) {
                curr = tokenizer.nextToken();
                if (!tokenizer.hasMoreTokens() && isOperator(curr)) {
                    throw new IllegalExpressionException("your input is invalid, check your expression");
                }
                if (curr.equals(" ")) continue;
                if (isFunction(curr)) stack.push(curr);
                else if (isDelimiter(curr)) {
                    if (curr.equals("(")) stack.push(curr);
                    else if (curr.equals(")")) {
                        while (!stack.peek().equals("(")) {
                            postfix.add(stack.pop());
                            if (stack.isEmpty()) {
                                throw new IllegalExpressionException("your input is invalid, check your brackets");
                            }
                        }
                        stack.pop();
                        if (!stack.isEmpty() && isFunction(stack.peek())) {
                            postfix.add(stack.pop());
                        }
                    } else {
                        if (curr.equals("-") && (prev.equals("") || (isDelimiter(prev) && !prev.equals(")")))) {
                            // унарный минус
                            curr = "u-";
                        } else {
                            while (!stack.isEmpty() && (priority(curr) <= priority(stack.peek()))) {
                                postfix.add(stack.pop());
                            }

                        }
                        stack.push(curr);
                    }

                } else {
                    postfix.add(curr);
                }
                prev = curr;
            }

            while (!stack.isEmpty()) {
                if (isOperator(stack.peek())) postfix.add(stack.pop());
                else {
                    throw new IllegalExpressionException("your input is invalid, check your brackets");
                }
            }
            return postfix;
        }
    }

    static class Ideone {
        public Double calc(List<String> postfix) {
            Deque<Double> stack = new ArrayDeque<>();
            for (String x : postfix) {
                if (x.equals("sqrt")) stack.push(Math.sqrt(stack.pop()));
                else if (x.equals("cube")) {
                    Double tmp = stack.pop();
                    stack.push(tmp * tmp * tmp);
                } else if (x.equals("pow10")) stack.push(Math.pow(10, stack.pop()));
                else if (x.equals("+")) stack.push(stack.pop() + stack.pop());
                else if (x.equals("-")) {
                    Double b = stack.pop(), a = stack.pop();
                    stack.push(a - b);
                } else if (x.equals("*")) stack.push(stack.pop() * stack.pop());
                else if (x.equals("/")) {
                    Double b = stack.pop(), a = stack.pop();
                    stack.push(a / b);
                } else if (x.equals("u-")) stack.push(-stack.pop());
                else stack.push(Double.valueOf(x));
            }
            return stack.pop();
        }
    }

    public static double calculate(String expression) throws IllegalExpressionException {
        try {
            List<String> polka = ExpressionParser.parse(expression);
            return new Ideone().calc(polka);
        } catch (NumberFormatException e) {
            throw new IllegalExpressionException("illegal symbols in expression");
        }

    }
}