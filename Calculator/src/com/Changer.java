package com;

public class Changer implements Machine {
    private Machine machine;
    public Changer(Machine machine){
        this.machine = machine;
    }
    public void work(){
        machine.work();
    }
}
