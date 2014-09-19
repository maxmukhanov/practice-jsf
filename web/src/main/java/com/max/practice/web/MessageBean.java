package com.max.practice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Locale;

@Component(value = "msg")
public class MessageBean extends HashMap{

    @Autowired
    private MessageSource messageSource;
    @Autowired
    private LocaleBean localeBean;

    @Override
    public String get(Object key) {
        Locale locale = localeBean.getLocale();

        return messageSource.getMessage((String) key, null, locale);
    }
}
