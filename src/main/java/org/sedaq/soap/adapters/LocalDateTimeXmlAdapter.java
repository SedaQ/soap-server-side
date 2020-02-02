package org.sedaq.soap.adapters;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeXmlAdapter extends XmlAdapter<String, LocalDateTime> {

    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_DATE_TIME;

    @Override
    public LocalDateTime unmarshal(String v) throws Exception {
        return LocalDateTime.parse(v, dateTimeFormatter);
    }

    @Override
    public String marshal(LocalDateTime v) throws Exception {
        if (v != null) {
            return v.format(dateTimeFormatter);
        } else {
            return null;
        }
    }
}
