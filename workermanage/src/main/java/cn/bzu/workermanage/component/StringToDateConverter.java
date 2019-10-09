package cn.bzu.workermanage.component;

import org.springframework.stereotype.Component;
import org.springframework.core.convert.converter.Converter;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class StringToDateConverter implements Converter<String, Date> {


    private static final String DATE_Format = "MM-dd-YYYY hh:mm:ss a";


    @Override
    public Date convert(String value) {
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_Format);
        try {
            return formatter.parse(value);
        } catch (Exception e) {
            throw new RuntimeException(String.format("parser %s to Date fail", value));
        }
    }

}

