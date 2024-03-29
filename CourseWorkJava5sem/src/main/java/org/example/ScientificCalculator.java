package org.example;

import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.util.List;

/**
 * @author Koroliov P.I.
 * @version 1.0
 *
 * Class for finding the answer.
 */
public class ScientificCalculator extends JFrame implements ActionListener {
    private int flag = 0;
    private char sign;
    private String name = "0";
    private String num = "0";
    private double sum = 0;
    private double num1 = 0;
    private double num2 = 0;
    private double memory = 0;
    /**
     * Method for history of operations
     *
     * @return list about operations
     */
    List<String> history = new ArrayList<String>();

    JTextField t = new JTextField();
    JPanel mypanel = new JPanel();
    JPanel panel = new JPanel();

    JFrame frame = this;
    JFileChooser fileChooser;

    /**
     * Set properties of Calculator.
     */
    public ScientificCalculator() {
        //Menubar: ==================
        setSize(400, 400);
        JMenuBar jmbrBar = new JMenuBar();
        JMenu jmnuFile = new JMenu("File");
        JMenu jmnuOption = new JMenu("Option");
        JMenu jmnuHelp = new JMenu("Help");
        JMenuItem jmnuitMinimize = new JMenuItem("Minimize");
        JMenuItem jmnuExit = new JMenuItem("Exit");
        JMenuItem jmnuitAboutProgram = new JMenuItem("About Program");
        JMenuItem jmnuitAboutAuthor = new JMenuItem("About Author");
        JMenuItem jmnuitScientific = new JMenuItem("Scientific Calculator");
        JMenuItem jmnuitSimple = new JMenuItem("Basic Calculator");
        JMenuItem jmnuitFileAdd = new JMenuItem("Add to file");

        jmnuitMinimize.setBorder(BorderFactory.createRaisedBevelBorder());
        jmnuExit.setBorder(BorderFactory.createRaisedBevelBorder());
        jmnuitAboutProgram.setBorder(BorderFactory.createRaisedBevelBorder());
        jmnuitAboutAuthor.setBorder(BorderFactory.createRaisedBevelBorder());
        jmnuitScientific.setBorder(BorderFactory.createRaisedBevelBorder());
        jmnuitSimple.setBorder(BorderFactory.createRaisedBevelBorder());
        jmnuitFileAdd.setBorder(BorderFactory.createRaisedBevelBorder());
        jmnuFile.setBorder(BorderFactory.createRaisedBevelBorder());
        jmnuOption.setBorder(BorderFactory.createRaisedBevelBorder());
        jmnuHelp.setBorder(BorderFactory.createRaisedBevelBorder());

        jmbrBar.add(jmnuFile);
        jmbrBar.add(jmnuOption);
        jmbrBar.add(jmnuHelp);
        jmnuOption.add(jmnuitScientific);
        jmnuOption.add(jmnuitSimple);
        jmnuFile.add(jmnuitMinimize);
        jmnuFile.add(jmnuExit);
        jmnuHelp.add(jmnuitAboutProgram);
        jmnuHelp.add(jmnuitAboutAuthor);
        jmnuFile.add(jmnuitFileAdd);

        jmnuitMinimize.addActionListener(this);
        jmnuitSimple.addActionListener(this);
        jmnuitScientific.addActionListener(this);
        jmnuExit.addActionListener(this);
        jmnuitAboutProgram.addActionListener(this);
        jmnuitAboutAuthor.addActionListener(this);
        jmnuitFileAdd.addActionListener(this);

        //TextField: ===============================
        t.setEditable(false);
        t.setBackground(new Color(210, 230, 224));
        t.setPreferredSize(new Dimension(80, 50));
        t.setFont(new Font("Tahoma", 4, 26));
        t.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));

        // ============================
        setLocation(350, 150);
        setJMenuBar(jmbrBar);
        BorderLayout mybl = new BorderLayout();
        setLayout(mybl);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        add(t, BorderLayout.NORTH);

        fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
        fileChooser.setFileFilter(filter);

        setTitle("Calculator");
        //Panel: ================
        panel.setLayout(new GridLayout(5, 4, 3, 3));
        panel.setBackground(Color.LIGHT_GRAY);
        String Button = "ACCx²√789+456-123×0.=÷";
        int i;
        for (i = 0; i < Button.length(); i++) {
            if (i == 0) {
                name = Button.substring(i, i + 2);
                i++;
            } else if (i == 3) {
                name = Button.substring(i, i + 2);
                i += 1;
            } else {
                name = Button.substring(i, i + 1);
            }
            JButton b = new JButton(name);
            panel.add(b);
            b.setFont(new Font("Tahoma", 4, 17));
            b.addActionListener(this);
            b.setBackground(new Color(240, 240, 240));
            b.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(Color.GRAY, Color.LIGHT_GRAY), BorderFactory.createRaisedBevelBorder()));
        }
        add(panel, BorderLayout.CENTER);

        //MyPanel: =====================
        mypanel.setLayout(new GridLayout(6, 6, 3, 3));
        mypanel.setBackground(Color.LIGHT_GRAY);
        String Buttons = "-C--------√---789----456----123=+--0-.±×÷-";
        for (i = 0; i < Buttons.length(); i++) {
            if (i == 0)
                name = "AC";
            else if (i == 2)
                name = "MC";
            else if (i == 3)
                name = "MR";
            else if (i == 4)
                name = "MS";
            else if (i == 5)
                name = "M+";
            else if (i == 6)
                name = "M-";
            else if (i == 7)
                name = "x²";
            else if (i == 8)
                name = "x³";
            else if (i == 9)
                name = "xⁿ";
            else if (i == 11)
                name = "sin";
            else if (i == 12)
                name = "sinh";
            else if (i == 13)
                name = "asin";
            else if (i == 17)
                name = "ⁿ√x";
            else if (i == 18)
                name = "cos";
            else if (i == 19)
                name = "cosh";
            else if (i == 20)
                name = "acos";
            else if (i == 24)
                name = "¹/x";
            else if (i == 25)
                name = "tan";
            else if (i == 26)
                name = "tanh";
            else if (i == 27)
                name = "atan";
            else if (i == 34)
                name = "mod";
            else if (i == 36)
                name = "00";
            else if (i == 41)
                name = "log";
            else
                name = Buttons.substring(i, i + 1);
            JButton b = new JButton(name);
            mypanel.add(b);
            b.setFont(new Font("Tahoma", 4, 17));
            b.addActionListener(this);
            b.setBackground(new Color(240, 240, 240));
            b.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(Color.GRAY, Color.LIGHT_GRAY), BorderFactory.createRaisedBevelBorder()));
        }
        setVisible(true);
    }

    /*
     * Method for messaging about Exception
     * @param String messages - message about exception
     */
    public void validation(String messages) {
        JOptionPane.showMessageDialog(null, messages);
    }


    private void trigonometry(String s) {
        if (s.equals("sin"))
            sum = Math.sin((num1 * Math.PI) / 180);
        else if (s.equals("cos"))
            sum = Math.cos((num1 * Math.PI) / 180);
        else if (s.equals("tan"))
            sum = Math.tan((num1 * Math.PI) / 180);
        else if (s.equals("asin"))
            sum = Math.asin(num1);
        else if (s.equals("acos"))
            sum = Math.acos(num1);
        else if (s.equals("atan"))
            sum = Math.atan(num1);
        else if (s.equals("sinh"))
            sum = Math.sinh(num1);
        else if (s.equals("cosh"))
            sum = Math.cosh(num1);
        else if (s.equals("tanh"))
            sum = Math.tanh(num1);
        else if (s.equals("log"))
            sum = Math.log10(num1);
    }


    private void memory(String s) {
        if (s.equals("MR")) {
            num = String.valueOf(memory);
            t.setText(num2 + "");
            num = "0";
        } else if (s.equals("MS")) {
            num2 = memory;
            //num=t.getText();
            memory = Double.parseDouble(num);
            num = String.format(Locale.US, "%.10g%n", memory);
            t.setText(num2 + "");
        } else if (s.equals("MC")) {
            memory = 0;
        } else if (s.equals("M+")) {
            num = t.getText();
            memory += Double.parseDouble(num);
            num = "0";
        } else if (s.equals("M-")) {
            //num = t.getText();
            memory -= Double.parseDouble(num);
            num = "0";
        }
    }

    /**
     * Method for basic operations
     */
    double basicOperations() {
        if (sign == '+') {
            sum = num1 + num2;
            history.add("" + num1 + sign + num2 + "=" + sum);
        } else if (sign == '-') {
            sum = num1 - num2;
            history.add("" + num1 + sign + num2 + "=" + sum);
        } else if (sign == '×') {
            sum = num1 * num2;
            history.add("" + num1 + sign + num2 + "=" + sum);
        } else if (sign == '÷') {
            if (num2 == 0) {
                validation("Деление на ноль невозможно");
            } else {
                sum = num1 / num2;
                history.add("" + num1 + sign + num2 + "=" + sum);
            }
        } else if (sign == 'x') {
            sum = Math.pow(num1, num2);
            history.add("" + num1 + sign + num2 + "=" + sum);
        } else if (sign == 'ⁿ') {
            sum = Math.pow(num1, 1 / num2);
            history.add("" + num1 + sign + num2 + "=" + sum);
        } else if (sign == 'm') {
            sum = num1 % num2;
            history.add("" + num1 + sign + num2 + "=" + sum);
        }
        num1 = sum;
        if (sum == (int) sum) {
            num = String.valueOf(sum);
            num = num.substring(0, num.length() - 2);
        } else {
            num = String.format(Locale.US, "%.10g%n", sum);
            sum = Double.parseDouble(num);
            num = String.valueOf(sum);
        }
        t.setText(num);
        sign = '0';
        num = "0";
        return sum;

    }
    /**
     * Переопределяем метод интерфейса слушателя.
     */
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        char ch = s.charAt(0);
        if (s.equals("Exit")) {
            System.exit(0);
        } else if (s.equals("Minimize")) {
            setState(JFrame.ICONIFIED);
            /**
             * Реализация записи в файл.
             */
        } else if (s.equals("Add to file")) {
            if (fileChooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
                try {
                    FileWriter fileWriter = new FileWriter(fileChooser.getSelectedFile());
                    for (int i = 0; i < history.size(); i++) {
                        fileWriter.write(history.get(i) + "\n");
                    }
                    fileWriter.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        } else if (s.equals("About Program")) {
            new AboutProgramFrame();
        } else if (s.equals("About Author")) {
            new AboutAuthorFrame();
        } else if (s.equals("Scientific Calculator")) {
            setBounds(getLocation().x, getLocation().y, 360, 320);
            remove(panel);
            setTitle("Scientific Calculator");
            add(mypanel, BorderLayout.CENTER);
        } else if (s.equals("Basic Calculator")) {
            setBounds(getLocation().x, getLocation().y, 220, 290);
            remove(mypanel);
            setTitle("Calculator");
            add(panel, BorderLayout.CENTER);
        } else if (s.charAt(0) == 'M') {
            memory(s);
        } else if (s.equals("x²") || ch == '√' || s.equals("x³") || ch == '¹' || s.equals("sin") || s.equals("cos") || s.equals("tan") || s.equals("sinh") || s.equals("cosh") || s.equals("tanh") || s.equals("asin") || s.equals("acos") || s.equals("atan") || s.equals("log")) {
            num = t.getText();
            num1 = Double.parseDouble(num);
            if (s.equals("x²"))
                sum = Math.pow(num1, 2);
            else if (ch == '¹')
                sum = 1 / num1;
            else if (s.equals("x³"))
                sum = Math.pow(num1, 3);
            else if (s.charAt(0) == 'c' || s.charAt(0) == 't' || s.charAt(0) == 's' || s.charAt(0) == 'a' || s.charAt(0) == 'l') {
                trigonometry(s);
            } else if (ch == '√')
                if (num1 > 0) sum = Math.sqrt(num1);
                else validation("Неверный ввод");
            flag = 0;
            if (sum == (int) sum) {
                num = String.valueOf(sum);
                num = num.substring(0, num.length() - 2);
            } else {
                num = String.format(Locale.US, "%.10g%n", sum);
                sum = Double.parseDouble(num);
                num = String.valueOf(sum);
            }
            t.setText(num);
            num = "0";
            num1 = 0;
        } else if (ch == '±') {
            num = t.getText();
            if (num.charAt(0) != '-')
                num = "-" + num;
            else if (num.charAt(0) == '-')
                num = num.substring(1, num.length());
            t.setText(num);
        } else if (ch == 'C') {
            if (num.length() > 1)
                num = num.substring(0, num.length() - 1);
            else
                num = "0";
            t.setText(num);
        } else if (ch == 'A') {
            sign = '0';
            num = "0";
            sum = 0;
            num1 = 0;
            num2 = 0;
            flag = 0;
            t.setText(num);
        } else if (ch >= '0' && ch <= '9' || ch == '.') {
            if (ch == '.' && num.charAt(num.length() - 1) == '.')
                s = "";
            if (ch == '.')
                num += s;
            else if (num.equals("0"))
                num = s;
            else
                num = num + s;
            t.setText(num);
        } else if (ch == '=') {
            if (flag == 1) {
                num2 = Double.parseDouble(num);
                basicOperations();
            } else {
                num = t.getText();
                t.setText(num);
                num = "0";
            }
            flag = 0;
        } else {
            num = t.getText();
            if (flag == 0)
                num1 = Double.parseDouble(num);
            else {
                if (num.charAt(num.length() - 1) >= '0' && num.charAt(num.length() - 1) <= '9' && num.charAt(num.length() - 1) == ' ')
                    num2 = Double.parseDouble(num);
                num1 = basicOperations();
            }
            num = "0";
            for (int i = 0; i < 23; i++)
                num += "  ";
            num += s;
            t.setText(num);
            num = "0";
            sign = ch;
            flag = 1;
        }
        setSize(450, 450);
    }
}
