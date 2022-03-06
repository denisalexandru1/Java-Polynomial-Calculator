package UI;

import com.sun.deploy.security.SelectableSecurityManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import Model.*;
import Logic.*;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view){
        this.model = model;
        this.view = view;

        view.addBtnListener(new AddBtnListener());
        view.subBtnListener(new SubBtnListener());
        view.mulBtnListener(new MulBtnListener());
        view.divBtnListener(new DivBtnListener());
        view.intBtnListener(new IntBtnListener());
        view.derBtnListener(new DerBtnListener());
    }

    class AddBtnListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String polynomial1 = view.getPoly1();
            String polynomial2 = view.getPoly2();
            //Logic.Polynomial blankPolynomial = new Logic.Polynomial();
            if(polynomial1.isEmpty() || polynomial2.isEmpty()){
                view.setRes("More input needed");
            }
            else{
            Polynomial p1 = new Polynomial();
            Polynomial p2 = new Polynomial();
            if(p1.checkVariable(polynomial1) && p2.checkVariable(polynomial2) && p1.checkType(polynomial1) && p2.checkType(polynomial2))
                {
                p1.string2poly(polynomial1);
                //p1 = Model.Model.addition(p1, blankPolynomial);
                //p1.toString();

                p2.string2poly(polynomial2);

            Polynomial res = Model.addition(p1, p2);
            view.setRes(res);}
            else {
                view.setRes("Wrong input for one of the polynomials");
                }
            }
        }
    }

    class SubBtnListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String polynomial1 = view.getPoly1();
            String polynomial2 = view.getPoly2();

            if(polynomial1.isEmpty() || polynomial2.isEmpty()){
                view.setRes("More input needed");
            }
            else{
            Polynomial p1 = new Polynomial();
            p1.string2poly(polynomial1);
            //p1.toString();
            Polynomial p2 = new Polynomial();
            p2.string2poly(polynomial2);

            Polynomial res = Model.subtraction(p1, p2);
            view.setRes(res);
            }
        }
    }

    class MulBtnListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String polynomial1 = view.getPoly1();
            String polynomial2 = view.getPoly2();

            if(polynomial1.isEmpty() || polynomial2.isEmpty()){
                view.setRes("More input needed");
            }
            else{
            Polynomial p1 = new Polynomial();
            p1.string2poly(polynomial1);
            //p1.toString();
            Polynomial p2 = new Polynomial();
            p2.string2poly(polynomial2);

            Polynomial res = Model.multiplication(p1, p2);
            view.setRes(res);
            }
        }
    }

    class DivBtnListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String polynomial1 = view.getPoly1();
            String polynomial2 = view.getPoly2();


            if(polynomial1.isEmpty() || polynomial2.isEmpty() || polynomial2.charAt(0) == '0'){
                view.setRes("More input needed");
            }
            else {
                Polynomial p1 = new Polynomial();
                p1.string2poly(polynomial1);
                //p1.toString();
                Polynomial p2 = new Polynomial();
                p2.string2poly(polynomial2);

                ArrayList<Polynomial> res = Model.division(p1, p2);

                view.setRes(res);
            }
        }
    }

    class IntBtnListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String polynomial1 = view.getPoly1();
            if(polynomial1.isEmpty())
                view.setRes("More input needed for the first polynomial");
            else {
                Polynomial p1 = new Polynomial();
                p1.string2poly(polynomial1);
                if (p1.toString().charAt(0) == '0' && p1.toString().length() == 1) {
                    view.setRes("C");
                } else {
                    Polynomial res = Model.integral(p1);
                    view.setRes(res);
                }
            }
        }
    }

    class DerBtnListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String polynomial1 = view.getPoly1();
            if(polynomial1.isEmpty())
                view.setRes("More input needed for the first polynomial");
            else {
                Polynomial p1 = new Polynomial();
                p1.string2poly(polynomial1);
                //p1.toString();
                Polynomial res = Model.derivative(p1);
                view.setRes(res);
            }
        }
    }
}
