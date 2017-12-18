package com;
public class Calculator
{
    private String value1; //表格中的第一个参数
    private String value2;//表格中的第二个参数
    private double result;//计算结果
    private int operatorNum;
    public int getOperatorNum() {
        return operatorNum;
    }
    public void setOperatorNum(int operatorNum) {
        this.operatorNum = operatorNum;
    }
    public double getResult() {
        return result;
    }
    public void setResult(double result) {
        this.result = result;
    }
    public String getValue2() {
        return value2;
    }
    public void setValue2(String value2) {
        this.value2 = value2;
    }
    public void setValue1(String value1) {
        this.value1 = value1;
    }
    public String getValue1() {
        return value1;
    }
    public void calculate(){
        double a = Double.parseDouble(value1);
        double b = Double.parseDouble(value2);
        try{
            int key = operatorNum;
            switch (key){
                case 1:
                    result = a+b;
                    break;
                case 2:
                    result = a-b;
                    break;
                case 3:
                    result = a*b;
                    break;
                case 4:
                    result = a/b;
                    break;
                default:
                    break;
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
