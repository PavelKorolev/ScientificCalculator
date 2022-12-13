package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * @author Koroliov P.I.
 * @version 1.0
 *
 * Main window of application.
 */
public class StartFrame extends JFrame {
    /**
     * Method for searching all groups
     *
     * @return list of groups
     */

    /**
     * Set properties of Frame.
     */
    public StartFrame() throws HeadlessException {
        setSize(800, 720);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JFrame frame = this;

        JLabel jlblUniversity = new JLabel("Белорусский Национальный Технический Университет");
        JLabel jlblFaculty = new JLabel("Факультет информационнных технологий и робототехники");
        JLabel jlblDepartment = new JLabel("Кафедра программного обеспечения информационных систем и технологий");
        JLabel jlblCourseWork = new JLabel("Курсовая работа");
        JLabel jlblDiscipline = new JLabel("по дисциплине  \"Програмирование на языке Java\"");
        JLabel jlblScientificCalculator = new JLabel("Научный калькулятор");
        JLabel jlblStudent = new JLabel("Выполнил: Студент группы 10702120");
        JLabel jlblName = new JLabel("Королёв Павел Игоревич");
        JLabel jlblProfessor = new JLabel("Преподаватель: к.ф.-м.н.,доц.");
        JLabel jlblProfessorsName = new JLabel("Сидорик Валерий Владимирович");
        JLabel jlblYear = new JLabel("Минск 2022");

        Font fontmediumsize = new Font("System", Font.PLAIN, 16);
        Font fonthighsize = new Font("System", Font.BOLD, 20);

        jlblUniversity.setFont(fontmediumsize);
        jlblFaculty.setFont(fontmediumsize);
        jlblDepartment.setFont(fontmediumsize);
        jlblCourseWork.setFont(fonthighsize);
        jlblDiscipline.setFont(fontmediumsize);
        jlblScientificCalculator.setFont(fonthighsize);
        jlblStudent.setFont(fontmediumsize);
        jlblName.setFont(fontmediumsize);
        jlblProfessor.setFont(fontmediumsize);
        jlblProfessorsName.setFont(fontmediumsize);
        jlblYear.setFont(fontmediumsize);

        setLayout(null);
        jlblUniversity.setBounds(204, 20, 400, 25);
        jlblFaculty.setBounds(176, 60, 440, 25);
        jlblDepartment.setBounds(102, 85, 570, 25);
        jlblCourseWork.setBounds(295, 160, 190, 32);
        jlblDiscipline.setBounds(225, 190, 365, 25);
        jlblScientificCalculator.setBounds(270, 230, 400, 32);
        jlblStudent.setBounds(460, 365, 280, 25);
        jlblName.setBounds(460, 390, 280, 25);
        jlblProfessor.setBounds(460, 440, 280, 25);
        jlblProfessorsName.setBounds(460, 465, 280, 25);
        jlblYear.setBounds(350, 570, 90, 25);


        JLabel jlblPicLabel = new JLabel( new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("calc.jpg"))));
        jlblPicLabel.setBounds(80, 300, 260, 260);

        JButton jbtButtonNext = new JButton("Далее");
        JButton jbtButtonExit = new JButton("Выход");
        jbtButtonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        jbtButtonNext.setFont(fontmediumsize);
        jbtButtonExit.setFont(fontmediumsize);
        jbtButtonNext.setBounds(70, 620, 300, 35);
        jbtButtonExit.setBounds(420, 620, 300, 35);

        addAll(jlblUniversity, jlblFaculty, jlblDepartment, jlblCourseWork, jlblDiscipline, jlblScientificCalculator, jlblStudent, jlblName, jlblProfessor, jlblProfessorsName, jlblYear);
        addAll(jlblPicLabel, jbtButtonNext, jbtButtonExit);

        setVisible(true);

        /*
          Create and run Main Frame of application.
         */
        jbtButtonNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ScientificCalculator();
                setVisible(false);
            }
        });

        /**
         * Timer for closing
         */
        new Timer(1000, new ActionListener() {
            int timeInSeconds = 59;
            @Override
            public void actionPerformed(ActionEvent e) {
                timeInSeconds -= 1;
                jbtButtonExit.setText(String.valueOf(timeInSeconds + 1));

                if (timeInSeconds < 0) {
                    frame.dispose();
                }
            }
        }).start();
    }

    public void addAll(Component... array) {
        for (Component component : array) {
            add(component);
        }
    }
}
