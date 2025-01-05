package lk.hesh.org.example.hotelbokingmanegement.repo;

import lk.hesh.org.example.hotelbokingmanegement.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.Optional;

public interface BookingRepo extends JpaRepository<Booking,Long> {

    Optional<Booking> findByBookingConfirmationCode(String confirmationCode);
}
