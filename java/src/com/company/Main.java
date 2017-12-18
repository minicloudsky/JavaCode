package com.company;
import com.company.lexer.*;
import com.company.parser.Parser;
import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException {
        Lexer lex=new Lexer("H:\\1.cpp");
        Parser parser=new Parser(lex);
        parser.program();
        System.out.println('\n');
    }
}
