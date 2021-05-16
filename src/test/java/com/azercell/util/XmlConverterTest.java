package com.azercell.util;

import com.azercell.model.Member;
import com.azercell.model.Wrapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;


public class XmlConverterTest {


    @Test
    public void testIt() throws IOException {
        long start = System.currentTimeMillis();
        final String xml = "<member>\n" +
                "\t<name>dedicatedAccountInformation</name>\n" +
                "\t<value>\n" +
                "\t\t<array>\n" +
                "\t\t\t<data>\n" +
                "\t\t\t\t<value>\n" +
                "\t\t\t\t\t<struct>\n" +
                "\t\t\t\t\t\t<member>\n" +
                "\t\t\t\t\t\t\t<name>dedicatedAccountActiveValue1</name>\n" +
                "\t\t\t\t\t\t\t<value>\n" +
                "\t\t\t\t\t\t\t\t<string>18000</string>\n" +
                "\t\t\t\t\t\t\t</value>\n" +
                "\t\t\t\t\t\t</member>\n" +
                "\t\t\t\t\t\t<member>\n" +
                "\t\t\t\t\t\t\t<name>dedicatedAccountID</name>\n" +
                "\t\t\t\t\t\t\t<value>\n" +
                "\t\t\t\t\t\t\t\t<i4>128</i4>\n" +
                "\t\t\t\t\t\t\t</value>\n" +
                "\t\t\t\t\t\t</member>\n" +
                "\t\t\t\t\t\t<member>\n" +
                "\t\t\t\t\t\t\t<name>dedicatedAccountUnitType</name>\n" +
                "\t\t\t\t\t\t\t<value>\n" +
                "\t\t\t\t\t\t\t\t<i4>0</i4>\n" +
                "\t\t\t\t\t\t\t</value>\n" +
                "\t\t\t\t\t\t</member>\n" +
                "\t\t\t\t\t\t<member>\n" +
                "\t\t\t\t\t\t\t<name>dedicatedAccountValue1</name>\n" +
                "\t\t\t\t\t\t\t<value>\n" +
                "\t\t\t\t\t\t\t\t<string>18000</string>\n" +
                "\t\t\t\t\t\t\t</value>\n" +
                "\t\t\t\t\t\t</member>\n" +
                "\t\t\t\t\t\t<member>\n" +
                "\t\t\t\t\t\t\t<name>expiryDate</name>\n" +
                "\t\t\t\t\t\t\t<value>\n" +
                "\t\t\t\t\t\t\t\t<dateTime.iso8601>20210608T12:00:00+0000</dateTime.iso8601>\n" +
                "\t\t\t\t\t\t\t</value>\n" +
                "\t\t\t\t\t\t</member>\n" +
                "\t\t\t\t\t\t<member>\n" +
                "\t\t\t\t\t\t\t<name>pamServiceID</name>\n" +
                "\t\t\t\t\t\t\t<value>\n" +
                "\t\t\t\t\t\t\t\t<i4>1</i4>\n" +
                "\t\t\t\t\t\t\t</value>\n" +
                "\t\t\t\t\t\t</member>\n" +
                "\t\t\t\t\t\t<member>\n" +
                "\t\t\t\t\t\t\t<name>startDate</name>\n" +
                "\t\t\t\t\t\t\t<value>\n" +
                "\t\t\t\t\t\t\t\t<dateTime.iso8601>20210509T12:00:00+0000</dateTime.iso8601>\n" +
                "\t\t\t\t\t\t\t</value>\n" +
                "\t\t\t\t\t\t</member>\n" +
                "\t\t\t\t\t\t<member>\n" +
                "\t\t\t\t\t\t\t<name>dedicatedAccountValueTime</name>\n" +
                "\t\t\t\t\t\t\t<value>\n" +
                "\t\t\t\t\t\t\t\t<string>0d.5h.0m.0s</string>\n" +
                "\t\t\t\t\t\t\t</value>\n" +
                "\t\t\t\t\t\t</member>\n" +
                "\t\t\t\t\t</struct>\n" +
                "\t\t\t\t</value>\n" +
                "\t\t\t</data>\n" +
                "\t\t</array>\n" +
                "\t</value>\n" +
                "</member>";


        Wrapper wrapper = CustomConverter.doConvert(xml);

        wrapper.getMember()
                .getValue()
                .getArray()
                .getData()
                .getValue()
                .getStruct()
                .getMember()
                .forEach(level2 -> {
                    String propertyName = level2.getName();
                    Member.ValueLevelThree level3 = level2.getValue();
                    String propertyValue = level3.getString() != null ? level3.getString() : String.valueOf(level3.getI4());
                        System.out.println("PropertyName: " + propertyName + " propertyValue: " + propertyValue);

                });
    }


}
