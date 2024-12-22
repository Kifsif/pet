package gift.academic.pet.dtos;

import gift.academic.pet.models.User;

public class UserDto {

    private Long id;
    private String phone;
    private String email;
    private String name;
    private String registrationDate;
    private int ordersCount;
    private int petsCount;

    public UserDto(User user){
        id = user.getId();
        phone = user.getPhone().toString();
        email = user.getEmail();
        name = user.getName();
        registrationDate = user.getRegistrationDate().toString();
        ordersCount = user.getOrdersCount();
        petsCount = user.getPetsCount();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public int getOrdersCount() {
        return ordersCount;
    }

    public void setOrdersCount(int ordersCount) {
        this.ordersCount = ordersCount;
    }

    public int getPetsCount() {
        return petsCount;
    }

    public void setPetsCount(int petsCount) {
        this.petsCount = petsCount;
    }
}
