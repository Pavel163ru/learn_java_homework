package hibernate.model;

public class Phone {
    int id;
    int user_id;
    String phone_number;

    public Phone(){}
    public Phone(int user_id, String phone_number){
        this.user_id = user_id;
        this.phone_number = phone_number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
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