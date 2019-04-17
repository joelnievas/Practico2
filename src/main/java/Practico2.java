import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;


public class Practico2 {
    public static void main(String[] args) {

        Scanner myObj = new Scanner(System.in);

        System.out.println("Listado de sitios:");

        Site[] sites = null;


        try {
            String data = readUrl("https://api.mercadolibre.com/sites");

            sites = new Gson().fromJson(data, Site[].class);

            int i= 1;
            for(Site site : sites){
                System.out.println(i+ " :"+site.getName());
                i++;

            }

        } catch (IOException e){
            System.out.println("Ocurrio un error en las sitios");
            e.printStackTrace();
        }

        System.out.println("\n Escriba el numero del sitio que desea elegir:");

        int cod = (myObj.nextInt()-1);



        System.out.println("Eligio: "+ sites[cod].name);

        PaymentMethod[] paymentMethods = null;
        PaymentMethod[] paymentMethods1 = null;

        try {
            String data = readUrl("https://api.mercadolibre.com/sites/"+sites[cod].id+"/payment_methods");

            paymentMethods = new Gson().fromJson(data, PaymentMethod[].class);


            int i = 0;
            int e = 0;
            for(PaymentMethod paymentMethod : paymentMethods){
                System.out.println(i+1+" :" +paymentMethod.getName());
                i++;

            }

        } catch (IOException e){
            System.out.println("Ocurrio un error en los Payment Methods");
            e.printStackTrace();
        }
        System.out.println("\n Escriba el nombre del metodo de pago  que desea elegir:");

        int codp = myObj.nextInt()-1;

        System.out.println("Eligio: "+ paymentMethods[codp].name);

        System.out.println("Escribir Latitud: ");
        String saltodelinea = myObj.nextLine();
        String latitud = myObj.nextLine();

        System.out.println("Escribir longitud deseada: ");

        String longitud = myObj.nextLine();

        System.out.println("Escribir radio de distancia deseado: ");

        String radio = myObj.nextLine();


        try{
            String data = readUrl("https://api.mercadolibre.com/sites/"+sites[cod].id+"/payment_methods/"+paymentMethods[codp].id+"/agencies?near_to="+latitud+","+longitud+","+radio+"");

            JsonObject jsonObject = new JsonParser().parse(data).getAsJsonObject();
            Agency[] agencies = new Gson().fromJson(jsonObject.get("results"), Agency[].class);

            System.out.println("Seleccione un metodo de orden:");
            System.out.println("1: Agency code\n2: Distance\n3: Address");
            int order = myObj.nextInt();

            switch (order){
                case 1:{
                    Agency.setOrdenador(Ordenador.AGENCY_CODE);
                    break;
                }
                case 2:{
                    Agency.setOrdenador(Ordenador.DISTANCE);
                    break;
                }
                case 3:{
                    Agency.setOrdenador(Ordenador.ADDRESS_LINE);
                    break;
                }
            }







            Ordenar.menorMayor(agencies);






            //realizar ordenamiento elegido

            for(Agency agency: agencies){
                System.out.println("\nAgency Code: "+ agency.agency_code + "\nDistance: " + agency.distance +"\nAddress: "+ agency.getAddress().address_line+ "\n----------------------");
            }


        }catch (IOException e){
                System.out.println("Ocurrio un error en las Agencias");
                e.printStackTrace();
        }


    }

    private static String readUrl(String urlString) throws IOException{
        BufferedReader reader = null;

        try {
            URL url = new URL(urlString);
            URLConnection connection = url.openConnection();
            connection.addRequestProperty("Accept", "application/json");
            connection.addRequestProperty("User-Agent", "Mozilla/5.0");
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));

            int read = 0;
            StringBuffer buffer = new StringBuffer();
            char[] chars = new char[1024];
            while((read = reader.read(chars))!= -1){
                buffer.append(chars, 0, read);
            }
            return buffer.toString();


        }finally {
            if(reader != null){
                reader.close();
            }
        }

    }
}
