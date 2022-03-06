package Logic;

public class Monomial implements Comparable<Monomial>{
    private Integer grade;
    private Double coef;

    public Monomial(Integer grade, Double coef) {
        this.grade = grade;
        this.coef = coef;
    }

    public Monomial(Monomial m){
        this.grade = m.getGrade();
        this.coef = m.getCoef();
    }

    @Override
    public String toString() {
        if (!this.getCoef().equals(0.0)) {
            if (this.getGrade()==0)
            {
                System.out.printf("%+.2f ", this.getCoef());
                return String.format("%+.2f ", this.getCoef());
            }
            else if(this.getGrade() == 1)
            {
                System.out.printf("%+.2fx ", this.getCoef());
                return String.format("%+.2fx ", this.getCoef());
            }
            else {
                System.out.printf("%+.2fx^%d ",this.getCoef(), this.getGrade());
                return String.format("%+.2fx^%d ",this.getCoef(), this.getGrade());
            }
            }
        return "";
    }
    public Integer getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Double getCoef() {
        return coef;
    }

    public void setCoef(Double coef) {
        this.coef = coef;
    }

    @Override
    public int compareTo(Monomial o) {
        return this.getGrade().compareTo(o.getGrade());
    }

}
