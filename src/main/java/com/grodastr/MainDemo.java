package com.grodastr;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;


public class MainDemo implements ActionListener {
    private JPanel JPanel1;
    private JButton ConvertUnix;
    private JButton ConvertOmnicom;
    private JTextField textField;
    private JLabel response;


    public MainDemo() {
        Converter converter = new Converter();

        ConvertOmnicom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (converter.searchUnix(Long.parseLong(textField.getText()))<0){
                        response.setText("Время не может быть меньше нуля");

                    }else {
                        response.setText(String.valueOf(converter.searchUnix(Long.parseLong(textField.getText()))));
                    }

                }catch (Exception ex){
                    response.setText("Ошибка");
                }
            }
        });

        ConvertUnix.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (converter.searchOmnicom(Long.parseLong(textField.getText()))<0){
                        response.setText("Время до 2009 года");

                    }else {
                        response.setText(String.valueOf(converter.searchOmnicom(Long.parseLong(textField.getText()))));
                    }

                }catch (Exception ex){
                    response.setText("Ошибка");
                }
            }
        });
        JPopupMenu jpu = new JPopupMenu();
        JMenuItem jmiCopy = new JMenuItem("Copy");
        jpu.add(jmiCopy);
        jmiCopy.addActionListener(this);
        response.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                jpu.show(e.getComponent(),e.getX(),e.getY());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                jpu.show(e.getComponent(),e.getX(),e.getY());
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comStr = e.getActionCommand();
        if (comStr.equals("Copy")){
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            StringSelection stringSelection = new StringSelection(response.getText());
            clipboard.setContents(stringSelection,null);
        }
    }

    public static void main(String[] args)  {
        JFrame frame = new JFrame("Converter");

        frame.setContentPane(new MainDemo().JPanel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }
}
