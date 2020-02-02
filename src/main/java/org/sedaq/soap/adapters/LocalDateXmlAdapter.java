package org.sedaq.soap.adapters;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateXmlAdapter extends XmlAdapter<String, LocalDate> {

    DateTimeFormatter dateFormatter = DateTimeFormatter.ISO_DATE;

    @Override
    public LocalDate unmarshal(String v) throws Exception {
        return LocalDate.parse(v, dateFormatter);
    }

    @Override
    public String marshal(LocalDate v) throws Exception {
        if (v != null) {
            return v.format(dateFormatter);
        } else {
            return null;
        }
    }
}
