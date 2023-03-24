package utils;

public class DataSource
{
    public DataReader setDataSource(String dataFormat) {
        switch (dataFormat) {
            case "excel":
                return new ExcelReader();
            case "json":
                return new JsonReader();
            default:
                System.out.println("Invalid Data Format!!!");
                break;
        }
        return null;
    }
}
