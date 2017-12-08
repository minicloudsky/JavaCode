package com.company.lexer;

import java.io.*;
import java.util.*;
import com.company.symbols.*;

public class Lexer {
    public static int line=1;
    char peek=' ';
    Hashtable words=new Hashtable();


    private Reader in=null;
    private char[] source;

    void reserve(Word w){
        words.put(w.lexeme,w);
    }

    public Lexer(String fileName) throws IOException{
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

    boolean readch() throws IOException{
        if(-1==(in.read(source))){
            //System.out.println("eooro");
            return false;
        }
        peek=source[0];
        return true;
    }

    boolean readch(char c) throws IOException{
        readch();
        if(peek!=c){
            return false;
        }
        peek=' ';
        return true;
    }

    public Token scan() throws IOException{
        for(;;readch()) {
            if (peek == ' ' || peek == '\t') {
                continue;
            } else if (peek=='\r'||peek == '\n') {
                line++;
            } else {
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
        peek=' ';
        return tok;
    }
}
