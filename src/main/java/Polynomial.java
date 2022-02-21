import java.util.ArrayList;

public class Polynomial {
    public ArrayList<Monomial> monomialArrayList = new ArrayList<>();

    public String toString() {
        for (Monomial i : monomialArrayList) {
            System.out.println(i.getCoef() + "^" + i.getGrade() + " ");
        }
        return "final";
    }

    public Polynomial addition(Polynomial p1, Polynomial p2){
        Polynomial rez = new Polynomial();
        for (Monomial i: p1.monomialArrayList) {
            rez.monomialArrayList.add(i);
        }
        //copie la polinoamele 1 si 2??? 
        for(Monomial i: rez.monomialArrayList){
            int ok=0;
            Monomial temp;
            for(Monomial j: p2.monomialArrayList){
                if (j.getGrade()==i.getGrade()) {
                    i.setCoef(j.getCoef() + i.getCoef());
                    //rez.monomialArrayList.get().setCoef(j);
                    ok = 1;
                }
            }
            //if(ok==0)
             //   rez.monomialArrayList.add(j);
        }
    return rez;
    }

    public Polynomial subtraction(Polynomial p1, Polynomial p2){
        Polynomial rez = new Polynomial();
        for (Monomial i: p1.monomialArrayList) {
            rez.monomialArrayList.add(i);
        }

        for(Monomial i: p2.monomialArrayList){
            int ok=0;
            for(Monomial j: rez.monomialArrayList){
                if (j.getGrade()==i.getGrade()) {
                    j.setCoef(j.getCoef() - i.getCoef());
                    ok = 1;
                }
            }
            if(ok==0) {
                i.setCoef(-i.getCoef());
                rez.monomialArrayList.add(i);
            }
        }
    return rez;
    }
}
