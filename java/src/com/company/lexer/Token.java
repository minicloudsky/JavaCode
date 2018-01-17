package com.company.lexer;
/*
*
* 类 Token 有一个 tag 字段, 用于做出语法分析决定
* */
public class Token {
    public final int tag;

    public Token(int t){
        tag=t;
    }

    @Override
    public String toString() {
        return ""+(char)tag;
    }

}
