import Logic.Polynomial;
import Model.Model;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class ModelTest {
    Polynomial p1;
    Polynomial p2;

    @Test
    void addition1() {
        p1 = new Polynomial();
        p2 = new Polynomial();
        Polynomial res = new Polynomial();
        p1.string2poly("x^3");
        p2.string2poly("x^2");
        res.string2poly("x^3 + x^2");
        Assertions.assertEquals(res.toString(), Model.addition(p1, p2).toString());
    }
    @Test
    void addition2() {
        p1 = new Polynomial();
        p2 = new Polynomial();
        Polynomial res = new Polynomial();
        p1.string2poly("x^2 + x +1");
        p2.string2poly("-2x");
        res.string2poly("x^2 - x + 1");
        Assertions.assertEquals(res.toString(), Model.addition(p1, p2).toString());
    }
    @Test
    void addition3() {
        p1 = new Polynomial();
        p2 = new Polynomial();
        Polynomial res = new Polynomial();
        p1.string2poly("4x^3 - 3x^2 + 2");
        p2.string2poly("6x");
        res.string2poly("4x^3 - 3x^2 + 6x + 2");
        Assertions.assertEquals(res.toString(), Model.addition(p1, p2).toString());
    }
    @Test
    void addition4() {
        p1 = new Polynomial();
        p2 = new Polynomial();
        Polynomial res = new Polynomial();
        p1.string2poly("x^3 + x + 7");
        p2.string2poly("0");
        res.string2poly("x^3 + x + 7");
        Assertions.assertEquals(res.toString(), Model.addition(p1, p2).toString());
    }
    @Test
    void addition5() {
        p1 = new Polynomial();
        p2 = new Polynomial();
        Polynomial res = new Polynomial();
        p1.string2poly("-2x^3 + 6x^3");
        p2.string2poly("x^2");
        res.string2poly("4x^3 + x^2");
        Assertions.assertEquals(res.toString(), Model.addition(p1, p2).toString());
    }

    @Test
    void subtraction1() {
        p1 = new Polynomial();
        p2 = new Polynomial();
        Polynomial res = new Polynomial();
        p1.string2poly("x^3");
        p2.string2poly("x^2");
        res.string2poly("x^3 - x^2");
        Assertions.assertEquals(res.toString(), Model.subtraction(p1, p2).toString());
    }
    @Test
    void subtraction2() {
        p1 = new Polynomial();
        p2 = new Polynomial();
        Polynomial res = new Polynomial();
        p1.string2poly("x + x^2");
        p2.string2poly("x^3");
        res.string2poly("-x^3 + x^2 + x");
        Assertions.assertEquals(res.toString(), Model.subtraction(p1, p2).toString());
    }
    @Test
    void subtraction3() {
        p1 = new Polynomial();
        p2 = new Polynomial();
        Polynomial res = new Polynomial();
        p1.string2poly("x^3");
        p2.string2poly("-3x^3 + 2x - 5");
        res.string2poly("4x^3 - 2x + 5");
        Assertions.assertEquals(res.toString(), Model.subtraction(p1, p2).toString());
    }
    @Test
    void subtraction4() {
        p1 = new Polynomial();
        p2 = new Polynomial();
        Polynomial res = new Polynomial();
        p1.string2poly("x^3 + 1");
        p2.string2poly("-x^2 -5 + x");
        res.string2poly("x^3 + x^2 - x + 6");
        Assertions.assertEquals(res.toString(), Model.subtraction(p1, p2).toString());
    }
    @Test
    void subtraction5() {
        p1 = new Polynomial();
        p2 = new Polynomial();
        Polynomial res = new Polynomial();
        p1.string2poly("2");
        p2.string2poly("x^2 + 4x  - 5x^4 + 3x + 2");
        res.string2poly("5x^4 - x^2 - 7x");
        Assertions.assertEquals(res.toString(), Model.subtraction(p1, p2).toString());
    }

    @Test
    void multiplication1() {
        p1 = new Polynomial();
        p2 = new Polynomial();
        Polynomial res = new Polynomial();
        p1.string2poly("x^3 + 1");
        p2.string2poly("-x^2 -5 + x");
        res.string2poly("-5 + x - x^2 - 5 x^3 + x^4 - x^5");
        Assertions.assertEquals(res.toString(), Model.multiplication(p1, p2).toString());
    }

    @Test
    void multiplication2() {
        p1 = new Polynomial();
        p2 = new Polynomial();
        Polynomial res = new Polynomial();
        p1.string2poly("x^3 + 1");
        p2.string2poly("0");
        res.string2poly("0");
        Assertions.assertEquals(res.toString(), Model.multiplication(p1, p2).toString());
    }
    @Test
    void multiplication3() {
        p1 = new Polynomial();
        p2 = new Polynomial();
        Polynomial res = new Polynomial();
        p1.string2poly("x^3 + 1");
        p2.string2poly("-3x^2 + 5x -4");
        res.string2poly("-3 x^5 + 5 x^4 - 4 x^3 - 3 x^2 + 5 x - 4");
        Assertions.assertEquals(res.toString(), Model.multiplication(p1, p2).toString());
    }
    @Test
    void multiplication4() {
        p1 = new Polynomial();
        p2 = new Polynomial();
        Polynomial res = new Polynomial();
        p1.string2poly("x^3 + x^3 + 2");
        p2.string2poly("x^2 - x^2 + 1");
        res.string2poly("2x^3 + 2");
        Assertions.assertEquals(res.toString(), Model.multiplication(p1, p2).toString());
    }

    @Test
    void multiplication5() {
        p1 = new Polynomial();
        p2 = new Polynomial();
        Polynomial res = new Polynomial();
        p1.string2poly("-1 -3x + 4x^2");
        p2.string2poly("-4 +5x +5");
        res.string2poly("20 x^3 - 11 x^2 - 8 x - 1");
        Assertions.assertEquals(res.toString(), Model.multiplication(p1, p2).toString());
    }

    @Test
    void division1() {
        p1 = new Polynomial();
        p2 = new Polynomial();
        Polynomial q = new Polynomial();
        Polynomial r = new Polynomial();
        p1.string2poly("x^3 - 2x^2 + 6x -5");
        p2.string2poly(("x^2 -1"));
        q.string2poly("x-2");
        r.string2poly("7x - 7");

        Assertions.assertEquals(q.toString(), Model.division(p1, p2).get(0).toString());
        Assertions.assertEquals(r.toString(), Model.division(p1, p2).get(1).toString());

    }

    @Test
    void division2() {
        p1 = new Polynomial();
        p2 = new Polynomial();
        Polynomial q = new Polynomial();
        Polynomial r = new Polynomial();
        p1.string2poly("x^2 + 2x + 1");
        p2.string2poly(("x+1"));
        q.string2poly("x+1");
        r.string2poly("0");

        Assertions.assertEquals(q.toString(), Model.division(p1, p2).get(0).toString());
        Assertions.assertEquals(r.toString(), Model.division(p1, p2).get(1).toString());

    }

    @Test
    void division3() {
        p1 = new Polynomial();
        p2 = new Polynomial();
        Polynomial q = new Polynomial();
        Polynomial r = new Polynomial();
        p1.string2poly("x^3 + 1");
        p2.string2poly(("x + 1"));
        q.string2poly("x^2 - x + 1");
        r.string2poly("0");

        Assertions.assertEquals(q.toString(), Model.division(p1, p2).get(0).toString());
        Assertions.assertEquals(r.toString(), Model.division(p1, p2).get(1).toString());

    }

    @Test
    void division4() {
        p1 = new Polynomial();
        p2 = new Polynomial();
        Polynomial q = new Polynomial();
        Polynomial r = new Polynomial();
        p1.string2poly("x^2 + 1");
        p2.string2poly(("x^3"));
        q.string2poly("0");
        r.string2poly("x^2 + 1");

        Assertions.assertEquals(q.toString(), Model.division(p1, p2).get(0).toString());
        Assertions.assertEquals(r.toString(), Model.division(p1, p2).get(1).toString());

    }

    @Test
    void derivative1() {
        p1 = new Polynomial();
        p1.string2poly("3x^2 + 2x + 1");
        Polynomial res = new Polynomial();
        res.string2poly("6x + 2");
        Assertions.assertEquals(res.toString(), Model.derivative(p1).toString());
    }

    @Test
    void derivativ2() {
        p1 = new Polynomial();
        p1.string2poly("3x^4 + 2x + 1");
        Polynomial res = new Polynomial();
        res.string2poly("12x^3 + 2");
        Assertions.assertEquals(res.toString(), Model.derivative(p1).toString());
    }

    @Test
    void derivative3() {
        p1 = new Polynomial();
        p1.string2poly("x^3 - 2x^2 + 6x -5");
        Polynomial res = new Polynomial();
        res.string2poly("3x^2 - 4x + 6");
        Assertions.assertEquals(res.toString(), Model.derivative(p1).toString());
    }

    @Test
    void derivative4() {
        p1 = new Polynomial();
        p1.string2poly("4");
        Polynomial res = new Polynomial();
        res.string2poly("0");
        Assertions.assertEquals(res.toString(), Model.derivative(p1).toString());
    }

    @Test
    void derivative5() {
        p1 = new Polynomial();
        p1.string2poly("9x");
        Polynomial res = new Polynomial();
        res.string2poly("9");
        Assertions.assertEquals(res.toString(), Model.derivative(p1).toString());
    }

    @Test
    void integral1() {
        p1 = new Polynomial();
        p1.string2poly("3x^2 + 2x + 1");
        Polynomial res = new Polynomial();
        res.string2poly("x^3 + x^2 + x");
        Assertions.assertEquals(res.toString(), Model.integral(p1).toString());
    }

    @Test
    void integral2() {
        p1 = new Polynomial();
        p1.string2poly("5x^4 + 2x + 1");
        Polynomial res = new Polynomial();
        res.string2poly("x^5 + x^2 + x");
        Assertions.assertEquals(res.toString(), Model.integral(p1).toString());
    }


    @Test
    void integral4() {
        p1 = new Polynomial();
        p1.string2poly("4");
        Polynomial res = new Polynomial();
        res.string2poly("4x");
        Assertions.assertEquals(res.toString(), Model.integral(p1).toString());
    }

    @Test
    void integral5() {
        p1 = new Polynomial();
        p1.string2poly("10x");
        Polynomial res = new Polynomial();
        res.string2poly("5x^2");
        Assertions.assertEquals(res.toString(), Model.integral(p1).toString());
    }

}