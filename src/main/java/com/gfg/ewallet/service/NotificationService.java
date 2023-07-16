package com.gfg.ewallet.service;

import com.gfg.ewallet.service.resource.NotificationMessage;

public interface NotificationService {

    public void sendNotification(NotificationMessage notificationMessage);
}
