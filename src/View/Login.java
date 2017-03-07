package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 * Created by 杨帆 on 2017/3/3.
 */
public class Login {
    public static void VloginShow(){
        new LoginForm();
    }

    public static void login() {
        System.out.println("登陆成功!");
    }
}

class LoginForm extends JFrame{
    public LoginForm(){
        //设置窗口大小
        this.setSize(_FromDevice.screenSize.width / 2 , _FromDevice.screenSize.height / 2);
        //设置拖动的最低大小
        this.setMinimumSize(new Dimension(_FromDevice.screenSize.width / 2, _FromDevice.screenSize.height / 2));
        //设置初始出现位置
        this.setLocationRelativeTo(null);
        //初始化显示
        _InitShow();
        //关闭方法
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //设置可见性
        setVisible(true);
    }

    private void _InitShow(){
        //设置主面板布局
        this.setLayout(new GridLayout(1 , 2 , _FromDevice.baseSize ,_FromDevice.baseSize));

        //设置面板背景图片
        _SetBk();

        //设置图标
        _SetIcon();

        //占位
        JPanel leftPanel = new JPanel();
        leftPanel.setOpaque(false);
        this.add(leftPanel);

        //字体
        Font textFont = new Font("微软雅黑" , Font.PLAIN, _FromDevice.fontSize * 2);
        Font headFont = new Font("幼圆" , Font.BOLD , _FromDevice.fontSize * 4);

        //右面板
        JPanel rightPanel = new JPanel();
        rightPanel.setOpaque(false);
        rightPanel.setLayout(new GridLayout(2 , 1 , _FromDevice.baseSize , _FromDevice.baseSize * 50));

        //图标面板
        JPanel tPanel = new JPanel();
        tPanel.setOpaque(false);
        tPanel.setLayout(new BorderLayout());
        JLabel lLabel = new JLabel("管理员登录");
        lLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        lLabel.setFont(headFont);
        tPanel.add(lLabel , BorderLayout.CENTER);

        //登陆面板设置
        JPanel loginPanel = new JPanel();
        loginPanel.setOpaque(false);
        loginPanel.setLayout(new GridLayout(4 , 1 , _FromDevice.baseSize * 2 , _FromDevice.baseSize * 3));

        //设置账号面板
        JPanel accountPanel = new JPanel();
        accountPanel.setOpaque(false);
        accountPanel.setLayout(new FlowLayout(1,_FromDevice.baseSize * 2 , 0));
        JLabel accText = new JLabel("账号:");
        accText.setFont(textFont);
        accountPanel.add(accText);
        JTextField accInput = new JTextField(10);
        accInput.setFont(textFont);
        accountPanel.add(accInput);

        //设置密码面板
        JPanel passwordPanel = new JPanel();
        passwordPanel.setOpaque(false);
        passwordPanel.setLayout(new FlowLayout(1,_FromDevice.baseSize * 2 , 0));
        JLabel passText = new JLabel("密码:");
        passText.setFont(textFont);
        passwordPanel.add(passText);
        JPasswordField passInput = new JPasswordField(10);
        passInput.setFont(textFont);
        passwordPanel.add(passInput);

        //操作面板
        JPanel opPanel = new JPanel();
        opPanel.setOpaque(false);
        opPanel.setLayout(new FlowLayout(1 , _FromDevice.baseSize * 20 , 0));
        JButton loginButton = new JButton("登录");
        loginButton.setFont(textFont);
        loginButton.addActionListener(e -> {
            if (accInput.getText().equals("admin") && new String(passInput.getPassword()).equals("123456")){
                Login.login();
            }else{
                JOptionPane.showMessageDialog(null , "账号或者密码有误");
            }

        });
        JButton cancerButton = new JButton("取消");
        cancerButton.setFont(textFont);
        cancerButton.addActionListener(e -> {
            System.exit(0);
        });
        opPanel.add(loginButton);
        opPanel.add(cancerButton);

        //将账号密码面板及操作面板添加到登陆面板上
        loginPanel.add(accountPanel);
        loginPanel.add(passwordPanel);
        loginPanel.add(opPanel);

        //将面板添加到右面板上
        rightPanel.add(tPanel);
        rightPanel.add(loginPanel);

        //将右面版添加到主面板上
        this.add(rightPanel);
    }

    //背景设置
    private void _SetBk() {
        ImageIcon bkImage = new ImageIcon("src\\Asserts\\bk1.jpg");
        JLabel bkLabel = new JLabel(bkImage);
        JPanel imagePanel = (JPanel) this.getContentPane();
        imagePanel.setOpaque(false);
        getLayeredPane().add(bkLabel, new Integer(Integer.MIN_VALUE));
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                bkImage.setImage(bkImage.getImage().getScaledInstance(getWidth() , getHeight() , Image.SCALE_DEFAULT));
                bkLabel.setBounds(0 , 0 , getWidth(), getHeight());
            }
        });
    }

    //图标设置
    private void _SetIcon(){
        Toolkit tl = Toolkit.getDefaultToolkit();
        setIconImage(tl.createImage("src\\Asserts\\ICON.jpg"));
        setTitle("剧院管理系统");
    }
}