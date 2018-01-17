package com.company.lexer;
/***
 * 当在输入流中出现一个数位序列时，词法分析器将向语法分析器传送一个词法单元，
 * 该词法单元包含终结符号 Num 及 根据这些数位计算得到的整数属性值。
 * 如果把词法单元写成用 <> 括起来的元组，那么 29, 1 分别被表示成 <num, 29>, <num, 1>.
 * Num 继承 Token, 增加了一个用于存放整数值的字段 value。
 */
public class Num extends Token {
    public final int value;
    public Num(int v){
        super(Tag.NUM);
        value=v;
    }

    @Override
    public String toString() {
        return ""+value;
    }
}
