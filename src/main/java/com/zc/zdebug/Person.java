package com.zc.zdebug;

public class Person
{
    private Family family;

    public Family getFamily()
    {
       /* return family;*/
        return new Family();
    }

    public void setFamily(Family family)
    {
        this.family = family;
    }
    
}
class Family{
    public Job getJob(){
        return new Job();
    }
}

class Job{
    public void say(){
        System.out.println("Job.say-method");
    }
}
