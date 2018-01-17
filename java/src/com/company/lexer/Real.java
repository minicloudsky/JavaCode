package com.company.lexer;
/**
 * 与 Num 类似，用来表示实数
 * */
public class Real extends Token{
    public final float value;

    Real(float v){
        super(Tag.REAL);
        value=v;
    }
    @Override
    public String toString() {
        return ""+value;
    }
}
