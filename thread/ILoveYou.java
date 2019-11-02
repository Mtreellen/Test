package thread;

/**
 * @author mtreellen
 * @date 2019-10-31-21:21
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LiaoMei extends JFrame {
    private final JButton yes;
    private final JButton no;
    private final JLabel textLabel1;
    private final JLabel textLabel2;
    private final JLabel imageLabel;
    Icon img = new ImageIcon("C:\\\\Users\\\\Jack Hwo\\\\Desktop\\\\0.png");
    Icon emoji1 = new ImageIcon("C:\\Users\\Jack Hwo\\Desktop\\1.jpg");
    Icon emoji2 = new ImageIcon("C:\\Users\\Jack Hwo\\Desktop\\2.jpg");
    Icon emoji3 = new ImageIcon("C:\\Users\\Jack Hwo\\Desktop\\3.jpg");

    public LiaoMei() {
        super("来自一个默默喜欢你很久的人~~");
        setLayout(new FlowLayout());

        textLabel1 = new JLabel("喜欢你很久");
        textLabel1.setFont(new Font("宋体", 22, 23));
        add(textLabel1);

        textLabel2 = new JLabel("我们在一起好么?");
        textLabel2.setFont(new Font("楷体", 33, 30));
        add(textLabel2);

        imageLabel = new JLabel(img);
        imageLabel.setLocation(123, 124);
        add(imageLabel);

        yes = new JButton("好");
        add(yes);
        no = new JButton("不好");
        add(no);

        ButtonHandler1 handler1 = new ButtonHandler1();
        yes.addActionListener(handler1);
        ButtonHandler2 handler2 = new ButtonHandler2();
        no.addActionListener(handler2);
    }

    private class ButtonHandler1 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            JOptionPane.showMessageDialog(LiaoMei.this, String.format("三生有幸！！"));
        }
    }

    private class ButtonHandler2 implements ActionListener {
        private int flag = 0;

        @Override
        public void actionPerformed(ActionEvent event) {
            flag++;
            if (flag == 1) {
                JOptionPane.showMessageDialog(LiaoMei.this, String.format("和你一房两人三餐四季"), "在一起吧",
                        JOptionPane.INFORMATION_MESSAGE, emoji1);
                flag++;
            }
            if (flag == 3) {
                JOptionPane.showMessageDialog(LiaoMei.this, String.format("今夜我不关心人类，我只想你。"), "在一起吧",
                        JOptionPane.INFORMATION_MESSAGE, emoji2);
                flag++;
            }
            if (flag == 5) {
                JOptionPane.showMessageDialog(LiaoMei.this, String.format("你笑起来真像好天气"), "在一起吧",
                        JOptionPane.INFORMATION_MESSAGE, emoji3);
                flag=0;
            }
        }

    }
}
public class ILoveYou {
    public static void main(String[] args) {
        LiaoMei buttonFrame = new LiaoMei();
        buttonFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        buttonFrame.setResizable(false);
        buttonFrame.setFocusable(false);
        buttonFrame.setAlwaysOnTop(true);
        buttonFrame.setSize(600, 400);
        buttonFrame.setVisible(true);
        buttonFrame.setLocationRelativeTo(null);
    }
}
