package utils;

public class Testing1
{
    public static void main(String[] args)
    {
        JsonReader jr = new JsonReader();
        Object[][] tc001s = jr.readData("TC002");
        System.out.println(tc001s[0][0]);
        System.out.println(tc001s[0][1]);
        System.out.println(tc001s[0][2]);
        System.out.println("______________________________________");
        System.out.println(tc001s[1][0]);
        System.out.println(tc001s[1][1]);
        System.out.println(tc001s[1][2]);
        System.out.println("______________________________________");
        System.out.println(tc001s[2][0]);
        System.out.println(tc001s[2][1]);
        System.out.println(tc001s[2][2]);
    }
}
