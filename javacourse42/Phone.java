package javacourse42;

public class Phone {
    int id;
    int user_id;
    String phone_number;
    Phone(){}
    Phone(int id, int user_id, String phone_number){
        this.id = id;
        this.user_id = user_id;
        this.phone_number = phone_number;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", phone_number='" + phone_number + '\'' +
                '}';
    }
}
