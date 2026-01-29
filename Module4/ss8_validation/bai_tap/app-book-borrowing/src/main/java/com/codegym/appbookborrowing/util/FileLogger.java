package com.codegym.appbookborrowing.util;

import org.springframework.stereotype.Component;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
@Component
public class FileLogger {
    private static final String LIBRARY_LOG = "logs/library-actions.log";
    private static final String VISITOR_LOG = "logs/visitor.log";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public void logLibraryAction(String message) {
        writeToFile(LIBRARY_LOG, message);
    }
    public void logVisitor(String message) {
        writeToFile(VISITOR_LOG, message);
    }
    private void writeToFile(String filePath, String message) {
        File file = new File(filePath);
        file.getParentFile().mkdirs();
        StringBuffer sb = new StringBuffer();
        sb.append(LocalDateTime.now().format(formatter));
        sb.append(" - ");
        sb.append(message);
        sb.append("\n");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
