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
 * Frame about Program.
 */
public class AboutProgramFrame extends JFrame {
    /**
     * Set properties of Frame.
     */
    public AboutProgramFrame() {
        setSize(1150, 390);
        setResizable(false);

        JLabel label1 = new JLabel("Научный калькулятор");
        JLabel label2 = new JLabel("Программа реализует обычный и научный калькуляторы");
        JLabel label3 = new JLabel("В программе реализованы:");
        JLabel label4 = new JLabel("Базовые операции: сложение, вычитание, умножение, деление и т.п.");
        JLabel label5 = new JLabel("Продвинутые операции: возведение в n-ую степень, корень из числа n-ой степени и т.п.");
        JLabel label6 = new JLabel("Тригонометрические и обратные тригонометрические функции, функции для работы с памятью");
        JLabel label7 = new JLabel("Реализована в запись файл арифметических операций");
        JLabel label8 = new JLabel("Версия 1.0.0  2022");


        Font font1 = new Font("System", Font.PLAIN, 16);
        Font font2 = new Font("System", Font.BOLD, 20);
        Font font3 = new Font("System", Font.BOLD, 16);
        label1.setFont(font2);
        label2.setFont(font1);
        label3.setFont(font3);
        label4.setFont(font1);
        label5.setFont(font1);
        label6.setFont(font1);
        label7.setFont(font1);
        label8.setFont(font3);


        setLayout(null);
        label1.setBounds(225, 25, 660, 30);
        label2.setBounds(410, 75, 635, 25);
        label3.setBounds(410, 135, 635, 25);
        label4.setBounds(410, 165, 635, 25);
        label5.setBounds(410, 190, 735, 25);
        label6.setBounds(410, 215, 750, 25);
        label7.setBounds(410, 240, 635, 25);
        label8.setBounds(410, 290, 250, 25);

        JLabel picLabel = new JLabel( new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("calc.jpg"))));
        picLabel.setBounds(25, 85, 360, 220);

        JButton buttonNext = new JButton("Назад");
        /**
         * Переопределяем метод интерфейса слушателя.
         */
        buttonNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        buttonNext.setFont(font1);
        buttonNext.setBounds(610, 285, 130, 35);

        addAll(label1, label2, label3, label4, label5, label6, label7, label8, picLabel, buttonNext);

        setVisible(true);
    }
    /**
     * Method for add components.
     */
    public void addAll(Component... array) {
        for (Component component : array) {
            add(component);
        }
    }
}