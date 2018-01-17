package com.company.lexer;

import java.io.*;
import java.util.*;
import com.company.symbols.*;

/**
 * 程序需要预读一个字符，所以使用一个变量 peek 来保存下一个输入字符,
 * 同时规定: 要么保存了当前词法单元词素后的那个字符，要么保存空白符。*/
public class Lexer {
    public static int line=1;
    //下一个输入字符
    char peek=' ';
    //用一个表来保存字符串
    Hashtable words=new Hashtable();
    private Reader in=null;
    private char[] source;
//在初始化时在字符串表中加入保留的字符串以及他们对应的词法单元。
    void reserve(Word w){
        words.put(w.lexeme,w);
    }
//在初始化时在字符串表中加入保留的字符串以及他们对应的词法单元。
    public Lexer(String fileName) throws IOException
    {
        reserve(new Word("if",Tag.IF));
        reserve(new Word("else",Tag.ELSE));
        reserve(new Word("while",Tag.WHILE));
        reserve(new Word("do",Tag.DO));
        reserve(new Word("break",Tag.BREAK));
        reserve(Word.True);
        reserve(Word.Flase);
        reserve(Type.Int);
        reserve(Type.Char);
        reserve(Type.Bool);
        reserve(Type.Float);
        fileToStrbuf(fileName);
    }

    void fileToStrbuf(String fileName) throws IOException{
        in=new FileReader(fileName);
        source=new char[1];
    }

    void readch() throws IOException{
        if(-1==(in.read(source))){
            peek='$';
        }
        peek=source[0];
    }

    boolean readch(char c) throws IOException{
        readch();
        if(peek!=c){
            return false;
        }
        peek=' ';
        return      true;
    }
    //扫描读取文本串，跳过空白字符
    public Token scan() throws IOException{
        for(;;readch()) {
            if (peek == ' ' || peek == '\t') {
                continue;
            } else if (peek=='\r'||peek=='\n') {
                line++;
            }
//            注释为#comment#形式
            else if(peek=='#') {
                do{
                    readch();
                }while(peek!='#');
            }else {
                break;
            }
        }


        switch(peek){
            case '&':
                if(readch('&'))
                    return Word.and;
                else
                    return new Token('&');
            case '|':
                if(readch('|'))
                    return Word.or;
                else
                    return new Token('|');
            case '=':
                if(readch('='))
                    return Word.eq;
                else
                    return new Token('=');
            case '!':
                if(readch('='))
                    return Word.ne;
                else
                    return new Token('!');
            case '<':
                if (readch('='))
                    return Word.le;
                else
                    return new Token('<');
            case '>':
                if(readch('='))
                    return Word.ge;
                else
                    return new Token('>');
        }
        //接下来要处理数字。如果 peek 是数字，证明当前要处理的为数字常量，
        //如果含有 小数点. 证明是实数，否则为整数.
        if(Character.isDigit(peek)){
                int v=0;
            do{
                v=10*v+Character.digit(peek,10);
                readch();
            }while(Character.isDigit(peek));
            if(peek!='.'){
                return new Num(v);
            }
            float x=v;
            float d=10;
            for(;;){
                readch();
                if(!Character.isDigit(peek)){
                    break;
                }
                x=x+Character.digit(peek,10)/d;
                d*=10;
            }
            return new Real(x);
        }
//        处理标识符
        if(Character.isLetter(peek)){
            StringBuffer b=new StringBuffer();
            do{
                b.append(peek);
                readch();
            }while(Character.isLetterOrDigit(peek));
            String s=b.toString();
            Word w=(Word)words.get(s);
            if(w!=null){
                return w;
            }
            w=new Word(s,Tag.ID);
            words.put(s,w);
            return w;
        }
        Token tok=new Token(peek);
        peek = ' ';
        return tok;
    }
}
