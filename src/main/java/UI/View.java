package UI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import Model.*;
import Logic.*;

public class View extends JFrame{
    private JButton addBtn = new JButton("+");
    private JButton subBtn = new JButton("-");
    private JButton mulBtn = new JButton("*");
    private JButton divBtn = new JButton("/");
    private JButton derBtn = new JButton("Derivate");
    private JButton intBtn = new JButton("Integrate");

    private JTextField textFieldP1 = new JTextField(20);
    private JTextField textFieldP2 = new JTextField(20);
    private JTextField textFieldRes = new JTextField(20);

    private Model calcModel;

    public String getPoly1(){
        return textFieldP1.getText();
    }

    public String getPoly2(){
        return textFieldP2.getText();
    }

    //res pentru wrong input
    public void setRes(String res){
        textFieldRes.setText(res);
    }
    //res pentru rezultat
    public void setRes(Polynomial res){
        textFieldRes.setText(res.toString());
    }
    //res pentru impartire
    public void setRes(ArrayList<Polynomial> arrayList){
        String str = "Q: " + arrayList.get(0).toString() +" R: "+ arrayList.get(1).toString();
        textFieldRes.setText(str);
    }

    public void addBtnListener(ActionListener AddBtnListener){
        addBtn.addActionListener(AddBtnListener);
    }
    public void subBtnListener(ActionListener SubBtnListener){
        subBtn.addActionListener(SubBtnListener);
    }

    public void mulBtnListener(ActionListener MulBtnListener){
        mulBtn.addActionListener(MulBtnListener);
    }
    public void divBtnListener(ActionListener DivBtnListener){
        divBtn.addActionListener(DivBtnListener);
    }

    public void intBtnListener(ActionListener IntBtnListener){
        intBtn.addActionListener(IntBtnListener);
    }
    public void derBtnListener(ActionListener DerBtnListener){
        derBtn.addActionListener(DerBtnListener);
    }

    public View(Model model) {
        this.calcModel = model;

        JPanel panelP0 = new JPanel(new GridLayout(1, 0));
        JLabel labelP0 = new JLabel("Use X for variables");
        panelP0.add(labelP0);
        JPanel panelP1 = new JPanel(new GridLayout(2,1));
        JLabel labelP1 = new JLabel("First Logic.Polynomial (mandatory)");
        panelP1.add(labelP1);
        panelP1.add(textFieldP1);

        JPanel panelP2 = new JPanel(new GridLayout(2,1));
        JLabel labelP2 = new JLabel("Second Logic.Polynomial (optional)");
        panelP2.add(labelP2);
        panelP2.add(textFieldP2);
        //panelP2.setVisible(true);

        JPanel panelRes = new JPanel(new GridLayout(2,1));
        JLabel labelRes = new JLabel("Result");
        panelRes.add(labelRes);
        panelRes.add(textFieldRes);

        JPanel polyPanels = new JPanel(new GridLayout(4,1));
        polyPanels.add(panelP0);
        polyPanels.add(panelP1);
        polyPanels.add(panelP2);
        polyPanels.add(panelRes);

        Dimension btnDimension = new Dimension(90, 90);
        addBtn.setPreferredSize(btnDimension);
        subBtn.setPreferredSize(btnDimension);
        mulBtn.setPreferredSize(btnDimension);
        divBtn.setPreferredSize(btnDimension);
        intBtn.setPreferredSize(btnDimension);
        derBtn.setPreferredSize(btnDimension);

        JPanel topPanel = new JPanel(new GridLayout(1, 3));
        JPanel botPanel = new JPanel(new GridLayout(1, 3));

        topPanel.add(addBtn);
        topPanel.add(mulBtn);
        topPanel.add(intBtn);
        botPanel.add(subBtn);
        botPanel.add(divBtn);
        botPanel.add(derBtn);

        JPanel finalPanel = new JPanel(new BorderLayout());
        finalPanel.add(polyPanels, BorderLayout.NORTH);
        finalPanel.add(topPanel, BorderLayout.CENTER);
        finalPanel.add(botPanel, BorderLayout.SOUTH);
        finalPanel.setBorder(new EmptyBorder(20,50,20,50));
        //finalPanel.setVisible(true);
        this.setContentPane(finalPanel);
        this.pack();
        this.setTitle("Logic.Polynomial Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
