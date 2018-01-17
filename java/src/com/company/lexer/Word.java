package com.company.lexer;
/**
 * 类 Word 继承 Token, 增加了一个字段 lexeme, 用于保存关键字和标识符的词素。
 * */
public class Word extends Token{
    public String lexeme="";

    public Word(String s,int tag){
        super(tag);
        lexeme=s;
    }

    @Override
    public String toString() {
        return lexeme;
    }

    public static final Word
    and=new Word("&&",Tag.AND),or=new Word("||",Tag.OR),
    eq=new Word("==",Tag.EQ),ne=new Word("!=",Tag.NE),
    le=new Word("<=",Tag.LE),ge=new Word(">=",Tag.GE),
    minus=new Word("minus",Tag.MINUS),
    True=new Word("true",Tag.TRUE),
    Flase=new Word("false",Tag.FALSE),
    temp=new Word("t",Tag.TEMP);
}
