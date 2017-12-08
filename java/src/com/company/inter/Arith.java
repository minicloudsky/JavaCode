package com.company.inter;

import com.company.lexer.*;
import com.company.symbols.*;

public class Arith extends Op {
    public Expr p1,p2;
    public Arith(Token tok,Expr x1,Expr x2){
        super(tok,null);
        p1=x1;
        p2=x2;
        type=Type.max(p1.type,p2.type);
        if(type==null){
            error("type error");
        }
    }
    public Expr gen(){
        return new Arith(op,p1.reduce(),p2.reduce());
    }

    @Override
    public String toString() {
        return p1.toString()+" "+op.toString()+" "+p2.toString();
    }
}
