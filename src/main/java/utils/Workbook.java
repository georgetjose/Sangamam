package utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Workbook
{
    Sheet1 sheet1;

    @Getter
    @Setter
    public class Sheet1
    {
        String username;
        String password;
    }
}
