package com.codegym.configemail.repository;

import com.codegym.configemail.Entity.MailInbox;
import org.springframework.stereotype.Repository;

@Repository
public class MailInboxRepository {
    private MailInbox configInfo = new MailInbox("English", 10, false, "Best regards,Tri");
    public MailInbox getConfigInfo() {
        return configInfo;
    }
    public boolean setConfigInfo(MailInbox currentConfig) {
        configInfo = currentConfig;
        return true;
    }
}
