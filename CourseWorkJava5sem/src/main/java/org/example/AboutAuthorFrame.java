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
 * Frame about Author of application.
 */
public class AboutAuthorFrame extends JFrame {
    /**
     * Set properties of Frame.
     */
    public AboutAuthorFrame() {
        setSize(400, 630);
        setResizable(false);

        JLabel label1 = new JLabel("Автор");
        JLabel label2 = new JLabel("Студент группы 10702120");
        JLabel label3 = new JLabel("Королёв Павел Игоревич");
        JLabel label4 = new JLabel("Почта: hemetnesingwarynpc@gmail.com");

        Font font1 = new Font("System", Font.PLAIN, 16);
        Font font2 = new Font("System", Font.BOLD, 20);
        label1.setFont(font2);
        label2.setFont(font1);
        label3.setFont(font1);
        label4.setFont(font1);

        setLayout(null);
        label1.setBounds(170, 354, 60, 30);
        label2.setBounds(35, 400, 250, 25);
        label3.setBounds(35, 430, 250, 25);
        label4.setBounds(35,460,350,25);


        JLabel picLabel = new JLabel( new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("iam.jpg"))));
        picLabel.setBounds(45, 33, 300, 300);

        JButton buttonNext = new JButton("Назад");
        /**
         * Переопределяем метод интерфейса слушателя.
         * Create and run Main Frame of application.
         */
        buttonNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        buttonNext.setFont(font1);
        buttonNext.setBounds(35, 520, 310, 35);


        addAll(label1, label2, label3, label4, picLabel, buttonNext);

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
