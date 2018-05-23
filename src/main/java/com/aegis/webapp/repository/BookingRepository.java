package com.aegis.webapp.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aegis.webapp.entities.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
	Booking findByBookingDateAndHourIdAndRoomId(Date bookingDate,Long hourId,Long roomId);
	List<Booking> findAllByUserId(Long userId);
	Booking findByBookingId(Long bookingId);
	Booking findByBookingIdAndUserId(Long bookingId,Long userId);

}
