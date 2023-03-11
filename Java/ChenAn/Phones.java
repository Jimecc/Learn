package ChenAn;
/**
 * @author an
 * decription : 不可描述
 * @date 2022/11/8 9:46
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Phones {
    String name;
    String phone;
    HashMap<String,String> hashMap = new HashMap<>();
    void draw()throws FileNotFoundException{
        Phones p = new Phones();
        p.ReadTxt();

        JFrame jf = new JFrame("电话簿查询");
        JTextField jt1 = new JTextField("张三");
        JTextArea jt2 = new JTextArea();
        jf.setSize(500,300);
        jf.setLocationRelativeTo(null);
    jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Panel panel = new Panel();
        JButton button = new JButton("查询");
        panel.add(button);
        button.addActionListener(e -> {
            String name = jt1.getText();
            p.hashMap.get(name);
            jt2.setText(name + "," + phone);
            panel.add(jt2);
        });
        jt1.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                    String name = jt1.getText();
                    p.hashMap.get(name);
                    jt2.setText(name + "#" + phone);
                    panel.add(jt2);
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        jf.setContentPane(panel);
        jf.setVisible(true);
    }
    private void ReadTxt()throws  FileNotFoundException{
        String regex = "(.*?)#(.*?)#";
        Pattern pattern = Pattern.compile(regex);
        Scanner sc = new Scanner(new File("/Users/hsk/Project/Java/PureJava/ChenAn/phone.txt"));
        while (sc.hasNext()) {
            String getSC = sc.next();
            Matcher matcher = pattern.matcher(getSC);
            if (matcher.matches()) {
                name = matcher.group(1);
                String Phones = matcher.group(2);
                hashMap.put(name, Phones);
            }
        }
    }

    public static void main(String[] args) {
        try {
            Phones fileRW = new Phones();
            fileRW.draw();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

    