package com.zc.z08oop;

public class T01Final
{
    public static void main(String[] args)
    {
        System.out.println(null instanceof Object);//false
    }
}

class FA
{
    private static final String a;

    private final String b;

    private static String c;

    //private static final String d;

    private static String e = new String();

    private static final String f = new String();

    static
    {
        a = "";
        c = "ccc";
        e = new String();
        //f= new String();
    }

    {
        b = "";
        c = "";
        //d="";
    }

    public static final void statFinalMethod()
    {

    }

    public final void a()
    {
        {
            {
                {
                    {
                        {
                            {
                                {
                                    {
                                        {
                                            {
                                                {
                                                    {
                                                        {
                                                            {
                                                                {
                                                                    String s = null;
                                                                    System.out.println(s instanceof String);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void b()
    {

    }

    public static void c()
    {
    }
}

class FB extends FA
{
    /*public void a()
    {
        
    }*/

    public void b()
    {

    }

    /*public static final void statFinalMethod()
    {
        
    }*/
}
