public class Main {
    public static void main(String[] args) {
        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial();

        Monomial m1 = new Monomial(1, 2);
        Monomial m2 = new Monomial(2, 3);
        Monomial m3 = new Monomial(4, 5);
        Monomial m4 = new Monomial(2, 4);
        Monomial m5 = new Monomial(3, 8);

        p1.monomialArrayList.add(m5);
        p1.monomialArrayList.add(m2);
        p1.monomialArrayList.add(m1);
        p2.monomialArrayList.add(m3);
        p2.monomialArrayList.add(m4);

        p1.toString();
        p2.toString();

        Polynomial rez = p1.addition(p1, p2);
        rez.toString();
    }
}
