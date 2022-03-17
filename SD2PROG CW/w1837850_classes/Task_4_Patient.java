package w1837850_classes;
// https://www.geeksforgeeks.org/inheritance-in-java/
public class Task_4_Patient extends Task_4_Booth{
    String Surname;
    String Age;
    String City;
    String Id;
    String Vaccination;

    public Task_4_Patient(String Firstname, String Surname, String Age, String City, String Id, String Vaccination){
        super(Firstname);
        this.Surname = Surname;
        this.Age = Age;
        this.City = City;
        this.Id = Id;
        this.Vaccination = Vaccination;
    }
}
