import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Polynomial p1 = new Polynomial();
        //Polynomial p2 = new Polynomial();
        /*
        Monomial m1 = new Monomial(0, -5.0);
        Monomial m2 = new Monomial(1, 6.0);
        Monomial m3 = new Monomial(2, -2.0);
        Monomial m4 = new Monomial(3, 1.0);
        Monomial m5 = new Monomial(0, -1.0);
        Monomial m6 = new Monomial(2, 1.0);
        p1.monomialArrayList.add(m1);
        p1.monomialArrayList.add(m2);
        p1.monomialArrayList.add(m4);
        p1.monomialArrayList.add(m3);
        p2.monomialArrayList.add(m5);
        p2.monomialArrayList.add(m6);
        */


/*

        p1.monomialArrayList.add(new Monomial(2, 7.0));
        p1.monomialArrayList.add(new Monomial(1, 3.0));
        p1.monomialArrayList.add(new Monomial(0, 2.0));

        p2.monomialArrayList.add(new Monomial(2, 2.0));
        p2.monomialArrayList.add(new Monomial(1, 1.0));

        Polynomial rez2 = Model.addition(p1, p2);
        rez2.toString();*/
        /*
        p1.sortPoly();
        p2.sortPoly();
        p1.toString();
        p2.toString();
        ArrayList<Polynomial> rez = new ArrayList<>();
        rez = Model.division(p1, p2);

        rez.get(0).toString();
        rez.get(1).toString();

*/
        Model model = new Model();
        View view = new View(model);
        Controller controller = new Controller(model, view);
        view.setVisible(true);
        //String test = "5X^5 + 3X^2 + 4X - 1";
        //Polynomial p3 = new Polynomial();
        //p3.string2poly(test);
        //p3.toString();
    }
}

