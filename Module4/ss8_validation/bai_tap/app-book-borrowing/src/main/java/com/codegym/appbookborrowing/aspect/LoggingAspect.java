package com.codegym.appbookborrowing.aspect;

import com.codegym.appbookborrowing.util.FileLogger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private final FileLogger fileLogger;
    public LoggingAspect(FileLogger fileLogger) {
        this.fileLogger = fileLogger;
    }
    private int visitorCount = 0;

    @AfterReturning(pointcut = "execution(* com.codegym.appbookborrowing.service.BookService.borrowBook(..)) ||" +
            "execution(* com.codegym.appbookborrowing.service.BookService.returnBook(..))", returning = "result")
    public void logBookStateChange(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        if ("borrowBook".equals(methodName)) {
            fileLogger.logLibraryAction("Borrowed book - Id" + args[0] + " - Code: " + result);
        } else if ("returnBook".equals(methodName)) {
            fileLogger.logLibraryAction("Returned book - Code: " + args[0]);
        }
    }
    @Before("execution(* com.codegym.appbookborrowing.controller.*.*(..))")
    public void countVisitor(JoinPoint joinPoint){
        visitorCount++;
        String methodName = joinPoint.getSignature().getName();
        fileLogger.logVisitor("Visitor " + visitorCount + " visited - Action: " + methodName);
    }
}
