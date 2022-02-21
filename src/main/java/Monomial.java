public class Monomial {
    private int grade;
    private int coef;

    public Monomial(int grade, int coef) {
        this.grade = grade;
        this.coef = coef;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getCoef() {
        return coef;
    }

    public void setCoef(int coef) {
        this.coef = coef;
    }
}
