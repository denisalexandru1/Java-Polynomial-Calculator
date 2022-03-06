package Logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import Model.*;

public class Polynomial {
    public ArrayList<Monomial> monomialArrayList = new ArrayList<>();

    public String toString() {
        String newString = new String();
        if (this.monomialArrayList.size() == 0){
            System.out.println(0);
        return "0";
        }
        for (Monomial i : this.monomialArrayList){
            newString += " " + i.toString();
            //System.out.print(i.getCoef() + "x^" + i.getGrade() + " " );
        }
        System.out.println();
        //newString = newString.replaceFirst("\\+", "");
        return newString;
    }

    public Polynomial sortPoly(){
        Collections.sort(this.monomialArrayList, Collections.reverseOrder());
        return this;
    }

    public Integer getMaxGrade(){
        this.sortPoly();
        return this.monomialArrayList.get(0).getGrade();
    }

    public void removeZero() {
        Polynomial auxPolynomial = new Polynomial();
        for (Monomial i : this.monomialArrayList) {
            if (!i.getCoef().equals(0.0))
                auxPolynomial.monomialArrayList.add(i);
        }
        this.monomialArrayList = auxPolynomial.monomialArrayList;
    }

    public void removeDuplicates(){
        Polynomial auxPolynomial = new Polynomial();
        for(Monomial i: this.monomialArrayList){
            Polynomial auxPolynomial2 = new Polynomial();
            auxPolynomial2.monomialArrayList.add(i);
            auxPolynomial = Model.additionForDupliicates(auxPolynomial2, auxPolynomial);
        }
        this.monomialArrayList = auxPolynomial.monomialArrayList;
    }

    public static Monomial generateMonomial(String[] stringAux) {
        Monomial monom = new Monomial(0, 0.0);
        if (!stringAux[0].isEmpty()) {
            if (stringAux.length == 1) {
                String anotherAux = stringAux[0];
                char ch = anotherAux.charAt(anotherAux.length() - 1);
                if ((65 <= ch && ch <= 90) || (97 <= ch && ch <= 122)) {
                    monom.setGrade(1);
                    if (anotherAux.substring(0, anotherAux.length() - 1).length() == 0) monom.setCoef(1.0);
                    else {
                        if (anotherAux.substring(0, anotherAux.length() - 1).equals("-")) monom.setCoef(-1.0);
                        else monom.setCoef(Double.parseDouble(anotherAux.substring(0, anotherAux.length() - 1)));
                    }
                } else {
                    monom.setGrade(0);
                    monom.setCoef(Double.parseDouble(anotherAux));
                }
            } else {
                monom.setGrade(Integer.parseInt(stringAux[1]));
                String anotherAux = stringAux[0];
                if (anotherAux.substring(0, anotherAux.length() - 1).length() == 0) monom.setCoef(1.0);
                else {
                    if (anotherAux.substring(0, anotherAux.length() - 1).equals("-")) monom.setCoef(-1.0);
                    else monom.setCoef(Double.parseDouble(anotherAux.substring(0, anotherAux.length() - 1)));
            }
            }
        }
        return monom;
    }

    public void string2poly(String polyString) {
        Polynomial polinom = new Polynomial();
        polyString = polyString.replaceAll("\\s+", "");
        polyString = polyString.replaceAll("\\-", "+-");
        String[] stringformatat = polyString.split("\\+");
        Monomial monom = new Monomial(0, 0.0);
        for (String s : stringformatat) {
            String[] stringAux = s.split("\\^");
            monom = Polynomial.generateMonomial(stringAux);
            polinom.monomialArrayList.add(new Monomial(monom.getGrade(), monom.getCoef()));
        }
        polinom.sortPoly();
        polinom.removeZero();
        this.monomialArrayList = polinom.monomialArrayList;
    }

    public boolean checkVariable(String polyString){
        polyString = polyString.replaceAll("\\s+", "");
        polyString = polyString.toLowerCase();
        System.out.println("aici "+polyString);
        String patternString = "[a-zA-Z]";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(polyString);
        ArrayList<String> stringArrayList = new ArrayList<>();
        while (matcher.find()) {
            if(!stringArrayList.contains(matcher.group(0)))
                stringArrayList.add(matcher.group(0));
        }
        if((stringArrayList.size() == 1 &&  stringArrayList.get(0).equals("x")) || stringArrayList.size()==0)
            return true;
        return false;
    }

    public boolean checkType(String polyString){
        polyString = polyString.replaceAll("\\s+", "");
        polyString = polyString.toLowerCase();
        if(polyString.charAt(0) != '-')
            polyString = "+" + polyString;
        String[] stringformatat = polyString.split("[-+][0-9]*([a-zA-Z](\\^[0-9]*)?)?\n");
        for(String s : stringformatat){
            if(s.isEmpty())
                return false;
        }
        return true;
    }
}

