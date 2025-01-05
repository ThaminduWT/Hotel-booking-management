package lk.hesh.org.example.hotelbokingmanegement.repo;

import lk.hesh.org.example.hotelbokingmanegement.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookingRepo extends JpaRepository<Booking,Long> {
    Optional<Booking> findBookingConfirmationCode(String confirmationCode);
}
