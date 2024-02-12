import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main{
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);    
    Map<String,String> date = new HashMap<>();
    Map<String, String> data;
    while(true){
        System.out.println("Enter data in the format: surname first name middle name date of birth phone number gender");
        String input = scanner.nextLine();
        if(input.isEmpty()){
            break;
        }
        String[] parts = input.split(" ");
        if(parts.length != 6){
            System.out.println("Data entry error");
            continue;
        }
        String lastName = parts[0];
        String firstName = parts[1];
        String middleName = parts[2];
        String dateOfBirth = parts[3];
        String phoneNumber = parts[4];
        String gender = parts[5];
        if(!isValidDate(dateOfBirth)|| !isValidPhoneNumber(phoneNumber)||! isValidGender(gender)){
            System.out.println("Data entry error");
            continue;
        }
        String dataString = lastName + " " + firstName + " " +  middleName + " "+ dateOfBirth +" "+ phoneNumber + " " + gender;
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt", true));
            writer.write(dataString);
            writer.newLine();
            writer.close();
        }catch(IOException e){
            System.out.println("///");
            e.printStackTrace();
           
        }    
        data.put(lastName, dataString);
    }
    
    for(Map.Entry<String, String> entry : data.entrySet()){
        System.out.println(entry.getKey()+":"+entry.getValue());
    }
    scanner.close();
}
    private static boolean isValidDate(String date){
        String regex = "\d{2}/.\d{2}.\d{4}";
        return date.matches(regex);
    }

    private static boolean isValidPhoneNumber(String phoneNumber){
        String regex = "\d+";
        return phoneNumber.matches(regex);    
    }

    private static boolean isValidGender(String gender){
        return gender.equals("f")||gender.equals("m");
    }
}