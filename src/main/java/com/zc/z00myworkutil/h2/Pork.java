package com.zc.z00myworkutil.h2;

import java.util.ArrayList;
import java.util.List;

public class Pork {
    private Long id;
    private Long threadId;
    private Long stackNum;
    private String threadName;
    private Long methodId;
    private Long whoInvokeMeId;
    private String className;
    private String methodName;
    private Long lineNum;
    private Long invokeAt;
    private List<Pork> children = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getThreadId() {
        return threadId;
    }

    public void setThreadId(Long threadId) {
        this.threadId = threadId;
    }

    public Long getStackNum() {
        return stackNum;
    }

    public void setStackNum(Long stackNum) {
        this.stackNum = stackNum;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public Long getMethodId() {
        return methodId;
    }

    public void setMethodId(Long methodId) {
        this.methodId = methodId;
    }

    public Long getWhoInvokeMeId() {
        return whoInvokeMeId;
    }

    public void setWhoInvokeMeId(Long whoInvokeMeId) {
        this.whoInvokeMeId = whoInvokeMeId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Long getLineNum() {
        return lineNum;
    }

    public void setLineNum(Long lineNum) {
        this.lineNum = lineNum;
    }

    public Long getInvokeAt() {
        return invokeAt;
    }

    public void setInvokeAt(Long invokeAt) {
        this.invokeAt = invokeAt;
    }

    public List<Pork> getChildren() {
        return children;
    }

    public void setChildren(List<Pork> children) {
        this.children = children;
    }

    public void addChild(Pork pork) {
        this.children.add(pork);
    }
}
