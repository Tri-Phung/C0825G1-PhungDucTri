package com.codegym.configemail.service;

import com.codegym.configemail.Entity.MailInbox;
import com.codegym.configemail.repository.MailInboxRepository;
import org.springframework.stereotype.Service;

@Service
public class MailInboxService {
    private MailInboxRepository mailInboxRepository = new MailInboxRepository();
    public MailInbox getConfigInfo() {
        return mailInboxRepository.getConfigInfo();
    }
    public boolean setConfigInfo(MailInbox currentConfig) {
        return mailInboxRepository.setConfigInfo(currentConfig);
    }
}
