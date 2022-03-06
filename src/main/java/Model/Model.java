package Model;

import Logic.Monomial;
import Logic.Polynomial;

import java.util.ArrayList;

public class Model {

    public static Polynomial addition(Polynomial p1, Polynomial p2) {
        Polynomial rez = new Polynomial();
        p1.sortPoly();
        p2.sortPoly();

        //p1.toString();
        //p2.toString();
        for (Monomial i : p1.monomialArrayList) {
            rez.monomialArrayList.add(i);
        }
        for (Monomial i : p2.monomialArrayList) {
            int ok = 0;
            for (Monomial j : rez.monomialArrayList) {
                if (j.getGrade() == i.getGrade()) {
                    j.setCoef(j.getCoef() + i.getCoef());
                    ok = 1;
                }
            }
            if (ok == 0)
                rez.monomialArrayList.add(i);
        }
        rez.removeZero();
        rez.removeDuplicates();
        rez.sortPoly();
        return rez;
    }

    public static Polynomial additionForDupliicates(Polynomial p1, Polynomial p2) {
        Polynomial rez = new Polynomial();
        p1.sortPoly();
        p2.sortPoly();

        for (Monomial i : p1.monomialArrayList) {
            rez.monomialArrayList.add(i);
        }
        for (Monomial i : p2.monomialArrayList) {
            int ok = 0;
            for (Monomial j : rez.monomialArrayList) {
                if (j.getGrade() == i.getGrade()) {
                    j.setCoef(j.getCoef() + i.getCoef());
                    ok = 1;
                }
            }
            if (ok == 0)
                rez.monomialArrayList.add(i);
        }
        rez.removeZero();
        rez.sortPoly();
        return rez;
    }

    public static Polynomial subtraction(Polynomial p1, Polynomial p2) {
        Polynomial rez = new Polynomial();
        p1.sortPoly();
        p2.sortPoly();
        //p1.toString();
        //p2.toString();
        for (Monomial i : p1.monomialArrayList) {
            rez.monomialArrayList.add(i);
        }
        for (Monomial i : p2.monomialArrayList) {
            int ok = 0;
            for (Monomial j : rez.monomialArrayList) {
                if (j.getGrade() == i.getGrade()) {
                    j.setCoef(j.getCoef() - i.getCoef());
                    ok = 1;
                }
            }
            if (ok == 0) {
                i.setCoef(-i.getCoef());
                rez.monomialArrayList.add(i);
            }
        }
        rez.removeZero();
        rez.removeDuplicates();
        rez.sortPoly();
        return rez;
    }

    public static Polynomial multiplication(Polynomial p1, Polynomial p2) {
        Polynomial rez = new Polynomial();
        p1.sortPoly();
        p2.sortPoly();
        //p1.toString();
        //p2.toString();

        for (Monomial i : p1.monomialArrayList) {
            for (Monomial j : p2.monomialArrayList) {
                Monomial temp = new Monomial(i.getGrade() + j.getGrade(), i.getCoef() * j.getCoef());
                Polynomial tempP = new Polynomial();
                tempP.monomialArrayList.add(temp);
                rez = Model.addition(rez, tempP);
            }
        }
        rez.sortPoly();
        rez.removeDuplicates();
        return rez;
    }


    public static ArrayList<Polynomial> division(Polynomial p1, Polynomial p2) {
        Polynomial quotient = new Polynomial();
        Polynomial blankPolynomial = new Polynomial();
        p1.sortPoly();
        p2.sortPoly();

        while (p1.monomialArrayList.size() != 0 && p1.getMaxGrade() >= p2.getMaxGrade()) {
            Monomial i = p2.monomialArrayList.get(0);
            Polynomial temp = new Polynomial();
            Monomial j = new Monomial(p1.monomialArrayList.get(0));
            if (j.getGrade() >= i.getGrade()) {
                Monomial tempM = new Monomial(0, 0.0);
                tempM.setCoef(j.getCoef() / i.getCoef());
                tempM.setGrade(j.getGrade() - i.getGrade());
                temp.monomialArrayList.add(tempM);
            } else break;
            Polynomial auxPolynomial = Model.multiplication(p2, temp);
            auxPolynomial = Model.subtraction(blankPolynomial, auxPolynomial);
            quotient = Model.addition(quotient, temp);
            p1 = Model.addition(p1, auxPolynomial);
        }
        ArrayList<Polynomial> finalRes = new ArrayList<>();
        finalRes.add(quotient);
        finalRes.add(p1);
        //System.out.println("Q "+quotient);
        //System.out.println("R "+p1);
        return finalRes;
    }

    public static Polynomial derivative(Polynomial p1) {
        Polynomial rez = new Polynomial();
        p1.sortPoly();
        p1.toString();

        for (Monomial i : p1.monomialArrayList) {
            if (i.getGrade() != 0) {
                Monomial temp = new Monomial(i.getGrade() - 1, i.getCoef() * i.getGrade());
                rez.monomialArrayList.add(temp);
            }
        }
        rez.sortPoly();
        rez.removeDuplicates();
        return rez;
    }

    public static Polynomial integral(Polynomial p1) {
        Polynomial rez = new Polynomial();
        p1.sortPoly();
        p1.toString();

        for (Monomial i : p1.monomialArrayList) {
            Monomial temp = new Monomial(0, 0.0);
            if (i.getGrade() != 0) {
                temp = new Monomial(i.getGrade() + 1, i.getCoef() / (i.getGrade()+1));
            } else {
                temp = new Monomial(1, i.getCoef());
            }
            rez.monomialArrayList.add(temp);
        }

        rez.sortPoly();
        rez.removeDuplicates();
        return rez;
    }

    //public boolean isStringOK(String s){

    //}


}