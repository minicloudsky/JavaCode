package com;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 一个计算器，与Windows附件自带计算器的标准版功能、界面相仿。 但还不支持键盘操作。
 */
public class Calculator extends JFrame implements ActionListener,Machine {
    private static Calculator calculatorinstance = null;

    /**
     * 构造函数
     */
    private Calculator() {
        super();
        // 初始化计算器
        init();
        // 设置计算器的背景颜色
        this.setBackground(Color.LIGHT_GRAY);
        this.setTitle("设计模式计算器~15031210101~15软件工程一班~贾亚武");
        // 在屏幕(500, 300)坐标处显示计算器
        this.setLocation(500, 300);
        // 不许修改计算器的大小
        this.setResizable(true);
        // 使计算器中各组件大小合适
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * 获取计算器的实例
     * @return
     */
    public static Calculator getCalculatorInstance(){
        if(calculatorinstance == null){
            calculatorinstance = new Calculator();
        }
        return calculatorinstance;
    }

    /** 计算器上的键的显示名字 */
    private final String[] KEYS = { "7", "8", "9", "/", "sqrt", "4", "5", "6",
            "*", "%", "1", "2", "3", "-", "1/x", "0", "+/-", ".", "+", "=" };
    /** 计算器上的功能键的显示名字 */
    private final String[] COMMAND = { "Backspace", "CE", "C" };
    /** 计算器左边的M的显示名字 */
    private final String[] M = { " ", "MC", "MR", "MS", "M+" };
    /** 计算器上键的按钮 */
    private JButton keys[] = new JButton[KEYS.length];
    /** 计算器上的功能键的按钮 */
    private JButton commands[] = new JButton[COMMAND.length];
    /** 计算器左边的M的按钮 */
    private JButton m[] = new JButton[M.length];
    /** 计算结果文本框 */
    private JTextField resultText = new JTextField("0");

    // 标志用户按的是否是整个表达式的第一个数字,或者是运算符后的第一个数字
    private boolean firstDigit = true;
    // 计算的中间结果。
    private double resultNum = 0.0;
    // 当前运算的运算符
    private String operator = "=";
    // 操作是否合法
    private boolean operateValidFlag = true;
    /**
     * 初始化计算器
     */
    private void init() {
        resultText.setHorizontalAlignment(JTextField.RIGHT);
        resultText.setEditable(false);
        resultText.setBackground(Color.WHITE);
        JPanel calckeysPanel = new JPanel();
        calckeysPanel.setLayout(new GridLayout(4, 5, 3, 3));
        for (int i = 0; i < KEYS.length; i++) {
            keys[i] = new JButton(KEYS[i]);
            calckeysPanel.add(keys[i]);
            keys[i].setForeground(Color.CYAN);
            keys[i].setFont(new Font("微软雅黑",Font.BOLD, 25));
        }
        keys[3].setForeground(Color.pink);
        keys[8].setForeground(Color.pink);
        keys[13].setForeground(Color.pink);
        keys[18].setForeground(Color.pink);
        keys[19].setForeground(Color.pink);
        JPanel commandsPanel = new JPanel();
        commandsPanel.setLayout(new GridLayout(1, 3, 3, 3));
        for (int i = 0; i < COMMAND.length; i++) {
            commands[i] = new JButton(COMMAND[i]);
            commandsPanel.add(commands[i]);
            commands[i].setForeground(Color.red);
        }
        JPanel calmsPanel = new JPanel();
        calmsPanel.setLayout(new GridLayout(5, 1, 3, 3));
        for (int i = 0; i < M.length; i++) {
            m[i] = new JButton(M[i]);
            calmsPanel.add(m[i]);
            m[i].setForeground(Color.red);
        }
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout(3, 3));
        panel1.add("North", commandsPanel);
        panel1.add("Center", calckeysPanel);
        JPanel top = new JPanel();
        top.setLayout(new BorderLayout());
        top.add("Center", resultText);
        getContentPane().setLayout(new BorderLayout(3, 5));
        getContentPane().add("North", top);
        getContentPane().add("Center", panel1);
        getContentPane().add("West", calmsPanel);
        for (int i = 0; i < KEYS.length; i++) {
            keys[i].addActionListener(this);
        }
        for (int i = 0; i < COMMAND.length; i++) {
            commands[i].addActionListener(this);
        }
        for (int i = 0; i < M.length; i++) {
            m[i].addActionListener(this);
        }
    }

    /**
     * 处理事件
     */
    public void actionPerformed(ActionEvent e) {
        String label = e.getActionCommand();
        if (label.equals(COMMAND[0])) {
            handleBackspace();
        } else if (label.equals(COMMAND[1])) {
            resultText.setText("0");
        } else if (label.equals(COMMAND[2])) {
            handleC();
        } else if ("0123456789.".indexOf(label) >= 0) {
            handleNumber(label);
        } else {
            handleOperator(label);
        }
    }

    /**
     * 处理Backspace键被按下的事件
     */
    private void handleBackspace() {
        String text = resultText.getText();
        int i = text.length();
        if (i > 0) {
            text = text.substring(0, i - 1);
            if (text.length() == 0) {
                resultText.setText("0");
                firstDigit = true;
                operator = "=";
            } else {
                resultText.setText(text);
            }
        }
    }
    /**
     * 处理数字键被按下的事件
     * @param key
     */
    private void handleNumber(String key) {
        if (firstDigit) {
            resultText.setText(key);
        } else if ((key.equals(".")) && (resultText.getText().indexOf(".") < 0)) {
            resultText.setText(resultText.getText() + ".");
        } else if (!key.equals(".")) {
            resultText.setText(resultText.getText() + key);
        }
        firstDigit = false;
    }
    /**
     * 处理C键被按下的事件
     */
    private void handleC() {
        resultText.setText("0");
        firstDigit = true;
        operator = "=";
    }
    /**
     * 处理运算符键被按下的事件
     * @param key
     */
    private void handleOperator(String key) {
        if (operator.equals("/")) {
            if (getNumberFromText() == 0.0) {
                operateValidFlag = false;
                resultText.setText("除数不能为零");
            } else {
                resultNum /= getNumberFromText();
            }
        } else if (operator.equals("1/x")) {
            if (resultNum == 0.0) {
                operateValidFlag = false;
                resultText.setText("零没有倒数");
            } else {
                resultNum = 1 / resultNum;
            }
        } else if (operator.equals("+")) {
            resultNum += getNumberFromText();
        } else if (operator.equals("-")) {
            resultNum -= getNumberFromText();
        } else if (operator.equals("*")) {
            resultNum *= getNumberFromText();
        } else if (operator.equals("sqrt")) {
            resultNum = Math.sqrt(resultNum);
        } else if (operator.equals("%")) {
            resultNum = resultNum / 100;
        } else if (operator.equals("+/-")) {
            resultNum = resultNum * (-1);
        } else if (operator.equals("=")) {
            resultNum = getNumberFromText();
        }
        if (operateValidFlag) {
            long t1;
            double t2;
            t1 = (long) resultNum;
            t2 = resultNum - t1;
            if (t2 == 0) {
                resultText.setText(String.valueOf(t1));
            } else {
                resultText.setText(String.valueOf(resultNum));
            }
        }
        operator = key;
        firstDigit = true;
        operateValidFlag = true;
    }

    /**
     * 从结果文本框中获取数字
     * @return
     */
    private double getNumberFromText() {
        double result = 0;
        try {
            result = Double.valueOf(resultText.getText()).doubleValue();
        } catch (NumberFormatException e) {
        }
        return result;
    }
    public void work(){
        System.out.println("我是Java Swing构建的超级计算器");
    }
}