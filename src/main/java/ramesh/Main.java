package ramesh;



import ramesh.services.BankService.BankServiceImp;

import javax.xml.ws.Endpoint;



public class Main {

    public String title = "  _________                  __________                __    \n" +
            " /   _____/ _________  ______\\______   \\_____    ____ |  | __\n" +
            " \\_____  \\ /  _ \\__  \\ \\____ \\|    |  _/\\__  \\  /    \\|  |/ /\n" +
            " /        (  <_> ) __ \\|  |_> >    |   \\ / __ \\|   |  \\    < \n" +
            "/_______  /\\____(____  /   __/|______  /(____  /___|  /__|_ \\\n" +
            "        \\/           \\/|__|          \\/      \\/     \\/     \\/";

    private void printInfo()
    {
        String [] titleArray = title.split("\n");

        for (String s:titleArray) {
            System.out.println(s);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Developed by Ramesh Shyaman");
    }

    public static void main(String[] args) {
        Main app = new Main();
        app.printInfo();

        // write your code here
        System.out.println();

        String url = "http://localhost:8080/ws/bank";
        Endpoint.publish( url, new BankServiceImp());
        System.out.println("Server is running...");
        System.out.println(String.format("soap url : %s?wsdl" ,url ) );
    }

}
