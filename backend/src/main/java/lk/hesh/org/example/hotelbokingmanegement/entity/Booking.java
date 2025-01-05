package lk.hesh.org.example.hotelbokingmanegement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Check in date is required")
    private LocalDate checkInDate;
    @Future(message = "Check out date must be in the future")
    private LocalDate checkOutDate;
    @Min(value = 1, message = "Number of adults should not be less than one")
    private int numberOfAdults;
    @Min(value = 0, message = "Number of children should not be less than zero")
    private int numberOfChildren;
    private int totalNumberOfGuest;
    private String bookingConfirmationCode;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;

    public void calculateTotalNumberOfGuest(){
        this.totalNumberOfGuest = this.numberOfAdults + this.numberOfChildren;
    }

    public void setNumberOfAdults(int numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
        calculateTotalNumberOfGuest();
    }

    public void setNumberOfChildren(int numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
        calculateTotalNumberOfGuest();
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", numberOfAdults=" + numberOfAdults +
                ", numberOfChildren=" + numberOfChildren +
                ", totalNumberOfGuest=" + totalNumberOfGuest +
                ", bookingConfirmationCode='" + bookingConfirmationCode + '\'' +

                '}';
    }
}
