package com.zc.basic.z02oop.demo;

public class T05Final
{
    public static void main(String[] args)
    {

    }

    public void a()
    {
        final int b;
        b = 10;
    }
}

class Cell
{
    private final int id;

    public Cell(int id)
    {
        this.id = id;
    }

    public void updateId(int id)
    {
        //这一行编译错误,只要final初始化后,试图改变final值都会引起编译错误
        //	this.id = id;
    }

    public static void main(String[] args)
    {
        Cell cell = new Cell(1001);
        cell.updateId(1002);
        System.out.println(cell.id);
    }
}
