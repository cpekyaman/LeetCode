package com.leetcode.problems.medium;

public class SolveEquation {
    private static final String INF = "Infinite solutions";
    private static final String NONE = "No solution";

    public static String solveEquation(String equation) {
        String[] parts = equation.split("=");
        String left=parts[0], right=parts[1];

        if(left.equals(right)) {
            return INF;
        }

        Eq lhs = parse(left), rhs = parse(right);
        if(lhs.coeff == rhs.coeff && lhs.constant == rhs.constant) {
            return INF;
        }

        // putting x on lhs and constants on rhs
        int coeff = lhs.coeff-rhs.coeff;
        int constant = rhs.constant-lhs.constant;

        // this means we have found that lhs=rhs cancelled each other in terms of x.
        // but there is a constant term remaining resulting in 0=<some_value>.
        if(coeff == 0) {
            return NONE;
        }

        return "x=" + constant / coeff;
    }

    private static Eq parse(String part) {
        StringBuilder curr = new StringBuilder();
        int sign=1, constant=0, coeff=0;
        for(int i=0; i<part.length(); i++) {
            char c = part.charAt(i);
            if(c == '-' || c == '+' || i == part.length()-1) {
                if(i == part.length()-1) {
                    curr.append(c);
                }
                if(curr.length() > 0) {
                    // either we add to coeff of x or we add to constant term
                    if(curr.indexOf("x") >= 0) {
                        coeff += sign * coeff(curr.toString());
                    } else {
                        constant += sign * Integer.parseInt(curr.toString());
                    }
                    curr = new StringBuilder();
                }
                // sign for the next expression (coeff or constant)
                sign = (c == '+' ? 1 : -1);
            } else {
                // continue building the token
                curr.append(c);
            }
        }

        return new Eq(coeff, constant);
    }

    private static int coeff(String x) {
        if(x.length() == 1 || ! Character.isDigit(x.charAt(0))) {
            return 1;
        }
        return Integer.parseInt(x.replace("x", ""));
    }

    // small helper represents the coefficient of x and the constant term on one side
    private static final class Eq {
        private int coeff;
        private int constant;

        Eq(int coeff, int constant) {
            this.coeff = coeff;
            this.constant = constant;
        }
    }

    public static void main(String[] args) {
        System.out.println(SolveEquation.solveEquation("x+5-3+x=6+x-2"));
        System.out.println(SolveEquation.solveEquation("2x=x"));
        System.out.println(SolveEquation.solveEquation("x=x"));
        System.out.println(SolveEquation.solveEquation("x=x+1"));
        System.out.println(SolveEquation.solveEquation("x=x+0"));
        System.out.println(SolveEquation.solveEquation("2x=x+0"));
        System.out.println(SolveEquation.solveEquation("2x=x+1"));
        System.out.println(SolveEquation.solveEquation("x=0"));
        System.out.println(SolveEquation.solveEquation("x+4=x-4"));
    }
}
